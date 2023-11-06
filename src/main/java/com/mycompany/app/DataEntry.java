import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DataEntry {


	DataEntryScreen Screen;
	Immigrant currentImmigrant;
	
	public DataEntry()
	{
		Screen = new DataEntryScreen();
	}
	
	
	public static void main(String[] args)
	{
		
		//
		//Screen = new DataEntryScreen();
		
		
		DataEntry DE = new DataEntry();
		
		
		//DE.Screen.getInfo();
		
	}
	
	


	private class DataEntryScreen extends Frame{
		
		private Label label1;
		private TextField fName;
		private TextField lName;
		private TextField aNum;
		
		private Button getInfo;
		private Button submit;
		
		public DataEntryScreen()
		{
			setLayout(new FlowLayout());
			
			label1 = new Label("Test");
			
			fName = new TextField("FirstName");
			lName= new TextField("LastName");;
			aNum = new TextField("AlienNum");;
			
			getInfo = new Button("Get Record");
			submit = new Button("Submit");
			
			add(label1);
			
			add(fName);
			add(lName);
			add(aNum);
			
			add(getInfo);
			add(submit);
			
			
			buttonHandler listen = new buttonHandler();
			
			submit.addActionListener(listen);
			getInfo.addActionListener(listen);
			
			setSize(300, 100);
			setVisible(true);
			
			this.addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent e) {
			        dispose();
			    }
			});
		}
		
		//ToDo: set return
		public Object getInfo(String firstName, String lastName, String alienNum)
		{
			
			currentImmigrant = new Immigrant(firstName,lastName,alienNum);
			//ToDo: Add response to validate False
			currentImmigrant.validateInfo();
			
			
			return null;
		}
		
		//ToDo All of this redrawing the screen
		public void showScreen()
		{
			
			//draw
		}
		private class buttonHandler implements ActionListener {
		      // ActionEvent handler - Called back upon button-click.
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	if(evt.getSource().equals(getInfo))	    	
		        	getInfo(fName.getText(),lName.getText(),aNum.getText());
		        else if(evt.getSource().equals(submit))	    	
		        	currentImmigrant.setStatus("Test");
		  
		    	
		    	showScreen();
		      }
		}
	}

	
}
