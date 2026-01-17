package final_project.FireMonster;

import final_project.SuperFire;

public class SneakyFire extends SuperFire{
    
    public SneakyFire() {
        
        name = "Sneaky Fire Boss";
        hp = 100;
        
        int i = new java.util.Random().nextInt(100)+1;
        
        if(i<30) {
            
            attack = 8;
            attackMessage = "Fire Dart";
        }
        else if (i>50) {
            
            attack = 5; 
            attackMessage = "Heat Wave";
        }    
        else {
            attack = 30;
            attackMessage = "Inferno Fury";
        }
    }
}