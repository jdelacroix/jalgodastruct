// Copyright (C) 2014 Jean-Pierre de la Croix
// see the LICENSE file included with this software

package com.jpdelacroix.jalgodastruct.sort;

import java.util.List;

public class BubbleSort<E extends Comparable<E>> implements SortingAlgorithm<E> {

	@Override
	public void sort(List<E> list) {
		E currentItem;
		for (int i=0; i<list.size()-1; i++) {
			currentItem = list.get(i);
			for (int j=i+1; j<list.size(); j++) {
				if (list.get(j).compareTo(currentItem) < 0) {
					swap(list, i, j);
					currentItem = list.get(i);
				}
			}
		}
	}

}
