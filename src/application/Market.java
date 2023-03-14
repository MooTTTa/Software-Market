package application;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static service.Service.*;

public class Market {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Product> products;
    public static Map<Product, Integer> cart;

    public static void main(String[] args) {
        products = new ArrayList<>();
        cart = new HashMap<>();
        menu();
    }

    public static void  menu(){
        System.out.println("---------------------------------------");
        System.out.println("-------- WELCOME TO ZÉ MARKET ---------");
        System.out.println("---------------------------------------");
        System.out.println(" Select the option you want to perform ");
        System.out.println("---------------------------------------");
        System.out.println("| Option 1 - Register |");
        System.out.println("| Option 2 - List |");
        System.out.println("| Option 3 - Purchase |");
        System.out.println("| Option 4 - Cart |");
        System.out.println("| Option 5 - To go out |");

        int option = sc.nextInt();

        switch (option){
            case 1:
                registerProducts();
                break;
            case 2:
                listProducts();
                break;
            case 3:
                purchaseProducts();
                break;
            case 4:
                cartProducts();
                break;
            case 5:
                System.out.println("Check back often!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalidation option!");
                menu();
                break;
        }
    }
}
