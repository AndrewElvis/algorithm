/**
 * @author AndrewElvis
 * @date 2020-09-11-22:25
 * @description
 */
public class TestInter {

    public static void main(String[] args) {
        String str = "chinese"; //字符串常量池中
        String str1 = new StringBuilder("chi").append("nese").toString(); //new String()在堆中
        //jdk7后字符串常量池移到堆中,sb.toString()会new String对象在堆中,在这之前如果字符串常量池中有的话会返回不同的引用
        System.out.println(str1 == str1.intern()); //false
        String str2 = new StringBuilder("eng").append("lish").toString();
        //jdk7后字符串常量池移到堆中,如果这之前字符串常量池中没有的话,intern方法会直接返回堆中的引用
        System.out.println(str2 == str2.intern()); //true
    }
}
