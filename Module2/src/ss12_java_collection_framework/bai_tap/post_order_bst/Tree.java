package ss12_java_collection_framework.bai_tap.post_order_bst;

public interface Tree<E> {
    public boolean insert(E e);

    public void postorder();

    public int getSize();
}
