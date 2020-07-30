package id.emhusnan.exam.bbw.authorization.helper;

public class HeaderHelper {
    public static String extractTokenFromHeader(String headerValue) {
        return headerValue.substring("Bearer ".length());
    }
}
