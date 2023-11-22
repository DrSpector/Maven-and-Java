import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class RScreen extends Application {

    TextField nameInput;
    TextField idInput;
    TextField statusInput;

    @Override
    public void start(Stage stage) {

	Scene scene = new Scene(new Group(), 450, 250);

	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(5);
	grid.setHgap(5);
   
	Label aIDLabel1 = new Label("sadf");
	Label nameLabel1 = new Label("Nasdfasdf");
	Label aIDLabel2 = new Label("sasddsaf");
	Label nameLabel2 = new Label("Name");
	Label statusLabel = new Label("Status");

	idInput = new TextField();
	idInput.setPrefColumnCount(10);

	nameInput = new TextField();
	nameInput.setPrefColumnCount(20);

	statusInput = new TextField();
	statusInput.setPrefColumnCount(10);

	grid.add(aIDLabel1, 0, 0);
	grid.add(idInput,1,0);

	grid.add(nameLabel1, 0, 1);
	grid.add(nameInput,1,1);

	Button search = new Button("Search");
	GridPane.setConstraints(search, 2, 1);
	grid.getChildren().add(search);

	search.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
		System.out.println(nameInput.getText());
                getInfo(idInput.getText(),nameInput.getText());
            }
	});


	grid.add(aIDLabel2, 0, 3);
	grid.add(nameLabel2, 0, 4);
	grid.add(statusLabel, 0, 5);
	grid.add(statusInput,1,5);

	

	Button submit = new Button("Submit");
	GridPane.setConstraints(submit, 0, 6);
	grid.getChildren().add(submit);

	Group root = (Group) scene.getRoot();
   	root.getChildren().add(grid);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    protected String[] getInfo(String aID, String name)
    {
	System.out.println("A:" + aID + " Name:" + name);
	return null;
    }
}