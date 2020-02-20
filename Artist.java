import java.io.*;
public class Artist {

	//fields of type protected, so can be accessed by the TopStreamingArtists class
	protected String name;
	protected Artist next;
	
	//constructor
	public Artist(String s, Artist a) {
		name=s;
		next=a;
	}
	
	//constructor
	public Artist(String s) {
		name=s;
		next=null;
	}
	
	public void displayArtist() // display the artist's name
	{ System.out.println(name); }
	
	//print out the artist's name to the file
	public void displayArtist(PrintWriter file) // display this link
	{ file.println(name); }
}
