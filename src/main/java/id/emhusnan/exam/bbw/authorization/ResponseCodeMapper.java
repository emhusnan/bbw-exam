package id.emhusnan.exam.bbw.authorization;

import id.emhusnan.exam.bbw.authorization.model.ResponseCode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseCodeMapper {
    List<ResponseCode> rc = new ArrayList<>();

    public ResponseCodeMapper() {
        rc.add(new ResponseCode("000", "Success"));
        rc.add(new ResponseCode("001", "Header not completed"));
        rc.add(new ResponseCode("002", "Token not valid"));
        rc.add(new ResponseCode("003", "VA not found"));
        rc.add(new ResponseCode("004", "Signature not valid"));
        rc.add(new ResponseCode("005", "Client ID not found"));
        rc.add(new ResponseCode("006", "General Error"));
    }

    public ResponseCode getSucces() {
        return rc.get(0);
    }

    public ResponseCode getHeaderNotCompleted() {
        return rc.get(1);
    }

    public ResponseCode getGeneralError() {
        return rc.get(6);
    }

    public ResponseCode getInvalidSignature() {
        return rc.get(4);
    }

    public ResponseCode getInvalidClientId() {
        return rc.get(5);
    }
}
