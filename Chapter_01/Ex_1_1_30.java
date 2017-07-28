// 1.1.30  数组练习。编写一段程序，创建一个N×N 的布尔数组a[][]。其中当i 和j 互质时（没有相同因子），a[i][j] 为true，否则为false。

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_30 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (gcd(i, j) == 1)
                    a[i][j] = true;
                else
                    a[i][j] = false;
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++)
                s = s + String.format("%6s", a[i][j]);
            StdOut.println(s);
        }
    }

    public static int gcd(int p, int q) {
        if (p == 0 || q == 0)
            return 1;

        int r = p % q;
        if (r == 0)
            return q;
        return gcd(q, r);
    }
}