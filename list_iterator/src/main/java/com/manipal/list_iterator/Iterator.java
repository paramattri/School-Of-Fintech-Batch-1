package com.manipal.list_iterator;

public interface Iterator<E>{
	
	boolean hasNext();
	boolean hasPrevious();
	E next();
	E previous();

}
