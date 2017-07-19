//1.1.9 编写一段代码，将一个正整数N 用二进制表示并转换为一个String 类型的值s
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_09 {
    public static void main(String[] args) {
        StdOut.println("Please enter a number");
        int n = StdIn.readInt();
        if (n < 0) {
            StdOut.println("error");
            return;
        }
        String s = "";
        while (n > 0) {
            s = n % 2 + s;
            n = n / 2;
        }
        StdOut.println(s);
    }
}