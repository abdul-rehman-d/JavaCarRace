package view.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.text.Font;

public class GameMenuButton extends GameButton {
	
	private final String FONT_PATH = ".dependencies\\SpaceMissionFont.otf";
	private final String BUTTON_PRESSED = "-fx-background-color: transparent; -fx-background-image: url('/assets/btnPressed.png');";
	private final String BUTTON_RELEASED = "-fx-background-color: transparent; -fx-background-image: url('/assets/btnReleased.png');";
	
	public GameMenuButton(String text) {
		// setting text
		setText(text);
		// setting font
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
			}
		catch(FileNotFoundException e) {
				setFont(Font.font("Verdana",23));
			}
		// setting length and width
		setPrefWidth(190);
		setPrefHeight(49);
		// setting style 
		setStyle(BUTTON_RELEASED);
		// initializing listeners to implement styles for pressing and releasing
		initializeListeners();
	}

	@Override
	protected void setReleasedStyle() {
		setStyle(BUTTON_RELEASED);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4); 
	}

	@Override
	protected void setPressedStyle() {
		setStyle(BUTTON_PRESSED);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4); 
	}
	
}
