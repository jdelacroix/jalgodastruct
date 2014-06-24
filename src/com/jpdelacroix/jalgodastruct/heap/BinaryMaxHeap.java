package com.jpdelacroix.jalgodastruct.heap;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class BinaryMaxHeap<E extends Comparable<E>> implements Heap<E> {
	
	private ArrayList<E> internalArray = new ArrayList<>();
	
	public BinaryMaxHeap(Collection<? extends E> c) {
		internalArray.addAll(c);
		buildMaxHeap();
	}
	
	@Override
	public E remove(int index) {
		if (index >= 0 && index < internalArray.size()) {
			swap(index, internalArray.size()-1);
			E key = internalArray.remove(internalArray.size()-1);
			ensureMaxHeapProperty(index);
			return key;
		}
		return null;
	}
	
	@Override
	public int search(E key) {
		for (int i=0; i<internalArray.size(); i++) {
			if (key.equals(internalArray.get(i))) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void insert(E key) {
		internalArray.add(key);
		int index = internalArray.size()-1;
		while (index >=0 && key.compareTo(internalArray.get(getParent(index))) > 0) {
			swap(index, getParent(index));
			index = getParent(index);
		}
	}

	@Override
	public void merge(Heap<E> heap) {
		E key = heap.remove(0);
		while (key != null) {
			insert(key);
			key = heap.remove(0);
		}
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		for (E key : internalArray) {
			buffer.append(key.toString() + ",");
		}
		buffer.append("\b]");
		return buffer.toString();
	}
	
	private void buildMaxHeap() {
		for (int i = (internalArray.size()/2)-1; i >= 0; i--) {
			ensureMaxHeapProperty(i);
		}
	}
	
	private void ensureMaxHeapProperty(int root) {
		int leftChild = getLeftChild(root), rightChild = getRightChild(root), largestNode = root;
		if (leftChild < internalArray.size() && internalArray.get(leftChild).compareTo(internalArray.get(root)) > 0) {
			largestNode = leftChild;
		}
		if (rightChild < internalArray.size() && internalArray.get(rightChild).compareTo(internalArray.get(largestNode)) > 0) {
			largestNode = rightChild;
		}
		if (largestNode != root) {
			swap(largestNode, root);
			ensureMaxHeapProperty(largestNode);
		}
	}
	
	private int getParent(int root) {
		return (root-1)/2;
	}
	
	private int getLeftChild(int root) {
		return (2*root+1);
	}
	
	private int getRightChild(int root) {
		return (2*root+2);
	}
	
	private void swap(int indexA, int indexB) {
		E temp = internalArray.get(indexA);
		internalArray.set(indexA, internalArray.get(indexB));
		internalArray.set(indexB, temp);
	}
}
