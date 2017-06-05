package com.tasks.task13;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonTest {
    private final List<Person> testList = Arrays.asList(new Person("A", "YY", (byte) 88), new Person("J", "MALE", (byte) 2), new Person("C", "MALE", (byte) 1),
            new Person("B", "FEMALE", (byte) 1), new Person("H", "FEMALE", (byte) 1), new Person("H", "MALE", (byte) 0));

    @Test
    public void testStatistics() {
        Assert.assertEquals(3, Person.statNumberOfChildren((byte) 1, testList));
    }

}
