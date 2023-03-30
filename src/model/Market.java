package model;

import service.Service;

import java.util.Scanner;

public class Market {
    public static Scanner sc = new Scanner(System.in);

    public void test() {
        System.out.println("hello");
    }

    public void menu() {
        Service service = new Service();

        int option = 0;
        do {
            System.out.println("---------------------------------------");
            System.out.println("-------- WELCOME TO ZÉ MARKET ---------");
            System.out.println("---------------------------------------");
            System.out.println(" Select the option you want to perform ");
            System.out.println("---------------------------------------");
            System.out.println("| Option 1 - Register |");
            System.out.println("| Option 2 - List |");
            System.out.println("| Option 3 - Purchase |");
            System.out.println("| Option 4 - Cart |");
            System.out.println("| Option 5 - Delete product |");
            System.out.println("| Option 6 - To go out |");

            System.out.println();
            System.out.print("Option select: ");
            option = sc.nextInt();


            switch (option) {
                case 1:
                    service.registerProducts();
                    break;
                case 2:
                    service.listProducts();
                    break;
                case 3:
                    service.purchaseProducts();
                    break;
                case 4:
                    service.cartProducts();
                    break;
                case 5:
                    service.deleteProducts();
                    break;
                default:
                    System.out.println("Invalidation option!");
                    break;
            }
        }while (option != 6);
        System.out.println("Check back often!");
    }
}
