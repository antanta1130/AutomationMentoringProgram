package com.tasks.task3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BubbleSortTest {
    @DataProvider(name = "test")
    public static Object[][] contains() {
	return new Object[][] {
		{ new Integer[] { 2, 9, 3, 6, 4, 5, 1, 7, 8, 0 }, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } },
		{ null, null } };
    }

    @Test(dataProvider = "test")
    public void testFind(Integer[] inputArray, Integer[] expectedArray) {
	Assert.assertEquals(BubbleSort.sort(inputArray), expectedArray);
    }
}
