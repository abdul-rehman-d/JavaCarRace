package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUI {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	public GUI() {
		// Initializing screen
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		// creating background
		setMenuBackground();
		// creating menu buttons
		GameButton btn = new GameButton("START");
		btn.setLayoutX(WIDTH/2 - btn.getWidth());
		btn.setLayoutY(HEIGHT/2 - btn.getHeight());
		mainPane.getChildren().add(btn);
		
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void setMenuBackground() {
		// TODO Auto-generated method stub
		
	}
	
}
