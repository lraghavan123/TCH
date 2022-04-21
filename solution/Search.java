package solution;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public final class Search {

	private static final List<Bank> banks = new ArrayList<>();	

	public static void main(String[] args){

		loadBanksFromFile();
		System.out.println("\nBank details have been loaded.\n");
		
		Integer searchType = null;
		while(null == searchType){
			searchType = getSearchType();
			if (null != searchType){
				break;
			}
		}
		
		String searchValue = null;
		while(null == searchValue){
			searchValue = getSearchValue(searchType);
			if (null != searchValue){
				break;
			}
		}

		searchBanks(searchType , searchValue );
		System.out.println("\nThank you!");
	}

	private static Integer getSearchType(){
		System.out.println("Enter a number to search banks by options.");
 		System.out.println("Type 1 for ID OR 2 for Name OR 3 for Type OR 4 for City OR 5 for State OR 6 for Zip");
		Scanner s = new Scanner(System.in);
		Integer searchType = null;
		if (s.hasNextLine()){
			try {
				searchType = new Integer(s.nextLine());
			}catch(Exception e){  return null;  }
			if (searchType < 1 || searchType > 6){
				searchType = null;
			}
		}
		return searchType;
	}

	private static String getSearchValue(Integer type){
		System.out.println("Enter a value to search");
		Scanner s = new Scanner(System.in);
		String searchValue = null;
		if (s.hasNextLine()){
			try {
				searchValue = new String(s.nextLine());
				if (type == 1 || type == 6){
				   try{ long someLong = Long.parseLong(searchValue);
				   }catch(Exception e){ System.out.println("Enter a valid number");  return null; }
				}
			}catch(Exception e){  return null;  }
		}
		return searchValue;
	}

	private static void searchBanks(Integer type, String value){
		
		List<Bank> exactMatches = new ArrayList<>();
		List<Bank> partialMatches = new ArrayList<>();
		for (Bank b : banks){
		   switch (type) {
			case 1: {
				int searchValue = Integer.parseInt(value);
				if ( b.getId() == searchValue){  exactMatches.add(b);	}
				break;
			}
			case 2: {
				if ( b.getName().toLowerCase().equals(value.toLowerCase()) ){  exactMatches.add(b);	}
				else if ( b.getName().toLowerCase().contains(value.toLowerCase()) ){  partialMatches.add(b);	}
				break;
			}
			case 3: {
				if ( b.getType().toLowerCase().equals(value.toLowerCase()) ){  exactMatches.add(b);	}
				else if ( b.getType().toLowerCase().contains(value.toLowerCase()) ){  partialMatches.add(b);	}
				break;
			}
			case 4: {
				if ( b.getCity().toLowerCase().equals(value.toLowerCase()) ){  exactMatches.add(b);	}
				else if ( b.getCity().toLowerCase().contains(value.toLowerCase()) ){  partialMatches.add(b);	}
				break;
			}
			case 5: {
				if ( b.getCity().toLowerCase().equals(value.toLowerCase()) ){  exactMatches.add(b);	}
				break;
			}
			case 6: {
				long searchValue = Long.parseLong(value);
				if ( b.getZip() == searchValue){  exactMatches.add(b);	}
				break;
			}
		   }
		}//end-for

		if ( !exactMatches.isEmpty() ){
		   System.out.println("Exact case-insensitive matches: " );
		   printResultHeader();
		   for (Bank b : exactMatches){
			printResult(b);
		   }
		}
		if ( !partialMatches.isEmpty() ){
		   System.out.println("Partial case-insensitive matches: " );
		   printResultHeader();
		   for (Bank b : partialMatches){
			printResult(b);
		   }
		}
		if (exactMatches.isEmpty() && partialMatches.isEmpty()){
		   System.out.println("No banks found matching the search criteria." );
		}
	}

	private static void printResultHeader(){
		System.out.println("ID\tName\t\t\tType\tCity\t\tState\tZip");
		for (int i = 0; i < 78; i++) {
        		System.out.print("-");
		}
		System.out.println("");
	}

	private static void printResult(Bank b){
		System.out.println(b.getId() + "\t" + b.getName() + 
					( b.getName().length() > 13 ? "\t" : "\t\t" ) + 
					b.getType() + "\t" + 
					b.getCity() + ( b.getCity().length() > 7 ? "\t" : "\t\t" ) + 
					b.getState() + "\t" + b.getZip());
	}


	private static void loadBanksFromFile(){

	   try(Scanner lineScanner = new Scanner(new File("ProgrammingAssignment.csv"))){

		//Read line
		boolean isHeaderLine = true;
  		while (lineScanner.hasNextLine()) {
    			String line = lineScanner.nextLine();
			if (isHeaderLine) {
				isHeaderLine = false;  //toggle to ignore first line
				continue;
			}
			
			Bank b = new Bank();

    			//Scan the line for tokens
    			try (Scanner columnScanner = new Scanner(line)) {
      			columnScanner.useDelimiter(",");
			int col=0;
      			while (columnScanner.hasNext()) {
				switch (col) {
				   case 0: b.setId(Integer.parseInt(columnScanner.next())); break;
				   case 1: b.setName(columnScanner.next()); break;
				   case 2: b.setType(columnScanner.next()); break;
				   case 3: b.setCity(columnScanner.next()); break;
				   case 4: b.setState(columnScanner.next()); break;
				   case 5: b.setZip(Long.parseLong(columnScanner.next())); break;
				}
        			col++;
      			}
			banks.add(b);
    		}
  	   }
	   } catch (FileNotFoundException e) {
  		e.printStackTrace();
	   }
	}

}