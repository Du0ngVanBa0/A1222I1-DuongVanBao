package dvb.cart.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Cart() {
    }

    private boolean isProductInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectProductInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!isProductInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> productInCart = selectProductInCart(product);
            if (productInCart != null) {
                int quantity = productInCart.getValue() + 1;
                products.replace(productInCart.getKey(), quantity);
            }
        }
    }

    public void changeQuantity(Product product, int newQuantity) {
        if (!isProductInCart(product)) {
            products.put(product, newQuantity);
        } else {
            Map.Entry<Product, Integer> productInCart = selectProductInCart(product);
            if (productInCart != null) {
                if (newQuantity > 0) {
                    products.replace(productInCart.getKey(), newQuantity);
                } else {
                    products.remove(productInCart);
                }
            }
        }
    }

    public void deleteProduct(Product product) {
        Map.Entry<Product, Integer> productInCart = selectProductInCart(product);
        if (productInCart != null) {
            products.remove(productInCart.getKey());
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;
    }
}
