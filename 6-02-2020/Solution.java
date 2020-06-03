// This comes from Kickstart 2018 Round F Question 1

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 1; i <= cases; i++) {
            int sol = solve(in);
            System.out.println("Case #" + i + ": " + sol);
        }
        in.close();
    }

    public static int solve(Scanner in) {
        int L = in.nextInt();
        String A = in.next();
        String B = in.next();
        int count = 0;
        for(int i = 0; i < L; i++) {
            Set<Map<Character, Integer>> setB = new HashSet<>();
            // Processing through setB
            for(int j = 0; j + i < L; j++) {
                setB.add(processing(B.substring(j, j + i + 1)));
            }

            // Checking through A possible solutions
            for(int j = 0; j + i < L; j++) {
                if(setB.contains(processing(A.substring(j, j + i + 1)))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Map<Character, Integer> processing(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }
}