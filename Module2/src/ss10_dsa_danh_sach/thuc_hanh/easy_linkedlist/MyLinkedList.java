package ss10_dsa_danh_sach.thuc_hanh.easy_linkedlist;


public class MyLinkedList {
    private Node head;
    private int numNodes;
    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node{
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
