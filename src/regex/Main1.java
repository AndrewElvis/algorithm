package regex;

import java.util.regex.Pattern;

/**
 * @author AndrewElvis
 * @date 2020-09-18-12:55
 * @description
 */
public class Main1 {
    public static void main(String[] args) {
        String content = "I am noob " +
                "from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);
    }
}
