package softEng1;
//class should be custom to accommodate the original CSV data
public class Gradebook {
	public String FirstName; 
    public String LastName; 
    public String Major;
    public String Gender;
    public String ID; 
    public String Grade;
    
    public static Gradebook FromCSV(String csvline)
    {
    	String[] values = csvline.split(",");
        Gradebook gradeValues = new Gradebook();
        //The values are the columns for each row
        gradeValues.FirstName = values[0];
        gradeValues.LastName = values[1];
        gradeValues.Major = values[2];
        gradeValues.Gender = values[3];
        gradeValues.ID = values[4];
        
    	return gradeValues;
    }
    


}
