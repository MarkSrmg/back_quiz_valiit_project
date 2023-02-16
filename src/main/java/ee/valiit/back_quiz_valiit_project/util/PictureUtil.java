package ee.valiit.back_quiz_valiit_project.util;

import java.nio.charset.StandardCharsets;

public class PictureUtil {

    public static String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        } else {
            return new String(byteArray);
        }
    }
    public static byte[] stringToByteArray(String picture) {
        if (picture == null || picture.equals("")) {
            return null;
        }
        return picture.getBytes(StandardCharsets.UTF_8);
    }
}
