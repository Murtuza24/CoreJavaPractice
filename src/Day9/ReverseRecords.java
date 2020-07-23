package Day9;

import java.util.Iterator;
import java.util.Stack;

public class ReverseRecords {
    static Stack<String> stack = new Stack<String>();

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            stack.add("Employee"+i);
        }

        Iterator iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.println(stack.pop());
        }


    }
}
