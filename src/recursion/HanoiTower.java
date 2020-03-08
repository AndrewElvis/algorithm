package recursion;

/**
 * @author AndrewElvis
 * @date 2020-03-07-18:56
 */
public class HanoiTower {
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        }else {
            process(N - 1, from, help, to);
            System.out.println("move " + N +" from " + from + " to " + to);
            process(N - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        String from = "left";
        String help = "mid";
        String to = "right";
        int N = 3;
        process(N, from, to, help);
    }
}
