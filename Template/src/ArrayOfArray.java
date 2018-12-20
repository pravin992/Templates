// https://stackoverflow.com/questions/3642205/java-arraylist-of-arrays
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayOfArray {

	public static void main(String[] args) {
		
		//Declaration of an ArrayList of String Arrays
		 ArrayList<String[]> ArrOfArr = new ArrayList<String[]>();
		 
		 
		  //Assignment of 4 different String Arrays with different lengths
		 ArrOfArr.add( new String[]{"line1: 10","line1: 20","line1: 30"}  );
		 ArrOfArr.add( new String[]{"line2: 100"}  );
	     ArrOfArr.add( new String[]{"line3: 77","line3: 88","line3:99", "line3: 66"}  );
	     ArrOfArr.add( new String[]{"line4: 40","line4: 50"}  );
		 
	     // Printing out the ArrayList Contents of String Arrays
		
	        for( int i = 0; i < ArrOfArr.size(); i++ ) 
	        {
	            for( int j = 0; j < ArrOfArr.get(i).length; j++ )
	                System.out.printf(" " + ArrOfArr.get(i)[j]);

	            System.out.println();
	        }
		        
		    }
		}
	


