package id.emhusnan.exam.bbw.authorization.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureHelperTest {
    @Test
    void generateSignature() {
        String signature = SignatureHelper.generateSignature("test");
        //expected value generated on https://freeformatter.com/hmac-generator.html#ad-output
        String expected = "4c6506631e03c8e7df47b343ac65781b261c6e7b5f44df3024b3cf49c7c2f751";
        assertEquals(expected, signature);

        String requestBody = "{\n" +
                "    \"client_id\": \"001\",\n" +
                "    \"reference_number\": \"000000000001\",\n" +
                "    \"virtual_account\": \"7771234567890\"\n" +
                "}";

        //this one failed,
        String expectedSignature="ce20470484c27c0441d7c9dedc7d3e187e5e908df1780c6c389941b779033519";
        String toSign = SignatureHelper.makeStringToSign("a0daAPsGwPDHGMv6MpWzoIPgZvN9YvrSi7xdVI7Jb98638ilM7ila7",
                requestBody
                ,"2016-02-03T10:00:00.000+07:00");

        String signatureFromDoc = SignatureHelper.generateSignature(toSign);
        assertEquals(expectedSignature, signatureFromDoc);

    }

    @Test
    void sanitizeRequestBody() {
        String requestBody = "{\n" +
                "    \"client_id\": \"001\",\n" +
                "    \"reference_number\": \"000000000001\",\n" +
                "    \"virtual_account\": \"7771234567890\"\n" +
                "}";
        String sanitized = SignatureHelper.sanitizeRequestBody(requestBody);

        //expecvted value fromhttps://jsonformatter.curiousconcept.com/ compact mode
        String expected = "{\"client_id\":\"001\",\"reference_number\":\"000000000001\",\"virtual_account\":\"7771234567890\"}";
        assertEquals(expected, sanitized);
    }

}