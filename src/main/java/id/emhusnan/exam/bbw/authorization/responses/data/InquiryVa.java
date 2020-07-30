package id.emhusnan.exam.bbw.authorization.responses.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InquiryVa {
    @JsonProperty("account_name")
    String accountName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
