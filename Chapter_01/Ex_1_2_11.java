// 1.2.11 根据Date的API实现一个SmartDate类型，在日期非法时抛出一个异常。
// 
// 1.2.12 为SmartDate添加一个方法dayOfTheWeek()，为日期中每周的日返回 Monday、Tuesday、Wednesday、Thursday、Friday、Saturday 或 Sunday 中的适当值。你可以假定时间是21世纪。

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


    // 蔡勒（Zeller）公式，（蔡勒公式只适合于1582年（中国明朝万历十年）10月15日之后的情形）
    // w：星期； w对7取模得：0-星期日，1-星期一，2-星期二，3-星期三，4-星期四，5-星期五，6-星期六
    // c：世纪（年份前两位数）
    // y：年（后两位数）
    // m：月（m大于等于3，小于等于14，即在蔡勒公式中，某年的1、2月要看作上一年的13、14月来计算，比如2003年1月1日要看作2002年的13月1日来计算）
    // d：日
    // [ ]代表取整，即只要整数部分。

    // w=(y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1)%7
    private static String dayOfTheweek(int m, int d, int y) {
        if (!isVaild(m, d, y))
            throw new IllegalArgumentException("Invalid date");
        if (y < 1582)
            throw new IllegalArgumentException("Unable to calculate");
        if (y == 1582 && m < 10)
            throw new IllegalArgumentException("Unable to calculate");
        if (y == 1582 && m == 10 && d < 15)
            throw new IllegalArgumentException("Unable to calculate");

        if (m <= 2) {
            m += 12;
            y--;
        }
        int c = y / 100;
        y = y % 100;
        int w = (y + (y / 4) + (c / 4) - 2 * c + (26 * (m + 1) / 10) + d - 1) % 7;
        switch (w) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "Sunday";
        }
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

        StdOut.println(Ex_1_2_11.dayOfTheweek(8, 16, 2017));
        StdOut.println(Ex_1_2_11.dayOfTheweek(7, 16, 2017));
        StdOut.println(Ex_1_2_11.dayOfTheweek(11, 22, 1992));
        // StdOut.println(Ex_1_2_11.dayOfTheweek(10, 10, 1582));

        Ex_1_2_11 date1 = new Ex_1_2_11(8, 14, 2017);
        StdOut.println(date1);

        Ex_1_2_11 date2 = new Ex_1_2_11(8, 40, 2017);
        StdOut.println(date2);
    }
}