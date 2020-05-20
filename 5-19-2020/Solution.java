import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 1; i <= cases; i++) {
            int sol = solve(in);
            System.out.println("Case #" + i + ": " + sol);
        }
    }
    
    public static int solve(Scanner in) {
        int n = in.nextInt();
        int k = in.nextInt();

        int count = 0;
        int expect = k;
        for(int i = 0; i < n; i++) {
            int value = in.nextInt();
            if(value == expect) {
                expect--;
            } else {
                expect = k;
            }
            if(expect == 0) {
                count++;
                expect = k;
            }
        }
        return count;
    }

    public static int solve2(Scanner in) {
        // input
        int n = in.nextInt();
        int k = in.nextInt();

        // taking in input values
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        // going through our input
        int count = 0;
        for(int i = 0; i < n; i++) {
            int look = list.get(i);
            if(look == k && i <= n - k) {
                boolean check = true;
                for(int j = i + 1; j < i + k; j++) {
                    if(list.get(j - 1) - 1 != list.get(j)) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    count++;
                }
            }
        }
        return count;
    }
}