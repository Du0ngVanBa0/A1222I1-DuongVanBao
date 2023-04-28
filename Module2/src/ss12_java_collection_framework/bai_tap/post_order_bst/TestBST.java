package ss12_java_collection_framework.bai_tap.post_order_bst;

public class TestBST {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("DD");
        tree.insert("CD");
        tree.insert("FD");
        tree.insert("ID");
        tree.insert("ED");
        tree.insert("BD");
        tree.insert("GD");
        tree.insert("HD");
        tree.insert("AD");
        tree.postorder();
    }
}
