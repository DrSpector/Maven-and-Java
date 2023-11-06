import java.util.Scanner;
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
public class Driver extends Application
{

    @Override
    public void start(Stage stage) {

	Scene scene = new Scene(new Group(), 60, 70);
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(5);
	grid.setHgap(5);

	Button DE = new Button("DE");
	GridPane.setConstraints(DE, 0, 0);
	grid.getChildren().add(DE);

	DE.setOnAction(new EventHandler<ActionEvent>() {
       		@Override
        	public void handle(ActionEvent event) {
			Stage DEStage = new Stage();
			DEScreen DE = new DEScreen();
			DE.start(DEStage);
			DEStage.show();

		}
	});

	Button Review = new Button("Review");
	GridPane.setConstraints(Review, 0, 1);
	grid.getChildren().add(Review);
	
	Review.setOnAction(new EventHandler<ActionEvent>() {
       		@Override
        	public void handle(ActionEvent event) {
			Stage ReviewStage = new Stage();
			Review reviewer = new Review();
			reviewer.start(ReviewStage);
			ReviewStage.show();

		}
	});



	Group root = (Group) scene.getRoot();
   	root.getChildren().add(grid);

        stage.setScene(scene);
        stage.show();


    }

    public static void main( String[] args )
    {
	Scanner keyboard = new Scanner(System.in);
	
	Database database = new Database();
	database.setImmigrant(new Immigrant("Jon","Smith","A1245"));
	database.setImmigrant(new Immigrant("Ron","Smith","A1246"));
	database.setImmigrant(new Immigrant("Bon","Smith","A1247"));
	database.setImmigrant(new Immigrant("Hon","Smith","A1248"));

//      int input = keyboard.nextInt();
//	if(input == 0)
//		DEScreen.main();
//	else if(input == 1)
//		RScreen.main(null);
	launch();
    }
}