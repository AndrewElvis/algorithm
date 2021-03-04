package creator;

/**
 * @author AndrewElvis
 * @date 2021-03-03-14:26
 * @description
 */
public class AutoBoxing {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Long : 8373, long : 958
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            // 此语句为sum = sum + i, 当sum为包装类时, sum + i sum会自动拆箱为基本数据类型与i进行计算,
            // 之后再自动装箱为Long类型赋值给sum, 此处就多余了拆箱装箱的过程, 因此不能滥用包装类
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(sum);
    }
}
