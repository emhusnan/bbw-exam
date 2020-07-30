package id.emhusnan.exam.bbw.authorization.model;

public class ResponseCode {
    String code;
    String message;

    public ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
