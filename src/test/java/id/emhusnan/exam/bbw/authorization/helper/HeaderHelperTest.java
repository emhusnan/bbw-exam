package id.emhusnan.exam.bbw.authorization.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderHelperTest {

    @Test
    void extractTokenFromHeader() {
        String token = HeaderHelper.extractTokenFromHeader("Bearer 3021f445-7e55-41e6-bdeb-54b8da8e882f");
        assertEquals("3021f445-7e55-41e6-bdeb-54b8da8e882f", token);
    }
}