package id.emhusnan.exam.bbw.authorization.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import id.emhusnan.exam.bbw.authorization.ResponseCodeMapper;
import id.emhusnan.exam.bbw.authorization.model.ResponseCode;

public abstract class BaseResponse<T> {
    @JsonIgnore
    protected ResponseCodeMapper rc = new ResponseCodeMapper();

    @JsonProperty("rc")
    String responseCode;
    @JsonProperty("message")
    String responseMessage;
    @JsonProperty("data")
    T responseData;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode rc) {
        this.responseCode = rc.getCode();
        this.responseMessage = rc.getMessage();
    }

    public String getResponseMessage() {
        return responseMessage;
    }


    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public void markAsGeneralError() {
        setResponseCode(rc.getGeneralError());
    }

    public void markAsHeaderNotCompleted() {
        setResponseCode(rc.getHeaderNotCompleted());
    }

    public void markAsInvalidSignature() {
        setResponseCode(rc.getInvalidSignature());
    }

    public void markAsInvalidClientId() {
        setResponseCode(rc.getInvalidClientId());
    }
}
