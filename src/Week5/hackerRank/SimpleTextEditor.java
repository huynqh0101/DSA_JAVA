import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        String text = "";
        Stack <String> st = new Stack<>();

        for (int i = 0; i < Q; i++) {
            int re = sc.nextInt();
            switch (re) {
                case 1:
                {
                    st.push(text);


                    String append = sc.next();
                    text += append;
                    break;
                }


                case 2:
                {

                    st.push(text);
                    int k = sc.nextInt();
                    String newText = text.substring(0, text.length() - k);
                    text = newText;
                    break;
                }

                case 3:
                {
                    int k = sc.nextInt();
                    System.out.println(text.charAt(k - 1));
                    break;
                }

                case 4:
                {
                    if (!st.isEmpty()) {
                        String oldText = st.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
        sc.close();
    }
}
