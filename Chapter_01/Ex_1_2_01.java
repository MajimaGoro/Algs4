// 1.2.1 编写一个Point2D的用例，从命令行接受一个整数N。在单位正方形内生成N个随机点，然后计算两点之间的最近距离

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;


public class Ex_1_2_01 {
    public static Point2D[] drawDot(int n) {
        Point2D[] dot = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            dot[i] = new Point2D(x, y);
            dot[i].draw();
        }
        return dot;
    }

    public static void drawLine(Point2D[] dot) {
        Point2D a = new Point2D(0.0, 0.0);
        Point2D b = new Point2D(0.0, 0.0);
        double dis = -1.0;
        for (int i = 0; i < dot.length - 1; i++)
            for (int j = i+1; j < dot.length; j++) {
                double d = dot[i].distanceTo(dot[j]);
                if (dis < 0 || d < dis) {
                    dis = d;
                    a = dot[i];
                    b = dot[j];
                }
            }
        a.drawTo(b);
        StdOut.println("the shortest distance of "+a+" to "+b+" is "+dis);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StdDraw.setScale(0, 1);
        StdDraw.rectangle(0.5, 0.5, 0.5, 0.5);

        StdDraw.setPenRadius(0.015);
        Point2D[] dot = drawDot(n);

        StdDraw.setPenRadius();
        drawLine(dot);
    }
}