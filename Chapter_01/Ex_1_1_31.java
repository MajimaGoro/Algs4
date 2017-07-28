// 1.1.31  随机连接。编写一段程序，从命令行接受一个整数N 和double 值p（0 到1 之间）作为参数，
// 在一个圆上画出大小为0.05 且间距相等的N 个点，然后将每对点按照概率p 用灰线连接。

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class Ex_1_1_31 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        double p = StdIn.readDouble();
        p = Math.max(0, Math.min(p, 1));

        drawPoint(n, p);
    }

    public static void drawPoint(int n, double p) {
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.circle(0.0, 0.0, 1.0);

        //StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setPenRadius(.015);
        StdDraw.setPenColor();

        double[][] a = new double[n][2];
        for (int i = 0; i < n; i++) {
            //x
            a[i][0] = Math.cos(2*Math.PI*i/n);
            //y
            a[i][1] = Math.sin(2*Math.PI*i/n);
            StdDraw.point(a[i][0], a[i][1]);
        }

        StdDraw.setPenRadius();

        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                if (StdRandom.bernoulli(p))
                    StdDraw.line(a[i][0], a[i][1], a[j][0], a[j][1]);
    }
}