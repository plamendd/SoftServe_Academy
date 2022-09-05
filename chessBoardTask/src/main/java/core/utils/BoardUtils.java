package core.utils;

public class BoardUtils {

    public  static Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
