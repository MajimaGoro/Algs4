// 1.3.10 编写一个过滤器 InfixToPostfix ，将算数表达式由中序表达式转为后续表达式。

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

class Ex_1_3_10 {
    public static void infixToPostfix(String s) {
        String[] strings = s.split("\\s+");
        // for (int i = 0; i < strings.length; i++) {
        //     StdOut.println(strings[i].equals("("));
        //     StdOut.println(strings[i]);
        // }
        Stack<String> ops = new Stack<String>();
        Stack<String> value = new Stack<String>();
        for (int i = 0; i < strings.length; i++)
            if (strings[i].equals("("))
                ;
            else if (strings[i].equals("+") || strings[i].equals("-") || strings[i].equals("*") || strings[i].equals("/"))
                ops.push(strings[i]);
            else if (strings[i].equals(")")) {
                String v = value.pop();
                value.push(String.format("%s %s %s", value.pop(), v, ops.pop()));
            }
            else
                value.push(strings[i]);
        StdOut.println(s);
        StdOut.println(value.pop() + "\n");
    }

    public static void main(String[] args) {
        infixToPostfix("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        infixToPostfix("( ( ( 2 * 3 ) / ( 2 - 1 ) ) + ( 3 * ( 4 - 1 ) ) )");

        /*

        result:
        ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
        1 2 3 + 4 5 * * +

        ( ( ( 2 * 3 ) / ( 2 - 1 ) ) + ( 3 * ( 4 - 1 ) ) )
        2 3 * 2 1 - / 3 4 1 - * +

        */
    }
}