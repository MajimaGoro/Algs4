//1.1.20 编写一个递归的静态方法计算ln(N!) 的值。
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_20 {
    public static void main(String[] args) {
        StdOut.println(calculate(3));
    }

    public static double calculate(int value) {
        if (value <= 1) {
            return 0;
        }
        return Math.log(value) + calculate(value - 1);
    }
}