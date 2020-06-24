import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 1; i <= cases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(in);
        }
        in.close();
    }
    // taking the top two and then taking them out
    public static void solve(Scanner in) {
        // read the input
        int i = in.nextInt();
        
        // put it in a data structure: array
        int[] P = new int[i];
        int sum = 0;
        for(int j = 0; j < i; j++) {
            // 0 -> 'A'
            int c = in.nextInt();
            P[j] = c;
            sum += c;
        }

        // while loop until all are 0
        while(sum != 0) {
            // find the largest one, second largest
            int one = -1; 
            int two = -1; 
            for (int j = 0; j < i; j++) {
                if (one == -1 || P[j] > P[one]) { 
                    two = one; 
                    one = j; 
                } else if (two == -1 || P[j] > P[two]) { 
                    two = j; 
                }
            }

            // if remove most is not majority
            P[one]--;
            sum--;
            System.out.print((char)(one + 'A'));
            if((double)(P[two]) / (double) (sum) > .5) {
                // (double) (p[two] / sum)
                P[two]--;
                sum--;
                System.out.print((char)(two + 'A'));
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}

// one at a time, then two if necessary
// two at a time, then one if necessary