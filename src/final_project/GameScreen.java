package final_project;

import final_project.Game.ChoiceHandler;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class GameScreen {
    
    //GUI Items
    JFrame window;
    JProgressBar healthBar;
    JPanel titleImagePanel, mainImagePanel, blockTitlePanel, startButtonPanel, IntroTextPanel, MainTextPanel, decisionButtonPanel, choiceButtonPanel, playerPanel, healthBarPanel;
    JLabel titleImageLabel, mainImageLabel, blockName, blockName2, hpLabel, weaponLabel, weaponNameLabel, timerLabel, timerNameLabel;
    Font titleFont1 = new Font("Futura", Font.BOLD, 60);
    Font titleFont2 = new Font("Futura", Font.PLAIN, 40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 16);
    Font normalFont2 = new Font("Times New Roman", Font.PLAIN, 12);
    JButton startButton, acceptButton, denyButton, choice1, choice2, choice3, choice4;
    JTextArea IntroTextArea, mainTextArea;
    ImageIcon titleImage, mainImage;
    
    GameStory story;
    
    //Items for Menu Bar
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem quit;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem title;
                    
    public void createGameScreen(ChoiceHandler cHandler){
        
        //Create Game Screen
        window = new JFrame();
        window.setVisible(true);
        window.setSize(700, 500);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        
        //Intro Game Screen    
        blockTitlePanel = new JPanel();
        blockTitlePanel.setBounds(100, 100, 500, 150);
        blockTitlePanel.setBackground(Color.black);
        blockName = new JLabel("FIRECRACKER");
        blockName2 = new JLabel("Burning Time");
        blockName.setForeground(Color.white);
        blockName2.setForeground(Color.yellow);
        blockName.setFont(titleFont1);
        blockName2.setFont(titleFont2);
        blockTitlePanel.add(blockName);
        blockTitlePanel.add(blockName2);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(200, 260, 300, 300);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START"); 
        startButton.setFont(titleFont1);
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.black);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);
                
        window.add(blockTitlePanel);
        window.add(startButtonPanel);
       
        // Menu Bar
        
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        title = new javax.swing.JMenuItem();
        
        jMenu1.setText("File");
        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });        
        title.setText("Home Page");
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });
        
        jMenu1.add(quit);
        jMenu1.add(title);
        jMenuBar1.add(jMenu1);
        
        jMenu2.setText("About");
        about.setText("Student Info");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        jMenu2.add(about);
        jMenuBar1.add(jMenu2);
        
        window.setJMenuBar(jMenuBar1);
        
        IntroTextPanel = new JPanel();
        IntroTextPanel.setBounds(50, 70, 380, 240);
        IntroTextPanel.setBackground(Color.black);
        window.add(IntroTextPanel);
        
        IntroTextArea = new JTextArea("By clicking on the 'Accept' button to the right, you will accidentally set a fire to the building you're in. \n\nYou will have only a few minutes to answer the right question to escape in time. There are two keys that you will need to find in order to escape. There are also items throughout the quest that'll aid you in completing the level.\n\nWill you take on this challenge?");
        IntroTextArea.setBounds(50, 70, 380, 240);
        IntroTextArea.setBackground(Color.black);
        IntroTextArea.setForeground(Color.white);   
        IntroTextArea.setFont(normalFont);
        IntroTextArea.setLineWrap(true);
        IntroTextArea.setWrapStyleWord(true);
        IntroTextArea.setEditable(false);
        IntroTextPanel.add(IntroTextArea);
        
        decisionButtonPanel = new JPanel();
        decisionButtonPanel.setBounds(470, 75, 200, 160);
        decisionButtonPanel.setBackground(Color.black);
        decisionButtonPanel.setLayout(new GridLayout(2,1));
        window.add(decisionButtonPanel);
        
        acceptButton = new JButton("Accept");
        acceptButton.setBackground(Color.black);
        acceptButton.setForeground(Color.black);        
        acceptButton.setFont(normalFont2);
        decisionButtonPanel.add(acceptButton);
        acceptButton.addActionListener(cHandler);
        acceptButton.setActionCommand("accept");

        denyButton = new JButton("Deny");
        denyButton.setBackground(Color.BLACK);
        denyButton.setForeground(Color.black);
        denyButton.setFont(normalFont2);
        decisionButtonPanel.add(denyButton);
        denyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyActionPerformed(evt);
            }
        });

        MainTextPanel = new JPanel();
        MainTextPanel.setBounds(35, 280, 410, 140);
        MainTextPanel.setBackground(Color.black);
        window.add(MainTextPanel);
        
        mainTextArea = new JTextArea("Random Bullshit");
        mainTextArea.setBounds(35, 280, 410, 140);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);   
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        MainTextPanel.add(mainTextArea);
        
        mainImagePanel = new JPanel();
        mainImagePanel.setBounds(35,80,410,190);
        mainImagePanel.setBackground(Color.black);
        
        mainImageLabel = new JLabel();
        mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/firstEncounter.png");
        Image originalImage = mainImage.getImage();
        Image scaledImage = originalImage.getScaledInstance(410, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
    
        mainImageLabel.setIcon(scaledIcon);
        mainImagePanel.add(mainImageLabel);
        
        window.add(mainImagePanel);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(470, 90, 190, 320);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonPanel);
        
        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.black);   
        choice1.setFont(normalFont2);
        choice1.setFocusPainted(false);
        choiceButtonPanel.add(choice1);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.black);   
        choice2.setFont(normalFont2);
        choice2.setFocusPainted(false);
        choiceButtonPanel.add(choice2);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.black);   
        choice3.setFont(normalFont2);
        choice3.setFocusPainted(false);
        choiceButtonPanel.add(choice3);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.black);   
        choice4.setFont(normalFont2);
        choice4.setFocusPainted(false);
        choiceButtonPanel.add(choice4);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        
        healthBarPanel = new JPanel();
        healthBarPanel.setBounds(470,30,200,50);
        healthBarPanel.setBackground(Color.black);
        window.add(healthBarPanel);
        healthBar = new JProgressBar(0, 20);  
        healthBar.setPreferredSize(new Dimension(190, 40));
        healthBar.setBackground(Color.black);
        healthBar.setForeground(Color.green);
        healthBarPanel.add(healthBar);
        
        playerPanel = new JPanel();
        playerPanel.setBounds(35, 30, 410, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 6));
        window.add(playerPanel);
        
        timerLabel = new JLabel("Time:");
        timerLabel.setFont(normalFont);
        timerLabel.setForeground(Color.white);
        playerPanel.add(timerLabel);
        
        timerNameLabel = new JLabel("05:00");
        timerNameLabel.setFont(normalFont);
        timerNameLabel.setForeground(Color.white);
        playerPanel.add(timerNameLabel);
        
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);
        
        weaponNameLabel = new JLabel("");
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setFont(normalFont);
        playerPanel.add(weaponNameLabel);
       
        window.setVisible(true);
        
    }
    
    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {                                      
        JOptionPane.showMessageDialog(null, "Name: Jefferey Chen (0033490915), Teah Good (0034798079) \nEmail: jwchen@purdue.edu, tlgood@purdue.edu \nClass: CNIT 25501 \nDescription: A short game utilizing the principles we've come to learn through labs and lectures. \nThe user will be asked to complete the role-playing game within the designated timeframe. \nIf not, the user will be prompted with a 'GAME OVER' screen, prompting them to restart the game.");
    }
    
    private void denyActionPerformed(java.awt.event.ActionEvent evt) {                                      
        JOptionPane.showMessageDialog(null, "Well that's a shame! \nIt seems you let the fire win, \nis there something else you can do \nto prevent it from happening next time.");
    }  

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        System.exit(0);
    }    
    
    private void titleActionPerformed(java.awt.event.ActionEvent evt) {                                     
        blockTitlePanel.setVisible(true);
        startButtonPanel.setVisible(true);
        
        IntroTextPanel.setVisible(false);
        decisionButtonPanel.setVisible(false);
        
        MainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        playerPanel.setVisible(false);
        healthBarPanel.setVisible(false);
        mainImagePanel.setVisible(false);

    
    }   
}
