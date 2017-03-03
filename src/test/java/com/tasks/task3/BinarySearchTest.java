package com.tasks.task3;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BinarySearchTest {
    private BinarySearch binarySearch;

    @BeforeTest
    public void initialize() {
	int[] array = { 2, 9, 3, 6, 4, 5, 1, 7, 8, 0 };
	binarySearch = new BinarySearch(array);
    }

    @Test
    public void testFind() {
	Assert.assertEquals(binarySearch.find(5), true);
    }

    @Test
    public void testNotFind() {
	Assert.assertEquals(binarySearch.find(55), false);
    }

}
