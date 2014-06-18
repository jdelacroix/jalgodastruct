// Copyright (C) 2014 Jean-Pierre de la Croix
// see the LICENSE file included with this software

package com.jpdelacroix.jalgodastruct.sort;

import java.util.ArrayList;

/**
 * An interface for in-place sorting algorithms.
 * 
 * Use {@link #sort(ArrayList)} to sort an ArrayList of comparable Objects.
 * 
 * @author Jean-Pierre de la Croix
 */
public interface SortingAlgorithm {
	
	/**
	 * sort() sorts in-place Comparables in a possibly unsorted ArrayList.
	 * @param list		A possibly unsorted ArrayList of comparable Objects
	 */
	public <E extends Comparable<E>> void sort(ArrayList<E> list);
	
	/**
	 * swap() switches Objects at two indices within an ArrayList
	 * @param list		An ArrayList of Objects
	 * @param indexA	Index of the first Object
	 * @param indexB	Index of the second Object
	 */
	public default <E> void swap(ArrayList<E> list, int indexA, int indexB) {
		E itemC = list.get(indexA);
		list.set(indexA, list.get(indexB));
		list.set(indexB, itemC);
	}
}
