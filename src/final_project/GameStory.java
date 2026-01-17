package final_project;

import final_project.FireMonster.BigFire;
import final_project.FireMonster.SmallFire;
import final_project.FireMonster.SneakyFire;
import final_project.FireMonster.UndefeatedFire;
import final_project.weapon.Weapon_BucketOfWater;
import final_project.weapon.Weapon_HandFan;
import final_project.weapon.Weapon_Plunger;
import final_project.weapon.Weapon_Spit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GameStory {
    
    private int partofKey;
    public Timer gameTimer;
    private int timeRemaining;
    private int gameDelay; 

    Game game;
    Timer gametimer;
    GameScreen gameScreen;
    VisibilityManager vm;
    Player player = new Player();
    SuperFire fire;
    
    DecimalFormat dFormat = new DecimalFormat("00");
    
    public GameStory(Game g, GameScreen screen, VisibilityManager manager) {
        
        game = g;
        gameScreen = screen;
        vm = manager;   
    }
    
    public void startTimer() {
        
        timeRemaining = 300;
        gameDelay = 1000;
        int delay = gameDelay; 
    
        gameTimer = new Timer(delay, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                int minutes = timeRemaining / 60;
                int seconds = timeRemaining % 60;
                
                String ddSeconds, ddMinutes;
                
                ddMinutes = dFormat.format(minutes);
                ddSeconds = dFormat.format(seconds);

                gameScreen.timerNameLabel.setText(ddMinutes + ":" + ddSeconds);
                timeRemaining--;

                if (timeRemaining <= -1) {
                    
                    gameTimer.stop();
                    
                    gameScreen.mainTextArea.setText("You lost on time and slowly became one with the fire... \nWhat could you do differently next time?");
                        
                    gameScreen.choice1.setText("");
                    gameScreen.choice2.setText("");
                    gameScreen.choice3.setText("");
                    gameScreen.choice4.setText("");
                        
                    int newDelay = 1000;
                    adjustGameDelay(newDelay);
                    
                    JOptionPane.showMessageDialog(null, "<GAME OVER>");
                    defaultSetup();
                    vm.showTitleScreen();
                } 
            }
        });
        gameTimer.start();
    }
    
    public void adjustGameDelay(int newDelay) {
        
        if (newDelay < gameDelay) {
            gameTimer.setDelay(200);
        }
    }
    
    public void defaultSetup() {
        
        player.currentWeapon = new Weapon_Spit();
        gameScreen.weaponNameLabel.setText(player.currentWeapon.name);
        
        player.hp = 20;
        gameScreen.healthBar.setValue(player.hp);
        
        partofKey = 0;
    }
    
    public void selectPosition(String nextPosition) {
        
        switch(nextPosition) {
        case "firstEncounter": firstEncounter(); break;
        case "DescendWrong": DescendWrong(); break;
        case "descent": descent(); break;
        case "JumpOut": JumpOut(); break;
        case "Left1": Left1(); break;
        case "Left2": Left2(); break;
        case "Left3": Left3(); break;
        case "Right1": Right1(); break;
        case "Right2": Right2(); break;
        case "Right3": Right3(); break;
        case "falseRight": falseRight(); break;
        case "Spit": Spit(); break;
        case "Wait": Wait(); break;
        case "HandFan": HandFan(); break;
        case "Plunger": Plunger(); break;
        case "Bucket": Bucket(); break;
        case "fight": fight(); break;
        case "fight1": fight1(); break;
        case "fight2": fight2(); break;
        case "attack": attack(); break;
        case "attack1": attack1(); break;
        case "attack2": attack2(); break;
        case "fireAttack": fireAttack(); break;
        case "fireAttack1": fireAttack(); break;
        case "fireAttack2": fireAttack2(); break;
        case "lose": lose(); break;
        case "toTitle": toTitle(); break;
        case "Continue": Continue(); break;
        case "door1": door1(); break;
        case "door2": door2(); break;
        case "crosswalk": crosswalk(); break;
        case "crosswalk2": crosswalk2(); break;
        case "room1": room1(); break;
        case "win": win(); break;
        case "win1": win1(); break;
        case "win2": win2(); break;
        case "ending": ending(); break;
        }
    }
    
    public void firstEncounter() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/firstEncounter.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("There is a fire that randomly broke out somewhere in the building. You opened your office door to see a window. \n\nThere's only five minutes, so act fast and avoid danger during your evacuation.");
        gameScreen.choice1.setText("Jump out of the window");
        gameScreen.choice2.setText("Go down the left hallway");
        gameScreen.choice3.setText("Go down the right hallway");
        gameScreen.choice4.setText("Spit at the window");
    
        game.nextPosition1 = "JumpOut";
        game.nextPosition2 = "Left1";
        game.nextPosition3 = "Right1";
        game.nextPosition4 = "Spit";
    }
    
    public void JumpOut() {
        
        timeRemaining = timeRemaining - 20;
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/JumpOut.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);

        gameScreen.mainTextArea.setText("You decided to trying growing a pair of wings. As you glanced down the four story building, you questioned if you're going to be first human being to sore with the birds... of course not, you'll die...\n\n20 seconds was lost.");
        gameScreen.choice1.setText("Rethink your life choices");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "firstEncounter";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    
    public void Left1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Left1.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("At the end of the hallway, you see a green EXIT sign. However, it's covered by smoke so you can't tell where it's pointing.");
        gameScreen.choice1.setText("Go to the left");
        gameScreen.choice2.setText("Go to the right");
        gameScreen.choice3.setText("Go back");
        gameScreen.choice4.setText("Wait");
    
        game.nextPosition1 = "Left2";
        game.nextPosition2 = "falseRight";
        game.nextPosition3 = "firstEncounter";
        game.nextPosition4 = "Wait";   
    }
    
    public void Left2() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Left2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You chose the correct path, and began descending some stairs. However on the second floor, it is seemingly blocked by rubble. Looks like you have to find another way out.");
        gameScreen.choice1.setText("Exit stairway");
        gameScreen.choice2.setText("Descend down the stairs");
        gameScreen.choice3.setText("Wait");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "Right2";
        game.nextPosition2 = "DescendWrong";
        game.nextPosition3 = "Wait";
        game.nextPosition4 = "";   
    }
    
    public void Left3() {
        
        fire = new SneakyFire();
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Left3.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);

        gameScreen.mainTextArea.setText("A " + fire.name + " blocks your way. Can you handle it, or shall you retrace your steps?");
        gameScreen.choice1.setText("Continue");
        gameScreen.choice2.setText("Retrace your steps");
        gameScreen.choice3.setText("Wait");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "fight2";
        game.nextPosition2 = "crosswalk2";
        game.nextPosition3 = "Wait";
        game.nextPosition4 = "";  
    }
    
    public void Right1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right1.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("There seems to be an old man who collapsed from the smoke. There's three objects near him. You decided to pick up... ");
        gameScreen.choice1.setText("A Hand Fan");
        gameScreen.choice2.setText("A Plunger");
        gameScreen.choice3.setText("A Bucket of Water");
        gameScreen.choice4.setText("Nothing");
    
        game.nextPosition1 = "HandFan";
        game.nextPosition2 = "Plunger";
        game.nextPosition3 = "Bucket";
        game.nextPosition4 = "firstEncounter";   
    }
    
    public void Right2() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("Something seems off. There seems to be a thicker cloud of smoke here. Your senses dictates there is danger in the area. ");
        gameScreen.choice1.setText("Continue");
        gameScreen.choice2.setText("Retrace your steps");
        gameScreen.choice3.setText("Wait");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "Continue";
        game.nextPosition2 = "Left1";
        game.nextPosition3 = "Wait";
        game.nextPosition4 = "";   
    }
    
    public void Right3() {
        
        timeRemaining = timeRemaining - 10;
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right3.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You opened the door, and there wasn't anything inside. Maybe another room has something of importance.\n\n10 seconds was lost.");
        
        gameScreen.choice1.setText("Go back");
        gameScreen.choice2.setText("Wait");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "crosswalk2";
        game.nextPosition2 = "Wait";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void falseRight() {
        
        timeRemaining = timeRemaining - 10;
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/firstEncounter.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("Nothing seems to be here but a window. However, in the distance, you hear someone's cry for help. Perhaps it could be important...\n\n10 seconds was lost.");
        gameScreen.choice1.setText("Go back");
        gameScreen.choice2.setText("Retrace your steps");
        gameScreen.choice3.setText("Wait");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "Left1";
        game.nextPosition2 = "firstEncounter";
        game.nextPosition3 = "Wait";
        game.nextPosition4 = "";   
    }
    
    public void HandFan() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/HandFan.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        player.currentWeapon = new Weapon_HandFan();
        gameScreen.weaponNameLabel.setText(player.currentWeapon.name);
        
        gameScreen.mainTextArea.setText("You obtained a Hand Fan!");
        gameScreen.choice1.setText("Return to where you were");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "firstEncounter";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";   
    }
    
    public void Plunger() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Plunger.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        player.currentWeapon = new Weapon_Plunger();
        gameScreen.weaponNameLabel.setText(player.currentWeapon.name);
        
        gameScreen.mainTextArea.setText("You obtained a Plunger!");
        gameScreen.choice1.setText("Return to where you were");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "firstEncounter";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";   
    }
    
    public void Bucket() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Bucket.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        player.currentWeapon = new Weapon_BucketOfWater();
        gameScreen.weaponNameLabel.setText(player.currentWeapon.name);
        
        gameScreen.mainTextArea.setText("You obtained a Bucket of Water!");
        gameScreen.choice1.setText("Return to where you were");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "firstEncounter";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";   
    }
    
    public void Continue() {
        
        int i = new java.util.Random().nextInt(50)+1;
        
        if(i<45) {
            
            gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/BigFire.png");
            gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
            fire = new BigFire();
        }
        else {
            gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/UndefeatedFire.png");
            gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
            fire = new UndefeatedFire();
        }
        
        gameScreen.mainTextArea.setText("A " + fire.name + " blocks your way. Can you handle it, or shall you retrace your steps?");
        gameScreen.choice1.setText("Continue");
        gameScreen.choice2.setText("Retrace your steps");
        gameScreen.choice3.setText("Wait");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "fight1";
        game.nextPosition2 = "Left1";
        game.nextPosition3 = "Wait";
        game.nextPosition4 = "";   
    }
    
    public void Spit() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Spit.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You decided to spit at the window! It was ineffective!");
        gameScreen.choice1.setText("Go back");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "firstEncounter";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    
    public void Wait() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Wait.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        timeRemaining = timeRemaining - 20;
        int newDelay = gameDelay - 700;
        adjustGameDelay(newDelay);
        
        JOptionPane.showMessageDialog(null, "You decided to wait for safety to come for you. \nHowever, you misjudged the effects of the smoke. \nTime has suddenly picked up pace, and your body has weakened. \nAt the cost of some precious health and time, you move forward...\n\n20 seconds was lost and rate of timer countdown increased.");
        
        gameScreen.mainTextArea.setText("You waited...");
        player.hp = player.hp - 5;
        gameScreen.healthBar.setValue(player.hp);
        gameScreen.choice1.setText("Go to beginning");
        gameScreen.choice2.setText("Restart");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "firstEncounter";
        game.nextPosition2 = "toTitle";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
        
    }
    
    public void DescendWrong() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/SmallFire.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        fire = new SmallFire();
        
        gameScreen.mainTextArea.setText("You went down the wrong stairs and twisted your ankle. While getting up, you noticed a " + fire.name + "!");
        player.hp = player.hp - 3;
        
        gameScreen.healthBar.setValue(player.hp);
        gameScreen.choice1.setText("Fight");
        gameScreen.choice2.setText("Go back");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "fight";
        game.nextPosition2 = "Left2";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void descent() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Descent.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You proceed down the stairs. It seems to be clear as of this moment.");
        
        gameScreen.choice1.setText("Continue");
        gameScreen.choice2.setText("Go back");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "crosswalk2";
        game.nextPosition2 = "crosswalk";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void crosswalk() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/crosswalk.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("Another split, but it's clearer to make out where to go. By going left, there is another safer stairway to descend down. However, there seems to be something else important to the right.");
        
        gameScreen.choice1.setText("Go left");
        gameScreen.choice2.setText("Go right");
        gameScreen.choice3.setText("Wait");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "descent";
        game.nextPosition2 = "door1";
        game.nextPosition3 = "Wait";
        game.nextPosition4 = "";        
    }
    
    public void crosswalk2() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/crosswalk2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("In front of you, you see a door seemingly leading to your freedom. To the left, there is a raging fire. To the right, there's another room. \n\nHow should you proceed?");
        
        gameScreen.choice1.setText("To the door");
        gameScreen.choice2.setText("To the left");
        gameScreen.choice3.setText("To the right");
        gameScreen.choice4.setText("Go back up the stairs");
    
        game.nextPosition1 = "door2";
        game.nextPosition2 = "Left3";
        game.nextPosition3 = "Right3";
        game.nextPosition4 = "firstEncounter"; 
    }
    
    public void door2() {
        
        if(partofKey <= 1) {
            
            gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/door2.png");
            gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
            
            gameScreen.mainTextArea.setText("You don't have enough key parts to unlock this yet. Where else could you search to find the missing pieces?");

            gameScreen.choice1.setText("Go back");
            gameScreen.choice2.setText("wait");
            gameScreen.choice3.setText("");
            gameScreen.choice4.setText("");

            game.nextPosition1 = "crosswalk2";
            game.nextPosition2 = "Wait";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
        }
        else if(partofKey == 2) {
            ending();
        }  
    }
    
    public void fight() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/SmallFire.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText(fire.name + ": " + fire.hp + "\nQuick! We don't have much time!");
        
        gameScreen.choice1.setText("Extinguish it");
        gameScreen.choice2.setText("Go back");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "attack";
        game.nextPosition2 = "Left2";
        game.nextPosition3 = "";
        game.nextPosition4 = "";       
    }
    
    public void fight1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText(fire.name + ": " + fire.hp + "\nQuick! We don't have much time!");
        
        gameScreen.choice1.setText("Extinguish it");
        gameScreen.choice2.setText("Go back");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "attack1";
        game.nextPosition2 = "Right2";
        game.nextPosition3 = "";
        game.nextPosition4 = "";       
    }
    
    public void fight2() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Left3.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
                
        gameScreen.mainTextArea.setText(fire.name + ": " + fire.hp + "\nQuick! We don't have much time!");
        
        gameScreen.choice1.setText("Extinguish it");
        gameScreen.choice2.setText("Go back");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "attack2";
        game.nextPosition2 = "crosswalk2";
        game.nextPosition3 = "";
        game.nextPosition4 = "";       
    }
    
    public void attack() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        int playerDmg = player.currentWeapon.damage;
        
        fire.hp = fire.hp - playerDmg;
        
        gameScreen.mainTextArea.setText("You used " + player.currentWeapon.name + " and it did " + playerDmg + " damage!\nThe boss still has " + fire.hp);
        gameScreen.mainTextArea.setText(fire.name + ": " + fire.hp + "\nHurray! We don't have much time!");
        
        gameScreen.choice1.setText("Extinguish it again");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
        
        if(fire.hp > 0) {
            game.nextPosition1 = "fireAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";          
        }
        else if(fire.hp < 1) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
        }
    }
    
    public void attack1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        int playerDmg = player.currentWeapon.damage;
        
        fire.hp = fire.hp - playerDmg;
        
        gameScreen.mainTextArea.setText("You used " + player.currentWeapon.name + " and it did " + playerDmg + " damage!\nThe boss still has " + fire.hp);
        gameScreen.mainTextArea.setText(fire.name + ": " + fire.hp + "\nHurray! We don't have much time!");
        
        gameScreen.choice1.setText("Extinguish it again");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
        
        if(fire.hp > 0) {
            game.nextPosition1 = "fireAttack1";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";          
        }
        else if(fire.hp < 1) {
            game.nextPosition1 = "win1";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
        }
    }
    
    public void attack2() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        int playerDmg = player.currentWeapon.damage;
        
        fire.hp = fire.hp - playerDmg;
        
        gameScreen.mainTextArea.setText("You used " + player.currentWeapon.name + " and it did " + playerDmg + " damage!\nThe boss still has " + fire.hp);
        gameScreen.mainTextArea.setText(fire.name + ": " + fire.hp + "\nHurray! We don't have much time!");
        
        gameScreen.choice1.setText("Extinguish it again");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
        
        if(fire.hp > 0) {
            game.nextPosition1 = "fireAttack2";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";          
        }
        else if(fire.hp < 1) {
            game.nextPosition1 = "win2";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
        }
    }
    
    public void fireAttack() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/SmallFire.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        int fireDmg = new java.util.Random().nextInt(fire.attack);
        
        player.hp = player.hp - fireDmg;
       
        gameScreen.mainTextArea.setText("The fire used " + fire.attackMessage + "! Your HP is: " + player.hp);
        gameScreen.healthBar.setValue(player.hp);
        
        gameScreen.choice1.setText("Attack: " + player.currentWeapon.name);
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
        
        if(player.hp > 0) {
            game.nextPosition1 = "attack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";          
        }
        else if(player.hp < 1) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
        } 
    }
    
    public void fireAttack1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Right2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        int fireDmg = new java.util.Random().nextInt(fire.attack);
        
        player.hp = player.hp - fireDmg;
       
        gameScreen.mainTextArea.setText("The fire used " + fire.attackMessage + "! Your HP is: " + player.hp);
        gameScreen.healthBar.setValue(player.hp);
        
        gameScreen.choice1.setText("Attack: " + player.currentWeapon.name);
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
        
        if(player.hp > 0) {
            game.nextPosition1 = "attack1";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";          
        }
        else if(player.hp < 1) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
        } 
    }
    
    public void fireAttack2() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Left3.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        int fireDmg = new java.util.Random().nextInt(fire.attack);
        
        player.hp = player.hp - fireDmg;
       
        gameScreen.mainTextArea.setText("The fire used " + fire.attackMessage + "! Your HP is: " + player.hp);
        gameScreen.healthBar.setValue(player.hp);
        
        gameScreen.choice1.setText("Attack: " + player.currentWeapon.name);
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
        
        if(player.hp > 0) {
            game.nextPosition1 = "attack2";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";          
        }
        else if(player.hp < 1) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
        } 
    }  
    
    public void win() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Win.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You've extinguished a " + fire.name + "!");
                
        gameScreen.choice1.setText("Go back");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "Left2";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void win1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Win.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You've extinguished a " + fire.name + "!");
                
        gameScreen.choice1.setText("Continue");
        gameScreen.choice2.setText("Go back");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "crosswalk";
        game.nextPosition2 = "Left2";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void win2() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Win2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
                
        gameScreen.mainTextArea.setText("You defeat the " + fire.name + " and it dropped another part of the key. Can you open the door now?");

        partofKey = partofKey + 1;
        
        gameScreen.choice1.setText("Continue");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "crosswalk2";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void door1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/door2.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("There's a room infront of you. Do you wish to enter the room?");
        
        gameScreen.choice1.setText("Enter");
        gameScreen.choice2.setText("Go back");
        gameScreen.choice3.setText("Wait");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "room1";
        game.nextPosition2 = "crosswalk";
        game.nextPosition3 = "Wait";
        game.nextPosition4 = "";       
    }
    
    public void room1() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Room1.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You found a part of a key! It seems to be broke in half. Maybe the other half is nearby...");
        
        partofKey = 1;

        gameScreen.choice1.setText("Go back");
        gameScreen.choice2.setText("Wait");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "crosswalk";
        game.nextPosition2 = "Wait";
        game.nextPosition3 = "";
        game.nextPosition4 = "";  
    }
    
    public void lose() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/Wait.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameScreen.mainTextArea.setText("You were engulfed by the fire.");
        JOptionPane.showMessageDialog(null, "<GAME OVER>");

        gameScreen.choice1.setText("Restart");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void ending() {
        
        gameScreen.mainImage = new ImageIcon("/Users/jeffereychen/NetBeansProjects/Final_Project/src/final_project/images/ending.png");
        gameScreen.mainImageLabel.setIcon(gameScreen.mainImage);
        
        gameTimer.stop();

        gameScreen.mainTextArea.setText("You were able to break out of the fire just in time!\n\nCongratulations!");
   
        gameScreen.choice1.setText("To Title");
        gameScreen.choice2.setText("");
        gameScreen.choice3.setText("");
        gameScreen.choice4.setText("");
    
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void toTitle() {
        
        defaultSetup();
        gameTimer.stop();
        vm.showTitleScreen();
        int newDelay = 1000;
        adjustGameDelay(newDelay);
    }  
    
}

