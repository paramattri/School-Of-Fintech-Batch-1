package com.manipal.list_iterator;

public class ListTwoWays<E> implements Container<E>{
	
	private E[] list;

	public E[] getList() {
		return list;
	}

	public void setList(E[] list) {
		this.list = list;
	}
	
	public Iterator getIterator() {
		
		return new ListIteratorTwoWays();
		
	}
	
	private class ListIteratorTwoWays implements Iterator<E>{
		
		int startIndex = 0;
		int lastIndex = list.length - 1;
		
		public boolean hasNext() {
			
			if(startIndex < list.length)
				return true;
			
			return false;
		}

		public boolean hasPrevious() {
			
			if(lastIndex >= 0)
				return true;
			
			return false;
		}

		public E next() {
			
			if(hasNext())
				return list[startIndex++];
			
			return null;
		}

		public E previous() {
			
			if(hasPrevious())
				return list[lastIndex--];
			
			return null;
		}
		
	}

}
