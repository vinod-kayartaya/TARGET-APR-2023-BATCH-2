# Assignment for week 4

Implement the following methods in the classes `com.targetindia.repository.HashMapContactsRepository`, `com.targetindia.repository.CsvContactsRepository` and `com.targetindia.repository.SerializableContactsRepository`:

1. public void updateContact(Person person) throws RepositoryException;
1. public void deleteContact(String email) throws RepositoryException;
1. public Person getContactByPhone(String phone) throws RepositoryException;
1. public List<Person> getContactsByCity(String city) throws RepositoryException;
1. public List<Person> getContactsByAge(int age) throws  RepositoryException;

Test the working of the same, by changing the value in `repository.properties` file.

```sh
ContactsRepository.impl.class=com.targetindia.repository.SerializableContactsRepository
#ContactsRepository.discriminator=serializable
```