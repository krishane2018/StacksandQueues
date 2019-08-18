import java.util.LinkedList;

public class QueueListBased<E> {
	
	private LinkedList<E> items; // Holds the items of the stack.
	
	public QueueListBased() {	// Constructor, creates stack.
		createQueue();
	}
	
	public void createQueue() {		// Creates stack.
		items = new LinkedList<E>();
	}
	
	public void dequeueAll() {			// Removes all the items in the stack.
		items.clear();
	}
	
	public boolean isEmpty() {		// Checks if stack is empty. 
		return items.isEmpty();
	}
	
	public void enqueue (E o) {		// Adds item to the stack.
		items.add(o);
	}
	
	public E dequeue() throws RuntimeException { // Removes item at the top of the stack and returns it.
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return items.removeFirst();
	}
	
	public E peek() throws RuntimeException{ // Returns the top item of the stack.
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return items.peek();
	}

}
