package Day7;


import java.util.*;

public class GenericStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();
    private int top = 0;

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public void push(T item) {
        stack.add(top++, item);
    }

    public T pop() {
        return stack.remove(--top);
    }

    public static void main(String[] args) {
        GenericStack<Integer> s = new GenericStack<Integer>();
        s.push(17);
        int i = s.pop();
        System.out.format("%4d%n", i);
        System.out.println(String.valueOf(s.isEmpty()));
    }

}