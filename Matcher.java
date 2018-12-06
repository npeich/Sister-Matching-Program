package Reader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

/*
 * This class figures out all the matches.
*/


public class Matcher {
	
	private SortedMap<String, ArrayList<String>> map;
	private ArrayList<String> holdToDelete = new ArrayList<String>();
	private boolean oneToOne = false;
	private String oneB = "";
	private String oneL = "";
			
	
	public Matcher() {
		
	}
	
	public void remover (SortedMap<String, ArrayList<String>> sister, SortedMap<String, ArrayList<String>> baby)
	{	
		System.out.println("\n");

		//iterating over values only
		for (String key : baby.keySet()) {
			
			//gets little's name and who they want
			String littleName = key.toUpperCase();
			ArrayList<String> wantForBig = baby.get(key);
			
			//System.out.println("\nMy name is " + littleName);
			//System.out.println("I want " + wantForBig + " as my big\n");
			
			
			//loop thru big's names that the little wants
			for (String bigName : wantForBig) {
				
				ArrayList<String> bigsListOfLittles = sister.get(bigName);
				
				//System.out.println(littleName + " wants " + bigName + " as their big.");
				
				
				//if the big does not want the little, remove the big from the little's list
				if (!bigsListOfLittles.contains(littleName)) {
					
					//System.out.println(littleName + " is not on " + bigName + "'s list. TAKE OUT OF LIST");
					
					holdToDelete.add(bigName);
					
					//System.out.println("\nNOT a match = " + holdToDelete);
				
				}
				
				//System.out.println("\nNOT a match = " + holdToDelete);
				if (bigsListOfLittles.contains(littleName)) {
					
					//preserves names of 1:1 matches
					if (bigsListOfLittles.indexOf(littleName) == 0 && wantForBig.indexOf(bigName) == 0) {
						oneToOne = true;
						oneB = bigName;
						oneL = littleName;
					}
					
					//System.out.println(bigName + " wants " + bigsListOfLittles + " to be my littles, so we have a match!!");				
					continue;
				}

			}
			
			
			//deletes non matches from little's list
			wantForBig.removeAll(holdToDelete);
			
			
			System.out.println("\n" + littleName + " can choose from = " + wantForBig);
			
			
			//this guarantees 1:1 (without taking away possibility for big to take twins
			if (oneToOne) {
				System.out.print(" *** ONE TO ONE MATCH! ***\n");
				System.out.print(oneL + "'s big is " + oneB + "!\n");
			}
			//alerts that there are no matches
			if (wantForBig.size() == 0) {
				System.out.println("look at spreadsheet for 4/5 choice\n");
			}
			else {
				System.out.println("");
			}
			
			
			//resets everything
			holdToDelete.clear();
			oneToOne = false;
		}
		
		//check for my sanity
		System.out.println("\n\nDONE");
		
	}
}
