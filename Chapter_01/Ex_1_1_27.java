// 1.1.27 二项分布。估计用以下代码计算binomial(100, 50) 将会产生的递归调用次数： 
// public static double binomial(int N, int k, double p) 
// {  
// if (N == 0 && k == 0) return 1.0; and if (N < 0 || k < 0) return 0.0; 
// return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1); 
// }  
// 将已经计算过的值保存在数组中并给出一个更好的实现。

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Counter;
//package edu.princeton.cs.algs4;

public class Ex_1_1_27 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int k = StdIn.readInt();
        double p = StdIn.readDouble();
        Counter c = new Counter("calls");
        double result = binomial(n, k, p, c);
        StdOut.println("result = "+result);
        StdOut.println(c);
    }

    public static double binomial(int n, int k, double p, Counter c) {
        double[][] a = new double[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                a[i][j] = -1;
            }
        }
        return binomial(a, n, k, p, c);
    }

    public static double binomial(double[][] a, int n, int k, double p, Counter c) {
        if (n == 0 && k == 0) {
            return 1.0;
        }
        if (n < 0 || k < 0) {
            return 0.0;
        }

        if (a[n][k] == -1) {
            c.increment();
            a[n][k] = (1.0 - p)*binomial(a, n-1, k, p, c) + p*binomial(a, n-1, k-1, p, c);
        }
        //c.increment();
        //return (1.0 - p)*binomial(a, n-1, k, p, c) + p*binomial(a, n-1, k-1, p, c);
        return a[n][k];
    }
}