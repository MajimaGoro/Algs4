// 1.3.42 复制栈。为基于链表实现的栈编写一个新的构造函数，使以下代码
//        Stack<Item> t = new Stack<Item>(s);
//        得到的t指向栈s的一个新的独立的副本。

import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_42<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Ex_1_3_42() {
        first = null;
        n = 0;
    }

    public Ex_1_3_42(Ex_1_3_42<Item> s) {
        this();

        Ex_1_3_42<Item> temp = new Ex_1_3_42<Item>();
        for (Item item : s) {
            temp.push(item);
        }
        for (Item item : temp) {
            this.push(item);
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) 
            throw new IllegalArgumentException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) 
            throw new IllegalArgumentException("Stack underflow");
        return first.item;
    }

    public Iterator<Item> iterator() {
        Iterator<Item> iter = new StackIterator<Item>(first);
        return iter;
    }

    private class StackIterator<Item> implements Iterator<Item> {
        private Node<Item> cur;

        public StackIterator(Node<Item> first) {
            cur = first;
        }

        public void remove() {

        }

        public boolean hasNext() {
            return cur != null;
        }

        public Item next() {
            if (!hasNext())
                throw new IllegalArgumentException("");
            Item item = cur.item;
            cur = cur.next;
            return item;
        }
    }


    public static void main(String[] args) {
        Ex_1_3_42<Integer> s = new Ex_1_3_42<Integer>();
        for (int i = 0; i < 5; i++) 
            s.push(i);
        StdOut.println(s);

        StdOut.println("");

        Ex_1_3_42<Integer> t = new Ex_1_3_42<Integer>(s);
        StdOut.println(t);


    }
}