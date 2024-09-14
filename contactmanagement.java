package ContactManagement;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void updateContact(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}

public class ContactManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact(scanner, contacts);
                    break;
                case 2:
                    viewContacts(contacts);
                    break;
                case 3:
                    updateContact(scanner, contacts);
                    break;
                case 4:
                    deleteContact(scanner, contacts);
                    break;
                case 5:
                    System.out.println("Exiting Contact Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addContact(Scanner scanner, ArrayList<Contact> contacts) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);

        System.out.println("Contact added successfully!");
    }

    private static void viewContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\nContacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
                System.out.println("--------------------");
            }
        }
    }

    private static void updateContact(Scanner scanner, ArrayList<Contact> contacts) {
        viewContacts(contacts);

        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the name of the contact to update: ");
        String nameToUpdate = scanner.nextLine();

        boolean contactFound = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameToUpdate)) {
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = scanner.nextLine();

                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();

                contact.updateContact(newPhoneNumber, newEmail);
                System.out.println("Contact updated successfully!");
                contactFound = true;
                break;
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scanner, ArrayList<Contact> contacts) {
        viewContacts(contacts);

        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the name of the contact to delete: ");
        String nameToDelete = scanner.nextLine();

        boolean contactFound = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameToDelete)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                contactFound = true;
                break;
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found.");
        }
    }
}