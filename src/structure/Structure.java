package structure;

public class Structure<T> {

	public T[] elements; 
	public int size;

	
	@SuppressWarnings("unchecked")
	public Structure(int capacity){
		this.elements = (T[]) new Object[capacity]; //solução do livro effective Java
		this.size = 0;
	}

	public Structure(){
		this(10);
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}

	public boolean include(T element) {
		this.increasescapacity();
		if (this.size < this.elements.length){
			this.elements[this.size] = element;
			this.size++;
			return true;
		} 
		return false;
	}

	public boolean include(int position, T element){

		if (position < 0 || position > size){
			throw new IllegalArgumentException("Posição inválida");
		}

		this.increasescapacity();

		//mover todos os elements
		for (int i=this.size-1; i>=position; i--){
			this.elements[i+1] = this.elements[i];
		}
		this.elements[position] = element;
		this.size++;

		return true;
	}
	
	public void remove(int position){
		if (!(position >= 0 && position < size)){
			throw new IllegalArgumentException("position invalida");
		}
		for (int i=position; i<size-1; i++){
			elements[i] = elements[i+1];
		}
		size--;
	}

	@SuppressWarnings("unchecked")
	public void increasescapacity(){
		if (this.size == this.elements.length){
			T[] elementsNew = (T[]) new Object[this.elements.length * 2];
			for (int i=0; i<this.elements.length; i++){
				elementsNew[i] = this.elements[i];
			}
			this.elements = elementsNew;
		}
	}
	
	public int size(){
		return this.size;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=0; i<this.size-1; i++){
			s.append(this.elements[i]);
			s.append(", ");
		}
		
		if (this.size>0){
			s.append(this.elements[this.size-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
}