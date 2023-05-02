package com.targetindia.repository;

import com.targetindia.exceptions.DuplicateEmailException;
import com.targetindia.exceptions.DuplicatePhoneException;
import com.targetindia.model.Person;
import com.targetindia.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

@Slf4j
public class CsvContactsRepository implements ContactsRepository{

    private static final String FILENAME = "addressbook.csv";
    private Map<String, Person> map = new TreeMap<>();

    private void loadFromFile(){
        try(
                FileReader file = new FileReader(FILENAME);
                BufferedReader in = new BufferedReader(file);
                ){
            // skip the header line in the CSV file
            in.readLine();

            String line;
            while((line=in.readLine())!=null){
                String[] arr = line.split(",");
                Person p = new Person();
                p.setFirstname(arr[0]);
                p.setLastname(arr[1]);
                p.setEmail(arr[2]);
                p.setPhone(arr[3]);
                p.setCity(arr[4]);
                p.setBirthDate(DateUtil.toDate(arr[5]));
                map.put(p.getEmail(), p);
            }
        }
        catch(Exception e){
            throw new RepositoryException(e);
        }
    }

    private void saveToFile(){
        // replace the current file with new content (from the map)
        try(
                PrintWriter out= new PrintWriter(FILENAME);
                ){
            out.println("firstname,lastname,email,phone,city,birthDate");
            for(Person p: map.values()){
                out.printf("%s,%s,%s,%s,%s,%s%n",
                        p.getFirstname(),
                        p.getLastname(),
                        p.getEmail(),
                        p.getPhone(),
                        p.getCity(),
                        DateUtil.toString(p.getBirthDate()));
            }
        }
        catch (Exception e){
            throw new RepositoryException(e);
        }
    }

    public CsvContactsRepository() {
        loadFromFile();
    }

    @Override
    public void addNewContact(Person person) throws RepositoryException {
        log.trace("trying to add a new contact as {}", person);
        if(map.containsKey(person.getEmail())){
            log.trace("email already present in the contact list");
            throw new DuplicateEmailException();
        }

        for(Person p: map.values()){
            if(p.getPhone().equals(person.getPhone())){
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
}
