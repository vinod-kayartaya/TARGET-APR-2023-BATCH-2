package com.targetindia.repository;

import com.targetindia.model.Person;

import java.util.List;

public interface ContactsRepository {
    // a typical Repository interface provides methods to perform CRUD and Query operations
    // it's a general practice for the methods of this such interface to throw RepositoryException

    // CRUD
    public void addNewContact(Person person) throws RepositoryException;
    public Person getContactById(String email) throws RepositoryException;
    public void updateContact(Person person) throws RepositoryException;
    public void deleteContact(String email) throws RepositoryException;

    // Query
    public List<Person> getAllContacts() throws RepositoryException;
    public Person getContactByPhone(String phone) throws RepositoryException;
    public List<Person> getContactsByCity(String city) throws RepositoryException;
    public default List<Person> getContactsByName(String name) throws RepositoryException{
        throw new RepositoryException("Method not implemented");
    }
    public List<Person> getContactsByAge(int age) throws  RepositoryException;
}
