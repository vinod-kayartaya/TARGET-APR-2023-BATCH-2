package com.targetindia.repository;

import com.targetindia.model.Person;

import java.util.List;

public class JdbcContactsRepository implements ContactsRepository{
    @Override
    public void addNewContact(Person person) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }

    @Override
    public Person getContactById(String email) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }

    @Override
    public void updateContact(Person person) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");

    }

    @Override
    public void deleteContact(String email) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");

    }

    @Override
    public List<Person> getAllContacts() throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }

    @Override
    public Person getContactByPhone(String phone) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }

    @Override
    public List<Person> getContactsByCity(String city) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }

    @Override
    public List<Person> getContactsByAge(int age) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }
}
