/**
 *1.1.15  编写一个静态方法histogram()，接受一个整型数组a[] 和一个整数M 为参数并返回一个大小为M的数组，
 *其中第i个元素的值为整数i在参数数组中出现的次数。如果a[]中的值均在0到M-1之间，
 *返回数组中所有元素之和应该和a.length 相等
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_15 {

    public static void main(String[] args) {
        int n = 30;
        int m = 10;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(m);
        }

        for (int i = 0; i < n; i++) {
            StdOut.printf("%2d", a[i]);
        }

        int[] h = histogram(a, m);

        StdOut.println("\n");
        for (int i = 0; i < h.length; i++) {
            StdOut.printf("%4d", h[i]);
        }
    }
    
    public static int[] histogram(int[] a, int m) {
        int[] h = new int[m];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0 && a[i] < m) {
                h[a[i]]++;
            }
        }
        return h;
    }
}