public class Solution {

    public static String solve(String digits) {
        // Solution 1
        String sol = "";
        int depth = 0;
        for(int i = 0; i < digits.length(); i++) {
            int n = digits.charAt(i) - '0';
            while(n > depth) {
                sol += "(";
                depth++;
            }
            while(n < depth) {
                sol += ")";
                depth--;
            }
            sol += n;
        }
        for(int i = 0; i < depth; i++) {
            sol += ")";
        }
        return sol;

        // Solution 2
        String sol = "";
        for(int i = 0; i < digits.length(); i++) {
            int n = digits.charAt(i) - '0';
            for(int j = 0; j < n; j++) {
                sol += "(";
            }
            sol += n;
            for(int j = 0; j < n; j++) {
                sol += ")";
            }
        }
        while(sol.contains(")(")) {
            sol = sol.replace(")(", "");
        }
        return sol;

        // Solution 3
        // create the string
        int max = 0;
        String sol = "";
        for(int i = 0; i < digits.length(); i++) {
            int n = Character.getNumericValue(digits.charAt(i));
            max = Math.max(max, n);
            for(int j = 0; j < n; j++) {
                sol += "(";
            }
            sol += n;
            for(int j = 0; j < n; j++) {
                sol += ")";
            }
        }

        // filter the string
        for(int j = 0; j < max; j++) {
            for(int i = 1; i < sol.length(); i++) {
                if(sol.substring(i - 1, i + 1).equals(")(")) {
                    sol = sol.substring(0, i - 1) + sol.substring(i + 1);
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        testingOne();
    }

    public static void testingOne() {
        System.out.println("TestingOne:");
        assertequals("0000", solve("0000"));
        assertequals("((((4))))", solve("4"));
        assertequals("(1)0(1)", solve("101"));
        assertequals("((2))0((((((6))))))", solve("206"));
        if(flag) {
            System.out.println("Darn failed TestingOne!");
        } else {
            System.out.println("Yay passed TestingOne!");
            testingTwo();
        }
    }

    public static void testingTwo() {
        System.out.println("TestingTwo:");
        assertequals("0(11)0", solve("0110"));
        assertequals("0(1111)", solve("01111"));
        assertequals("(111111)", solve("111111"));
        assertequals("0(1)0", solve("010"));
        if(flag) {
            System.out.println("Darn failed TestingTwo!");
        } else {
            System.out.println("Yay passed TestingTwo!");
            testingThree();
        }
    }

    public static void testingThree() {
        System.out.println("TestingThree:");
        assertequals("(1(2(3(4))))", solve("1234"));
        assertequals("(((((((((9))))))))11)", solve("911"));
        assertequals("(1(2)1111)", solve("121111"));
        assertequals("((((4))2(((5)))))", solve("425"));
        if(flag) {
            System.out.println("Darn failed TestingThree!");
        } else {
            System.out.println("Yay passed TestingThree!");
            System.out.println("YAY YOU PASSED ALL THE TESTS!");
            System.out.println("You are a real G");
        }
    }
    
    private static boolean flag = false;
    public static void assertequals(String a, String b) {
        if(!a.equals(b)) {
            flag = true;
            System.out.println("darn failed");
            System.out.println("Expected: " + a);
            System.out.println("Received: " + b);
        }
    }
}