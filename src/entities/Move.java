package entities;

import playerboundary.LevelApplication;
import entities.PuzzleLevel;

public class Move {
	
	/**
	 * the selected word
	 */
	Word word;
	
	/**
	 * the selected word
	 */
	LevelModel model;
	
	LevelApplication app;
	
	/**
	 * Constructor for Move
	 * 
	 * @param word the selected word
	 * @param level the level in which the move is made
	 */
	public Move(Word word, LevelModel model) {
		this.word = word;
		this.app = app;
		this.model = model;
	}
	
	public boolean doMove() {
		if (isValidMove()) {
			//TODO: do Move
			
			// add word to model's word list
			model.getWordList().addElement(word.toString());
			
			// update numscore
			int wordScore = word.getScore();
			model.getCurrentScore().updateScore(wordScore);
			
			// update star score (if necessary)
			// if current score is greater than star1 goal
			if (model.getCurrentScore().getScore() >= model.getGoals().getStar1()) {
				model.getCurrentScore().setStar(1);
			} else if (model.getCurrentScore().getScore() >= model.getGoals().getStar2()) {
				model.getCurrentScore().setStar(2);
			} else if (model.getCurrentScore().getScore() >= model.getGoals().getStar3()) {
				model.getCurrentScore().setStar(3);
			}
			
			// remove word from board
			model.getBoard().removeWord(word);
			
			// repopulate tiles
			model.getBoard().repopulate();
			
			// move completed
			return true;
		}
		return false;
	}
	
	public boolean undoMove() {
		if (model.getHistorySize() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isValidMove() {
		if (word.isValid()) {
		//are there any more stipulations? Check if timer has run out/etc.?
		return true;
		}
		else return false;
	}

}