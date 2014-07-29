// Copyright (C) 2014 Jean-Pierre de la Croix
// see the LICENSE file included with this software

package com.jpdelacroix.jalgodastruct.heap;

public interface Heap<E extends Comparable<E>> {
		
	public int search(E key);
	public void insert(E key);
	public E remove(int index);
	public void merge(Heap<E> heap);
	
}
