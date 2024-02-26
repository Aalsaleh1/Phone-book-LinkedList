/*************Information***************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
15-10-2023


AUTHORS:
Abdulaziz Alsaleh 
****************************************/
public class Node<T> {
	public T data;
	public Node<T> next;
	//Initializes a new Node object with null data and null next reference.
	public Node () {
		data = null;
		next = null;
	}
    //Initializes a new Node object with the provided data and null next reference
	public Node (T val) {
		data = val;
		next = null;
	}
    //Retrieves the data stored in the node
	public T getData() {
		return data;
	}
    //Sets the data stored in the node
	public void setData(T data) {
		this.data = data;
	}
    //Retrieves the next node in the linked list
	public Node<T> getNext() {
		return next;
	}
    //Sets the next node in the linked list
	public void setNext(Node<T> next) {
		this.next = next;
	}

	

	
}