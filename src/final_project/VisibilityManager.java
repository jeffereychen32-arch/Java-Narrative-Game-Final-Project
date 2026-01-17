package final_project;
    
public class VisibilityManager {
    
    GameScreen gameScreen;
    
    public VisibilityManager(GameScreen g) {
    
        gameScreen = g;
    }
    
    public void showTitleScreen() {
        
        gameScreen.blockTitlePanel.setVisible(true);
        gameScreen.startButtonPanel.setVisible(true);
        
        gameScreen.IntroTextPanel.setVisible(false);
        gameScreen.decisionButtonPanel.setVisible(false);
       
        gameScreen.MainTextPanel.setVisible(false);
        gameScreen.mainImagePanel.setVisible(false);
        gameScreen.choiceButtonPanel.setVisible(false);
        gameScreen.playerPanel.setVisible(false);
        gameScreen.healthBarPanel.setVisible(false);

    }
    
    public void showIntroScreen() {
        
        gameScreen.blockTitlePanel.setVisible(false);
        gameScreen.startButtonPanel.setVisible(false);
        
        gameScreen.IntroTextPanel.setVisible(true);
        gameScreen.decisionButtonPanel.setVisible(true);
        
        gameScreen.MainTextPanel.setVisible(false);
        gameScreen.mainImagePanel.setVisible(false);
        gameScreen.choiceButtonPanel.setVisible(false);
        gameScreen.playerPanel.setVisible(false);
        gameScreen.healthBarPanel.setVisible(false);

    }
    
    public void titletoEncounter() {
        
        gameScreen.blockTitlePanel.setVisible(false);
        gameScreen.startButtonPanel.setVisible(false);
        
        gameScreen.IntroTextPanel.setVisible(false);
        gameScreen.decisionButtonPanel.setVisible(false);

        gameScreen.MainTextPanel.setVisible(true);
        gameScreen.mainImagePanel.setVisible(true);
        gameScreen.choiceButtonPanel.setVisible(true);
        gameScreen.playerPanel.setVisible(true);
        gameScreen.healthBarPanel.setVisible(true);

    } 
}

