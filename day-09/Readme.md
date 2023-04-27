# Map

- is a collection of key/value pairs
- You may consider the "key" is the index for accessing an element inside a Map
- "key" is expected to be a unique value
  - For example, in order to store and quickly access objects of Employee type, we may use the employeeId or email or phone etc. as the key

```plantuml
@startuml

interface Map<K, V> {
    + put(key: K, value: V): V
    + get(key: K): V
    + isEmpty(): boolean
    + size(): int
    + containsKey(key: K): boolean
    + containsValue(value: V): boolean
    + remove(key: K): V
    + clear(): void
    + keySet(): Set<K>
    + values(): Collection<V>
    + entrySet(): Set<Entry<K, V>>
}

abstract class Dictionary{}
abstract class AbstractMap{}

Map <|.. AbstractMap
Map <|.. HashMap
AbstractMap <|-- HashMap
Map <|.. LinkedHashMap
HashMap <|-- LinkedHashMap
Map <|.. Hashtable
Dictionary <|-- Hashtable
Map <|-- SortedMap
SortedMap <|-- NavigatableMap
NavigatableMap <|.. TreeMap
AbstractMap <|-- TreeMap

interface SortedMap{}
interface NavigatableMap{}

note left of Hashtable: Legacy type and has synchronized methods\n should be used when the map is shared with multiple threads
note right of HashMap: Should be the default choice, since they use arrays and faster
note right of LinkedHashMap: If the order of put and get are to be same
note right of TreeMap: If the order of get() in asc order of keys

@enduml
```

An illustration of Hashtable from Wikipedia:

![](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Hash_table_5_0_1_1_1_1_1_LL.svg/675px-Hash_table_5_0_1_1_1_1_1_LL.svg.png)

![](./multi-tier-apps.dio.png)
