import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'receivedText' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING S as parameter.
     */

    public static String receivedText(String S) {
        String sol = "";
        int p = 0;
        boolean lock = false;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c == '<') {
                p = 0;
            } else if(c == '>') {
                p = sol.length();
            } else if(c == '#') {
                lock = !lock;
            } else if(c == '*') {
                sol = (p == 0 ? "" : sol.substring(0, p - 1)) + sol.substring(p);
                p--;
            } else if(!(Character.isDigit(c) && lock)) {
                sol = sol.substring(0, p) + c + sol.substring(p);
                p++;
            }
        }
        return sol;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String S = bufferedReader.readLine();

        String result = Result.receivedText(S);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}