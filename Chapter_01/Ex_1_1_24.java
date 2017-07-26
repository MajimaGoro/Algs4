/**1.1.24  给出使用欧几里德算法计算105 和24 的最大公约数的过程中得到的一系列p 和q 的值。
 *扩展该算法中的代码得到一个程序Euclid，从命令行接受两个参数，计算它们的最大公约数并打
 *印出每次调用递归方法时的两个参数。使用你的程序计算1 111 111 和1 234 567 的最大公约数。
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_24 {
    public static void main(String[] args) {
        int p = StdIn.readInt();
        int q = StdIn.readInt();
        if (p <= 0 || q <= 0) {
            StdOut.println("error");
            return;
        }
        if (p >= q) {
            StdOut.println("result: "+gcd(p, q));
            return;
        }
        StdOut.println("result: "+gcd(q, p));
    }

    public static int gcd(int p, int q) {
        StdOut.println("p: "+p+"  q: "+q);
        int r = p % q;
        if (r == 0) {
            return q;
        }
        return gcd(q, r);
    }
}