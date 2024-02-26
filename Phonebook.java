
/*************Information***************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
15-10-2023
TEAM:

AUTHORS:
Mohammed Aldosari - 443102427
Abdulaziz Alsaleh - 443106575
Abdulaziz Alkharji - 443102059

****************************************/
import java.util.Scanner;

public class Phonebook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//1
		LinkedList_ADT<Contact> MyContactsList = new LinkedList_ADT<Contact>();//1
		LinkedList_ADT<Event> MyEventsList = new LinkedList_ADT<Event>();//1

		System.out.println("Welcome to the Linked Tree Phonebook!");//1
		boolean is_run = true;//1

		while (is_run) {//n+1
			
			System.out.println("\n*************************************");
			System.out.println("\nPlease choose an option:");
			System.out.println("1.Add a contact");
			System.out.println("2.Search for a contact");
			System.out.println("3.Delete a contact");
			System.out.println("4.Schedule an event");
			System.out.println("5.Print event details");
			System.out.println("6.Print contact by first name");
			System.out.println("7.Print all events alphabetically");
			System.out.println("8.Exit");
			System.out.print("\nEnter your choice: ");
			int choice;
			try {
				choice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a valid choice.");
				scanner.nextLine(); // Clear the input buffer
				continue; // Skip to the next iteration of the loop
			}

			System.out.println();

			switch (choice) {

			case 1://Adding a contact.
				System.out.println("Enter contact details:");
				System.out.print("Name: ");
				String name = scanner.nextLine();
				System.out.print("Phone Number: ");
				String phoneNumber = scanner.nextLine();
				System.out.print("Email Address: ");
				String emailAddress = scanner.nextLine();
				System.out.print("Address: ");
				String address = scanner.nextLine();
				System.out.print("Birthday: ");
				String birthday = scanner.nextLine();
				System.out.print("Notes: ");
				String notes = scanner.nextLine();
				Contact contact = new Contact(name, phoneNumber, emailAddress, address, birthday, notes);
				MyContactsList.insertContactSorted(contact);

				break;

			case 2://Searching for a contact
				System.out.println("Enter search criteria: ");
				System.out.println("1. Name");
				System.out.println("2. PhoneNumber");
				System.out.println("3. Email Address");
				System.out.println("4. Address");
				System.out.println("5. Birthday");
				System.out.print("Enter your choice: ");
				int criteriaNumber;
				try {
					criteriaNumber = scanner.nextInt();
					scanner.nextLine();
				} catch (Exception e) {
					System.out.println("Invalid input! Please enter a valid choice.");
					scanner.nextLine(); // Clear the input buffer
					break;
				}
				System.out.print("Enter the information: ");
				String criteriaData = scanner.nextLine();
				MyContactsList.findFirst();
				MyContactsList.searchByCriteria(criteriaNumber, criteriaData, true);
				break;
			case 3://Deleting a contact.
				System.out.print("Enter the name of the contact you want to delete: ");
				String contactToBeDeleted = scanner.nextLine();
				if (MyContactsList.deleteContact(contactToBeDeleted)) {
					MyEventsList.deleteEvent(contactToBeDeleted);
				}
				break;

			case 4://Scheduling an event
				System.out.print("Enter event title: ");
				String eventTitle = scanner.nextLine();
				System.out.print("Enter contact name: ");
				String eventContactName = scanner.nextLine();

				if (MyContactsList.searchContactByName(eventContactName) != null) {
					Contact ContactEvent = MyContactsList.retrieve();
					System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
					String eventDayandTime = scanner.nextLine();
					if (MyEventsList.searchEventConflict(eventDayandTime)) {
						System.out.println("You already have an event on this date.");
						break;
					}
					System.out.print("Enter event location: ");
					String eventLocation = scanner.nextLine();
					Event newEvent = new Event(eventTitle, ContactEvent, eventDayandTime, eventLocation);
					MyEventsList.insertEventSorted(newEvent);
					System.out.println("Event added successfully!\n\n");
					break;
				} else {
					System.out.println("Contact Not Found!");
					break;
				}

			case 5://Printing event details base on the criteria
				System.out.println("Enter search criteria: ");
				System.out.println("1. Contact Name");
				System.out.println("2. Event Title");
				System.out.print("Enter your choice: ");
				int noDetail;
				try {
					noDetail = scanner.nextInt();
					scanner.nextLine();
				} catch (Exception e) {
					System.out.println("Invalid input! Please enter a valid choice.");
					scanner.nextLine(); // Clear the input buffer
					break;
				}
				System.out.print("Enter the details: ");
				String details = scanner.nextLine();
				MyEventsList.searchByEventDetails(noDetail, details);
				break;

			case 6://Printing contacts by first name
				LinkedList_ADT<Contact> MatchingContacts = new LinkedList_ADT<Contact>();
				System.out.print("Enter first name: ");
				String firstName = scanner.nextLine();
				MyContactsList.findFirst();
				while (!MyContactsList.checkIfNull()) {
					// Extract the first name from the contact full name
					String contactFirstName = MyContactsList.retrieve().getName().split(" ")[0];

					if (contactFirstName.equalsIgnoreCase(firstName)) {
						Contact matchedContact = MyContactsList.retrieve();
						MatchingContacts.insertContactSorted(matchedContact);
					}
					MyContactsList.findNext();
				}

				
				if (MatchingContacts.empty()) {
					System.out.println("No contacts with the given first name found.");
				} else {
					MatchingContacts.findFirst();
					while (!MatchingContacts.checkIfNull()) {
						System.out.println(MatchingContacts.retrieve());
						System.out.println("=====================================================\n");
						MatchingContacts.findNext();
					}
				}
				break;
			case 7://Printing all events alphabetically
				MyEventsList.printEventSorted();

				break;

			case 8://Exiting the program
				System.out.println("Goodbye!");
				is_run = false;
				break;

			default://If the user enters an invalid choice, an error message is displayed
				System.out.println("Invalid input! Out of Range");
				break;
			}
		}
	}

}