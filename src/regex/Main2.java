package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author AndrewElvis
 * @date 2020-09-18-13:03
 * @description
 */
public class Main2 {
    public static void main(String[] args) {
        String regex = "(\\D*)(\\d+)(.*)";
        String content = "This order was placed for QT3000! OK?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("Found value: " + matcher.group(0) );
            System.out.println("Found value: " + matcher.group(1) );
            System.out.println("Found value: " + matcher.group(2) );
            System.out.println("Found value: " + matcher.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
