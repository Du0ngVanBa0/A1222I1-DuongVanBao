package ss12_java_collection_framework.bai_tap.practice_use_arraylist_linkedlist;

import ss12_java_collection_framework.thuc_hanh.sort_by_comparable_comparator.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
//    ArrayList<Product> productList;
    LinkedList<Product> productList;

    public ProductManager() {
//        productList = new ArrayList<>();
        productList = new LinkedList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Add successfully this product into product list!");
    }

    public int searchNameIndex(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int searchIdIndex(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void searchProduct(String name) {
        int index = searchNameIndex(name);
        if (index != -1) {
            System.out.println("Product you want to search in index: " + index);
            System.out.println(productList.get(index));
        } else {
            System.out.println("Can't find this product in the product list!");
        }
    }

    public void editProduct(String id) {
        int pos = searchIdIndex(id);
        if (pos != -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----Edit Product-----");
            System.out.println("Enter new id:  ");
            String newId = sc.nextLine();
            System.out.println("Enter new name:  ");
            String newName = sc.nextLine();
            System.out.println("Enter new price:  ");
            int newPrice = Integer.parseInt(sc.nextLine());
            productList.set(pos, new Product(newId, newName, newPrice));
            System.out.println("Edit successfully id: " + id);
        } else {
            System.out.println("Can't find this position in the product list!");
        }
    }

    public void deleteProduct(String id) {
        int index = searchIdIndex(id);
        if (index != -1) {
            productList.remove(index);
            System.out.println("Delete successfully id: " + id);
        } else {
            System.out.println("Can't find this product in the product list!");
        }
    }

    public void sortAscPriceProduct() {
        AscPriceComparator ascPriceComparator = new AscPriceComparator();
        System.out.println("-----Sort ascending price-----");
        productList.sort(ascPriceComparator);
    }

    public void sortDescPriceProduct() {
        DescPriceComparator descPriceComparator = new DescPriceComparator();
        System.out.println("-----Sort descending price-----");
        productList.sort(descPriceComparator);
    }

    public void showProduct() {
        System.out.println("-----Show product list-----");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
