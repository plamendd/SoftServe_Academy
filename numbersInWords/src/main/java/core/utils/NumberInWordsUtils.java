package core.utils;

public class NumberInWordsUtils {

    public  static Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
