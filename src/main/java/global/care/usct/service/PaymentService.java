package global.care.usct.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import global.care.usct.model.Beneficiary;
import global.care.usct.types.PaymentOnboardingCallbackMode;
import global.care.usct.types.PaymentOnboardingStatus;
import java.util.List;

public interface PaymentService {
  String health();

  void registerBeneficiary(List<Beneficiary> beneficiaries);

  void updateBeneficiary(List<Beneficiary> beneficiaries);

  void orderPayment(List<Beneficiary> beneficiaries);

  void updatePaymentOnboardingStatus(String data, PaymentOnboardingCallbackMode onboardingMode)
      throws JsonProcessingException;

  void updatePaymentOrderStatus(String callbackBody) throws JsonProcessingException;

  default void validateOnboardingStatus(List<Beneficiary> beneficiaries) {
    beneficiaries.forEach(
        beneficiary -> {
          if (!beneficiary.getPaymentOnboardingStatus().equals(PaymentOnboardingStatus.ONBOARDED)) {
            throw new RuntimeException("Not every beneficiary is registered in Payment Service!");
          }
        });
  }
}
