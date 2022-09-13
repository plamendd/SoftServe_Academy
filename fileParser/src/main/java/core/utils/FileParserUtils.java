package core.utils;

import java.util.regex.Pattern;

public class FileParserUtils {
    private FileParserUtils(){
    }
    public static StringBuilder replaceAll(StringBuilder sb, String find, String replace){
        return new StringBuilder(Pattern.compile(find).matcher(sb).replaceAll(replace));
    }
}
