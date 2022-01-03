package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameSubScene extends SubScene {

	private final String PATH = "/assets/panel.png";
	private boolean isHidden;
	GameBackButton backButton;
	private final String FONT_PATH = "src/assets/SpaceMissionFont.otf";
	
	public GameSubScene(String text) {
		super(new AnchorPane(), 500, 500);
		prefWidth(500);
		prefHeight(500);
		BackgroundImage backgroundImage = new BackgroundImage(new Image(PATH, 500, 500, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root = (AnchorPane) this.getRoot();
		root.setBackground(new Background(backgroundImage));
		setLayoutX(800);
		setLayoutY(100);
		isHidden = true;
		
		backButton = new GameBackButton();
		backButton.setLayoutX(45);
		backButton.setLayoutY(65);
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				moveScene();
			}
			
		});
		root.getChildren().add(backButton);
		
		Text title = new Text();
		title.setText(text);
		try {
			title.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 48));
			}
		catch(FileNotFoundException e) {
				title.setFont(Font.font("Verdana",48));
			}
		title.setLayoutX(120);
		title.setLayoutY(100);
		root.getChildren().add(title);
		
	}
	
	public void moveScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		transition.setToX(-650);
		if (isHidden) {
			transition.setToX(-650);
			isHidden = false;
		} else {
			transition.setToX(650);
			isHidden = true;
		}
		transition.play();
	}
	
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
}
