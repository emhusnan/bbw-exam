package id.emhusnan.exam.bbw.authorization.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InquiryVaRequest {
    @JsonProperty("client_id")
    String clientId;
    @JsonProperty("reference_number")
    String referenceNumber;
    @JsonProperty("virtual_account")
    String virtualAccount;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }
}
