import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        String text = "";
        Stack <String> oldVersion = new Stack<>();

        for (int i = 0; i < Q; i++) {
            int request = scanner.nextInt();
            switch (request) {
                case 1:
                {
                    oldVersion.push(text);


                    String append = scanner.next();
                    text += append;
                    break;
                }


                case 2:
                {

                    oldVersion.push(text);


                    int k = scanner.nextInt();
                    String newText = text.substring(0, text.length() - k);
                    text = newText;
                    break;
                }

                case 3:
                {
                    int k = scanner.nextInt();
                    System.out.println(text.charAt(k - 1));
                    break;
                }

                case 4:
                {
                    if (!oldVersion.isEmpty()) {
                        String oldText = oldVersion.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
        scanner.close();
    }
}
