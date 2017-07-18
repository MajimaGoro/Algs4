import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_05 {
    public static void main(String[] args) {
        StdOut.println("Please enter two number");
        double x, y;
        x = StdIn.readDouble();
        y = StdIn.readDouble();

        if (isClamp(x, 0, 1) && isClamp(y, 0, 1)) {
            StdOut.println("true");
        }
        else {
            StdOut.println("false");
        }
    }

    public static boolean isClamp(double value, double minValue, double maxValue) {
        if (value >= minValue && value <= maxValue) {
            return true;
        }
        return false;
    }
}