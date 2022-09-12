package core.utils;

public class EnvelopAnalysisUtils {

    private EnvelopAnalysisUtils(){
    }

    public  static Double parseDoubleOrNull(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
