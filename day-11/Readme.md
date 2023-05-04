# Java IO Streams


- Allows us to read from a source of data or write to a target of data
- InputStream 
    - an abstract class that provides most of the functionalities (low level) that can be performed on a source of data
    - 


```plantuml
@startuml

abstract class InputStream{
    + read(): int
    + read(bytes: byte[]): int
    + read(bytes: byte[], offset: int, len: int): int
    + close(): void
    + skip(len: long): void
    + available(): int
}

interface Closeable{
    + close(): void throws IOException
}
interface AutoCloseable{
    + close(): void throws Exception
}

AutoCloseable <|-- Closeable
Closeable <|.. InputStream

InputStream <|-- FilterInputStream
FilterInputStream <|-- DataInputStream
InputStream <|-- ObjectInputStream
InputStream <|-- FileInputStream
FileInputStream <|-- SocketInputStream
@enduml
```