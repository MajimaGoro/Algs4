// 1.2.2 编写一个Interval1D的用例，从命令行接受一个整数N。从标准输入中读取N个间隔（每个间隔由一对double值定义）并打印出所有相交的间隔对

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_02 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Interval1D[] l = new Interval1D[n];
        for (int i = 0; i < n; i++) {
            int min = StdRandom.uniform(0, 100);
            int max = StdRandom.uniform(min, 100);
            l[i] = new Interval1D(min, max);
        }

        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                if (l[i].intersects(l[j]))
                    StdOut.println(l[i]+" and "+l[j]+" are intersecting.");
    }
}