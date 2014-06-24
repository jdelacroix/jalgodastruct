package com.jpdelacroix.jalgodastruct.sort;

import java.util.List;

import com.jpdelacroix.jalgodastruct.heap.BinaryMaxHeap;
import com.jpdelacroix.jalgodastruct.heap.Heap;

public class HeapSort<E extends Comparable<E>> implements SortingAlgorithm<E> {

	@Override
	public void sort(List<E> list) {
		Heap<E> heap = new BinaryMaxHeap<E>(list);
		for (int i=list.size()-1; i>=0; i--) {
			list.set(i, heap.remove(0));
		}
	}

}
