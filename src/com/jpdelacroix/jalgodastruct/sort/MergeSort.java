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
		LinkedList<E> arrayA = new LinkedList<>(), arrayB = new LinkedList<>();
		
		for (int i=startIndex; i<=pivotIndex; i++) {
			arrayA.add(list.get(i));
		}
		for (int i=pivotIndex+1; i<=endIndex; i++) {
			arrayB.add(list.get(i));
		}
		
		int i = startIndex;
		while (!arrayA.isEmpty() && !arrayB.isEmpty()) {
			if(arrayA.peek().compareTo(arrayB.peek()) < 0) {
				list.set(i, arrayA.removeFirst());
			} else {
				list.set(i, arrayB.removeFirst());
			}
			i++;
		}
		while (!arrayA.isEmpty()) {
			list.set(i, arrayA.removeFirst());
			i++;
		}
		while (!arrayB.isEmpty()) {
			list.set(i, arrayB.removeFirst());
			i++;
		}
	}

}
