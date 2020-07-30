package id.emhusnan.exam.bbw.authorization.responses;

import id.emhusnan.exam.bbw.authorization.responses.data.InquiryVa;

public class InquiryVaResponse extends BaseResponse<InquiryVa> {

    public InquiryVaResponse() {
        setResponseCode(rc.getSucces());
        setResponseData(new InquiryVa());
    }
}
