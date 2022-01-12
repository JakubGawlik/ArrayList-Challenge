package Kuba;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        menu();

    }
    public static void menu(){

        MobilePhone mobilePhone = new MobilePhone();

        boolean showMenu = true;

        while (showMenu){

            System.out.println("1. Quit");
            System.out.println("2. Print list of contacts");
            System.out.println("3. Add new contact");
            System.out.println("4. Update existing contact");
            System.out.println("5. Remove contact");
            System.out.println("6. Find contact");
            System.out.println("Enter option: ");

            int option = s.nextInt();

            switch (option){
                case 1 -> showMenu=false;
                case 2 -> mobilePhone.printListOfContacts();
                case 3 -> mobilePhone.addNewContact();
                case 4 -> mobilePhone.updateContact();
                case 5 -> mobilePhone.removeContact();
                case 6 -> mobilePhone.findContact();
                default -> System.out.println("Option not available");
            }
        }
    }
}
