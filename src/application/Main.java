package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.GUI;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			GUI gui = new GUI();
			primaryStage = gui.getMainStage();
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
