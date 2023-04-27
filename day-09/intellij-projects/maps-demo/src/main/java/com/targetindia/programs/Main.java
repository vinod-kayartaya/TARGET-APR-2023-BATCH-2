package com.targetindia.programs;

import com.targetindia.repository.HashMapContactsRepository;
import com.targetindia.model.Person;
import com.targetindia.utils.DateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    HashMapContactsRepository repo = new HashMapContactsRepository();

    public static void main(String[] args) {
        log.trace("starting the app now");
        new Main().start();
        log.trace("exiting the app now");
    }

    public void start() {
        int choice;
        while ((choice = menu()) != 0) {
            switch (choice) {
                case 1:
                    printContactList();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    acceptAndAddNewContact();
                    break;
                default:
                    System.out.println("Invalid value for the choice. Please try again.");

            }
        }
        System.out.println("Thank you for using our app. Have a nice day!");
    }

    private void acceptAndAddNewContact() {
        // TODO accept values from the user for a new Person data and call the repository function to add the person
        //  object to the underlying data structure
    }

    private void printContactList() {
        List<Person> list = repo.getAllContacts();

        if (list.size() == 0) {
            System.out.println("No contacts found in your address book. Please add a new one.");
            return;
        }

        line("=");
        System.out.printf("%-25s %-25s %-10s %-15s %-12s%n",
                "Name", "Email", "Phone", "City", "D.O.B.");
        line();

        for (Person p : list) {
            System.out.printf("%-25s %-25s %-10s %-15s %-12s%n",
                    p.getFirstname() + " " + p.getLastname(),
                    p.getEmail(),
                    p.getPhone(),
                    p.getCity(),
                    DateUtil.toString(p.getBirthDate()));
        }

        line("=");
    }

    private void line() {
        line("-", 91);
    }

    private void line(String pattern) {
        line(pattern, 91);
    }

    private void line(int count) {
        line("-", count);
    }

    private void line(String pattern, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(pattern);
        }
        System.out.println();
    }

    public int menu() {
        try {
            System.out.println("*** Addressbook Application ***");
            System.out.println("*** MAIN MENU               ***");
            System.out.println("0. Exit");
            System.out.println("1. List all contacts");
            System.out.println("2. Search contact by email");
            System.out.println("3. Search contact by phone");
            System.out.println("4. Search by name");
            System.out.println("5. Search by city");
            System.out.println("6. Add a new contact");

            int choice = KeyboardUtil.getInt("Enter your choice: ");
            return choice;
        } catch (Exception e) {
            log.warn("user entered wrong choice type in the menu()");
            System.out.println("You are expected to enter an integer value only.");
            return -1;
        }
    }
}
