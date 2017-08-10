// 如果字符串s中的字符循环移动任意位置之后能够得到另一个字符串t，那么s就被称为t的回环变位。例如，ACTGACG就是TGACGAC的一个回环变位，反之亦然。
// 判定这个条件在基因组序列的研究中是很重要的。编写一个程序检查两个给定的字符串s和t是否互为回环变位。提示：答案只需要一行用到indexOf()、length()和字符串连接的代码。

import edu.princeton.cs.algs4.StdOut;

class Ex_1_2_06 {
    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];
        if ((s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0)) {
            StdOut.println(s+" and "+t+" is circular rotation.");
            return;
        }
        StdOut.println(s+" and "+t+" is not circular rotation.");
    }
}