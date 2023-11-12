import java.util.ArrayList;

public class WorkflowTable {
	
	
    public static ArrayList<Immigrant> wft= new ArrayList<>();;

	private WorkflowTable(){
	}


    // Immigrant i - The Immigrant record to store in the queue
    // return an integer ID for the immigrant.
    public static int setNext(Immigrant immigrant) {
        wft.add(immigrant);
        return wft.indexOf(immigrant);
    }

    // Peek at the queue
    // return The Immigrant at the front of the queue.
    public static Immigrant getFirst() {
        if (!wft.isEmpty()) {
            return wft.get(0);
        } else {
            return null;
        }
    }

    // Pop the queue
    // return the Immigrant that was removed from the queue
    public static Immigrant removeFirst() {
        if (!wft.isEmpty()) {
            // Remove the first immigrant and return it
            return wft.remove(0);
        } else {
            return null;
        }
    }
}

