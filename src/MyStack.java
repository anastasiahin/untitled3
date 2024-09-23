public class MyStack {
    private static class Node {
        Object value;
        Node next;
        Node(Object value) {
            this.value = value;
        }
    }
    private Node top;
    private int size;
    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            pop();
            return;
        }
        Node current = top;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
    public void clear() {
        top = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object peek() {
        if (top == null) {
            return null;
        }
        return top.value;
    }
    public Object pop() {
        if (top == null) {
            return null;
        }
        Object value = top.value;
        top = top.next;
        size--;
        return value;
    }
}
class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Size: " + stack.size()); // Виведе: Size: 3
        System.out.println("Peek: " + stack.peek()); // Виведе: Peek: Third
        System.out.println("Pop: " + stack.pop()); // Виведе: Pop: Third
        System.out.println("Size after pop: " + stack.size()); // Виведе: Size after pop: 2
        stack.remove(0);
        System.out.println("Peek after remove: " + stack.peek()); // Виведе: Peek: First
        stack.clear();
        System.out.println("Size after clear: " + stack.size()); // Виведе: Size after clear: 0
    }
}
