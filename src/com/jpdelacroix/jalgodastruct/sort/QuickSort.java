package com.jpdelacroix.jalgodastruct.sort;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort<E extends Comparable<E>> implements SortingAlgorithm<E> {

	@Override
	public void sort(ArrayList<E> list) {
		subsort(list, 0, list.size()-1);
	}
	
	private void subsort(ArrayList<E> list, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivotIndex = partition(list, startIndex, endIndex);
			subsort(list, startIndex, pivotIndex-1);
			subsort(list, pivotIndex+1, endIndex);
		}
	}
	
	private int partition(ArrayList<E> list, int startIndex, int endIndex) {
		// Optionally, randomly pick the pivot, else pick endIndex as pivotIndex
//		int pivotIndex = startIndex+(new Random()).nextInt(endIndex-startIndex+1);
//		swap(list, pivotIndex, endIndex);
		E pivotItem = list.get(endIndex);
		int i = startIndex-1;
		for (int j=startIndex; j<endIndex; j++) {
			if (list.get(j).compareTo(pivotItem) <= 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i+1, endIndex);
		return (i+1);
	}

}
