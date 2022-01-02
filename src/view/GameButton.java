package view;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class GameButton extends Button {
	
	private final String BUTTON_PRESSED = "-fx-background-color: transparent; -fx-background-image: url('/assets/longBtnPressed.png');";
	private final String BUTTON_RELEASED = "-fx-background-color: transparent; -fx-background-image: url('/assests/longBtnReleased.png');";
	
	public GameButton(String text) {
		// setting text
		setText(text);
		// setting font
		setFont(Font.font("Verdana",23));
		// setting length and width
		setPrefWidth(190);
		setPrefHeight(49);
		// setting style 
		setStyle(BUTTON_RELEASED);
		// initializing listeners to implement styles for pressing and releasing
		initializeListeners();
	}

	private void initializeListeners() {
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setPressedStyle();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setReleasedStyle();
				}
			}
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
			setEffect(new DropShadow());
			}
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
	}

	private void setReleasedStyle() {
		setStyle(BUTTON_RELEASED);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4); 
	}

	private void setPressedStyle() {
		setStyle(BUTTON_PRESSED);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4); 
	}
	
}
