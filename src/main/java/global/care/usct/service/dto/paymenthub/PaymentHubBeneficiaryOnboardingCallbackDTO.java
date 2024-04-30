package global.care.usct.service.dto.paymenthub;

import java.util.List;

public record PaymentHubBeneficiaryOnboardingCallbackDTO(
    String requestID,
    String registerRequestID,
    int numberFailedCases,
    List<PaymentHubBeneficiaryOnboardingFailedCallbackDTO> failedCases) {}
