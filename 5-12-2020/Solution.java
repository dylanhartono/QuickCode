import java.util.*;
public class Solution {
    public static int solve(int rightAnswers, String me, String fr) {
        // You can rename the variables to be something easier to remember
        // hints: 
        // you can see how many questions there are with s.length()
        // grab an index with s.charAt(index)
        // maybe think of how many they got wrong?

        // NOTE: I'm working with Mahin's answer to see if it is possible
        // Ask me questions whenever :)
        boolean[] arr = new boolean[me.length()];
        for(int i = 0; i < me.length(); i++) {
            arr[i] = me.charAt(i) == fr.charAt(i);
        }
        int max = 0;
        int R = rightAnswers;
        int N = me.length();
        List<int[]> combinations = generate(N, R);
        for(int[] combo : combinations) {
            int val = 0;
            int j = 0;
            for(int i = 0; i < me.length(); i++) {
                if(j < combo.length - 1 && combo[j] < i) {
                    j++;
                }
                val += combo[j] == i && arr[i] ? 1 : 0;
                val += combo[j] != i && !arr[i] ? 1 : 0;
            }
            max = Math.max(val, max);
        }
        return max;
    }
    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }
    private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
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