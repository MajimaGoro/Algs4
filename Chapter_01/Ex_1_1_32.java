// 1.1.32 直方图。假设标准输入流中含有一系列double值。编写一段程序，从命令行接受一个整数N 和两个double 值l 和r。
// 将(l，r) 分为N 段并使用StdDraw 画出输入流中的值落入每段的数量的直方图。

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdDraw;

public class Ex_1_1_32 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        double l = StdIn.readDouble();
        double r = StdIn.readDouble();
        double[] a = new In("TinyW.txt").readAllDoubles();
        drawHistogram(n, l, r, a);
    }

    public static void drawHistogram(int n, double l, double r, double[] a) {
        int[] count = new int[n];
        for (int i = 0; i < a.length; i++) {
            int range = getRange(n, l, r, a[i]);
            if (range >= 0)
                count[range]++;
        }

        int maxY = StdStats.max(count);

        //StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, maxY);

        double w = (r - l) / n;

        for (int i = 0; i < count.length; i++) {
            double x = l + (i + 0.5) * w;
            double y = count[i] / 2.0;
            double halfWidth = 0.5 * w;
            double halfHeight = y;
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }

    public static int getRange(int n, double l, double r, double v) {
        if (v >= r || v < l)
            return -1;
        return (int) ((v - l) / (r - l) * n);
    }
}
