package global.care.usct.controller.dto;

import global.care.usct.controller.dto.digital.registries.PackageDto;

public class CreateBeneficiaryDto {
  private CandidateDto candidateDto;
  private PackageDto enrolledPackage;

  public CreateBeneficiaryDto() {}

  public CreateBeneficiaryDto(CandidateDto candidateDto, PackageDto enrolledPackage) {
    this.candidateDto = candidateDto;
    this.enrolledPackage = enrolledPackage;
  }

  public CandidateDto getCandidateDto() {
    return candidateDto;
  }

  public void setCandidateDto(CandidateDto candidateDto) {
    this.candidateDto = candidateDto;
  }

  public PackageDto getEnrolledPackage() {
    return enrolledPackage;
  }

  public void setEnrolledPackage(PackageDto enrolledPackage) {
    this.enrolledPackage = enrolledPackage;
  }
}
