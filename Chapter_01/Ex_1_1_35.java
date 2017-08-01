// 1.1.35 模拟掷骰子。以下代码能够计算每种两个骰子之和的准确概率分布： 
// int SIDES = 6; 
// double[] dist = new double[2*SIDES+1]; 
// for (int i = 1; i <= SIDES; i++) 
//     for (int j = 1; j <= SIDES; j++) 
//         dist[i+j] += 1.0; 
// for (int k = 2; k <= 2*SIDES; k++) 
//     dist[k] /= 36.0; 
// dist[i] 的值就是两个骰子之和为i 的概率。用实验模拟N 次掷骰子，并在计算两个1 到 6 之间的随机整数之和时记
// 录每个值的出现频率以验证它们的概率。N 要多大才能够保证你的经验数据和准确数据的吻合程度达到小数点后三位？

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_1_35 {
    private static final int SIDES = 6;

    public static double[] getProbability() {
        double[] dist = new double[SIDES*2+1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;

        for (int k = 2; k <= SIDES*2; k++)
            dist[k] /= SIDES*SIDES;

        return dist;
    }

    public static double[] getActual(int n) {
        double[] dist = new double[SIDES*2+1];
        for (int i = 0; i < n; i++) {
            int a = StdRandom.uniform(1, SIDES+1);
            int b = StdRandom.uniform(1, SIDES+1);
            dist[a+b] += 1.0;
        }

        for (int k = 2; k <= SIDES*2; k++)
            dist[k] /= n;

        return dist;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        for (int i = 2; i <= SIDES*2; i++)
            StdOut.printf("%7d", i);
        StdOut.println();

        double[] pro = getProbability();
        for (int i = 2; i <= SIDES*2; i++)
            StdOut.printf("%7.3f", pro[i]);
        StdOut.println();

        double[] act = getActual(n);
        for (int i = 2; i <= SIDES*2; i++)
            StdOut.printf("%7.3f", act[i]);
        StdOut.println();

        // StdOut.printf("%7.3f", 0.0016);      输出0.002
        // StdOut.printf("%7.3f", 0.0012);      输出0.001
        for (int i = 2; i <= SIDES*2; i++) {
            double p = Math.round(pro[i] * 1000) / 1000.0;
            double a = Math.round(act[i] * 1000) / 1000.0;
            double t = Math.abs(p - a);
            if (t >= 0.001) {
                StdOut.println("It is inaccurate");
                return;
            }
        }
        StdOut.println("It is accurate");
    }
}