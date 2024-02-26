/*************Information***************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
15-10-2023


AUTHORS:
Abdulaziz Alsaleh 
****************************************/
public interface List<T> {
	public void findFirst( );
	public void findNext( );
	public T retrieve( );
	public void update(T t);
	public boolean full( );
	public boolean empty( );
	public boolean last();


}