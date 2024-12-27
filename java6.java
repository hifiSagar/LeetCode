import java.util.*;

class MyStack {
    private Queue<Integer> q1;  // Main queue to store elements
    private Queue<Integer> q2;  // Temporary queue to assist with pop/top

    // Constructor
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element onto stack (push to q1)
    public void push(int x) {
        q1.add(x);  // Always add to q1
    }

    // Removes the element on the top of the stack and returns it
    public int pop() {
        // Move all but the last element from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // The last element in q1 is the one to pop
        int topElement = q1.poll();

        // Swap q1 and q2 so that q1 is ready for next operation
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Get the top element without removing it
    public int top() {
        // Move all but the last element from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // The last element in q1 is the top element
        int topElement = q1.peek();

        // Add the top element to q2 so that q1 can be restored
        q2.add(q1.poll());

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Returns true if the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());  // Output: 2
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.empty()); // Output: false
    }
}