public class AirplaneRoutes {

    public static int solve(int days, int[] buses) {
        // Write your answer here to solve :)
        return 1;
    }
    public static void main(String[] args) {
        testing();
    }

    public static void testing() {
        assertequals(6, solve(10, new int[]{3, 7, 2}));
        assertequals(99, solve(100, new int[]{11, 10, 5, 50}));
        assertequals(1, solve(1, new int[]{1}));
        if(flag) {
            System.out.println("Darn failed testing");
        } else {
            System.out.println("Yay passed testing!");
            System.out.println("You're chillinggg");
        }
    }
    
    private static boolean flag = false;
    public static void assertequals(int a, int b) {
        if(a != b) {
            flag = true;
            System.out.println("darn failed");
            System.out.println("Expected: " + a);
            System.out.println("Received: " + b);
        }
    }
}