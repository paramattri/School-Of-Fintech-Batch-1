package com.manipal.list_iterator_demo;

import com.manipal.list_iterator.Iterator;
import com.manipal.list_iterator.ListTwoWays;

public class ListIterarorDemo {

	public static void main(String[] args) {
		
		ListTwoWays<String> listTwoWays = new ListTwoWays<String>();
		String[] fruits = {"Apple","Banana","Mango","Orange"};
		
		listTwoWays.setList(fruits);
		Iterator<String> iter = listTwoWays.getIterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		while(iter.hasPrevious()) {
			System.out.println(iter.previous());
		}		

	}

}
