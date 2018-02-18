package rz.ciklum.domain;

/**
 * Class for Ciklum users
 */

public class UsersCiklum {
	
    private String FirstName; 
    private String LastName;  
    
    
    public UsersCiklum(String firstName, String lastName) {
    	this.FirstName = firstName;
    	this.LastName = lastName;
    }

    public UsersCiklum() {
    	
    }
    
    public String getFirstname(){
    	return FirstName;
    }
    
    public void setFirstname(String firstName){
    	this.FirstName = firstName;
    }
    
    public String getLastName(){
    	return LastName;
    }
    
    public void setLastName(String lastName){
    	this.LastName = lastName;
    }

}
