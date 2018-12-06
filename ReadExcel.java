package Reader;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

import jxl.*;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/*
 * This class reads the excel sheet and returns a sorted map.
*/


public class ReadExcel {
	private String inputFile;
	
	//creates sister map
	public SortedMap<String, ArrayList<String>> Bsisters = new TreeMap<>();	

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    
    public SortedMap<String, ArrayList<String>> read() throws IOException  {
    	//inputFile = "/Users/natalieeichorn/Desktop/sisters.xls";
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            
            //set up for reading sheet
            Sheet sheet = w.getSheet(0);
            int col = sheet.getColumns();
            int row = sheet.getRows();
            
            //loops thru row
            for (int r = 0; r < row; r++) {
            	//gets top 3 little's
            	Cell cell1 = sheet.getCell(0, r);
            	Cell cell2 = sheet.getCell(1, r);
            	Cell cell3 = sheet.getCell(2, r);
            	Cell cell4 = sheet.getCell(3, r);

            	//name of sister
            	String sister = cell1.getContents().toUpperCase();
            	
            	//adds names of potential little's to array
            	ArrayList<String> wants = new ArrayList<String>();
            	
            	wants.add(cell2.getContents().toUpperCase());
            	wants.add(cell3.getContents().toUpperCase());
            	wants.add(cell4.getContents().toUpperCase());            	
            	
                //puts sister as key and the list as the value
                Bsisters.put(sister, wants);
            }
            
            System.out.println(Bsisters);
            
        } catch (BiffException e) {
            e.printStackTrace();
        }
        
        //returns TreeMap of Big's with the little's they want
        return Bsisters;
    }
    
    
    public static void main(String[] args) throws IOException {
        ReadExcel test = new ReadExcel();
        test.setInputFile("/Users/natalieeichorn/Desktop/sister.xls");
        test.read();
    }

}
