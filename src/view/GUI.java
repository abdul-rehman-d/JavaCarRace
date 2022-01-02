package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class GUI {

	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	public GUI() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		
		mainStage.setScene(mainScene);
		mainScene.setFill(new LinearGradient
				(
		        0, 0, 1, 1, true,
		        CycleMethod.NO_CYCLE,
		        new Stop(0, Color.web("#81c483")),
		        new Stop(1, Color.web("#fcc200"))
		        )
		);
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
}
