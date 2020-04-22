// Guys realize all of these are in O(n) runtime, so any of your solutions would have been
// efficient and fast in this case

public class Solution {
    // Nice Aaron and Mahin I honestly did not think this would end up being correct, but looking
    // at the logic, it's all there!
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

    // Ben's supposed solution in fruition. It was sooo close
    public static int solve2(int days, int[] buses) {
        int val = buses[buses.length - 1];
        while(buses[buses.length - 1] <= days - buses[buses.length - 1]) {
            buses[buses.length - 1] += val;
        }
        for(int i = buses.length - 2; i > -1; i--) {
            val = buses[i];
            while(buses[i] <= buses[i + 1] - val) {
                buses[i] += val;
            }
        }
        return buses[0];
    }

    // Andrea's Solution
    // If I were following you {3, 7, 2}, 10 -> would end up to be like {1, 3, 0}, 10
    // Realize if you subtracted all the elements in the array from 10 you would get 6
    // aka the answer
    public static int solve3(int days, int[] buses) {
        for(int i = 0; i < buses.length; i++) {
            buses[i] = days % buses[i];
        }
        for(int i = 0; i < buses.length; i++) {
            days -= buses[i];
        }
        return days;
    }

    // Do answers like above. Only pure luck will get you to 3 line answers like these
    public static int solve4(int days, int[] planes) {
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