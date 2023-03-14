package service;

import model.Product;
import utils.Utils;

import static application.Market.*;

public class Service {
    public static void registerProducts(){
        System.out.println("Name of product: ");
        String name = sc.next();

        System.out.println("Price of product: ");
        Double price = sc.nextDouble();

        Product product = new Product(name, price);
        products.add(product);

        System.out.println("Product register sucessFull");
        menu();
    }

    public static void listProducts(){
        if (products.size() > 0) {
            System.out.println("List of all products: ");
            for (Product p : products) {
                System.out.println(p);
                System.out.println();
            }

        } else {
            System.out.println("Not product register!");
        }
        menu();
    }

    public static void purchaseProducts(){
        if(products.size() > 0){
            System.out.println("Code of product: ");

            System.out.println("--------- Product disponible ------------");
            for (Product p : products){
                System.out.println(p + "\n");
            }

            int id = Integer.parseInt(sc.next());
            boolean isPresent = false;

            for (Product p : products){
                if (p.getId() == id){
                    int qtd = 0;
                    try {
                        qtd = cart.get(p);
                        cart.put(p, qtd + 1);
                    } catch (NullPointerException e){
                        // se o produto for o primeiro no carrinho
                        cart.put(p, qtd + 1);
                    }
                    System.out.println(p.getName() + " ADD in cart");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Want to add another product to the cart?  ");
                        System.out.println("Type 1 to yes or 0 to finish purchase: ");
                        int option = Integer.parseInt(sc.next());

                        if (option == 1) {
                            purchaseProducts();
                        } else {
                            finishPurchase();
                        }
                    }
                } else {
                    System.out.println("Product not found!");
                    menu();
                }
            }
        } else {
            System.out.println("Not existing Products registers!");
            menu();
        }
    }

    public static void cartProducts(){
        System.out.println("Products in your Cart!");
        if (cart.size() > 0){
            for (Product p : cart.keySet()) {
                System.out.println( "Product: " + p + " \nAmount: " + cart.get(p));
            }
        } else {
            System.out.println("Cart empty!");
        }
        menu();
    }

    private static void finishPurchase(){
        Double valueOfPurchase = 0.0;
        System.out.println("Your products: ");
        for (Product p : products){
            int qtd = cart.get(p);
            valueOfPurchase += p.getPrice() * qtd;
            System.out.println(p);
            System.out.println("Amount: " + qtd);
            System.out.println("---------------");
        }
        System.out.println("The value you purchase is: " + Utils.doubleToString(valueOfPurchase));
        cart.clear();
        System.out.println("Thank you preference!");
        menu();
    }
}
