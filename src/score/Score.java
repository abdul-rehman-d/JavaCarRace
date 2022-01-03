package score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Score {
	
	File file;
	Scanner fileReader;
	String[] scores;
	
	public Score() {
		file = new File("src/score/scroes.txt");
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {}
			}
	}
	
//	public static void main(String[] args) {
//		Score score = new Score();
//		int i = score.getHighestScore();
//	}
	
	
	public void save(int points){
		FileWriter writer;
		try {
			writer = new FileWriter(file, true);
			writer.write(points + "_");
			writer.close();
		} catch (IOException e) {
		}
	}
	
	public void load() {
		String data = "";
		try {
			fileReader = new Scanner(file);
			while(fileReader.hasNextLine()) {
				data += fileReader.nextLine();
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scores = data.split("_");
	}
	
	public String getHighestScore() {
		load();
//		return "None yet";
		if (scores.length <= 1) {
			return "None yet";
		}
		int[] scoresInt = new int[scores.length];
		int max = 0;
		for(int i = 0; i<scores.length; i++) {
			scoresInt[i] = Integer.parseInt(scores[i]);

			if(max < scoresInt[i]) {
				max = scoresInt[i];
			}
		}

		return Integer.toString(max);
	}
}
