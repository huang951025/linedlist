/**
Author: Wei Wen Huang
Date: 2019/11/1
class: Data Structures
describe: rewrite 7# and add #11 add a method remove item by name

*/

import java.util.Scanner;
public class LinkedList<T> implements ListInterface<T> {
	Scanner input = new Scanner(System.in);
	private Node firstNode;

	private Node lastNode;

	private class Node {

		private T data;

		private Node prev;

		private Node next;

		private Node(T dataPortion) {

			this(null, dataPortion, null);

		} // end constructor

		private Node(Node prevNode, T dataPortion, Node nextNode) {

			prev = prevNode;

			data = dataPortion;

			next = nextNode;

		} // end constructor

	} // end Node

	public LinkedList() {

		firstNode = null;

		lastNode = null;

	}

	@Override

	public void add(T newEntry) {

		Node newNode = new Node(lastNode, newEntry, null);

		if (isEmpty()) {

			firstNode = newNode;

		}

		else {

			lastNode.next = newNode;

		}

		lastNode = newNode;

	}

	@Override

	public boolean add(int givenPosition, T newEntry) {

		boolean added = false;

		Node newNode = new Node(newEntry);

		if (isEmpty()) {

// System.out.println("Link is empty, inserting at index " + index + ", calling add(newEntry)");

			add(newEntry);

			added = true;

		}

		else if (givenPosition == 0) {

// System.out.println("Inserting at index " + index + ", givenPosition is " + givenPosition);

			newNode.next = firstNode;

			firstNode = newNode;

			added = true;

		}

		else {

			Node currentNode = getNode(givenPosition);

			if (currentNode == null) {

// System.out.println("Inserting at the end, index " + index);

				lastNode.next = newNode;

				newNode.prev = lastNode;

				lastNode = newNode;

				added = true;

			}

			else {

// System.out.println("Inserting before currentNode, index " + index);

				Node prevNode = currentNode.prev;

				newNode.prev = prevNode;

				newNode.next = currentNode;

				prevNode.next = newNode;

				currentNode.prev = newNode;

				added = true;

			}

		}

		return added;

	}

	@Override

	public T remove(int givenPosition) {

		T data = null;

		if (isEmpty()) {

			return data;

		}

		else if (givenPosition == 0) {

			data = firstNode.data;

			firstNode = firstNode.next;

			firstNode.prev = null;

		}

		else {

			Node currentNode = getNode(givenPosition);

			if (currentNode == null) {

				return data;

			}

			else if (currentNode == lastNode) {

				data = currentNode.data;

				lastNode = currentNode.prev;

				lastNode.next = null;

			}

			else {

				data = currentNode.data;

				Node prevNode = currentNode.prev;

				Node nextNode = currentNode.next;

				prevNode.next = currentNode.next;

				nextNode.prev = currentNode.prev;

			}

		}

		return data;

	}

	@Override

	public void clear() {

		firstNode = lastNode = null;

	}

	@Override

	public boolean replace(int givenPosition, T newEntry) {

		if (isEmpty()) {

			return false;

		}

		else {

			Node currentNode = getNode(givenPosition);

			if (currentNode != null) {

				currentNode.data = newEntry;

				return true;

			}

		}

		return false;

	}

	@Override

	public T getEntry(int givenPosition) {

		if (isEmpty()) {

			return null;

		}

		else {

			Node currentNode = getNode(givenPosition);

			if (currentNode != null) {

				return currentNode.data;

			}

			else {

				return null;

			}

		}

	}

	@Override

	public int getLength() {

		int count = 0;

		Node currentNode = firstNode;

		while (currentNode != null) {

			count++;

			currentNode = currentNode.next;

		}

		return count;

	}

	@Override

	public boolean isEmpty() {

		return firstNode == null;

	}

	@Override

	public void printList() {

		Node currentNode = firstNode;

		if (isEmpty()) {

			System.out.println("List is empty");

		}

		else {

			while (currentNode != null) {

				System.out.println(currentNode.data);

				currentNode = currentNode.next;

			}

		}

	}

	@Override

	public boolean isFull() {

		return false;

	}

	private Node getNode(int givenPosition) {

		int index = 0;

		Node currentNode = firstNode;

		while ((index != givenPosition) && (currentNode != null)) {

			currentNode = currentNode.next;

			index++;

		}

		return currentNode;

	}
   
	// a method remove item by name
	@SuppressWarnings("unused")
	public void removeItemByName(T name) {

    int index = 1;// index to count the position
	int [] found = new int[50];// a  array to save position
	
	int find = 0; // count how many time find position
	Node currentNode = firstNode; 
	boolean enter = false; // to check is enter correct 
	//while loop to found the position
	while(currentNode != lastNode) {
		if(currentNode.data.equals(name)) {
			System.out.println("found item in position "+ index);
			++find;
			found[find] = index;
			
		}
		
		index++;
		currentNode = currentNode.next;// get nextnode
	}//end while loop
	if(find ==1) {
		remove(found[find-1]);
		System.out.println("the бо" + name + "' is remove" );
	} else {
		System.out.println("please enter the position you want to remove");
		int givenPosition = input.nextInt();
	
		for(int i = 0; i < found.length; i++) { // check is enter correct
		if(givenPosition == found[i]) {
			enter = true;
		}// end if loop
	
		}//end for loop
		while(enter != true) { // when enter wrong
			
			System.out.println("Wrong enter please try again" );
			System.out.println("please enter the position you want to remove");
			System.out.println("enter 0 to exit");
			givenPosition = input.nextInt();
			
			if(givenPosition == 0) {
				break;
			}
			for(int i = 0; i < found.length; i++) {
			if(givenPosition == found[i]) {
				enter = true;
			}// end if loop
			
			}
		}//end while loop
		remove(found[find - 1]);
		System.out.println("the бо" + name + "' is remove" );
		
	
			
		
	}// end else loop
	}// end method remove by name
	
	//a method seek
	public boolean seek(T name) {
		boolean found = false; 
		int index = 1;// to save the position
		Node currentNode = firstNode; 
		while(currentNode != lastNode) { // seek the item
			if(currentNode.data.equals(name)) {
				System.out.println("found item " + name + " in position "+ index);
				found = true;

			}
			
			index++;
			currentNode = currentNode.next;// get nextnode
		}//end while loop
		
		
		
		
		return found;
	}// end method seek
	
}
	
