package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AndrewElvis
 * @date 2020-02-29-22:45
 */
public class T3_ReentranLock_Condition {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : aI) {
                    System.out.println(c);
                    c2.signal();

                    c1.await();
                }
                c2.signal();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.println(c);
                    c1.signal();

                    c2.await();
                }
                c1.signal();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
