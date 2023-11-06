import java.util.ArrayList;

class Database {

	public static ArrayList<Immigrant> ImmList = new ArrayList<Immigrant>();
	
	
	public static Immigrant getImmigrant(String aNum, String firstName, String lastName)
	{
		//Find Immigrant using this info in ImmList
		Immigrant searchedImmigrant = new Immigrant(firstName,lastName,aNum);
		if(!ImmList.contains(searchedImmigrant))
			return null;
		
		return ImmList.get(ImmList.indexOf(searchedImmigrant));
	}
	
	//ToDo
	public static boolean setImmigrant(Immigrant i)
	{
		if(ImmList.contains(i))
			ImmList.remove(i);
		ImmList.add(i);
		return true;
	}
}
