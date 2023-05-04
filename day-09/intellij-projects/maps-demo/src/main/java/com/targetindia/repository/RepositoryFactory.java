package com.targetindia.repository;

import java.util.ResourceBundle;

public final class RepositoryFactory {
    private RepositoryFactory() {
    }

    public static ContactsRepository getContactsRepository() throws RepositoryException{
        ResourceBundle rb = ResourceBundle.getBundle("repository");
        // String discriminator = rb.getString("ContactsRepository.discriminator");
        // return getContactsRepository(discriminator);

        String implClassName = rb.getString("ContactsRepository.impl.class");
        try {
            return (ContactsRepository) Class.forName(implClassName).newInstance();
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    public static ContactsRepository getContactsRepository(String discriminator) throws RepositoryException {
        switch(discriminator.toLowerCase()){
            case "mybatis":
                return new MyBatisContactsRepository();
            case "jdbc":
                return new JdbcContactsRepository();
            case "hashmap":
                return new HashMapContactsRepository();
            case "csv":
                return new CsvContactsRepository();
            case "serializable":
                return new SerializableContactsRepository();
            default:
                throw new RepositoryException("Unknown type for ContactsRepository: " + discriminator);
        }
    }
}
