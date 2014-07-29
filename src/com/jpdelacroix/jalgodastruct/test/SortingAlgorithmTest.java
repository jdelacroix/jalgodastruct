package com.jpdelacroix.jalgodastruct.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.jpdelacroix.jalgodastruct.sort.BubbleSort;
import com.jpdelacroix.jalgodastruct.sort.HeapSort;
import com.jpdelacroix.jalgodastruct.sort.InsertionSort;
import com.jpdelacroix.jalgodastruct.sort.MergeSort;
import com.jpdelacroix.jalgodastruct.sort.QuickSort;
import com.jpdelacroix.jalgodastruct.sort.SelectionSort;
import com.jpdelacroix.jalgodastruct.sort.SortingAlgorithm;

public class SortingAlgorithmTest {
	
	public static final int ARRAY_SIZE = 10000;
	private Integer[] unsortedArray, solutionArray;
	
	@Before
	public void setUp() {
		Random rg = new Random();
		unsortedArray = new Integer[ARRAY_SIZE];
		for (int i=0; i<unsortedArray.length; i++) {
			unsortedArray[i] = rg.nextInt(ARRAY_SIZE);
		}
		solutionArray = unsortedArray.clone();
		Arrays.sort(solutionArray);
	}

	@Test
	public void testBubbleSort() {
		SortingAlgorithm<Integer> sortingAlgorithm = new BubbleSort<>();
		System.out.println("Testing BUBBLE SORT");
		Integer[] sortedArray = sortArrayUsing(sortingAlgorithm);
		assertEquals(Arrays.toString(sortedArray), Arrays.toString(solutionArray));
	}
	
	@Test
	public void testSelectionSort() {
		SortingAlgorithm<Integer> sortingAlgorithm = new SelectionSort<>();
		System.out.println("Testing SELECTION SORT");
		Integer[] sortedArray = sortArrayUsing(sortingAlgorithm);
		assertEquals(Arrays.toString(sortedArray), Arrays.toString(solutionArray));
	}
	
	@Test
	public void testInsertionSort() {
		System.out.println("Testing INSERTION SORT");
		Integer[] sortedArray = sortArrayUsing(new InsertionSort<Integer>());
		assertEquals(Arrays.toString(sortedArray), Arrays.toString(solutionArray));
	}
	
	@Test
	public void testQuickSort() {
		System.out.println("Testing QUICK SORT");
		Integer[] sortedArray = sortArrayUsing(new QuickSort<Integer>());
		assertEquals(Arrays.toString(sortedArray), Arrays.toString(solutionArray));
	}
	
	@Test
	public void testMergeSort() {
		System.out.println("Testing MERGE SORT");
		Integer[] sortedArray = sortArrayUsing(new MergeSort<Integer>());
		assertEquals(Arrays.toString(sortedArray), Arrays.toString(solutionArray));
	}
	
	@Test
	public void testHeapSort() {
		System.out.println("Testing HEAP SORT");
		Integer[] sortedArray = sortArrayUsing(new HeapSort<Integer>());
		assertEquals(Arrays.toString(sortedArray), Arrays.toString(solutionArray));
	}

	private Integer[] sortArrayUsing(SortingAlgorithm<Integer> sortingAlgorithm) {
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
