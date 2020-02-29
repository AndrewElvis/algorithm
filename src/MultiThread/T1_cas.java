package MultiThread;


/**
 * @author AndrewElvis
 * @date 2020-02-29-0:05
 */
public class T1_cas {

    enum ReadyToRun {T1,T2}
    public static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {

            for (char c : aI) {
                while (r != ReadyToRun.T1) {}
                System.out.println(c);
                r = ReadyToRun.T2;
            }

        }, "t1").start();
        new Thread(() -> {

            for (char c : aC) {
                while (r != ReadyToRun.T2) {}
                System.out.println(c);
                r = ReadyToRun.T1;
            }

        }, "t2").start();

    }



}
