package MobileContactArrayList;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("06 70 123 4567");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter action number: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone number = " + phoneNumber);
        } else {
            System.out.println("Cannot add, " + name + " already exist.");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
        }
        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + " phone number is: " + existingContact.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("\nStarting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress:");
        System.out.println("\t0  - to shutdown");
        System.out.println("\t1  - to print contacts");
        System.out.println("\t2  - to add a new contact");
        System.out.println("\t3  - to update an existing contact");
        System.out.println("\t4  - to remove an existing contact");
        System.out.println("\t5  - query if an existing contact exists");
        System.out.println("\t6  - to print a list of available actions.");
        System.out.println("Choose your action:");
    }

}
