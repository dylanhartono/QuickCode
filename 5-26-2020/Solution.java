import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 1; i <= cases; i++) {
            String sol = solve(input);
            System.out.println("Case #" + i + ": " + sol);
        }
    }
    public static String solve(Scanner input) {
        int xp = input.nextInt();
        int yp = input.nextInt();
        String m = input.next();

        int xi = 0;
        int yi = 0;

        int count = 0;
        for(int i = 0; i < m.length(); i++) {
            // update pepper
            char c = m.charAt(i);
            if(c == 'N') {
                yp++;
            } else if(c == 'S') {
                yp--;
            } else if(c == 'W') {
                xp--;
            } else {
                xp++;
            }

            if(xi != xp) {
                // handle x's
                int w = xi - 1;
                int e = xi + 1;
                if((e == xp && yi == yp) || (w == xp && yi == yp)) {
                    return "" + (count + 1);
                }
                if(Math.abs(xp - w) < Math.abs(xp - e)) {
                    xi = w;
                } else {
                    xi = e;
                }
            } else {   
                // handle y's
                int n = yi + 1;
                int chill = yi;
                int s = yi - 1;
                
                if(chill == yp) {
                    return "" + (count + 1);
                } else if(s == yp) {
                    return "" + (count + 1);
                } else if(n == yp) {
                    return "" + (count + 1);
                }
                if(Math.abs(yp - n) < Math.abs(yp - s)) {
                    yi = n;
                } else {
                    yi = s;
                }
            }
            count++;
        }
        return "IMPOSSIBLE";
    }
}