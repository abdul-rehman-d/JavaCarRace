package view.models;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public abstract class GameButton extends Button {

	// this class is the abstract class for more specific buttons and it initializes listeners to implement styles for pressing and releasing
	
	protected abstract void setReleasedStyle();
	protected abstract void setPressedStyle();
	
	protected void initializeListeners() {
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
}
