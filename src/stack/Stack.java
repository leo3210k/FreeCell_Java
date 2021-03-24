package stack;

import structure.Structure;;

public class Stack<T> extends Structure<T>{

	public Stack(){
		super();
	}
	
	public Stack(int capacity){
		super(capacity);
	}
	
	public void stackUp(T element){

		if(this.size == 0) {
			this.include(element);
		}else {
			this.include(this.size, element);
		}
	}
	
	public T spy(){
		
		if (this.isEmpty()){
			return null;
		}
		
		return this.elements[this.size - 1];
	}
	
	public T get(Integer n) {
		int x = size();
		for(int i = 0;i <= x;i++) {
			if(this.elements[i] == elements[n]) {
				return this.elements[i];
			}
		}
		return null;
	}
	
	public int size() {
		int x = size();
		return x;
	}
	
	public T unStack(){
		
		final int POS = this.size - 1;
		
		if (this.isEmpty()){
			return null;
		}
		
		T elementToBeRemoved = this.elements[POS];
		
		this.remove(POS);
		
		return elementToBeRemoved;
		
	}
}

