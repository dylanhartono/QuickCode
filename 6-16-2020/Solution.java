import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 1; i <= cases; i++) {
            BigInteger sol = solve(in);
            System.out.println("Case #" + i + ": " + sol.toString());
        }
    }

    public static final char LETTER = 'B';
    public static BigInteger solve(Scanner input) {
        String pattern = input.next();
        char[] look = pattern.toCharArray();
        BigInteger start = new BigInteger(input.next());
        BigInteger end = new BigInteger(input.next());

        int numBs = 0;
        for (int i = 0; i < look.length; i++) {
            if (look[i] == LETTER) {
                numBs++;
            }
        }

        BigInteger count = BigInteger.ZERO;

        int s = start.subtract(BigInteger.ONE).mod(BigInteger.valueOf(pattern.length())).intValue();
        int e = end.subtract(BigInteger.ONE).mod(BigInteger.valueOf(pattern.length())).intValue();

        for (int i = s; i < pattern.length(); i++) {
            if (look[i] == LETTER) {
                count = count.add(BigInteger.ONE);
            }
        }
        for (int i = 0; i <= e; i++) {
            if (look[i] == LETTER) {
                count = count.add(BigInteger.ONE);
            }
        }
        BigInteger startMid = start.add(BigInteger.valueOf(pattern.length() - s - 1));
        BigInteger endMid = end.subtract(BigInteger.valueOf(e + 1));
        BigInteger numRepeats = endMid.subtract(startMid).divide(BigInteger.valueOf(pattern.length()));
        count = count.add(numRepeats.multiply(BigInteger.valueOf(numBs)));
        return count;
    }
    
    public static BigInteger solve2(Scanner in) {
        // take pattern, beg, end
        String pattern = in.next();
        BigInteger length = BigInteger.valueOf(pattern.length());
        char[] look = pattern.toCharArray();
        BigInteger beg = new BigInteger(in.next());
        BigInteger end = new BigInteger(in.next());
        
        // count variable
        BigInteger count = BigInteger.ZERO;

        // loop over array of characters
        // mod to beginning
        // loop to end checking if it's blue or not
        //      counts in the background
        for(BigInteger i = beg; i.compareTo(end) <= 0; i = i.add(BigInteger.ONE)) {
            if(look[i.subtract(BigInteger.ONE).mod(length).intValue()] == 'B') {
                count = count.add(BigInteger.ONE);
            }
        }

        // return count
        return count;
    }

    // This is the official solution. The first solution from Mahin probably makes
    // more sense. I essentially combined many of his steps into for loop.
    public static BigInteger solve3(Scanner in) {
        // take pattern, beg, end
        String pattern = in.next();
        BigInteger length = BigInteger.valueOf(pattern.length());
        char[] look = pattern.toCharArray();
        BigInteger beg = new BigInteger(in.next());
        BigInteger end = new BigInteger(in.next());
        
        // count variables
        BigInteger countall = BigInteger.ZERO;
        BigInteger countbeg = BigInteger.ZERO;
        BigInteger countend = BigInteger.ZERO;

        // reestablish beginning and end
        int begindex = beg.subtract(BigInteger.ONE).mod(length).intValue();
        int endindex = end.subtract(BigInteger.ONE).mod(length).intValue();

        // layers
        BigInteger layers = end.subtract(BigInteger.valueOf(endindex + 1))
        .subtract(beg.add(length).subtract(BigInteger.valueOf(begindex + 1)))
        .divide(length);

        for(int i = 0; i < pattern.length(); i++) {
            if(look[i] == 'B') {
                if(i >= begindex) {
                    countbeg = countbeg.add(BigInteger.ONE);
                }
                if(i <= endindex) {
                    countend = countend.add(BigInteger.ONE);
                }
                countall = countall.add(BigInteger.ONE);
            }
        }

        return countbeg.add(countend).add(countall.multiply(layers));
    }

}