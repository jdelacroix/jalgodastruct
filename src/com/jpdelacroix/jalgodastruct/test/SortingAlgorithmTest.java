package com.jpdelacroix.jalgodastruct.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.jpdelacroix.jalgodastruct.sort.BubbleSort;
import com.jpdelacroix.jalgodastruct.sort.InsertionSort;
import com.jpdelacroix.jalgodastruct.sort.SelectionSort;
import com.jpdelacroix.jalgodastruct.sort.SortingAlgorithm;

public class SortingAlgorithmTest {
	
	private final Integer[] unsortedArray = {3, 9, 4, 5, 1, 2, 7, 6, 8};

	@Test
	public void testBubleSort() {
		SortingAlgorithm sortingAlgorithm = new BubbleSort();
		System.out.println("Testing BUBBLE SORT");
		Integer[] sortedArray = sortArrayUsing(sortingAlgorithm);
		assertEquals(Arrays.toString(sortedArray), "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
	}
	
	@Test
	public void testSelectionSort() {
		SortingAlgorithm sortingAlgorithm = new SelectionSort();
		System.out.println("Testing SELECTION SORT");
		Integer[] sortedArray = sortArrayUsing(sortingAlgorithm);
		assertEquals(Arrays.toString(sortedArray), "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
	}
	
	@Test
	public void testInsertionSort() {
		System.out.println("Testing INSERTION SORT");
		Integer[] sortedArray = sortArrayUsing(new InsertionSort());
		assertEquals(Arrays.toString(sortedArray), "[1, 2, 3, 4, 5, 6, 7, 8, 9]");
	}

	private Integer[] sortArrayUsing(SortingAlgorithm sortingAlgorithm) {
		ArrayList<Integer> unsortedList = new ArrayList<>(unsortedArray.length);
		for (int i=0; i<unsortedArray.length; i++) {
			unsortedList.add(unsortedArray[i]);
		}
		
		System.out.println("   PRESORT: " + Arrays.toString(unsortedArray));
		
		sortingAlgorithm.sort(unsortedList);
		
		Integer[] sortedArray = new Integer[unsortedArray.length];
		unsortedList.toArray(sortedArray);
		
		System.out.println("  POSTSORT: " + Arrays.toString(sortedArray));
		
		return sortedArray;
	}
}
