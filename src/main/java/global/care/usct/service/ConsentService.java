package global.care.usct.service;

import global.care.usct.controller.dto.ConsentDto;
import global.care.usct.model.Candidate;
import java.util.Optional;

public interface ConsentService {

  Optional<ConsentDto> getConsent(Candidate candidate);

  String save(Candidate candidate);

  void deleteByCandidateId(Candidate candidate);
}
