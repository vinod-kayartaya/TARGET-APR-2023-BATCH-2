package com.targetindia.model;

import com.targetindia.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    int id;
    String name;
    Date dateOfJoin;
    double salary;
    String department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfJoin=" + DateUtil.toString(dateOfJoin) +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public static List<Employee> getDummyList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"Karrie Lebbon", DateUtil.toDate("2017-10-30"),1614,"Marketing"));
        list.add(new Employee(2,"Halley Hawking",DateUtil.toDate("2016-06-22"),4787,"Services"));
        list.add(new Employee(3,"Meade Wigginton",DateUtil.toDate("2016-02-02"),2019,"Training"));
        list.add(new Employee(4,"Ermentrude Darrington",DateUtil.toDate("2017-09-22"),6950,"Human Resources"));
        list.add(new Employee(5,"Konstantin Sandels",DateUtil.toDate("2016-12-02"),6924,"Support"));
        list.add(new Employee(6,"Alica Yakunin",DateUtil.toDate("2017-04-20"),4897,"Legal"));
        list.add(new Employee(7,"Hermione Catonnet",DateUtil.toDate("2016-01-07"),3399,"Accounting"));
        list.add(new Employee(8,"Teddy Brugman",DateUtil.toDate("2016-06-14"),3705,"Human Resources"));
        list.add(new Employee(9,"Hestia Argabrite",DateUtil.toDate("2018-04-30"),6164,"Human Resources"));
        list.add(new Employee(10,"Berty Epps",DateUtil.toDate("2016-01-21"),7782,"Services"));
        list.add(new Employee(11,"Abram Terbeck",DateUtil.toDate("2018-01-18"),5043,"Legal"));
        list.add(new Employee(12,"Mitch Goncaves",DateUtil.toDate("2016-08-04"),6006,"Human Resources"));
        list.add(new Employee(13,"Beryl Elias",DateUtil.toDate("2016-09-28"),8965,"Business Development"));
        list.add(new Employee(14,"Zelig Mackstead",DateUtil.toDate("2016-06-15"),5068,"Training"));
        list.add(new Employee(15,"Cathleen Graham",DateUtil.toDate("2018-02-20"),7690,"Human Resources"));
        list.add(new Employee(16,"Rosmunda Litherland",DateUtil.toDate("2017-07-07"),2015,"Training"));
        list.add(new Employee(17,"Krista Gonzalvo",DateUtil.toDate("2017-05-29"),4780,"Training"));
        list.add(new Employee(18,"Reinhold Martill",DateUtil.toDate("2018-01-02"),5287,"Accounting"));
        list.add(new Employee(19,"Cosette Dunn",DateUtil.toDate("2016-12-08"),3501,"Human Resources"));
        list.add(new Employee(20,"Guillema Ricketts",DateUtil.toDate("2017-05-01"),8004,"Sales"));
        return list;
    }
}
