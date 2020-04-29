public class BuyMaxCars {
    public static int solve(int[] houses, int money) {
        return 1;
    }

    public static void main(String[] args) {
        testing();
    }

    public static void testing() {
        assertequals(2, solve(new int[]{20, 90, 40, 90}, 100));
        assertequals(3, solve(new int[]{30, 30, 10, 10}, 50));
        assertequals(0, solve(new int[]{999, 999, 999}, 300));
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