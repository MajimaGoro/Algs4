// 1.3.37 Josephus问题。在这个古老的问题中，N个身陷绝境的人一致同意通过以下方式减少生存人数。他们围坐成一圈（位置记为0到N-1）并从第一个人开始报数，
// 报到M的人会被杀死，直到最后一个人留下来。传说Josephus找到了不会被杀死的位置。编写一个Queue的用例Josephus，从命令行接受N和M并打印出人们被杀死的
// 顺序（这也将显示Josephus在圈中的位置）。

import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_37<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    // private static class Node<Item> {
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Ex_1_3_37() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) 
            first = last;
        else
            oldLast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) 
            throw new IllegalArgumentException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) 
            last = null;
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    public Iterator<Item> iterator() {
        return new QueueIterator<Item>(first);
    }

    private class QueueIterator<Item> implements Iterator<Item> {
        private Node<Item> cur;

        public QueueIterator(Node<Item> first) {
            cur = first;
        }

        public void remove() {

        }

        public Item next() {
            if (!hasNext()) 
                throw new IllegalArgumentException();
            Item item = cur.item;
            cur = cur.next;
            return item;
        }

        public boolean hasNext() {
            return cur != null;
        }
    }

    public static void josephus(int n, int m) {
        Ex_1_3_37<Integer> queue = new Ex_1_3_37<Integer>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        StdOut.println(queue);

        int t = 0;
        while (!queue.isEmpty()) {
            int item = queue.dequeue();

            if (++t % m == 0)
                StdOut.print(item + " ");
            else
                queue.enqueue(item);
        }
    }

    public static void main(String[] args) {
        josephus(7, 2);
        StdOut.println("\n");
        josephus(10, 3);
    }
}