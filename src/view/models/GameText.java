package view.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameText extends Text {

	public void applyParagraphFont(int size) {
		try {
			setFont(Font.loadFont(new FileInputStream("src/assets/BigSpace.ttf"), size));
			}
		catch(FileNotFoundException e) {
				setFont(Font.font("Verdana",size));
			}
	}
	
	public void applyTitleFont(int size) {
		try {
			setFont(Font.loadFont(new FileInputStream("src/assets/SpaceMissionFont.otf"), size));
			}
		catch(FileNotFoundException e) {
				setFont(Font.font("Verdana",size));
			}
	}
}