// 1.1.33 
// 矩阵库。编写一个 Matrix 库并实现以下API：
//  
// public class Matrix  
// static double dot(double[] x, double[] y) 
// 向量点乘
//   
// static double[][] mult(double[][] a, double[][] b) 
// 矩阵和矩阵之积
//  
// static double[][] transpose(double[][] a) 
// 转置矩阵
//   
// static double[] mult(double[][] a, double[] x) 
// 矩阵和向量之积
//  
// static double[] mult(double[] y, double[][] a) 
// 向量和矩阵之积
//  
// 编写一个测试用例，从标准输入读取矩阵并测试所有方法。

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_33 {
    public static void main(String[] args) {
        double[] dotX = new double[] {1, 2, 3};
        StdOut.println("dot result = " + dot(dotX, dotX) + "\n");

        double[][] multA = new double[][] {{1, 2, 3}, {4, 5, 6}};
        double[][] multB = new double[][] {{100, 10}, {10, 100}, {1, 1000}};
        print(mult(multA, multB));
        StdOut.print("\n");

        print(transpose(multA));
        StdOut.print("\n");

        print(mult(multA, dotX));
        StdOut.print("\n");

        print(mult(dotX, multB));
    }

    public static void print(double[] v) {
        String s = "";
        for (int i = 0; i < v.length; i++)
            s = s + String.format("%8.2f", v[i]);
        StdOut.println(s);
    }

    public static void print(double[][] a) {
        for (int i = 0; i < a.length; i++)
            print(a[i]);
    }

    //向量点乘
    //https://baike.baidu.com/item/%E5%B9%B3%E9%9D%A2%E5%90%91%E9%87%8F/448934?fr=aladdin
    public static double dot(double[] x, double[] y) {
        double value = 0;
        if (x.length != y.length)
            return value;
        for (int i = 0; i < x.length; i++) {
            value += x[i] * y[i];
        }
        return value;
    }

    //矩阵和矩阵之积
    //矩阵a的列数要等于b的行数
    public static double[][] mult(double[][] a, double[][] b) {
        int m = a.length;
        int p = a[0].length;
        int n = b[0].length;
        if (p != b.length)
            throw new IllegalArgumentException("colume is not equal to row");

        double[][] result = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < p; k++)
                    result[i][j] += a[i][k] * b[k][j];
            }
        }

        return result;
    }

    //转置矩阵
    public static double[][] transpose(double[][] a) {
        int m = a.length;
        int n = a[0].length;
        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                result[i][j] = a[j][i];

        return result;
    }

    //矩阵和向量之积
    //http://open.163.com/movie/2011/6/E/0/M82ICR1D9_M83E47VE0.html
    //理解为MxN的矩阵与Nx1矩阵相乘
    public static double[] mult(double[][] a, double[] x) {
        int m = a.length;
        int n = a[0].length;
        if (n != x.length)
            throw new IllegalArgumentException("colume is not equal to row");

        double[] result = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                result[i] += a[i][j] * x[j];
        return result;
    }

    //向量和矩阵之积
    //理解为1xM的矩阵和MxN矩阵相乘
    public static double[] mult(double[] y, double[][] a) {
        int m = y.length;
        int n = a[0].length;
        if (m != a.length)
            throw new IllegalArgumentException("colume is not equal to row");
        double[] result = new double[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                result[i] += y[j] * a[j][i];
        return result;
    }

}