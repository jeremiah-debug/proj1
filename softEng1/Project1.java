package softEng1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Project1 {

	static int i = 0;
	
	public static void main(String[] args) {
System.out.println("Retrieving csv file...");
        
		//Import and Export path for files
        String importPath = "C:/Users/Tron/Desktop/testGroup.csv";
        String exportPath = "C:/Users/Tron/Desktop/result.csv";
        
        //Creates the custom Gradebook class object to organize the read data
        Gradebook importDictionary = new Gradebook();
        
        String line = null;
        
        //Creates a reader for the CSV
        try (BufferedReader br = new BufferedReader(new FileReader(importPath))) 
        {
        	//Consumes the header line so the older headers don't show on the CSV
        	String headerLine = br.readLine();
        	
        	while ((line=br.readLine())!= null) {
        		
        		importDictionary= Gradebook.FromCSV(line);        		
        		saveCSV(importDictionary.FirstName, importDictionary.LastName, importDictionary.Gender, importDictionary.Major, importDictionary.ID, exportPath);
        		
        	}
        	
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FILE 'testGroup.csv' NOT FOUND! Please fix this and try again!");           
            System.exit(0);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        

   
        System.out.println("Program Complete");
        
    }

	//Method to save to the new CSV file. File needs to exist before hand...
	public static void saveCSV(String ID, String name, String age, String gender, String major, String filepath)
    {
		//Creates the writer for the CSV
    	try
    	{
    		FileWriter fw = new FileWriter(filepath,true);
    		BufferedWriter bw = new BufferedWriter(fw);
    		PrintWriter pw = new PrintWriter(bw);
    		if(i<1) 
    		{
    			System.out.println("Saving new csv file...");
    			
    			//Sets the new headers for the CSV
    			pw.println("FirstName,LastName,Major");
    			i++;
    		}
    		pw.println(ID+ ","+name+","+age);
    		pw.flush();
    		pw.close();
    	}
    	catch(Exception E)
    	{
    		System.out.println("File not saved");
    	}
    }

	
	
}
