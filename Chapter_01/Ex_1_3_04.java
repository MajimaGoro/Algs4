// 1.3.4 编写一个 Stack 的用例 Parentheses ，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整。例如，对于[()]{}{[()()]()}程序应该打印 true，对于[(])则打印 false。

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

class Ex_1_3_04 {

    public static boolean isBalanced(String s) {
        Stack<Character> left = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(')
                left.push(c);
            else if (c == '}' && (left.isEmpty() || left.pop() != '{'))
                return false;
            else if (c == ']' && (left.isEmpty() || left.pop() != '['))
                return false;
            else if (c == ')' && (left.isEmpty() || left.pop() != '('))
                return false;
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "[()]{}{[()()]()}";
        StdOut.println("string: "+s1+"\nisBalanced: "+isBalanced(s1));

        String s2 = "[(])";
        StdOut.println("string: "+s2+"\nisBalanced: "+isBalanced(s2));

        String s3 = "[()";
        StdOut.println("string: "+s3+"\nisBalanced: "+isBalanced(s3));

        String s4 = "())";
        StdOut.println("string: "+s4+"\nisBalanced: "+isBalanced(s4));
    }
}