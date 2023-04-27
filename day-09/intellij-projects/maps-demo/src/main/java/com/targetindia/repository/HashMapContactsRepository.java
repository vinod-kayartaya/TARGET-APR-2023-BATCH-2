package com.targetindia.repository;

import com.targetindia.model.Person;
import com.targetindia.utils.DateUtil;

import java.util.*;

public class HashMapContactsRepository {
    private Map<String, Person> contacts = new HashMap<>();

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
        List<Person> list = new ArrayList<Person>(contacts.values());
        Collections.<Person>sort(list, (p1, p2)->p1.getFirstname().compareTo(p2.getFirstname()));
        return list;
    }

    public void addNewContact(Person person){
        // TODO add this person to the "contacts" map, and ensure that the phone number is unique
        // Hint: contacts.put(person.getEmail(), person);
    }
}
