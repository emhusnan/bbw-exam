package id.emhusnan.exam.bbw.authorization.responses;

import id.emhusnan.exam.bbw.authorization.responses.data.PaymentVa;

public class PaymentVaResponse extends BaseResponse<PaymentVa> {
    public PaymentVaResponse() {
        setResponseCode(rc.getSucces());
        setResponseData(new PaymentVa());
    }
}
