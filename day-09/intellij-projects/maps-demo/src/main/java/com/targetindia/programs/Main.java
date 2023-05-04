package com.targetindia.programs;

import com.targetindia.exceptions.DuplicateEmailException;
import com.targetindia.exceptions.DuplicatePhoneException;
import com.targetindia.repository.ContactsRepository;
import com.targetindia.model.Person;
import com.targetindia.repository.RepositoryException;
import com.targetindia.repository.RepositoryFactory;
import com.targetindia.utils.DateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
public class Main {
    // since we are using the name of the class with "new" keyword, it's called
    // tight-coupling. Meaning, in case if we need to change the implementation,
    // we have to make changes to this file (and many other such files that might
    // have referred the class)
    // ContactsRepository repo = new HashMapContactsRepository();

    // the following code is called "loose coupling"
    ContactsRepository repo = RepositoryFactory.getContactsRepository();

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
                    acceptAndSearchByEmail();
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

    private void acceptAndSearchByEmail() {
        String email = KeyboardUtil.getString("Enter email to search: ");
        Person person = null;
        try {
            person = repo.getContactById(email);
            if (person == null) {
                System.out.printf("No data found for email '%s'%n", email);
                return;
            }

            System.out.println("The search was successful. Here is the data:");
            System.out.printf("Name          : %s %s%n", person.getFirstname(), person.getLastname());
            System.out.printf("Email address : %s%n", person.getEmail());
            System.out.printf("Phone number  : %s%n", person.getPhone());
            System.out.printf("Date of birth : %s%n", DateUtil.toString(person.getBirthDate()));
            line();
        } catch (RepositoryException e) {
            System.out.println("There was a problem : " + e.getMessage());
        }
    }

    private void acceptAndAddNewContact() {
        System.out.println("Enter new person details to be added: ");
        String firstname = KeyboardUtil.getString("Firstname     : ");
        String lastname = KeyboardUtil.getString("Lastname      : ");
        String email = KeyboardUtil.getString("Email address : ");
        String phone = KeyboardUtil.getString("Phone number  : ");
        String city = KeyboardUtil.getString("City          : ");
        Date birthDate = KeyboardUtil.getDate("Date of birth : ");
        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setEmail(email);
        person.setCity(city);
        person.setPhone(phone);
        person.setBirthDate(birthDate);

        try {
            repo.addNewContact(person);
        } catch (DuplicateEmailException | DuplicatePhoneException e) {
            System.out.println("There was a problem while trying to add this data: " + e.getMessage());
        }
    }

    private void printContactList() {
        try {
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
        } catch (RepositoryException e) {
            System.out.println("There was an error: " + e.getMessage());
        }
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
