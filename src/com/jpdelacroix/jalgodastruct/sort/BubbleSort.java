// Copyright (C) 2014 Jean-Pierre de la Croix
// see the LICENSE file included with this software
package com.jpdelacroix.jalgodastruct.sort;

import java.util.ArrayList;

public class BubbleSort implements SortingAlgorithm {

	@Override
	public <E extends Comparable<E>> void sort(ArrayList<E> list) {
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
