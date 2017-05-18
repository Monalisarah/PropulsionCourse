package stackFILO;

public class Stack<T> {
	
	// Property of stack, tracks the top Node on the stack.
	Node<T> top;
	int size = 0;
	 
	
	public void push(T data){
		Node<T> node = new Node<T>(data);
		node.setNext(top);
		this.top = node;
		this.size++;
	}

	T pop(){
		Node<T> topNode = this.top;
		this.top = topNode.getNext();
		this.size --;
		return topNode.getData();
	}
	
	T peek(){ 
		return this.top.getData();
	}
	
	int size(){
		return size;
	}
	
	boolean isEmpty(){
		return size == 0;
	}
}
