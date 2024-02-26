/*************Information***************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
15-10-2023


AUTHORS:
Abdulaziz Alsaleh 
****************************************/
public class Event implements Comparable {
	private String title, dateTime, location;
	private Contact contact;
    //Initializes a new Event object with the provided information.
	Event(String title, Contact contact, String dateTime, String location) {
		this.title = title;
		this.contact = contact;
		this.dateTime = dateTime;
		this.location = location;
		
	}
    //Retrieves the title of the event.
	public String getTitle() {
		return title;
	}
    //Sets the title of the event.
	public void setTitle(String title) {
		this.title = title;
	}
    //Retrieves the date and time of the event.
	public String getDateTime() {
		return dateTime;
	}
    //Sets the date and time of the event.
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
    //Retrieves the location of the event.
	public String getLocation() {
		return location;
	}
    //Sets the location of the event.
	public void setLocation(String location) {
		this.location = location;
	}
    //Retrieves the contact associated with the event.
	public Contact getContact() {
		return contact;
	}
    //Sets the contact associated with the event.
	public void setContact(Contact contact) {
		this.contact = contact;
	}
    //Returns a formatted string representation of the event.
	@Override   
	public String toString() {
		return "Event Title: " + title + "\nContact Name: " + contact.getName() + "\nDateTime: " + dateTime + "\nLocation: "	+ location;
	}
	//Compares two Event objects based on their titles in a case-insensitive manner and Returns a negative integer, zero, or a positive integer if the title of this event is less than, equal to, or greater than the title of the specified event, respectively
	@Override
	public int compareTo(Object event) {
		
		return this.title.compareToIgnoreCase(((Event) event).getTitle());
	}

}