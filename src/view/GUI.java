package view;

import game.MainGame;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;
import score.Score;
import view.models.GameMenuButton;
import view.models.GameSubScene;
import view.models.GameText;

public class GUI {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private AnchorPane menuPane;
	private Scene menuScene;
	private Stage menuStage;
	
	GameMenuButton startButton;
	GameMenuButton highScoreButton;
	GameMenuButton creditsButton;
	GameMenuButton exitButton;
	
	GameSubScene highScoreSubScene;
	GameText highScoreText;
	GameSubScene creditsSubScene;
	
	Score score;
	
	public GUI() {
		// Initializing screen
		menuPane = new AnchorPane();
		menuScene = new Scene(menuPane, WIDTH, HEIGHT);
		menuStage = new Stage();
		menuStage.setScene(menuScene);
		// creating background
		setMenuBackground();
		// adding icon, title
		menuStage.getIcons().add(new Image("/assets/logo.png"));
		menuStage.setResizable(false);
        menuStage.setTitle("Trails - A 2D Car Game");
        // playing intro animation
        
		// adding logo to menu
		Image logo = new Image("/assets/logo.png");
		ImageView logoView = new ImageView(logo);
		logoView.setLayoutX(285);
		logoView.setLayoutY(136);
		menuPane.getChildren().add(logoView);
		// creating menu buttons
		createMenuButtons();
		// adding all menu buttons to Stage
		addMenuButtons();
		// adding subscenes for buttons: high scores and credits
		score = new Score();
		creatHighScoreSubScene();
		createCreditsSubScene();
		playIntro();
		
	}

	private void playIntro() {
		ImageView intro = new ImageView(new Image("/assets/intro.png", WIDTH, HEIGHT, false, true));
		menuPane.getChildren().add(intro);
		TranslateTransition animation2 = new TranslateTransition(Duration.seconds(5), intro);
		animation2.setToY(HEIGHT);
		animation2.play();
	}

	public Stage getMainStage() {
		return menuStage;
	}
	
	private void setMenuBackground() {
		Image background = new Image("assets/background_menu.png", 800, 700, false, true);
		BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		menuPane.setBackground(new Background(backgroundImage));
	}
	
	private void createMenuButtons() {
		// initializing all the menu buttons and on click methods
		
		//start button
		startButton = new GameMenuButton("start");
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainGame game = new MainGame(menuStage);
			}
			
		});
		
		//high score button
		highScoreButton = new GameMenuButton("high score");
		highScoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				updateHighScore();
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
				menuStage.close();
			}
			
		});
	}
	
	private void addMenuButtons() {
		startButton.setLayoutX(305);
		startButton.setLayoutY(233);
		menuPane.getChildren().add(startButton);
		
		highScoreButton.setLayoutX(305);
		highScoreButton.setLayoutY(325);
		menuPane.getChildren().add(highScoreButton);
		
		creditsButton.setLayoutX(305);
		creditsButton.setLayoutY(418);
		menuPane.getChildren().add(creditsButton);
		
		exitButton.setLayoutX(305);
		exitButton.setLayoutY(511);
		menuPane.getChildren().add(exitButton);
	}
	
	private void creatHighScoreSubScene(){
		highScoreSubScene = new GameSubScene("HIGH SCORE");
	
		highScoreText  = new GameText();
		highScoreText.setText(score.getHighestScore());
		highScoreText.setLayoutX(240);
		highScoreText.setLayoutY(270);
		highScoreText.applyParagraphFont(48);
		highScoreSubScene.getPane().getChildren().add(highScoreText);
		menuPane.getChildren().add(highScoreSubScene);
	}
	
	private void updateHighScore(){
		highScoreText.setText("" + score.getHighestScore());
	}
	
	private void createCreditsSubScene() {
creditsSubScene = new GameSubScene("CREDITS");
		
		GameText name1 = new GameText(), name2 = new GameText(), des1 = new GameText(), des2 = new GameText();
		name1.setText("Abdul Rehman Daniyal");
		name1.setLayoutX(65);
		name1.setLayoutY(180);
		name1.applyParagraphFont(24);
		des1.setText("Developer & Designer");
		des1.setLayoutX(65);
		des1.setLayoutY(205);
		des1.applyParagraphFont(18);
		name2.setText("Muhammad Hamza Pervez");
		name2.setLayoutX(65);
		name2.setLayoutY(250);
		name2.applyParagraphFont(24);
		des2.setText("Developer");
		des2.setLayoutX(65);
		des2.setLayoutY(275);
		des2.applyParagraphFont(18);
		creditsSubScene.getPane().getChildren().add(name1);
		creditsSubScene.getPane().getChildren().add(des1);
		creditsSubScene.getPane().getChildren().add(name2);
		creditsSubScene.getPane().getChildren().add(des2);
		
		menuPane.getChildren().add(creditsSubScene);
	}
	
	
}
