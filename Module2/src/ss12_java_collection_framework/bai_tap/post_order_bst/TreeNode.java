package ss12_java_collection_framework.bai_tap.post_order_bst;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> right;
    protected TreeNode<E> left;

    public TreeNode(E element) {
        this.element = element;
    }
}
