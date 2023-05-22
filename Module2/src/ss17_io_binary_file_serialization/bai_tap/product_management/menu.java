package ss17_io_binary_file_serialization.bai_tap.product_management;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class menu {
    Scanner sc = new Scanner(System.in);
    ByteStream bytestream = new ByteStream();

    void addProduct() {
        String id;
        String nameProduct;
        String Manufacturers; // hãng sản xuất
        double price;
        String other;

        System.out.println("Enter id :");
        id = sc.nextLine();
        System.out.println("enter nameProduct");
        nameProduct = sc.nextLine();
        System.out.println("Enter the Manufacturers");
        Manufacturers = sc.nextLine();
        System.out.println("Enter the price ");
        price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter the other");
        other = sc.nextLine();

        Product myProduct = new Product(id, nameProduct, Manufacturers, price, other);
        ByteStream.addProduct(myProduct);
    }

    void listProduct() throws ClassNotFoundException, IOException {
        List<Product> myProducts = ByteStream.readProductList();
        for (Product product : myProducts) {
            System.out.println(product.toString());
        }
    }

    void findByProduct() {
        System.out.println("enter the id find ");
        Product product = ByteStream.findProductbyId(sc.nextLine());
        if (product != null) {
            System.out.println(product.toString());
        } else {
            System.out.println("not Find");
        }
    }

    void Menu() throws IOException, ClassNotFoundException {
        int chosen = 0;
        while (true) {
            System.out.println("1.add product");
            System.out.println("2.Write File prodcut");
            System.out.println("3.Read File prodcut");
            System.out.println("4.find product by id ");
            System.out.println("5.Exit ");

            System.out.println("choice :");
            chosen = Integer.parseInt(sc.nextLine());

            switch (chosen) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    ByteStream.writeObjectList();
                    break;
                case 3:
                    listProduct();
                    break;
                case 4:
                    findByProduct();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("nhap loi ");
                    break;
            }

        }

    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        menu m = new menu();
        m.Menu();
    }

}