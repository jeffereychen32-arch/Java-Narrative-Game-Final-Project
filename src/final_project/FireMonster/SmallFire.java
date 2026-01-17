package final_project.FireMonster;

import final_project.SuperFire;

public class SmallFire extends SuperFire {
    
    public SmallFire() {
        
        name = "Small Fire";
        hp = 10;
        
        int i = new java.util.Random().nextInt(50)+1;
        
        if(i<30) {
            
            attack = 1;
            attackMessage = "Fire Spit";
        }
        else {
            attack = 3;
            attackMessage = "Spark";
        }
    }
}
