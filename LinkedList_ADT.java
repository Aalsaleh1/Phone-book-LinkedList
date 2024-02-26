/*************Information***************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
15-10-2023


AUTHORS:
Abdulaziz Alsaleh 
****************************************/
public class LinkedList_ADT<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList_ADT() {//0
		head = null;//1
		current = head;//1
	}

	public boolean empty() {//0
		return head == null;//1
	}

	public boolean checkIfNull() {//0
		return current == null;//1
	}
	//Total: 1

	public boolean last() {//0
		return current.next == null;//1
	}

	public boolean full() {//0
		return false;//1
	}

	public void findFirst() {//0
		current = head;//1
	}

	public void findNext() {//0
		current = current.next;//1
	}

	public T retrieve() {//0
		return current.data;//1
	}

	public void update(T Val) {//0
		current.data = Val;//1
	}

	public Contact searchContactByName(String name) {//0
		findFirst();//1
		if (empty()) {//1
			return null;//1
		}
		while (!checkIfNull()) { //n+1  ,where n is number of contacts
			Contact contact = (Contact) current.getData(); //n
			if (contact.getName().equalsIgnoreCase(name)) { // n(k+1) , where k is length of name
				return contact;//1
			}
			findNext();//n

		}
		 // Contact not found
		return null;//1
	}//0
	//Total: 4+nk+4n

	public Contact searchContactByNumber(String phoneNumber) {//0
		findFirst();//1
		if (empty()) {//1
			return null;//1
		}
		while (!checkIfNull()) { //n+1 ,where n is number of contacts
			if (((Contact) current.data).getPhoneNumber().equals(phoneNumber)) { // n(k + 1) ,where k is length of phoneNumber
				return (Contact) current.data; //1
			}//0
			findNext();//n
		}//0
		return null;//1
	}//0
	//Total: 4+nk+3n

	public void insertContactSorted(T contact) {//0
	    Node<T> newNode = new Node<T>(contact);//1

	    // Check if contact with the same name already exists
	    if (searchContactByName(((Contact) newNode.data).getName()) != null) { // (4+nd+4n) +1
	        System.out.println("A contact with the same name already exists.");//1
	        return;//1
	    }//0

	    // Check if contact with the same number already exists
	    if (searchContactByNumber(((Contact) newNode.data).getPhoneNumber()) != null) {// (4+3n+nf) +1
	        System.out.println("A contact with the same number already exists.");//1
	        return;//1
	    }//0

	    if (empty() || ((Contact) newNode.data).compareTo(head.data) < 0) { //2
	        newNode.next = head;//1
	        head = newNode;//1
	        System.out.println("Contact added successfully!");//1
	        return;//1
	    }//0
		

	    findFirst();//1
	    while (!last() && ((Contact) newNode.data).compareTo(current.next.data) > 0) {//n -1 +1
	        findNext();//n-1
	    }//0

	    newNode.next = current.next;//1
	    current.next = newNode;//1
	    System.out.println("Contact added successfully!");//1
	}//0
	//Total: 16+2nk+9n  ,where n is the number of contacts,d is the length of Name, and f is the length of phoneNumber

	public void deleteEvent(String name) {//0
		if (empty()) {//1
			System.out.println("The event list is empty.");//1
			return;//1
		}//0

		Node<T> prev = null;//1
		findFirst();//1
		boolean deleted = false;//1
		while (!checkIfNull()) {//n+1 , where n is number of events
			if (((Event) current.data).getContact().getName().equalsIgnoreCase(name)) {// n(k+2)
				// Delete the event from the linked list
				if (prev == null) { //1
					// Deleting the first event
					head = current.next;//1
					
				} else {//c-1 , where c is the number of events that will be deleted
					
					// Deleting an event from the middle or end of the list
					prev.next = current.next;//c-1
				}
				deleted = true; //c
			} else {//n-c
				prev = current;//n-c
			}
			findNext();//n
		}

		if (deleted) {//1
			System.out.println("Events connected with '" + name + "' deleted successfully.");//1
		} else {//1
			System.out.println("Events connected with '" + name + "' not found in the event list.");//1
		}//0
	}//0
	//Total: 6+nk+6n+c       


	public boolean deleteContact(String name) {//0
		if (empty()) {//1
			System.out.println("Contact '" + name + "' not found in the contact list.");//1
			return false;//1
		}//0

		Node<T> prev = null;//1
		findFirst();//1
		while (!checkIfNull()) {//n+1 ,where n is number of contacts
			if (((Contact) current.data).getName().equalsIgnoreCase(name)) {//n(k+1) ,where k is length of Name
				if (prev == null) {//1
					// Deleting the first contact
					head = current.next;//1
				} else {//1
					// Deleting a contact from the middle or end of the list
					prev.next = current.next;//1
				}//0
				System.out.println("Contact '" + name + "' deleted successfully.");//1
				return true;//1
			}//0
			prev = current;//n
			findNext();//n
			

		}//0

		System.out.println("Contact '" + name + "' not found in the contact list.");//1
		return false;//1
	}
	//Total:6+4n+nk


	public void insertEventSorted(T event) {//0
	    Node<T> newNode = new Node<T>(event);//1

		if (empty() || ((Event) newNode.data).compareTo(head.data) < 0) {//2
	        newNode.next = head;//1
	        head = newNode;//1
	        System.out.println("Event added successfully!");//1
	        return;//1
	    }//0

	    findFirst();//1
	    while (!last() && ((Event) newNode.data).compareTo(current.next.data) > 0) {//n-1+1=n ,where n is number of events
	        findNext();//n-1
	    }//0

	    newNode.next = current.next;//1
	    current.next = newNode;//1
	    System.out.println("Event added successfully!");//1
		}//0
	//Total:6+2n


	public void printEventSorted() {//0
		findFirst();//1
		if (empty()) {//1
			System.out.println("There is no event.");//1
			return;//1
		}//0
		while (!checkIfNull()) {//n+1 ,where n is number of events
			System.out.println(current.data);//n
			findNext();//n
			System.out.println("=====================================================");//n
		}
	}
	//Total: 3+4n


	public void searchByCriteria(int criteria, String choiceDetails, boolean b) {//0
		if (empty()) {//1
			System.out.println("List is empty");//1
			return;//1
		}//0
		if (last()) {//1    
			if (criteria == 3) {//1
				if (((Contact) current.data).getEmailAddress().equalsIgnoreCase(choiceDetails))//d+1 , where d is length of email address
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 4) {//1
				if (((Contact) current.data).getAddress().equalsIgnoreCase(choiceDetails))//f+1 , where f is length of address
					System.out.println(((Contact) current.data));//1

			} else if (criteria == 5) {//1
				if (((Contact) current.data).getBirthday().equalsIgnoreCase(choiceDetails))//g+1, where g is length of Birthday
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 1) {//1
				if (((Contact) current.data).getName().equalsIgnoreCase(choiceDetails))//h+1, where h is length of Name
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 2) {//1
				if (((Contact) current.data).getPhoneNumber().equalsIgnoreCase(choiceDetails))//j+1, where j is length of PhoneNumber
					System.out.println(((Contact) current.data));//1
			}//0
			return;//1
		}//0
		if (b) {//1
			findFirst();//1

			if (criteria == 3) {//1
				if (((Contact) current.data).getEmailAddress().equalsIgnoreCase(choiceDetails))//d+1 , where d is length of email address
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 4) {//1
				if (((Contact) current.data).getAddress().equalsIgnoreCase(choiceDetails))//f+1 , where f is length of address
					System.out.println(((Contact) current.data));//1

			} else if (criteria == 5) {//1
				if (((Contact) current.data).getBirthday().equalsIgnoreCase(choiceDetails))//g+1, where g is length of Birthday
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 1) {//1
				if (((Contact) current.data).getName().equalsIgnoreCase(choiceDetails))//h+1, where h is length of Name
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 2) {//1
				if (((Contact) current.data).getPhoneNumber().equalsIgnoreCase(choiceDetails))//j+1, where j is length of PhoneNumber
					System.out.println(((Contact) current.data));//1
			}//0

			findNext();//1
			searchByCriteria(criteria, choiceDetails, false);//
		}//0

		else {//1
			if (criteria == 3) {//1
				if (((Contact) current.data).getEmailAddress().equalsIgnoreCase(choiceDetails))//d+1 , where d is length of email address
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 4) {//1
				if (((Contact) current.data).getAddress().equalsIgnoreCase(choiceDetails))//f+1 , where f is length of address
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 5) {//1
				if (((Contact) current.data).getBirthday().equalsIgnoreCase(choiceDetails))//g+1, where g is length of Birthday
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 1) {//1
				if (((Contact) current.data).getName().equalsIgnoreCase(choiceDetails))//h+1, where h is length of Name
					System.out.println(((Contact) current.data));//1
			} else if (criteria == 2) {//1
				if (((Contact) current.data).getPhoneNumber().equalsIgnoreCase(choiceDetails))//j+1, where j is length of PhoneNumber
					System.out.println(((Contact) current.data));//1
			}
			findNext();//1
			searchByCriteria(criteria, choiceDetails, false); //

		}//0
		return;//1
	}//0
	//Total: from email, NO need to count each line, so this method is Big O(n)


	public boolean searchEventConflict(String date) {//0
		findFirst();//1
		if (empty()) {//1
			return false;//1
		}
		while (!checkIfNull()) {//n+1    ,where n is number of contacts
			if (((Event) current.data).getDateTime().equalsIgnoreCase(date)) { //n(k+1)  , where k is length of DateTime
				return true;//1
			}//0
			findNext();//n
			
		}//0
		return false;//1
	}//0
	//Total:4+nk+3n


	public void searchByEventDetails(int criteria, String choiceDetails) {//0
		System.out.println("=====================================================");//1
		if (empty()) {//1
			System.out.println("No events found.");//1
			return;//1
		}//0
		findFirst();//1
		switch (criteria) {//1   
		case 1://1
			while (!checkIfNull()) {//n+1
				if (((Event) current.data).getContact().getName().equalsIgnoreCase(choiceDetails)) {// n(d+1) , where d is length of Name
					System.out.println(current.data);//n
				}
				findNext();//n
			}
			break;//1
		case 2://1
			while (!checkIfNull()) {//n+1
				if (((Event) current.data).getTitle().equalsIgnoreCase(choiceDetails)) {// n(f+1) , where f is length of Title
					System.out.println(current.data);//n
				}
				findNext();//n
			}
			break;
		default://1
			System.out.println("Invalid input! Please enter a valid choice.");//1

		}//0		
	}//0
	//Total:  it will be '7+nd+4n' or '7+nf+4n'    depending on values of d, and f


}//0