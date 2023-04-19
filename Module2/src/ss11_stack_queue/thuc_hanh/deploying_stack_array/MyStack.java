package ss11_stack_queue.thuc_hanh.deploying_stack_array;

public class MyStack {
    private int[] arr;
    private int size = 0;
    private int index = -1;

    public MyStack(int size) {
        this.size = size;
        arr = new int[this.size];
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            index++;
            arr[index] = element;
        }
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is null");
        } else {
            return arr[index--];
        }
    }

    public int size() {
        return index + 1;
    }

    public boolean isFull() {
        return (this.size == this.index + 1);
    }

    public boolean isEmpty() {
        return (this.index == -1);
    }
}
