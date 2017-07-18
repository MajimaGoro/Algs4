import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_03 {
    public static void main(String[] args) {
        StdOut.println("Please enter three number:");
        int a, b, c;
        a = StdIn.readInt();
        b = StdIn.readInt();
        c = StdIn.readInt();

        if (isEqual(a, b, c)) {
            StdOut.println("equal");
        }
        else {
            StdOut.println("not equal");
        }
    }

    public static boolean isEqual(int a, int b, int c) {
        if (a == b && a == c) {
            return true;
        }
        return false;
    }

    return true;
}