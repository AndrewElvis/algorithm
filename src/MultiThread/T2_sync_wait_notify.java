package MultiThread;

/**
 * @author AndrewElvis
 * @date 2020-02-29-0:26
 */
public class T2_sync_wait_notify {

    public static void main(String[] args) {
        final Object o = new Object();

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {

            synchronized (o) {
                for (char c : aI) {
                    System.out.println(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//在结束后需要通知另外线程，不然程序结束不了
                           //（比如t1的最后一次循环wait后t2线程执行完后不会通知t1那么t1会一直等待）
            }
        }, "t1").start();

        new Thread(() -> {

            synchronized (o) {
                for (char c : aC) {
                    System.out.println(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
