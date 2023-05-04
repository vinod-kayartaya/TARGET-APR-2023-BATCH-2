package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Data
@NoArgsConstructor
public class Customer implements Externalizable {
    // an object of this class is an instance of:
    // 1. java.lang.Object
    // 2. com.targetindia.model.Customer
    // 3. java.io.Externalizable
    // 4. java.io.Serializable

    private int id; // primitive is serializable by default
    private String name; // Check String class; it is Serializable
    private String email;
    private Address address = new Address(); // not serializable
    private byte[] photo; // array of primitives is by default serializable

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void print() {
        System.out.printf("ID     : %d%n", id);
        System.out.printf("Name   : %s%n", name);
        System.out.printf("Email  : %s%n", email);
        if (address != null) {
            System.out.printf("Address: %s%n", address.getHouseStreet());
            System.out.printf("         %s%n", address.getArea());
            System.out.printf("         %s%n", address.getCity());
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // the writeObject() method of ObjectOutputStream now, gives me the "out" variable,
        // so that I can decide and write whatever data I want. This may include the individual
        // members for the address (which currently is not Serializable)
        Object[] data = {
                id,
                name,
                email,
                address.getHouseStreet(),
                address.getArea(),
                address.getCity(),
                photo
        };
        out.writeObject(data);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Object[] data = (Object[]) in.readObject();
        id = (int) data[0];
        name = (String) data[1];
        email = (String) data[2];
        if (address == null) {
            address = new Address();
        }
        address.setHouseStreet((String) data[3]);
        address.setArea((String) data[4]);
        address.setCity((String) data[5]);
        photo = (byte[]) data[6];
    }
}
