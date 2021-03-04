import static sun.misc.Version.print;

/**
 * @author AndrewElvis
 * @date 2021-02-24-11:30
 * @description
 */
public class Main {

    public static void main(String[] args) {

    }

    public void test1() {
        //Variable 'x' might not have been initialized
        //未初始化会报错
        //原因是局部变量未初始化的话，该变量可能会是任意值，java针对此类错误会直接报错，防止用户忘记初始化造成异常
        //int x;
        //System.out.println(x);
        int x = 0;
        System.out.println(x);
    }

}
