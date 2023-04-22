package ss12_java_collection_framework.bai_tap.practice_use_arraylist_linkedlist;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct(new Product("123","Lăn nách",20));
        pm.addProduct(new Product("124","Xe lăn",55));
        pm.addProduct(new Product("125","Quạt chotomatte",32));
        pm.addProduct(new Product("126","Chai khử mùi",65));
        pm.addProduct(new Product("127","Hàng cấm",125));

        pm.showProduct();
//        pm.editProduct("123");
//        pm.showProduct();
//        pm.deleteProduct("123");
//        pm.showProduct();
//        pm.searchProduct("Hàng cấm");
        pm.sortAscPriceProduct();
        pm.showProduct();
        pm.sortDescPriceProduct();
        pm.showProduct();
    }
}
