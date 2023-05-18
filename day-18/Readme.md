```sql
CREATE TABLE employees (
    id int primary key auto_increment,
    name varchar(50) not null,
    salary double,
    department varchar(50) default 'PRODUCTION'
);
```

