package core.utils;

public class SortingTrianglesUtils {
    private SortingTrianglesUtils(){
    }

    public  static Double parseDoubleOrNull(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }

}
