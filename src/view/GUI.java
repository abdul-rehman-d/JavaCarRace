package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class GUI {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	GameButton startButton;
	GameButton highScoreButton;
	GameButton creditsButton;
	GameButton exitButton;
	
	public GUI() {
		// Initializing screen
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		// creating background
		setMenuBackground();
		// adding logo
		Image logo = new Image("/assets/logo.png");
		ImageView logoView = new ImageView(logo);
		logoView.setLayoutX(285);
		logoView.setLayoutY(136);
		mainPane.getChildren().add(logoView);
		// creating menu buttons
		createMenuButtons();
		// adding all menu buttons to Stage
		addMenuButtons();
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	private void setMenuBackground() {
		Image background = new Image("assets/background_menu.png", 800, 700, false, true);
		BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(backgroundImage));
	}
	
	private void createMenuButtons() {
		// initializing all the menu buttons and on click methods
		
		//start button
		startButton = new GameButton("start");
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			}
			
		});
		
		//high score button
		highScoreButton = new GameButton("high score");
		highScoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			}
			
		});
				
		//credits button
		creditsButton = new GameButton("credits");
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			}
			
		});
				
		//exit button
		exitButton = new GameButton("exit");
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainStage.close();
			}
			
		});
	}
	
	private void addMenuButtons() {
		startButton.setLayoutX(305);
		startButton.setLayoutY(233);
		mainPane.getChildren().add(startButton);
		
		highScoreButton.setLayoutX(305);
		highScoreButton.setLayoutY(325);
		mainPane.getChildren().add(highScoreButton);
		
		creditsButton.setLayoutX(305);
		creditsButton.setLayoutY(418);
		mainPane.getChildren().add(creditsButton);
		
		exitButton.setLayoutX(305);
		exitButton.setLayoutY(511);
		mainPane.getChildren().add(exitButton);
	}
}
