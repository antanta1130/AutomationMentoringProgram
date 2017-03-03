package com.tasks.task3;

public class BinarySearch {
    private int[] array;

    public BinarySearch(int[] array) {
	this.array = array;
    }

    public boolean find(int x) {
	boolean flag = false;
	int start = 0;
	int end = array.length;
	int mid;

	if (array != null) {
	    BubbleSort.sort(array);
	    while (start < end) {
		mid = (start + end) >>> 1;
		if (array[mid] == x) {
		    flag = true;
		    break;
		} else {
		    if (x > array[mid]) {
			start = mid + 1;
		    } else {
			end = mid;
		    }
		}
	    }

	}

	return flag;
    }

}
