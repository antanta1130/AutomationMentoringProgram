package com.tasks.task3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BubbleSortTest {
    private int[] array = { 2, 9, 3, 6, 4, 5, 1, 7, 8, 0 };
    private int[] expectedArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    @Test
    public void testSort() {
        Assert.assertEquals(BubbleSort.sort(array), expectedArray);
    }

}
