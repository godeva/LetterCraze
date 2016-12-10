package builderboundary;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import entities.Model;

import java.awt.Color;

public class CreateNewLevelApplication extends JPanel {

    Model model;
    JPanel cards;
    JButton backButton;

    public CreateNewLevelApplication(Model m) {
        model = m;
        setLayout(null);
        setBounds(0, 0, 800, 600);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 75, 29);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        nameLabel.setBounds(120, 50, 74, 37);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        nameTextField.setBounds(196, 50, 284, 37);
        nameTextField.setToolTipText("Gives your level a name");
        nameTextField.setColumns(1);

        JPanel boardSquares = new JPanel();
        boardSquares.setBounds(120, 120, 360, 360);
        this.add(boardSquares);
        boardSquares.setLayout(null);

        JButton[][] squaresArray = new JButton[6][6];
//        char[][] charArray = new char[squaresArray.length][squaresArray[0].length];

        for (int x = 0; x < squaresArray.length; x++) {
            for (int y = 0; y < squaresArray[x].length; y++) {
                squaresArray[x][y] = new JButton(" ");
                squaresArray[x][y].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
//                        char buttonChar = ((JButton) e.getSource()).getText().toUpperCase().charAt(0);
////                        ((JButton) e.getSource()).setText((String)(buttonChar == 'Q' ? "Qu" : (char)('0' + buttonChar + 1)));
//                        ((JButton) e.getSource()).setText((String)(buttonChar == 'Q' ? "Qu" : (char)('0' + buttonChar + 1)));
//                        if (buttonChar == ' ') {
//                            ((JButton) e.getSource()).setBackground(new Color(0xFF0000));
//                            ((JButton) e.getSource()).setOpaque(false);
//                        } else {
//                            ((JButton) e.getSource()).setBackground(new Color(0xFF0000));
//                            ((JButton) e.getSource()).setOpaque(true);
//                            
//                        }
//                        
//                        
//                        ((JButton) e.getSource()).repaint();
                        
                    }
                    
                });
                squaresArray[x][y].setBounds(60*x, 60*y, 60, 60);
                boardSquares.add(squaresArray[x][y]);
            }
        }


        this.add(backButton);
        this.add(nameLabel);
        this.add(nameTextField);

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
        numMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numMovesLabel.setBounds(6, 6, 188, 16);
        puzzlePanel.add(numMovesLabel);

        JSpinner numMovesSpinner = new JSpinner();
        numMovesSpinner.setBounds(134, 34, 60, 28);
        puzzlePanel.add(numMovesSpinner);

        JPanel lightningPanel = new JPanel();
        cards.add(lightningPanel, "Lightning");
        lightningPanel.setLayout(null);

        JLabel timeLabel = new JLabel("Time Allowed (secs):");
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setBounds(6, 6, 188, 16);
        lightningPanel.add(timeLabel);

        JSpinner timeSpinner = new JSpinner();
        timeSpinner.setBounds(134, 34, 60, 28);
        lightningPanel.add(timeSpinner);

        JPanel themePanel = new JPanel();
        cards.add(themePanel, "Theme");
        themePanel.setLayout(null);

        JLabel themeLabel = new JLabel("Theme:");
        themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        themeLabel.setBounds(6, 6, 188, 16);
        themePanel.add(themeLabel);

        JTextField textField = new JTextField();
        textField.setBounds(6, 34, 188, 28);
        themePanel.add(textField);
        textField.setColumns(10);

        JLabel lblWords = new JLabel("Words:");
        lblWords.setHorizontalAlignment(SwingConstants.CENTER);
        lblWords.setBounds(6, 75, 188, 16);
        themePanel.add(lblWords);

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(6, 103, 134, 28);
        themePanel.add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBounds(144, 103, 50, 29);
        themePanel.add(btnNewButton);

        JList list = new JList();
        list.setBorder(new LineBorder(new Color(0, 0, 0)));
        list.setBounds(6, 143, 188, 247);
        themePanel.add(list);

        // code inside here magically changes view depending on whether "Puzzle", "Lightning", or "Theme" is selected
        // this should maybe be separated out into a new controller class?
        JComboBox gameModeComboBox = new JComboBox();
        gameModeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, (String)e.getItem());
                //System.out.print((String)e.getItem());
            }
        });
        gameModeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
        gameModeComboBox.setMaximumRowCount(3);
        gameModeComboBox.setBounds(6, 34, 188, 27);
        settingsPanel.add(gameModeComboBox);

        JLabel gameModeLabel = new JLabel("Game Mode:");
        gameModeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameModeLabel.setBounds(6, 6, 188, 27);
        settingsPanel.add(gameModeLabel);

        JLabel starGoal1Label = new JLabel("Star 1 Goal:");
        starGoal1Label.setBounds(6, 73, 72, 16);
        settingsPanel.add(starGoal1Label);

        JLabel starGoal2Label = new JLabel("Star 2 Goal:");
        starGoal2Label.setBounds(6, 101, 72, 16);
        settingsPanel.add(starGoal2Label);

        JLabel starGoal3Label = new JLabel("Star 3 Goal:");
        starGoal3Label.setBounds(6, 129, 72, 16);
        settingsPanel.add(starGoal3Label);

        JSpinner starGoal1Spinner = new JSpinner();
        starGoal1Spinner.setBounds(134, 67, 60, 28);
        settingsPanel.add(starGoal1Spinner);

        JSpinner starGoal2Spinner = new JSpinner();
        starGoal2Spinner.setBounds(134, 95, 60, 28);
        settingsPanel.add(starGoal2Spinner);

        JSpinner starGoal3Spinner = new JSpinner();
        starGoal3Spinner.setBounds(134, 123, 60, 28);
        settingsPanel.add(starGoal3Spinner);

        JButton btnSaveLevel = new JButton("Save Level");
        btnSaveLevel.setBounds(120, 520, 170, 37);
        add(btnSaveLevel);

        JButton btnPublishToLettercraze = new JButton("Publish to LetterCraze");
        btnPublishToLettercraze.setBounds(310, 520, 170, 37);
        add(btnPublishToLettercraze);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
