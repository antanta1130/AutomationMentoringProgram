package com.tasks.task3;

public class BinarySearch {
    private int[] array;

    public BinarySearch(int[] array) {
	this.array = array;
    }

    public int find(double x) {
	int position = -1;
	int start = 0;
	int end = array.length;
	int mid;

	if (array != null) {
	    while (start < end) {
		mid = (start + end) >>> 1;
		if (array[mid] == x) {
		    position = mid;
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

	return position;
    }

}
