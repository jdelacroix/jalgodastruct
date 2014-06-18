// Copyright (C) 2014 Jean-Pierre de la Croix
// see the LICENSE file included with this software

/*
 * Comments:
 * 
 * Insertion sort is very fast on small arrays, best case O(n), worst and average O(n^2)
 * In fact, O(n+d), where d is the number of inversions
 * 
 * Online and partial sorts are possible, because after k steps, the first k items in the
 * array are sorted (versus the k smallest values, see selection sort). 
 * 
 * Stable, in-place.
 * 
 */

package com.jpdelacroix.jalgodastruct.sort;

import java.util.ArrayList;

public class InsertionSort implements SortingAlgorithm {

	@Override
	public <E extends Comparable<E>> void sort(ArrayList<E> list) {
		int j = 0;
		for (int i=0; i<list.size(); i++) {
			j = i;
			while (j>0 && list.get(j-1).compareTo(list.get(j)) > 0) {
				swap(list, j-1, j);
				j--;
			}
		}
	}
	
//	@Override
//	public <E extends Comparable<E>> void sort(ArrayList<E> list) {
//		E currentItem;
//		int j = 0;
//		for (int i=0; i<list.size(); i++) {
//			j = i;
//			while (j>0 && list.get(j-1).compareTo(currentItem) > 0) {
//				list.set(j, list.get(j-1));
//				j--;
//			}
//			list.set(j, currentItem);
//		}
//	}
	
	

}
