package casa.loma.game;

import java.util.LinkedList;

public class Player {
    private String name;
    private int healthBar = 100;
    private int writeUps;
    public  LinkedList <String> taskBar = new LinkedList<>();

    public Player(){
        name = "Player";
        healthBar = 100;
        writeUps = 0;
    }

    public Player(String name){
        this.name = name;
        healthBar = 100;
        writeUps = 0;
    }

    //Tasks and Stress affect health bar
    public void HBDecrease(){
        healthBar -= 10;
    }

    public int getHealthBar(){
        return healthBar;
    }

    public int getWriteUps(){
        return writeUps;
    }

    public String geName(){
        return name;
    }

    public boolean hasTask(){
        if(taskBar.size() == 0){
            return false;
        } else {
            return true;
        }
        
    }
}
