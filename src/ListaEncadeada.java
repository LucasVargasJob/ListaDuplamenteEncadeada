import java.util.Iterator;

public class ListaEncadeada implements Iterable<Object> {
	private No head = null;
	private No tail = null;
	private int elementos = 0;
	
	public void append(Object o){
		No node = new No(o);
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		tail = node;
		elementos++;
	}
	
	public void addFirst(Object o){
		No node = new No(o);
		if (head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
			node.setNext(head);
		}
		head = node;
		elementos++;
	}
	
	public void remove(Object o){}
	
	
	public Iterador iterador() {
		return new ListaIterator() ;
	}
	
	public No getFirst(){
		return head;
	}
	    
	public No getLast(){
		return tail;
	}
	  
	public boolean hasObject(Object o){
		if (head != null){
			return true;
	    }else{
	    	return false;
	    }
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	
    private static class No {

    	private Object dado;
    	private No anterior;
    	private No proximo;
    	
        public No(Object dado){
        	this.dado = dado;
        	this.anterior = null;
    		this.proximo = null;
        }
     
        public No NoNext(){
        	return proximo;
        }
        
        public void setNext(No proximo) {
			this.proximo = proximo;
		}
        
        public No NoPrevious(){
        	return anterior;
        }
        
        public void setPrevious(No anterior) {
			this.anterior = anterior;
		}
        
        public Object getData(){
        	return dado;
        }

    }
///////////////////////////////////////////////////////////////////////////////////////////////
    private class ListaIterator implements Iterador {

		private No current = null;

		public void starter() {
			if (current == null)
				current = head;
		}
		
		@Override
		public boolean hasNext() {
			starter();
			return current.NoNext() != null;
		}
		
		
		@Override
		public boolean hasPrevious() {
			starter();
			return current.NoPrevious() != null;
		} 
		
		@Override
		public Object next() {
			starter();
			if (hasNext()) {
				current = current.NoNext();
				return current.dado;
			} else {
				return "Não possui proximo.";
			}
		}
		
		@Override
		public Object previous() {
			starter();
			if (hasPrevious()) {
				current = current.NoPrevious();
				return current.dado;
			} else {
				return "Não possui anterior.";
			}
		} 
	
		@Override
		public void insertBefore(Object dado) {
			No no = new No(dado);
			starter();
			no.setNext(current);
			if (hasPrevious()) {
				no.setPrevious(current.NoPrevious());
				current.NoPrevious().setNext(no);
			} else {
				head = no;
			}
			current.setPrevious(no);
			elementos++;
		}

		@Override
		public void insertAfter(Object dado) {
			No no = new No(dado);
			starter();
			no.setPrevious(current);
			if (hasNext()) {
				no.setNext(current.NoNext());
				current.NoNext().setPrevious(no);
			} else {
				tail = no;
			}
			current.setNext(no);
			elementos++;
		}

		@Override
		public void remove() {}
		
    }

	@Override
	public Iterator<Object> iterator() {
		return null;
	}
	
	
	
	
	

	
	
	



	
}
