package com.jpdelacroix.jalgodastruct.sort;

/*
 * Comments:
 * 
 * Divide and conquer (just like QuickSort) and after subdividing, merge the two arrays
 */

import java.util.List;
import java.util.LinkedList;

public class MergeSort<E extends Comparable<E>> implements SortingAlgorithm<E> {

	@Override
	public void sort(List<E> list) {
		subsort(list, 0, list.size()-1);
	}
	
	public void subsort(List<E> list, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivotIndex = (startIndex+endIndex)/2;
			subsort(list, startIndex, pivotIndex);
			subsort(list, pivotIndex+1, endIndex);
			merge(list, startIndex, pivotIndex, endIndex);
		}
	}
	
	public void merge(List<E> list, int startIndex, int pivotIndex, int endIndex) {
		LinkedList<E> arrayA = new LinkedList<>(list.subList(startIndex, pivotIndex+1));
		LinkedList<E> arrayB = new LinkedList<>(list.subList(pivotIndex+1, endIndex+1));
		
		int i = startIndex;
		while (!arrayA.isEmpty() && !arrayB.isEmpty()) {
			if(arrayA.peek().compareTo(arrayB.peek()) < 0) {
				list.set(i, arrayA.removeFirst());
			} else {
				list.set(i, arrayB.removeFirst());
			}
			i++;
		}
		for (int j=0; j<arrayA.size(); j++) {
			list.set(i, arrayA.removeFirst());
			i++;
		}
		for (int j=0; j<arrayB.size(); j++) {
			list.set(i, arrayB.removeFirst());
			i++;
		}
	}

}
