package global.care.usct.service.dto.paymenthub;

public record PaymentHubBeneficiaryOnboardingFailedCallbackDTO(
    String payeeIdentity, String paymentModality, String failureReason) {}
