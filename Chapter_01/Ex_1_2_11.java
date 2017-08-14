// 1.2.11 根据Date的API实现一个SmartDate类型，在日期非法时抛出一个异常。

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_11 {
    // static变量也称作静态变量，静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。
    // 而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。
    private static final int[] DAYS = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int month;
    private final int day;
    private final int year;


    public Ex_1_2_11(int m, int d, int y) {
        if (!isVaild(m, d, y))
            throw new IllegalArgumentException("Invalid date");
        month = m;
        day = d;
        year = y;
    }

    private static boolean isVaild(int m, int d, int y) {
        if (m > 12 || m <= 0)
            return false;
        if (d > DAYS[m])
            return false;
        if (m == 2 && d == 29 && !isLeapYear(y))
            return false;
        return true;
    }

    // 闰年是公历中的名词，能被4整除但不能被100整除，或能被400整除的年份即为闰年。
    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public int day() {
        return day;
    }

    public int month() {
        return month;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }


    public static void main(String[] args) {
        // http://www.cnblogs.com/dolphin0520/p/3799052.html
        // “static方法就是没有this的方法。在static方法内部不能调用非静态方法，反过来是可以的。
        // 而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用static方法。这实际上正是static方法的主要用途。”
        StdOut.println(Ex_1_2_11.isVaild(8, 40, 2017));

        Ex_1_2_11 date1 = new Ex_1_2_11(8, 14, 2017);
        StdOut.println(date1);

        Ex_1_2_11 date2 = new Ex_1_2_11(8, 40, 2017);
        StdOut.println(date2);
    }
}