public class Solution {

    public static int solve(int days, int[] buses) {
        int multiples = buses[0];
        while(multiples <= days) {
            multiples += buses[0];
        }
        if(multiples > days) {
            multiples -= buses[0];
        }
        for(int i = 1; i < buses.length; i++) {
            int multiplesOther = buses[i];
            while(multiplesOther <= days) {
                multiplesOther += buses[i];
            }
            if(multiplesOther > days) {
                multiplesOther -= buses[i];
            }
            while(multiples > multiplesOther) {
                multiples -= buses[0];
            }
        }
        return multiples;
    }

    public static int solve2(int days, int[] planes) {
        for(int i = planes.length - 1; i > -1; i--) {
            days -= days % planes[i];
        }
        return days;
    }

////////////////////////////////////////////////////////////////

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