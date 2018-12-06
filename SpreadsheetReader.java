package Reader;

import java.io.IOException;
import java.util.Scanner;

/*
 * This program runs through 2 excel sheets of sister data to assign big little matches.
*/


public class SpreadsheetReader {

	public static void main(String[] args) throws IOException {
		
		// /Users/natalieeichorn/Desktop/sister.xls
		// /Users/natalieeichorn/Desktop/babies.xls
		
		ReadExcel sis = new ReadExcel();
		ReadExcel baby = new ReadExcel();
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter sisters list file name : ");
		String SfileName = keyboard.nextLine();	
		sis.setInputFile(SfileName);
	    System.out.print("This is the list of Sisters : ");
	    sis.read();

	    System.out.println("");

	    System.out.print("Enter babies list file name : ");
	    String BfileName = keyboard.nextLine();
	    baby.setInputFile(BfileName);
	    System.out.print("This is the list of Babies : ");
	    baby.read();
	    
	    System.out.println("");
	    
	    Matcher m = new Matcher();
	    m.remover(sis.read(), baby.read());
	}
}

