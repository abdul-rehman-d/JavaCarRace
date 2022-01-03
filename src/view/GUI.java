package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	GameMenuButton startButton;
	GameMenuButton highScoreButton;
	GameMenuButton creditsButton;
	GameMenuButton exitButton;
	
	GameSubScene highScoreSubScene;
	GameSubScene creditsSubScene;
	
	public GUI() {
		// Initializing screen
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		// creating background
		setMenuBackground();
		// adding icon, title
		mainStage.getIcons().add(new Image("/assets/logo.png"));
		mainStage.setResizable(false);
        mainStage.setTitle("Trails - a 2d car game");
		// adding logo to menu
		Image logo = new Image("/assets/logo.png");
		ImageView logoView = new ImageView(logo);
		logoView.setLayoutX(285);
		logoView.setLayoutY(136);
		mainPane.getChildren().add(logoView);
		// creating menu buttons
		createMenuButtons();
		// adding all menu buttons to Stage
		addMenuButtons();
		// adding subscenes for buttons: high scores and credits
		creatHighScoreSubScene();
		createCreditsSubScene();
		
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	private void setMenuBackground() {
		Image background = new Image("assets/background_menu.png", 800, 700, false, true);
		BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(backgroundImage));
	}
	
	private void applyFont(Text text, int size) {
		try {
			text.setFont(Font.loadFont(new FileInputStream("src/assets/BigSpace.ttf"), size));
			}
		catch(FileNotFoundException e) {
				text.setFont(Font.font("Verdana",size));
			}
	}
	
	private void createMenuButtons() {
		// initializing all the menu buttons and on click methods
		
		//start button
		startButton = new GameMenuButton("start");
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			}
			
		});
		
		//high score button
		highScoreButton = new GameMenuButton("high score");
		highScoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				highScoreSubScene.moveScene();
			}
			
		});
				
		//credits button
		creditsButton = new GameMenuButton("credits");
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				creditsSubScene.moveScene();
			}
			
		});
				
		//exit button
		exitButton = new GameMenuButton("exit");
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
	
	private void creatHighScoreSubScene(){
		highScoreSubScene = new GameSubScene("HIGH SCORE");
		mainPane.getChildren().add(highScoreSubScene);
	}
	private void createCreditsSubScene() {
creditsSubScene = new GameSubScene("CREDITS");
		
		Text name1 = new Text(), name2 = new Text(), des1 = new Text(), des2 = new Text();
		name1.setText("Abdul Rehman Daniyal");
		name1.setLayoutX(65);
		name1.setLayoutY(180);
		applyFont(name1, 24);
		des1.setText("Developer & Designer");
		des1.setLayoutX(65);
		des1.setLayoutY(205);
		applyFont(des1, 18);
		name2.setText("Muhammad Hamza Pervez");
		name2.setLayoutX(65);
		name2.setLayoutY(250);
		applyFont(name2, 24);
		des2.setText("Developer");
		des2.setLayoutX(65);
		des2.setLayoutY(275);
		applyFont(des2, 18);
		creditsSubScene.getPane().getChildren().add(name1);
		creditsSubScene.getPane().getChildren().add(des1);
		creditsSubScene.getPane().getChildren().add(name2);
		creditsSubScene.getPane().getChildren().add(des2);
		
		mainPane.getChildren().add(creditsSubScene);
	}
	
	
}
