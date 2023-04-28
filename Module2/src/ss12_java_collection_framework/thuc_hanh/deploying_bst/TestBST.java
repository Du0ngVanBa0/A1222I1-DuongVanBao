package ss12_java_collection_framework.thuc_hanh.deploying_bst;

import java.util.Scanner;

public class TestBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
        System.out.println("Preorder (sorted): ");
        tree.preorder();
        System.out.println("The number of nodes is: " + tree.getSize());
        System.out.print("Enter a name u want to search in Product List:  ");
        String search = sc.nextLine();
        System.out.println("Search "+search+": "+tree.search(search));
    }
}
