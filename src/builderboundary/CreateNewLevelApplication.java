package builderboundary;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entities.BuilderModel;
import entities.LevelModel;
import entities.LightningLevel;
import entities.Model;
import entities.PuzzleLevel;
import entities.ThemeLevel;

/**
 * The containing Frame for Creating a New Level.
 */

@SuppressWarnings("serial")
public class CreateNewLevelApplication extends JPanel {

	/** All Builder information. */
	BuilderModel model;
	/** Panel of cards */
	JPanel cards;
	/** Button to go back */
	JButton backButton;
	/** Button to add word */
	JButton addWordButton;
	/** Button to delete word */
	JButton deleteWordButton;
	/** Buttons for squares */
	JButton[][] squaresArray;
	/** Combo boxes to choose letters */
	JComboBox[][] lettersArray;
	/** Button to save level */
	JButton btnSaveLevel;
	/** Level type */
	String levelType;
	/** Combo box to select game mode */
	JComboBox gameModeComboBox;
	/** Button to preview level */
	JButton previewButton;
	/** Spinner for star 1 goal */
	JSpinner starGoal1Spinner;
	/** Spinner for star 2 goal */
	JSpinner starGoal2Spinner;
	/** Spinner for star 3 goal */
	JSpinner starGoal3Spinner;
	/** Spinner for number of moves */
	JSpinner numMovesSpinner;
	/** Spinner for time */
	JSpinner timeSpinner;
	/** Container for <code>JList wordList</code> */
	DefaultListModel listModel;
	/** List of words */
	JList wordList;
	/** Word field for theme levels */
	JTextField wordField;
	/** Theme field for theme levels */
	JTextField themeField;
	/** Level name */
	JLabel levelNameLabel;

	public CreateNewLevelApplication(BuilderModel model2) {

		levelType = "Puzzle";

		model = model2;
		setLayout(null);
		setBounds(0, 0, 800, 600);

		backButton = new JButton("Back");
		backButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		backButton.setBounds(10, 10, 75, 29);

		JPanel boardSquares = new JPanel();
		boardSquares.setBounds(120, 120, 360, 360);
		this.add(boardSquares);
		boardSquares.setLayout(null);

		squaresArray = new JButton[6][6];
		lettersArray = new JComboBox[6][6];
		//        char[][] charArray = new char[squaresArray.length][squaresArray[0].length];

		for (int x = 0; x < squaresArray.length; x++) {
			for (int y = 0; y < squaresArray[x].length; y++) {
				squaresArray[x][y] = new JButton(" ");
				squaresArray[x][y].setOpaque(true);
				squaresArray[x][y].setBounds(60*x, 60*y, 60, 60);
				boardSquares.add(squaresArray[x][y]);

				lettersArray[x][y] = new JComboBox<String>();
				lettersArray[x][y].addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {

					}
				});
				lettersArray[x][y].setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "QU", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
				// lettersArray[x][y].setFont(new Font("Lucida Grande", Font.PLAIN, 7)); this is the size needed for QU to show up on mac but its really small
				lettersArray[x][y].setMaximumRowCount(10);
				lettersArray[x][y].setBounds(60*x, 60*y+30, 60, 30);
				lettersArray[x][y].setOpaque(true);
				lettersArray[x][y].setBackground(Color.WHITE);
				lettersArray[x][y].setVisible(false);
				boardSquares.add(lettersArray[x][y]);

			}
		}


		this.add(backButton);

		JPanel settingsPanel = new JPanel();
		settingsPanel.setBounds(600, 0, 200, 600);
		this.add(settingsPanel);
		settingsPanel.setLayout(null);

		cards = new JPanel();
		cards.setBounds(0, 157, 200, 421);
		settingsPanel.add(cards);
		cards.setLayout(new CardLayout(0, 0));

		JPanel puzzlePanel = new JPanel();
		cards.add(puzzlePanel, "Puzzle");
		puzzlePanel.setLayout(null);

		JLabel numMovesLabel = new JLabel("Number of Moves Allowed:");
		numMovesLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		numMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numMovesLabel.setBounds(6, 6, 188, 16);
		puzzlePanel.add(numMovesLabel);

		numMovesSpinner = new JSpinner();
		numMovesSpinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		numMovesSpinner.setBounds(134, 34, 60, 28);
		numMovesSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		puzzlePanel.add(numMovesSpinner);

		JPanel lightningPanel = new JPanel();
		cards.add(lightningPanel, "Lightning");
		lightningPanel.setLayout(null);

		JLabel timeLabel = new JLabel("Time Allowed (secs):");
		timeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(6, 6, 188, 16);
		lightningPanel.add(timeLabel);

		timeSpinner = new JSpinner();
		timeSpinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		timeSpinner.setBounds(134, 34, 60, 28);
		timeSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		lightningPanel.add(timeSpinner);

		JPanel themePanel = new JPanel();
		cards.add(themePanel, "Theme");
		themePanel.setLayout(null);

		JLabel themeLabel = new JLabel("Theme:");
		themeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setBounds(6, 6, 188, 16);
		themePanel.add(themeLabel);

		themeField = new JTextField();
		themeField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		themeField.setBounds(6, 34, 188, 28);
		themePanel.add(themeField);
		themeField.setColumns(10);

		JLabel lblWords = new JLabel("Words:");
		lblWords.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblWords.setHorizontalAlignment(SwingConstants.CENTER);
		lblWords.setBounds(6, 75, 188, 16);
		themePanel.add(lblWords);

		wordField = new JTextField();
		wordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		wordField.setBounds(6, 103, 188, 28);
		themePanel.add(wordField);
		wordField.setColumns(10);

		addWordButton = new JButton("Add");
		addWordButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		addWordButton.setBounds(6, 135, 90, 29);
		themePanel.add(addWordButton);

		deleteWordButton = new JButton("Delete");
		deleteWordButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		deleteWordButton.setBounds(108, 135, 86, 29);
		themePanel.add(deleteWordButton);

		listModel = new DefaultListModel();
		wordList = new JList(listModel);
		wordList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		wordList.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		wordList.setBounds(6, 172, 188, 218);
		themePanel.add(wordList);


		gameModeComboBox = new JComboBox();
		gameModeComboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));

		/* created GameModeSelectionController to do this
        gameModeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, (String)e.getItem());
                levelType = (String)e.getItem();
                //System.out.println("Leveltype: " + levelType);

            }
        });
		 */

		gameModeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
		gameModeComboBox.setMaximumRowCount(3);
		gameModeComboBox.setBounds(6, 34, 188, 27);
		settingsPanel.add(gameModeComboBox);

		JLabel gameModeLabel = new JLabel("Game Mode:");
		gameModeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		gameModeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameModeLabel.setBounds(6, 6, 188, 27);
		settingsPanel.add(gameModeLabel);

		JLabel starGoal1Label = new JLabel("Star 1 Goal:");
		starGoal1Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal1Label.setBounds(6, 73, 72, 16);
		settingsPanel.add(starGoal1Label);

		JLabel starGoal2Label = new JLabel("Star 2 Goal:");
		starGoal2Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal2Label.setBounds(6, 101, 72, 16);
		settingsPanel.add(starGoal2Label);

		JLabel starGoal3Label = new JLabel("Star 3 Goal:");
		starGoal3Label.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal3Label.setBounds(6, 129, 72, 16);
		settingsPanel.add(starGoal3Label);

		starGoal1Spinner = new JSpinner();
		starGoal1Spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal1Spinner.setBounds(134, 67, 60, 28);
		starGoal1Spinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		settingsPanel.add(starGoal1Spinner);

		starGoal2Spinner = new JSpinner();
		starGoal2Spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal2Spinner.setBounds(134, 95, 60, 28);
		starGoal2Spinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		settingsPanel.add(starGoal2Spinner);

		starGoal3Spinner = new JSpinner();
		starGoal3Spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		starGoal3Spinner.setBounds(134, 123, 60, 28);
		starGoal3Spinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		settingsPanel.add(starGoal3Spinner);

		btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnSaveLevel.setBounds(120, 520, 360, 37);
		add(btnSaveLevel);

		levelNameLabel = new JLabel("");
		levelNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		levelNameLabel.setBounds(120, 78, 360, 30);
		add(levelNameLabel);

		JLabel lblLevelYouAre = new JLabel("You are working on:");
		lblLevelYouAre.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblLevelYouAre.setBounds(120, 50, 200, 16);
		add(lblLevelYouAre);
		
		previewButton = new JButton("Preview");
		previewButton.setBounds(299, 71, 175, 37);
		add(previewButton);
	}

	public void resetPanel() {

		levelNameLabel.setText("Custom Level " + (model.getSavedLevels().size()+1));

		starGoal1Spinner.setValue(0);

		starGoal2Spinner.setValue(0);

		starGoal3Spinner.setValue(0);

		gameModeComboBox.setSelectedIndex(0);
		numMovesSpinner.setValue(0);	
		timeSpinner.setValue(0);
		themeField.setText("");
		wordField.setText("");
		listModel.clear();

		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				squaresArray[x][y].setBackground(null);
				squaresArray[x][y].setBounds(60*x, 60*y, 60, 60);
				lettersArray[x][y].setVisible(false);
				lettersArray[x][y].setSelectedItem("A");
			}
		}

	}

	public JButton getBackButton() {
		return backButton;
	}

	public JButton[][] getSquareButtons() {
		return squaresArray;
	}

	public JComboBox[][] getLetterBoxes() {
		return lettersArray;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String type) {
		this.levelType = type;
	}

	public int[] getStarGoals() {
		int[] goals = new int[3];
		goals[0] = (int)starGoal1Spinner.getValue();
		goals[1] = (int)starGoal2Spinner.getValue();
		goals[2] = (int)starGoal3Spinner.getValue();
		return goals;
	}

	/**Getter that returns button for getting to btnSaveLevel.
	 * @return Save Level Button
	 */	
	public JButton getSaveButton() {
		return btnSaveLevel;
	}

	/**Getter that returns button for getting to wordList.
	 * @return Word List
	 */
	public JList getWordList() {
		return wordList;
	}

	/**Getter that returns button for getting to addWordButton.
	 * @return Add Word Button
	 */	
	public JButton getAddWordButton() {
		return addWordButton;
	}
	
	/**Getter that returns button for getting to deleteWordButton.
	 * @return Delete Word Button
	 */
	public JButton getDeleteWordButton() {
		return deleteWordButton;
	}

	/**Getter that returns spinner for getting to timeSpinner.
	 * @return Time Spinner
	 */
	public JSpinner getTimeSpinner() {
		return timeSpinner;
	}

	/**Getter that returns spinner for getting to numMovesSpinner.
	 * @return Number of Moves Spinner
	 */
	public JSpinner getNumMovesSpinner() {
		return numMovesSpinner;
	}

	/**Getter that returns field for getting to themeField.
	 * @return Theme Field
	 */
	public JTextField getThemeField() {
		return themeField;
	}

	/**Getter that returns field for getting to wordField.
	 * @return Word Model
	 */
	public JTextField getWordField() {
		return wordField;
	}

	/**Getter that returns model for getting to listModel.
	 * @return List model
	 */
	public DefaultListModel getDefaultListModel() {
		return listModel;
	}

	/**Getter that returns label for getting to levelNameLabel.
	 * @return Level Name
	 */
	public JLabel getLevelNameLabel() {
		return levelNameLabel;
	}

	/**Getter that returns panel for getting to cards.
	 * @return Cards
	 */
	public JPanel getCards() {
		return cards;
	}

	/**Getter that returns drop down menu for getting to gameModeComboBox.
	 * @return Game Type Combo Box
	 */
	public JComboBox getGameModeComboBox() {
		return gameModeComboBox;

	}
	
	/**Getter that returns button for getting to previewButton.
	 * @return Preview Level Button
	 */
	public JButton getPreviewButton() {
		return previewButton;
	}
}
