//package org.openjfx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import javafx.scene.control.Button;

public class Review extends Application {
    private Label firstLabel;
    private Label lastLabel;
    private Label alienLabel;
    private Label statusLabel;

    private Stage editStage;
    private Immigrant currentImmigrant;
    
    
    public boolean supplementCheck() {
        // Method to perform a validation check on the immigrant data
        // Implement the validation logic here
        if(currentImmigrant ==null)
        {return false;}
        return currentImmigrant.getFirstName().length() != 0 && currentImmigrant.getLastName().length() != 0 && currentImmigrant.getAlienID().length() != 0;
            

    }
    public boolean allValid() {

        boolean flag = true;
		if (currentImmigrant == null){
			return false;
		}
        if (currentImmigrant.getStatus() == null){
            flag = false;
        }

        if(currentImmigrant.getStatus().length() == 0){
            flag = false;
        }

        return flag;
            
    }

    // Method to edit the name
    private void edit() {
        TextField firstField = new TextField(firstLabel.getText().substring(12));

        TextField lastField = new TextField(lastLabel.getText().substring(11));

        TextField statusField = new TextField(statusLabel.getText().substring(8));
        
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            currentImmigrant.setFirstName(firstField.getText());
            currentImmigrant.setLastName(lastField.getText());
            if(statusField.getText() == "null" || statusField.getText() == ""){

                currentImmigrant.setStatus("");
            }
            else{
                currentImmigrant.setStatus(statusField.getText());
            }
            firstLabel.setText("First Name: " + firstField.getText());
            lastLabel.setText("Last Name: " + lastField.getText());
            statusLabel.setText("Status: " + currentImmigrant.getStatus());

            editStage.close();
        });

        VBox editNameBox = new VBox(firstField,lastField, statusField, saveButton);

        Scene editScene = new Scene(editNameBox, 300, 100);

        editStage = new Stage();
        editStage.setScene(editScene);
        editStage.show();
        
    }
    @Override
    public void start(Stage stage) {
 
        alienLabel = new Label("Alien ID: ");
        firstLabel = new Label("First Name: ");
        lastLabel = new Label("Last Name: ");
        statusLabel = new Label("Status: ");
        Label messageLabel = new Label("");

        
        // Set the font size for the labels
        alienLabel.setFont(Font.font(30));
        firstLabel.setFont(Font.font(30));
        lastLabel.setFont(Font.font(30));
        statusLabel.setFont(Font.font(30));


        messageLabel.setFont(Font.font(40));
        
        // Create a Button
        Button check = new Button("Check");
        Button edit = new Button("Edit");
        Button valid = new Button("Valid");
        Button next = new Button("Next");
        Button submit = new Button("Submit");

        check.setOnAction(e -> {
            // Code to be executed when the "Check" button is clicked
            if(supplementCheck()){
                messageLabel.setText("PASSED");
                System.out.println(currentImmigrant.getFirstName().length());
                System.out.println(currentImmigrant.getLastName());
            }
            else{
                messageLabel.setText("ERROR");
            }
            
        });

        valid.setOnAction(e -> {
            // Code to be executed when the "Check" button is clicked
            if(allValid()){
                messageLabel.setText("PASSED");
            }
            else{
                messageLabel.setText("ERROR: CANT FIND STATUS");
            }
            
        });

        edit.setOnAction(e -> {
        
        	if(currentImmigrant == null){
        		messageLabel.setText("ERROR: NO IMMIGRANT PRESENT");
        	}
        	else {
        		edit();
        	}
        
        });
        
        next.setOnAction(e -> {
            currentImmigrant = WorkflowTable.getFirst();
            if(currentImmigrant == null){
            	alienLabel.setText("Alien ID: ");
				firstLabel.setText("First Name: ");
				lastLabel.setText("Last Name: ");
				statusLabel.setText("Status: ");
            	messageLabel.setText("ERORR: NO IMMIGRANT PRESENT");
            	
            }
            else{
				alienLabel.setText("Alien ID: " + currentImmigrant.getAlienID());
				firstLabel.setText("First Name: " + currentImmigrant.getFirstName());
				lastLabel.setText("Last Name: " + currentImmigrant.getLastName());
				statusLabel.setText("Status: " + currentImmigrant.getStatus());
				messageLabel.setText("");
			}
        });
        
        submit.setOnAction(e ->{
        	if(currentImmigrant != null){
				if(!currentImmigrant.getStatus().equals("")){
					currentImmigrant = WorkflowTable.removeFirst();
					messageLabel.setText("IMMIGRANT SUBMITTED");
				}
				else{
					messageLabel.setText("INVALID STATUS");
				}
        	}        
        	
        });
        
		
		
        HBox hbox = new HBox();
        hbox.getChildren().addAll(check, valid, edit, submit, next);
        
        // Create an VBox to hold the labels
        VBox vbox = new VBox();
        vbox.getChildren().addAll(alienLabel,firstLabel, lastLabel, statusLabel, hbox, messageLabel);
        
		
        Scene var = new Scene(vbox, 600, 250);

        stage.setScene(var);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
