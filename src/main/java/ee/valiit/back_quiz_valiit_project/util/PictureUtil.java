package ee.valiit.back_quiz_valiit_project.util;

public class PictureUtil {

    public static String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        } else {
            return new String(byteArray);
        }
//        One liner ternary
//        return byteArray == null ? null : new String(byteArray);
    }
}
