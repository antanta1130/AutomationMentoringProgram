package com.tasks.task3;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BinarySearchTest {
    private BinarySearch binarySearch;

    @BeforeTest
    public void initialize() {
	int[] array = { 2, 9, 3, 6, 4, 5, 1, 7, 8, 0 };
	binarySearch = new BinarySearch(array);
    }

    @DataProvider(name = "test")
    public static Object[][] contains() {
	return new Object[][] { { 5, true }, { -55, false }, { 10, false }, { 0, true }, { -1, false } };
    }

    @Test(dataProvider = "test")
    public void testFind(int inputNumber, boolean expectedResult) {
	System.out.println(inputNumber + " " + expectedResult);
	Assert.assertEquals(binarySearch.find(inputNumber), expectedResult);
    }
}
