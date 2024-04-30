package global.care.usct.repositories;

import global.care.usct.model.Candidate;
import global.care.usct.model.Consent;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentRepository extends JpaRepository<Consent, Integer> {

  Optional<Consent> findConsentByCandidateId(Candidate candidate);

  void deleteByCandidateId(Candidate candidate);
}
