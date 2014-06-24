// Copyright (C) 2014 Jean-Pierre de la Croix
// see the LICENSE file included with this software

package com.jpdelacroix.jalgodastruct.sort;

import java.util.List;

public class SelectionSort<E extends Comparable<E>> implements SortingAlgorithm<E> {

	
	@Override
	public void sort(List<E> list) {
		int indexOfMin = 0;
		for (int i=0; i<list.size()-1; i++) {
			indexOfMin = i;
			for (int j=i+1; j<list.size(); j++) {
				if(list.get(j).compareTo(list.get(indexOfMin)) < 0) {
					indexOfMin = j;
				}
			}
			if (indexOfMin != i) {
				swap(list, i, indexOfMin);
			}
		}
	}

}
