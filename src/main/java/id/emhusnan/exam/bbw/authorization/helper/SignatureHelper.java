package id.emhusnan.exam.bbw.authorization.helper;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_256;

public class SignatureHelper {
    private static String API_SECRET = "sX@9Y!Jnfy6VXmfZ";

    public static String generateSignature(String StringToSign) {
        byte[] hmac = new HmacUtils(HMAC_SHA_256, API_SECRET).hmac(StringToSign.getBytes());
        return Hex.encodeHexString(hmac);
    }

    public static String makeStringToSign(String authToken, String requestBody, String timestamp) {
        String clearRequestBody = sanitizeRequestBody(requestBody);

        return authToken + ":" + DigestUtils.sha256Hex(clearRequestBody) + ":" + timestamp;
    }

    public static String sanitizeRequestBody(String requestBody) {
//        All carriage return characters, “\r”,are stripped
        return requestBody.replace("\r", "")
//        All line feed characters, “\n”,are stripped
                .replace("\n", "")
//        All tab characters, “\t”,are stripped
                .replace("\t", "")
//        All whitespace characters, “ ”,are stripped
                .replace(" ", "");
    }
}
