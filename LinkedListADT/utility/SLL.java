package utility;

import java.io.Serializable;

//import problemdomain.User;

public class SLL implements LinkedListADT, Serializable {

	private Node head;
	private int size;
	

	
	public SLL() {
		head = null;
	}



	@Override
	/**
	 * Clears the list.
	 */
	public void clear() {	
		this.size = 0;
        head = null;		
	}
	
	
	
	@Override
	/**
	 * Checks if the list is empty.
	 * @return True if it is empty.
	 */
	public boolean isEmpty() {
		return (head == null);
	}



	@Override
	/**
	 * Gets the number of elements in the list.
	 * @return Size of list (0 meaning empty)
	 */
	public int size() {			
		
		return this.size;
		
	}


	
	
	@Override
	/**
	 * Gets the data at the specified index.
	 * @param index Index of element to get.
	 * @return Data in element or null if it was not found.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of the list.
	 */
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		
		if (index >= this.size() || index < 0) {
			throw new IndexOutOfBoundsException ("Index are larger than the list size");
		}
		
		Node current = null;
		
		if (head != null) {
			current = head.getNext();
			
			for (int i = 0; i < index; i++) {
//				if (current.getNext() == null) {return null;}				
				current = current.getNext();
			}
		}
		
		return current.getData();
		
	}
	
	
	
	@Override
	/**
	 * Prepends (adds to beginning) data to the list.
	 * @param data Data to store inside element.
	 */
	public void prepend(Object data){		
				
		if (head == null) {
			head = new Node(data);
		}
			
		Node temp = new Node(data);
	
		temp.setNext(head.getNext());
		head.setNext(temp);
		
		this.size++;    
	}
	
	
	
	/**
	 * Adds to the end of the list.
	 * @param data Data to append.
	 */
	@Override
	public void append(Object data) {		
		
		if (head == null) {
			head = new Node(data);
		}
		
		Node temp = new Node(data);
		Node current = this.head;
		
		while(current.getNext() != null) {
			current = current.getNext();
		}
			
		current.setNext(temp);
		
		this.size++;
		
	}
	
	
	
	@Override
	/**
	 * Go through elements and check if we have one with data.
	 * @param data Data object to search for.
	 * @return True if element exists with value.
	 */
	public boolean contains(Object data) {
		
		Node current = head;
		Object temp;
		
		while (current != null) {
			temp = current.getData();
			if (temp.equals(data)) {
				return true;
			}
			
			current = current.getNext();
		}
		
		return false;
	}
	
	
	
	@Override
	/**
	 * Gets the first index of element containing data.
	 * @param data Data object to find the first index of.
	 * @return First of index of element with matching data or -1 if not found.
	 */
	public int indexOf(Object data) {
		
		Node current = head;
		Object temp;
		int i = -1;
		
		while (current != null) {
			
			temp = current.getData();
			if (temp.equals(data)) {
				return i;
			}
			
			
			current = current.getNext();
			i++;
		}
			
		return -1;
	}
	
	
	
	@Override
	/**
	 * Removes element at index from list, reducing the size.
	 * @param index Index of element to remove.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size - 1.
	 */
	public void delete(int index) throws IndexOutOfBoundsException {
		
		if (index >= this.size() || index < 0) {
			throw new IndexOutOfBoundsException ("Index are larger than the list size");
		}
		
		Node current = head;
		
		if(head != null) {
			
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
		}
		
		current.setNext(current.getNext().getNext());
		
		this.size--;
		
	}
	
	
	
	@Override
	/**
	 * Adds a new element at a specific position.
	 * @param data Data that element is to contain.
	 * @param index Index to add new element at.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size of the list.
	 */
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		
		Node temp = new Node(data);
		Node current = head;
		
		if (index >= this.size() || index < 0) {
			throw new IndexOutOfBoundsException ("Index are larger than the list size");
		}
		

		if (current != null) {
			//iterate through the list and stop at index 
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
		}
		
		temp.setNext(current.getNext());
		current.setNext(temp);
		
		this.size++;
		
	}
	
	
	
	@Override
	/**
	 * Replaces the data  at index.
	 * @param data Data to replace.
	 * @param index Index of element to replace.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	public void replace(Object data, int index) throws IndexOutOfBoundsException {	
		
		if (index >= this.size() || index < 0) {
			throw new IndexOutOfBoundsException ("Index are larger than the list size");
		}
		
		
		Node current = head;
		Node temp = new Node(data);
		
		if(current != null) {
			
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
		}
		
		current.setNext(current.getNext().getNext());
		temp.setNext(current.getNext());
		current.setNext(temp);
		
	}
	
}
