package core.utils;

public class BoardUtils {
    private BoardUtils(){
    }

    public  static Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

}
