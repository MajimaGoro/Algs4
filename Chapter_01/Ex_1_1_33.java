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


public class Ex_1_1_33 {

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
    public static double[][] mult(double[][] a, double[][] b) {
        int m = a.length;
        int p = a[0].length;
        int n = b[0].length;
        if (p != b.length)
            throw new IllegalArgumentException("file argument is null");

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

    
}