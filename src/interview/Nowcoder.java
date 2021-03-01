package interview;

/**
 * @author AndrewElvis
 * @date 2020-09-11-19:26
 * @description
 */
public class Nowcoder {
    public static void main(String[] args) {
        Nowcoder nowcoder = new Nowcoder();
        int i = 0;
        nowcoder.inc(i);
        i = i++;
        System.out.println(i);
    }
    void inc(int i) {
        i++;
    }
}
