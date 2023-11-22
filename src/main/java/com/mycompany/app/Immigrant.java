
public class Immigrant{

	private String firstName;
	private String lastName;
	private String alienID;
	private String status;
	private Immigrant searchedImmigrant;
	
	public Immigrant(String fN, String lN, String AID)
	{
		firstName = fN;
		lastName = lN;
		alienID = AID;
		status = "";
	}
	
	public Immigrant createImmigrant(String firstName, String lastName, String Anum)
	{
		searchedImmigrant = Database.getImmigrant(firstName, lastName, Anum);
		return searchedImmigrant;
	}
	
	public static Immigrant createImmigrant1(String Anum, String firstName, String lastName)
	{
		Immigrant searchedImmigrant1 = new Immigrant(firstName,lastName,Anum);
		if(searchedImmigrant1.validateInfo())
			searchedImmigrant1 = Database.getImmigrant(Anum,firstName, lastName);
		else
			return null;
		return searchedImmigrant1;
	}

	public boolean validateInfo()
	{
		return this.firstName != null && this.lastName != null && this.alienID != null;
		
		
	}
	
	public int compareTo(Immigrant o)
	{
		
		return this.firstName.compareTo(o.firstName);
	}	
	

	
	public boolean equals(Object o)
	{
		if (!(o instanceof Immigrant))
			return false;
		Immigrant c = (Immigrant) o;
		return this.firstName.equals(c.firstName) && this.lastName.equals(c.lastName) && this.alienID.equals(c.alienID);
	}
	public String getFirstName(){
		return this.firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public String getAlienID(){
		return this.alienID;
	}
	public String getStatus(){
		return this.status;
	}
	public void setFirstName(String fName){
		this.firstName = fName;
	}
	public void setLastName(String lName){
		this.lastName = lName;
	}
	public void setAlienID(String id){
		this.alienID = id;
	}
	//ToDo Finish calls
	public void setStatus(String s){
		status = s;
		//Call setImmigrant
		//Call setNext
		
	}

	public String toString()
	{
		return firstName + " " + lastName + " " + alienID;
	}

	public static void main(String[] args) {
		Immigrant a = new Immigrant("Long", "John", "123asdf");
		a.setFirstName("YOHOBO");
        System.out.println(a.getFirstName());
		System.out.println(a.getLastName());
		System.out.println(a.getAlienID());
    }
	
	
}
