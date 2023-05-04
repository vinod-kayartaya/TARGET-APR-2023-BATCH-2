package com.targetindia.repository;

import com.targetindia.exceptions.DuplicateEmailException;
import com.targetindia.exceptions.DuplicatePhoneException;
import com.targetindia.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

@Slf4j
public class SerializableContactsRepository implements ContactsRepository {
    private static final String FILENAME = "addressbook.dat";
    private Map<String, Person> map = new TreeMap<>();

    private void loadFromFile() {
        try (
                FileInputStream file = new FileInputStream(FILENAME);
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            map = (Map<String, Person>) in.readObject();
        } catch (Exception e) {
        }
    }

    private void saveToFile() {
        try (
                FileOutputStream file = new FileOutputStream(FILENAME);
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            out.writeObject(map);
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    public SerializableContactsRepository() {
        loadFromFile();
    }

    @Override
    public void addNewContact(Person person) throws RepositoryException {
        log.trace("trying to add a new contact as {}", person);
        if (map.containsKey(person.getEmail())) {
            log.trace("email already present in the contact list");
            throw new DuplicateEmailException();
        }

        for (Person p : map.values()) {
            if (p.getPhone().equals(person.getPhone())) {
                log.trace("phone number already present in the contact list");
                throw new DuplicatePhoneException();
            }
        }

        map.put(person.getEmail(), person);
        saveToFile();
        log.trace("successfully added the contact details");
    }

    @Override
    public Person getContactById(String email) throws RepositoryException {
        return null;
    }

    @Override
    public void updateContact(Person person) throws RepositoryException {

    }

    @Override
    public void deleteContact(String email) throws RepositoryException {

    }

    @Override
    public List<Person> getAllContacts() throws RepositoryException {
        List<Person> list = new ArrayList<>(map.values());
        Collections.sort(list, (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname()));
        return list;
    }

    @Override
    public Person getContactByPhone(String phone) throws RepositoryException {
        return null;
    }

    @Override
    public List<Person> getContactsByCity(String city) throws RepositoryException {
        return null;
    }

    @Override
    public List<Person> getContactsByAge(int age) throws RepositoryException {
        return null;
    }
}
