package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author AndrewElvis
 * @date 2020-09-18-13:16
 * @description
 */
public class RegexMatches
{
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT =
            "cat cat cat cattie cat";

    public static void main(String[] args){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
            System.out.println(m.group());
        }
    }
}
