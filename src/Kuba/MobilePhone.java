package Kuba;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MobilePhone {

    private final Scanner s = new Scanner(System.in);

    private final ArrayList<Contacts> contactList = new ArrayList<>();

    public MobilePhone() {
    }

    public void addNewContact(){

        System.out.println("Name: ");
        String name = s.nextLine();

        if (isContact(name)){
            System.out.println(name + " already exists");
        }else{
            System.out.println("Number: ");
            int number = Integer.parseInt(s.nextLine());
            Contacts contact = new Contacts(name, number);
            contactList.add(contact);
            System.out.println("Contact added");
            }
    }

    public void removeContact(){
        System.out.println("Name: ");
        String name = s.nextLine();

        if (isContact(name)){
                for (Iterator<Contacts> iterator = contactList.iterator(); iterator.hasNext();){
                    Contacts next = iterator.next();
                    if (next.getName().equals(name)){
                        contactList.remove(next);
                        System.out.println("Contact: " + next.getName() + " removed succesfully");
                    }
                }
        } else System.out.println(name + ", was not found");
    }

    public void updateContact(){
        System.out.println("Name: ");
        String name = s.nextLine();
        if (isContact(name)){
            System.out.println("What would you like to update? ");
            System.out.println("Press '1' to update name or '2' to update number");
            while (true) {
                int option = s.nextInt();
                if (option==1) {
                    updateName(name);
                    System.out.println("Name updated");
                    break;
                } else if (option==2){
                    updatePhoneNumber(name);
                    System.out.println("Phone number updated");
                    break;
                }else System.out.println("Wrong number! Press '1' to update name or '2' to update number");
            }
        }
    }

    public void updateName(String name){
        s.nextLine();
        System.out.println("Enter new name: ");
        String newName = s.nextLine();
        for (Contacts c: contactList){
            if (c.getName().equals(name)){
                 c.setName(newName);
            }
        }
    }

    public void updatePhoneNumber(String name){
        s.nextLine();
        System.out.println("Enter new number: ");
        int newPhoneNumber = s.nextInt();
        for (Contacts c: contactList) {
            if (c.getName().equals(name)){
            c.setPhoneNumber(newPhoneNumber);
            }

        }
    }

    private boolean isContact(String contactName) {
        boolean isContact = false;
        for (Contacts c : contactList) {
            if (c.getName().equals(contactName)) {
                isContact = true;
                break;
            }
        }
        return isContact;
    }

    public void findContact() {
        System.out.println("Name: ");
        String contactName = s.nextLine();

        if (isContact(contactName)){
            for (Contacts c: contactList) {
                if (c.getName().equals(contactName)){
                System.out.println("Contact: " + c.getName());
                System.out.println("Number: " + c.getPhoneNumber() );
                }
            }
       } else System.out.println("Contact not found");

    }

    public void printListOfContacts(){
        System.out.println("List of contacts: ");
        for (Contacts c: contactList) {
            System.out.println(c.getName() + " " + c.getPhoneNumber());
        }
    }
}
