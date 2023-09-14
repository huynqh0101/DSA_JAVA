package Week1;
public class bai6 {
    public static void main(String[] args) {
        // In ra chữ "NQH" bằng 9 dòng ký tự '*'
        String[] n = {
                "*       *",
                "**      *",
                "* *     *",
                "*  *    *",
                "*   *   *",
                "*    *  *",
                "*     * *",
                "*      **",
                "*       *"
        };

        String[] q = {
                "  *****  ",
                " *     * ",
                "*       *",
                "*       *",
                "*   *   *",
                " *     * ",
                "  *****  ",
                "        *",
                "         *"
        };

        String[] h = {
                "  *       *",
                "  *       *",
                "  *       *",
                "  *********",
                "  *       *",
                "  *       *",
                "  *       *",
                "  *       *",
                " *       *"
        };

        for (int i = 0; i < 9; i++) {
            System.out.println(n[i] + " " + q[i] + " " + h[i]);
        }
    }
}