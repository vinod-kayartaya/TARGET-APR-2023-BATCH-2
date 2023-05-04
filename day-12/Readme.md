# Object serialization and deserialization

- Serialization is a process of converting an object's internal bytes into a series of bytes that can be then
    - saved into a file
    - sent in a network
    - stored in an array of bytes
    - The class `ObjectOutputStream` provides a helper method called `writeObject()` to do this
    - While serializing, between two object's data, the `writeObject()` method, stores a marker byte, which acts like delimiter
    - The `writeObject()` is capable of navigating through the bytes of the object and converting the object's internal data into a series of bytes.
        - this is against the Java's security policy
        - as long as the data is inside the JVM, it is safe, and cannot be accessed from outside programs
        - To avoid this, the serialization process can only be done if the __author__ of this class has approved the process
        - This is done by adding the `implements Serializable` to the class
        - `java.io.Serializable` is a marker interface. The only reason as why we need to implement this in a class, is to say that an object of such a class is also an instanceof Serializable
- Deserialization is a process of recreating an object from the series of bytes created during the serialization process
    - this means, the structure of the object (class informatio) must be stored as part of the serialized data
    - `ObjectInputStream` provides a helper method called `readObject()` to do the same
    - This method reads all bytes between the marker byte and attempts to convert the bytes to object