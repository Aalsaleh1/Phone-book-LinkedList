/*************Information***************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
15-10-2023


AUTHORS:
Abdulaziz Alsaleh 
****************************************/
public class Contact implements Comparable {
	  private String name, phoneNumber, emailAddress, address, birthday, notes;
	  //Initializes a new Contact object with the provided information.
	    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.emailAddress = emailAddress;
	        this.address = address;
	        this.birthday = birthday;
	        this.notes = notes;
	    }
	    
		//Retrieves the name of the contact
	    public String getName() {
			return name;
		}

		//Sets the name of the contact
		public void setName(String name) {
			this.name = name;
		}

		//Retrieves the phone number of the contact
		public String getPhoneNumber() {
			return phoneNumber;
		}

		//Sets the phone number of the contact
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		//Retrieves the email address of the contact
		public String getEmailAddress() {
			return emailAddress;
		}

		//Sets the email address of the contact
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		//Retrieves the address of the contact
		public String getAddress() {
			return address;
		}

		//Sets the address of the contact
		public void setAddress(String address) {
			this.address = address;
		}

		//Retrieves the birthday of the contact
		public String getBirthday() {
			return birthday;
		}

		//Sets the birthday of the contact
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		//Retrieves the notes associated with the contact
		public String getNotes() {
			return notes;
		}

		//Sets the notes associated with the contact
		public void setNotes(String notes) {
			this.notes = notes;
		}

		//Compares two Contact objects based on their names in a case-insensitive manner and returns a formatted string representation of the contact
	    @Override
	    public String toString() {
	        return "Name: " + name +"\nPhone Number: " + phoneNumber +"\nEmail Address: " + emailAddress +"\nAddress: " + address +"\nBirthday: " + birthday +"\nNotes: " + notes;
	    }

		// Returns a negative integer, zero, or a positive integer if the name of this contact is less than, equal to, or greater than the name of the specified contact, respectively
		@Override
		public int compareTo(Object contact) {
			return this.name.compareToIgnoreCase(((Contact) contact).getName());		
		}

		
		}




	