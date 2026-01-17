
package final_project.FireMonster;

import final_project.SuperFire;

public class UndefeatedFire extends SuperFire{
    
    public UndefeatedFire() {
        
    name = "Undefeated Fire";
    hp = 80;
    
    int i = new java.util.Random().nextInt(50)+1;
        
        if(i<5) {
            
            attack = 1000000;
            attackMessage = "Pyrokinesis";
        }
        else {
            attack = 3;
            attackMessage = "Heat Wave";
        }
    }
}
