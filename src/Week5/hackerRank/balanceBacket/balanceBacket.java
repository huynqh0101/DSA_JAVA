package Week5.hackerRank.balanceBacket;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        String openBrackets = "([{";
        String closeBrackets = ")]}";

        for (char bracket : s.toCharArray()) {
            if (openBrackets.indexOf(bracket) != -1) {
                stack.push(bracket);
            } else if (closeBrackets.indexOf(bracket) != -1) {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();
                if ((bracket == ')' && top != '(') ||
                        (bracket == '}' && top != '{') ||
                        (bracket == ']' && top != '[')) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


public class balanceBacket {
}
