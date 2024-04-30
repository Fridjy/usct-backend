package global.care.usct.repositories;

import global.care.usct.model.PaymentDisbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDisbursementRepository extends JpaRepository<PaymentDisbursement, Integer> {
  PaymentDisbursement findByRequestUUID(String requestId);
}
