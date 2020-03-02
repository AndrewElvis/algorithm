package MultiThread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author AndrewElvis
 * @date 2020-02-29-22:58
 * TransferQueue(传递队列)生成一个空的队列，当一个线程take()时会阻塞等待直到另一个线程往队列里递东西，才会执行下面的代码
 */
public class T4_TransferQueue {
    public static void main(String[] args) {
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        new Thread(() -> {
            try {
                for (char c : aI) {
                    System.out.println(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                for (char c : aC) {
                    queue.transfer(c);
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
