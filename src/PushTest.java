
import java.math.BigInteger;

/**
 * @author AndrewElvis
 * @date 2020-02-29-23:35
 */
public class PushTest {
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(100)));
    }

    public static BigInteger factorial(BigInteger num) {
        if (num == BigInteger.valueOf(1)) return BigInteger.valueOf(1);
        return  num.multiply(factorial(BigInteger.valueOf(num.longValue()-1) ));
    }
}
