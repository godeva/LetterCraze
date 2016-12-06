package entities;

import java.io.IOException;
import java.util.Stack;

import javax.swing.DefaultListModel;

public abstract class LevelModel {
    
    Board board;
    Goal goals;
    
    Stack<Move> history;
    Score bestScore, currentScore;
    Boolean isUnlocked;
    String type;
    DefaultListModel<String> wordList;
    
    LevelModel(Board b, Goal g, String type) {
        this.board = b;
        this.goals = g;
        bestScore = new Score();
        currentScore = new Score();
        isUnlocked = false;
        this.type = type;
        history = new Stack<Move>();
        wordList = new DefaultListModel<String>();  
    }
    
    void initializeWordTable() {
    	try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * called whenever level is loaded from Map
     */
    public void initializeLevel() {
    	initializeWordTable();
        resetBoard();
    }
    
    /**
     * called whenever player hits reset button, or level is initialized
     */
    void resetBoard() {
    	board.reset(); // reset board
    	currentScore = new Score(); // set currentScore to 0;
    	history.clear(); // clear move history
    	
    }
    
    boolean undoMove() {
        return false;
    }
    
    boolean updateScreen() {
        return false;
    }
    
    public String getType() {
    	return type;
    }
    
    public boolean getIsUnlocked() {
    	return isUnlocked;
    }
    
    public Score getBestScore() {
    	return bestScore;
    }
    
    public Score getCurrentScore() {
    	return currentScore;
    }
    
    public Board getBoard() {
    	return board;
    }
    
    public DefaultListModel<String> getWordList() {
    	return wordList;
    }
    
    public Goal getGoals() {
    	return goals;
    }
    
    public int getHistorySize() {
    	return history.size();
    }
    
    public void pushToHistory(Move move) {
    	history.push(move);
    }
    
    public void popFromHistory(Move move) {
    	history.pop();
    }
    
    public void unlock() {
        isUnlocked = true;
    }
    
    public boolean getLockStatus() {
        return isUnlocked;
    }

    
}
