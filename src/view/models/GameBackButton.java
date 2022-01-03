package view.models;

public class GameBackButton extends GameButton {

	private final String STYLE = "-fx-background-color: transparent; -fx-background-image: url('/assets/backBtn.png')";
	
	public GameBackButton() {
		// setting length and width
		setPrefWidth(40);
		setPrefHeight(30);
		// setting style 
		setStyle(STYLE);
		// initializing listeners to implement styles for pressing and releasing
		initializeListeners();
	}

	@Override
	protected void setReleasedStyle() {
		setLayoutY(getLayoutY() - 4); 
	}

	@Override
	protected void setPressedStyle() {
		setLayoutY(getLayoutY() + 4); 
	}

	
	
}
