package ss11_stack_queue.bai_tap.deploying_circular_linkedlist;

public class Queue {
    public Node front;
    public Node rear;

    public void enQueue(int d) {
        Node temp = new Node(d);
        if (front == null) {
            front = rear = temp;
            front.link = front;
        } else {
            rear.link = temp;
            rear = temp;
            rear.link = front;
        }
    }

    public void deQueue() {
        if (front == null) {
            return;
        } else if (front == rear) {
            front = rear = null;
        } else {
            Node temp = rear;
            while (temp.link != rear) {
                temp = temp.link;
            }
            rear = temp;
            rear.link = front;
        }
    }

    public void displayQueue() {
        if (front == null) {
            return;
        } else {
            Node temp = front;
            do {
                System.out.println(temp.data);
                temp = temp.link;
            } while (temp != front);
        }
    }
}
