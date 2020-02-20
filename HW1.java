import java.io.*;
import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//open the csv file with the chart
		File myFile = new File("regional-global-weekly-latest.csv");
		
		//create a scanner object to read from file
		Scanner sc = new Scanner(myFile);
		
		//create an output file for artists and number of appearances on the list
		PrintWriter outFile = new PrintWriter("artists_appearances.txt");
		//create another file for sorted list of artists
		PrintWriter outFile_1 = new PrintWriter("sorted_output.txt");
		
		//skip the first line in the file
		String line = sc.nextLine();
		line = sc.nextLine();

		//create a 2-D array to store artists and the number of appearances on the list
		String[][] list = new String[200][2];
		
		int i =0;

		//read the info into the array
		while (sc.hasNext()) {
			line = sc.nextLine();
			String[] tokens = line.split(","); 
			//delete all quotation marks from the artists' names
			String artist =tokens[2].replaceAll("\"", "");
			
			boolean flag = false;
			
			for (int j=0; j<i; j++) {
				//if the artist already appears on the list increment the 
				//number of appearances 
				if (artist.equals(list[j][0])) {
					int number =Integer.parseInt(list[j][1]);
					number++;
					list[j][1]= Integer.toString(number);
					flag = true;
					break;
				}

			}
			//artist appears for the first time
			if (flag==false) {
				list[i][0]=artist;//adds into the array
				list[i][1]="1";//sets number of appearances to 1
				i++;
			}
		}


		//print out the data from the array to the first output file 
		outFile.println("Artist              # of appearances");
		outFile.println("------------------------------------");
		for (int count=0; count<200 && !(list[count][0]==null); count++) {
			outFile.printf("%-20s %2s\n", list[count][0],list[count][1]);  
		}


		//close the output file
		outFile.close();


		//create a linked list of Artist objects
		TopStreamingArtists artistNames = new TopStreamingArtists();



		/*use the data from the array and insert it into the linked list. 
		 The method insert from the TopStreamingArtists sorts the inserted 
		 files in alphabetical order */
		for (int k=0; list[k][0]!=null; k++) {
			artistNames.insert(list[k][0]);
		}


		//print the sorted list of artists to the second output file
		outFile_1.println("Artists in alphabetical order: ");
		outFile_1.println("------------------------------");
		artistNames.displayList(outFile_1);
		
		
		//close the output file
		outFile_1.close();

	}

}
