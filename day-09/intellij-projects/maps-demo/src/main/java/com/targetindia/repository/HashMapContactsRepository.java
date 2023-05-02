package com.targetindia.repository;

import com.targetindia.exceptions.DuplicateEmailException;
import com.targetindia.exceptions.DuplicatePhoneException;
import com.targetindia.model.Person;
import com.targetindia.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class HashMapContactsRepository implements ContactsRepository{
    private final Map<String, Person> contacts = new HashMap<>();

    public HashMapContactsRepository() {
        Person p = new Person();
        p.setFirstname("Vinod");
        p.setLastname("Kumar");
        p.setEmail("vinod@vinod.co");
        p.setPhone("9731424784");
        p.setCity("Bangalore");
        p.setBirthDate(DateUtil.toDate("20/01/1974"));
        contacts.put(p.getEmail(), p);

        p = new Person();
        p.setFirstname("Shyam");
        p.setLastname("Sundar");
        p.setEmail("shyam@xmpl.com");
        p.setPhone("9731420000");
        p.setCity("Bangalore");
        p.setBirthDate(DateUtil.toDate("02/10/1973"));
        contacts.put(p.getEmail(), p);
    }

    public List<Person> getAllContacts(){
        List<Person> list = new ArrayList<>(contacts.values());
        Collections.sort(list, (p1, p2)->p1.getFirstname().compareTo(p2.getFirstname()));
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

    public void addNewContact(Person person) throws RepositoryException, DuplicateEmailException, DuplicatePhoneException{
        log.trace("trying to add a new contact as {}", person);
        if(contacts.containsKey(person.getEmail())){
            log.trace("email already present in the contact list");
            throw new DuplicateEmailException();
        }

        for(Person p: contacts.values()){
            if(p.getPhone().equals(person.getPhone())){
                log.trace("phone number already present in the contact list");
                throw new DuplicatePhoneException();
            }
        }

        contacts.put(person.getEmail(), person);
        log.trace("successfully added the contact details");
    }

    @Override
    public Person getContactById(String email) throws RepositoryException {
        if(contacts.containsKey(email)){
            return contacts.get(email);
        }
        return null;
    }

    @Override
    public void updateContact(Person person) throws RepositoryException {

    }

    @Override
    public void deleteContact(String email) throws RepositoryException {

    }

}
