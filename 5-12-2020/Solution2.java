// import java.util.*;
// I don't know if you need this, but if you do, uncomment it!
public class Solution2 {
    public static int solve(int rightAnswers, String me, String friend) {
        int same = 0;
        int diff = 0;
        for(int i = 0; i < me.length(); i++) {
            if(me.charAt(i) == friend.charAt(i)) {
                same++;
            } else {
                diff++;
            }
        }
        if(rightAnswers > same) {
            // same + (diff - rightAnswers)
            return me.length() - rightAnswers;
        } else {
            return rightAnswers + diff;
        }
    }

    public static int solve2(int rightAnswers, String me, String friend) {
        int count = 0;
        int compliment = me.length() - rightAnswers;
        for(int i = 0; i < me.length(); i++) {
            if(me.charAt(i) == friend.charAt(i) && rightAnswers > 0) {
                rightAnswers--;
                count++;
            } else if(rightAnswers == 0 && me.charAt(i) == friend.charAt(i)) {
                compliment--;
            }
        }
        return count + compliment;
    }

    public static void main(String[] args) {
        testing();
    }

    public static void testing() {
        assertequals(2, solve(2, "TTTT", "TTTT"));
        assertequals(2, solve(3, "FTFFF", "TFTTT"));
        assertequals(9, solve(6, "TTFTFFTFTF", "TTTTFFTTTT"));
        assertequals(38, solve(15,"TTFTFTFTFFFTFTFTTTTFTFFFFTFTFTFTFFFTFTFTFTF", 
                    "FTFTFTTFTFTFTFTFTFTTFTFTFTFTFTFFFFFFFFTFTFT"));
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