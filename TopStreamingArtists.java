import java.io.*;

public class TopStreamingArtists {
	private Artist first;

	//no-arg constructor
	public TopStreamingArtists() {
		first=null;
	}

	//
	public boolean isEmpty() {
		return(first==null);
	}

	//inserts an object in the beginning 
	public void insertFirst(String s) {
		Artist a = new Artist(s);
		a.next=first;
		first=a;

	}

	//a method takes a string, creates and Artist object and inserts it into 
	//the linked list in alphabetical order
	public void insert(String s) // insert, in order
	{
		Artist newArt = new Artist(s); // make new Artist object
		Artist previous = null; // start at first
		Artist current = first;
		// until end of list,
		while (current != null && s.compareToIgnoreCase(current.name)>0)
		{ 
			previous = current;
			current = current.next; // go to next item
		}
		if(previous==null) // at beginning of list
			first = newArt; 
		else // not at beginning
			previous.next = newArt; 
		newArt.next = current; 
	} // end insert()


	//prints a list to the screen
	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Artist current = first; // start at beginning of list

		while(current != null) // until end of list,
		{
			current.displayArtist(); // print data
			current = current.next; // move to next link
		}
		System.out.println(" ");
	}
	

	//method prints out a list to the output file passed as a parameter
	public void displayList(PrintWriter file)
	{
		Artist current = first; // start at beginning of list

		while(current != null) // until end of list,
		{
			current.displayArtist(file); // print data
			current = current.next; // move to next link
		}

	}
}
