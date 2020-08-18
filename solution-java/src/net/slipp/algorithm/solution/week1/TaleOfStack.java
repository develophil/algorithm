package net.slipp.algorithm.solution.week1;

import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
 */
public class TaleOfStack {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T extends Number> {

    private Stack<T> fifo;
    private Stack<T> lifo;

    public MyQueue() {
        this.fifo = new Stack<>();
        this.lifo = new Stack<>();
    }

    public void enqueue(T number) {

        if (number.longValue() < 1 || number.longValue() > Math.pow(10, 9)) {
            return;
        }

        transferTo(fifo, lifo);

        lifo.push(number);

    }

    public void dequeue() {

        transferTo(lifo, fifo);

        fifo.pop();

    }

    public T peek() {

        transferTo(lifo, fifo);

        return fifo.peek();
    }

    private static <T> void transferTo(Stack<T> source, Stack<T> target) {

        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }
}
