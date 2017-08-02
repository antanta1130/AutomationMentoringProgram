package com.tasks.task13;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
    private String name;
    private Gender gender;
    private byte numberOfChildren;

    private static final Logger log = LoggerFactory.getLogger(Person.class);

    public Person() {
    }

    public Person(String name, String gen, byte numbOfChildren) {
        log.info("Person's constructor with parameters called: name {}, gender {}, numberOfChildren {}", name, gen, numbOfChildren);
        this.name = name;

        try {
            gender = Gender.valueOf(gen);
        } catch (IllegalArgumentException iaex) {
            log.warn("Incorrect gender {}", gen);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        if ((numbOfChildren >= 0) && (numbOfChildren < 20)) {
            numberOfChildren = numbOfChildren;
        } else {
            log.warn("Incorrect numberOfChildren {}", numbOfChildren);
        }

        log.debug("Person was constructed with parameters: name {}, gender {}, numberOfChildren {}", name, gender, numberOfChildren);

    }

    public static int statNumberOfChildren(byte numberOfChildren, List<Person> people) {
        int count = 0;
        log.debug("static method statNumberOfChildren() called: numberOfChildren {}:", numberOfChildren);

        for (Person person : people) {
            log.debug("person: {}, numberOfChildren: {}", person.getName(), person.getNumberOfChildren());
            if (person.getNumberOfChildren() == numberOfChildren) {
                count++;
            }
        }
        log.info("statNumberOfChildren() result: number of people which have {} children - {}", numberOfChildren, count);

        return count;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public byte getNumberOfChildren() {
        return numberOfChildren;
    }

}
