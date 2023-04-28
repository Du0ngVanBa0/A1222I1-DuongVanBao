package ss12_java_collection_framework.thuc_hanh.deploying_bst;

public interface Tree<E> {
    public boolean insert(E e);

    public void inorder();

    public int getSize();

    public void preorder();
}
