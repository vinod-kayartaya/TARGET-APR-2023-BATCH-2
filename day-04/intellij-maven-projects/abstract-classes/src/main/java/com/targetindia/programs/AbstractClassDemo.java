package com.targetindia.programs;

import com.targetindia.model.Animal;
import com.targetindia.model.Cat;
import com.targetindia.model.Dog;
import com.targetindia.model.Lion;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractClassDemo {

    public static void main(String[] args) {

        Animal a1;
        // a1 = new Animal();

        Dog d1 = new Dog(); // Dog is an Animal
        d1.talk(); // from Dog.java and not from Animal.java

        Cat c1 = new Cat();
        c1.talk();

        Lion l1 = new Lion();

        process(d1);
        process(c1);
        process(l1);

    }

    // polymorphic function
    static void process(Animal a){
        // since every subclass has the talk() method, compiler says okay
        log.trace("inside the process(), animal reference refers to an object of " + a.getClass().getName());
        a.talk(); // object's method called; not the reference's type's method
    }
}
