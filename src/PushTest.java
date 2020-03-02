import java.util.UUID;

/**
 * @author AndrewElvis
 * @date 2020-02-29-23:35
 */
public class PushTest {
    public static void main(String[] args) {
        System.out.println("PushTest...");
        System.out.println("Update Project test...");
        System.out.println(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        int a = (1 | 2);
        System.out.println(a);
    }
}
