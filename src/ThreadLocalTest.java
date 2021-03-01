/**
 * @author AndrewElvis
 * @date 2020-09-23-22:42
 * @description
 */
public class ThreadLocalTest {
    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);
}
