package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Market {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Product> products;
    private static Map<Product, Integer> cart;

    public static void main(String[] args) {
        products = new ArrayList<>();
        cart = new HashMap<>();
        menu();
    }

    private static void  menu(){
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
                RegisterProducts();
                break;
            case 2:
                ListProducts();
                break;
            case 3:
                PurchaseProducts();
                break;
            case 4:
                CartProducts();
                break;
            case 5:
                System.out.println("Check back often!");
                System.exit();
                break;
            default:
                System.out.println("Invalidation option!");
                menu();
                break;
        }
    }
}
