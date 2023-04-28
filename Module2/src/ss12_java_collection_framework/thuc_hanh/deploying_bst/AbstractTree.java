package ss12_java_collection_framework.thuc_hanh.deploying_bst;

public abstract class AbstractTree<E> implements Tree<E>{
    @Override
    public void inorder() {
    }

    public abstract boolean search(E e);

    @Override
    public void preorder() {

    }
}
