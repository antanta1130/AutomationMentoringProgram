package com.tasks.task3;

public class BubbleSort {
    public static Integer[] sort(Integer[] array) {
	int swap;

	if (array != null) {
	    for (int i = 0; i < array.length; i++) {
		for (int j = 1; j < array.length - i; j++) {
		    if (array[j - 1] > array[j]) {
			swap = array[j - 1];
			array[j - 1] = array[j];
			array[j] = swap;
		    }
		}
	    }
	}

	return array;
    }

}
