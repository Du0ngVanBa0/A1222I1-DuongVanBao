package ss12_java_collection_framework.bai_tap.practice_use_arraylist_linkedlist;

import java.util.Comparator;

public class AscPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
