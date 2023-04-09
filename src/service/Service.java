package service;

import model.Product;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static model.Market.*;

public class Service {

    private ArrayList<Product> products = new ArrayList<>();
    private Map<Product, Integer> cart = new HashMap<>();

    public void registerProducts() {
        System.out.println("How many products do you want to register: ");
        int qtdProd = sc.nextInt();
        for (int i = 0; i < qtdProd; i++) {
            System.out.println("Name of product: ");
            String name = sc.next();

            System.out.println("Price of product: ");
            Double price = sc.nextDouble();

            Product product = new Product(name, price);
            this.setProducts(product);

            System.out.println("Product register sucessFull");
        }
    }

    public void listProducts() {
        if (this.getProducts().size() > 0) {
            System.out.println("List of all products: ");
            for (Product p : products) {
                System.out.println(p);
                System.out.println();
            }

        } else {
            System.out.println("Not product register!");
        }
    }

    public void purchaseProducts() {
        if (this.getProducts().size() > 0) {
            System.out.println("Code of product: ");

            System.out.println("--------- Product disponible ------------");
            for (Product p : products) {
                System.out.println(p + "\n");
            }

            System.out.println("Enter the codes of the products you want to add to the cart: ");
            int id = sc.nextInt();

            for (Product p : products) {
                if (p.getId() == id) {
                    int qtd = Objects.isNull(cart.get(p)) ? 0 : cart.get(p);
                    this.setCart(p, qtd++);

                    System.out.println(p.getName() + " ADD in cart");

                    System.out.println("Want to add another product to the cart?  ");
                    System.out.println("Type 1 to yes or 0 to finish purchase: ");
                    int option = sc.nextInt();

                    if (option == 1) {
                        purchaseProducts();
                    } else {
                        finishPurchase();
                    }

                }
            }
        } else {
            System.out.println("Not existing Products registers!");
        }
    }

    public void cartProducts() {
        System.out.println("Products in your Cart!");
        if (this.getCart().size() > 0) {
            for (Product p : cart.keySet()) {
                System.out.println("Product: " + p + " \nAmount: " + cart.get(p));
            }
        } else {
            System.out.println("Cart empty!");
        }
    }

    public void deleteProducts() {
        int option = 0;
        do {
            boolean isPresent = false;

            System.out.println("Which product do you want to remove: ");
            int id = sc.nextInt();
            for (Product p : products) {
                if (p.getId() == id) {
                    isPresent = true;
                    products.remove(p);
                    System.out.println("Product removed successfully!");
                    break;
                }
            }

            if (!isPresent){
                System.out.println("Product not found.");
            }

            System.out.println("Do you want to remove another product type: 0");
            System.out.println("Do you want to exit type: 1");
            option = sc.nextInt();

        } while (option != 1);

    }

    public void finishPurchase() {
        Double valueOfPurchase = 0.0;
        System.out.println("Your products: ");
        for (Product p : products) {
            int qtd = cart.get(p);
            valueOfPurchase += p.getPrice() * qtd;
            System.out.println(p);
            System.out.println("Ammount: " + qtd);
            System.out.println("---------------");
        }
        System.out.println("The value you purchase is: " + Utils.doubleToString(valueOfPurchase));
        System.out.println("Thank you preference!");
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products.add(products);
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Product key, int value) {
        this.cart.put(key, value);
    }
}
