// Copyright (C) 2014 Jean-Pierre de la Croix
// see the LICENSE file included with this software

package com.jpdelacroix.jalgodastruct.sort;

import java.util.List;

/**
 * An interface for in-place sorting algorithms.
 * 
 * Use {@link #sort(ArrayList)} to sort an ArrayList of comparable Objects.
 * 
 * @author Jean-Pierre de la Croix
 */
public interface SortingAlgorithm<E extends Comparable<E>> {
	
	/**
	 * sort() sorts in-place Comparables in a possibly unsorted ArrayList.
	 * @param list		A possibly unsorted ArrayList of comparable Objects
	 */
	public void sort(List<E> list);
	
	/**
	 * swap() switches Objects at two indices within an ArrayList
	 * @param list		An ArrayList of Objects
	 * @param indexA	Index of the first Object
	 * @param indexB	Index of the second Object
	 */
	public default void swap(List<E> list, int indexA, int indexB) {
		E itemC = list.get(indexA);
		list.set(indexA, list.get(indexB));
		list.set(indexB, itemC);
	}
}
