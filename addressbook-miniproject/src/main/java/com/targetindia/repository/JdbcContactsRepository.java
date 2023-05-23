package com.targetindia.repository;

import com.targetindia.model.Person;
import com.targetindia.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JdbcContactsRepository implements ContactsRepository {
    @Override
    public void addNewContact(Person person) throws RepositoryException {
        String cmd = "insert into contacts (first_name, last_name, email, phone, city, birth_date) values (?,?,?,?,?,?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {
            stmt.setString(1, person.getFirstname());
            stmt.setString(2, person.getLastname());
            stmt.setString(3, person.getEmail());
            stmt.setString(4, person.getPhone());
            stmt.setString(5, person.getCity());
            // need to convert util.Date to sql.Date
            // because util.Date is a super class for sql.Date
            java.sql.Date birthDate = new java.sql.Date(person.getBirthDate().getTime());
            stmt.setDate(6, birthDate);

            stmt.execute();

        } catch (Exception e) {
            log.warn("Error while adding this person {}", person, e);
            throw new RepositoryException(e);
        }
    }

    @Override
    public Person getContactById(String email) throws RepositoryException {
        String cmd = "select * from contacts where lower(email)=?";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    return createPersonFromResultSet(rs);
                }
                else {
                    return null;
                }
            } // rs is closed here
        } // conn, stmt closed here
        catch (Exception e) {
            log.warn("error while getting all contacts", e);
            throw new RepositoryException(e); // converting any exception into a RepositoryException
        }
    }

    @Override
    public void updateContact(Person person) throws RepositoryException {
        String cmd = "update contacts set first_name=?, last_name=?, phone=?, city=?, birth_date=? where email=?";

        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {
            stmt.setString(1, person.getFirstname());
            stmt.setString(2, person.getLastname());
            stmt.setString(3, person.getPhone());
            stmt.setString(4, person.getCity());
            // need to convert util.Date to sql.Date
            // because util.Date is a super class for sql.Date
            java.sql.Date birthDate = new java.sql.Date(person.getBirthDate().getTime());
            stmt.setDate(5, birthDate);
            stmt.setString(6, person.getEmail());

            stmt.execute();

        } catch (Exception e) {
            log.warn("Error while adding this person {}", person, e);
            throw new RepositoryException(e);
        }
    }

    @Override
    public void deleteContact(String email) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");

    }

    @Override
    public List<Person> getAllContacts() throws RepositoryException {
        List<Person> list = new ArrayList<>();

        String cmd = "select * from contacts";
        try (
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(cmd);
        ) {
            while (rs.next()) {
                Person p = createPersonFromResultSet(rs);
                list.add(p);
            }
        } // conn, stmt and rs get closed here
        catch (Exception e) {
            log.warn("error while getting all contacts", e);
            throw new RepositoryException(e); // converting any exception into a RepositoryException
        }

        return list;
    }

    @Override
    public Person getContactByPhone(String phone) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }

    @Override
    public List<Person> getContactsByCity(String city) throws RepositoryException {
        List<Person> list = new ArrayList<>();

        String cmd = "select * from contacts where lower(city)=lower(?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {

            stmt.setString(1, city);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    Person p = createPersonFromResultSet(rs);
                    list.add(p);
                }
            } // rs is closed here
        } // conn, stmt closed here
        catch (Exception e) {
            log.warn("error while getting all contacts", e);
            throw new RepositoryException(e); // converting any exception into a RepositoryException
        }

        return list;
    }

    @Override
    public List<Person> getContactsByName(String name) throws RepositoryException {
        List<Person> list = new ArrayList<>();

        String cmd = "select * from contacts where lower(first_name) like lower(?) or lower(last_name) like lower(?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {

            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    Person p = createPersonFromResultSet(rs);
                    list.add(p);
                }
            } // rs is closed here
        } // conn, stmt closed here
        catch (Exception e) {
            log.warn("error while getting all contacts", e);
            throw new RepositoryException(e); // converting any exception into a RepositoryException
        }

        return list;
    }

    private static Person createPersonFromResultSet(ResultSet rs) throws SQLException {
        Person p = new Person();
        p.setFirstname(rs.getString("first_name"));
        p.setLastname(rs.getString("last_name"));
        p.setPhone(rs.getString("phone"));
        p.setEmail(rs.getString("email"));
        p.setCity(rs.getString("city"));
        p.setBirthDate(rs.getDate("birth_date"));
        // java.sql.Date extends from java.util.Date
        // hence java.sql.Date object is also a java.util.Date object
        return p;
    }

    @Override
    public List<Person> getContactsByAge(int age) throws RepositoryException {
        throw new RepositoryException("Method not implemented yet in JdbcContactsRepository class");
    }
}
