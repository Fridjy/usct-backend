package global.care.usct.service;

import global.care.usct.configuration.PaymentProperties;
import global.care.usct.controller.dto.BeneficiaryDto;
import global.care.usct.model.Beneficiary;
import global.care.usct.model.Candidate;
import global.care.usct.repositories.BeneficiaryRepository;
import global.care.usct.types.PaymentStatus;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeneficiaryService {
  private final BeneficiaryRepository repository;
  private final PaymentService paymentService;
  private final CandidateService candidateService;
  private final PaymentProperties properties;
  private final PackageService packageService;
  private final ConsentService consentService;

  public BeneficiaryService(
      BeneficiaryRepository repository,
      PaymentService paymentService,
      CandidateService candidateService,
      PaymentProperties properties,
      PackageService packageService,
      ConsentService consentService) {
    this.repository = repository;
    this.paymentService = paymentService;
    this.candidateService = candidateService;
    this.properties = properties;
    this.packageService = packageService;
    this.consentService = consentService;
  }

  public List<BeneficiaryDto> findAll() {
    List<Beneficiary> beneficiaries = repository.findAll();
    return beneficiaries.stream()
        .map(
            beneficiary -> {
              return new BeneficiaryDto(
                  beneficiary, packageService.getById(beneficiary.getEnrolledPackageId()));
            })
        .toList();
  }

  public BeneficiaryDto findById(int id) {
    var beneficiary =
        repository
            .findById(id)
            .orElseThrow(
                () -> new RuntimeException("Beneficiary with id: " + id + " doesn't exist"));
    return new BeneficiaryDto(
        beneficiary, packageService.getById(beneficiary.getEnrolledPackageId()));
  }

  public Beneficiary create(Candidate candidate, int enrolledPackageId) {
    log.info("Create beneficiary, firstName: {}", candidate.getPerson().getFirstName());
    String functionalId =
        candidate.getPerson().getPersonalIdCode()
            + properties.governmentIdentifier()
            + enrolledPackageId;

    Beneficiary beneficiary = new Beneficiary();
    beneficiary.setPerson(candidate.getPerson());
    beneficiary.setEnrolledPackageId(enrolledPackageId);
    beneficiary.setPaymentStatus(PaymentStatus.INITIATE);
    beneficiary.setFunctionalId(functionalId);
    Beneficiary savedBeneficiary = repository.save(beneficiary);
    candidateService.delete(candidate);
    paymentService.registerBeneficiary(List.of(savedBeneficiary));

    return savedBeneficiary;
  }
}
