// import java.util.*;
// I don't know if you need this, but if you do, uncomment it!
public class Exam {
    public static int solve(int rightAnswers, String me, String friend) {
        // You can rename the variables to be something easier to remember
        return 1;
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