package ss11_stack_queue.bai_tap.deploying_circular_linkedlist;

public class Main {
    public static void main(String[] args) {
        Queue saleQueue = new Queue();
        saleQueue.enQueue(14);
        saleQueue.enQueue(28);
        saleQueue.enQueue(25);
        saleQueue.enQueue(36);
        saleQueue.enQueue(45);
        saleQueue.deQueue();
        saleQueue.displayQueue();
    }
}
