package ss10_dsa_danh_sach.bai_tap.deployment_linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return getFirst();
        } else if (index == numNodes - 1) {
            return getLast();
        } else {
            Node temp = head;
            int timeLoop = index;
            for (int i = 0; i < timeLoop; i++) {
                temp = temp.next;
            }
            return (E) temp.data;
        }
    }

    public void addLast(E e) {
        Node temp = head;
        for (int i = 1; i < numNodes; i++) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        if (index == 0) {
            head = head.next;
        } else if (index == numNodes - 1) {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            int timeLoop = index - 2;
            for (int i = 0; i < timeLoop; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        numNodes--;
        return (E) temp.data;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    public int indexOf(E o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean remove(Object e) {
        int index = indexOf((E) e);
        if (index != -1) {
            remove(index);
        }
        return true;
    }

    public void addFirst(E e) {
        Node temp = new Node(e);
        temp.next = head;
        head = temp;
        numNodes++;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index == numNodes - 1) {
            addLast(element);
        } else {
            Node temp = head;
            int timeLoop = index - 1;
            for (int i = 0; i < timeLoop; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public Object clone() {
        MyLinkedList<E> clone = new MyLinkedList<>();
        clone.head = head;
        clone.numNodes = numNodes;
        return clone;
    }

    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
}
