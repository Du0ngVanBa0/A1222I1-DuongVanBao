package ss12_java_collection_framework.thuc_hanh.deploying_bst;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
    }
}
