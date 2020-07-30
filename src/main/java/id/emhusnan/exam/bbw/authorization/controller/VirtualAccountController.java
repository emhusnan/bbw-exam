package id.emhusnan.exam.bbw.authorization.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.emhusnan.exam.bbw.authorization.helper.HeaderHelper;
import id.emhusnan.exam.bbw.authorization.helper.SignatureHelper;
import id.emhusnan.exam.bbw.authorization.model.VirtualAccount;
import id.emhusnan.exam.bbw.authorization.repository.VirtualAccountRepository;
import id.emhusnan.exam.bbw.authorization.requests.InquiryVaRequest;
import id.emhusnan.exam.bbw.authorization.responses.BaseResponse;
import id.emhusnan.exam.bbw.authorization.responses.InquiryVaResponse;
import id.emhusnan.exam.bbw.authorization.responses.PaymentVaResponse;
import id.emhusnan.exam.bbw.authorization.responses.data.InquiryVa;
import id.emhusnan.exam.bbw.authorization.responses.data.PaymentVa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VirtualAccountController {
    @Autowired
    VirtualAccountRepository vaRepo;

    @PreAuthorize("#oauth2.hasScope('va-transaction')")
    @PostMapping("/va/inquiry")
    public BaseResponse<InquiryVa> inquiryVa(@RequestBody InquiryVaRequest request, @RequestHeader Map<String, String> headers) {
        InquiryVaResponse inquiryVaResponse = new InquiryVaResponse();

        //region header validation
        boolean validHeader = isValidHeader(headers);
        if (!validHeader) {
            inquiryVaResponse.markAsHeaderNotCompleted();
            return inquiryVaResponse;
        }
        //endregion

        String signature = headers.get("X-BBW-Signature");
        String timestamp = headers.get("X-BBW-Timestamp");
        String requestBodyString = "";
        String token = HeaderHelper.extractTokenFromHeader(headers.get("Authorization"));

        //region request body validation
        ObjectMapper Obj = new ObjectMapper();
        try {
            requestBodyString = Obj.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            inquiryVaResponse.markAsGeneralError();
            return inquiryVaResponse;
        }
        //endregion

        String stringToSign = SignatureHelper.makeStringToSign(token, requestBodyString, timestamp);
        String serverSignature = SignatureHelper.generateSignature(stringToSign);
        //region signature validation
        if (!serverSignature.equals(signature)) {
            inquiryVaResponse.markAsInvalidSignature();
            return inquiryVaResponse;
        }
        //endregion

        VirtualAccount byClientId = vaRepo.findByClientId(request.getClientId());
        if (byClientId == null) {
            inquiryVaResponse.markAsInvalidClientId();
        } else {
            InquiryVa inquiryVa = new InquiryVa();
            inquiryVa.setAccountName(byClientId.getAccountName());
            inquiryVaResponse.setResponseData(inquiryVa);
        }

        return inquiryVaResponse;
    }

    @PreAuthorize("#oauth2.hasScope('va-transaction')")
    @PostMapping("/va/transaction/payment")
    public BaseResponse<PaymentVa> paymentVa(@RequestHeader Map<String, String> headers) {
        PaymentVaResponse paymentVaResponse = new PaymentVaResponse();
        //region header validation
        boolean validHeader = isValidHeader(headers);
        if (!validHeader) {
            paymentVaResponse.markAsHeaderNotCompleted();
            return paymentVaResponse;
        }
        //endregion


        return paymentVaResponse;
    }

    private boolean isValidHeader(@RequestHeader Map<String, String> headers) {
        return headers.containsKey("X-BBW-Signature") && headers.containsKey("X-BBW-Timestamp");
    }
}
