package ss10_dsa_danh_sach.bai_tap.deployment_arraylist;

public class MyList<E> {
    private int size;
    static final int DEFAULT_CAPACITY = 10;
    Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    int size() {
        return size;
    }

    public Object clone() {
        MyList<E> clone = new MyList<>();
        System.arraycopy(elements, 0, clone.elements, 0, size);
        clone.size = size;
        return clone;
    }

    public void clear() {
        for (Object e : elements) {
            e = null;
        }
        size = 0;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2]);
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
        }
    }

    public boolean contains(E o) {
        for (Object e : elements) {
            if (e == o) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, E element) {
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = element;
        size++;
    }

    public boolean add(E o) {
        ensureCapacity(size + 1);
        elements[size] = o;
        size++;
        return true;
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
        E e = (E) elements[index];
        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];
        elements[size - 1] = null;
        size--;
        return e;
    }
}
