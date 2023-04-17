package ss10_dsa_danh_sach.bai_tap.deployment_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(6);
        myLinkedList.addFirst(7);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(9);
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(10);
        myLinkedList.addLast(32);
        myLinkedList.add(4,100);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        MyLinkedList<Integer> clone = (MyLinkedList<Integer>) myLinkedList.clone();
        System.out.println("\nClone: ");
        for (int i = 0; i < clone.size(); i++) {
            System.out.print(clone.get(i) + " ");
        }
        clone.remove(new Integer(10));
        System.out.println("\nClone after remove 10: ");
        for (int i = 0; i < clone.size(); i++) {
            System.out.print(clone.get(i) + " ");
        }
    }
}
