package casa.loma.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Room {
    private String name;
    private List<NPCs> npcList = new ArrayList<>();
    private int roomNum;
    private String about; //Description of each room 
    private Map<NPCs, Double> npcSCs; //NPC spawn chance
    private int[] neighbors; //Neigboring rooms (rooms you can exit to)

    public Room(String name, String about, int roomNum, int neighbors[]){
        this.name = name;
        this.about = about;
        this.roomNum = roomNum;
        // Initialize and copy the neighbors array
        this.neighbors = new int[neighbors.length];
         System.arraycopy(neighbors, 0, this.neighbors, 0, neighbors.length);
          // Initialize NPC-related data structures
        //this.npcSCs = new HashMap<>();
        // this.npcList = new ArrayList<>();

    }

    //setters and getters
    public void setRoomName(String name){
        this.name = name;
    }

    public void setAbout(String about){
        this.about = about;
    }

    public void setNeighbor(int neighbors[]){
        for(int i = 0; i < neighbors.length; i++){
            this.neighbors[i] = neighbors[i];
        } 
    }

    public void setRoomNum(int roomNum){
        this.roomNum = roomNum;
    }
    
    public String getRoomName(){
        return name;
    }

    public String getAbout(){
        return about;
    }

    public int []getNeighbor(){
        return neighbors;
    }

    public int getRoomNum(){
        return roomNum;
    }

    public void addNPCSpawnChance(NPCs npc, double spawnProbability) {
        npcSCs.put(npc, spawnProbability);
    }

    // Retrieve NPC array from CasaLomaGame
    public NPCs[] getNPCArray() {
        return CasaLomaGame.npcs; // Access the NPC array from CasaLomaGame
    }

    // Method to check if an NPC should spawn in the room
    public void spawnNPCs() {
        Random random = new Random();
        NPCs[] allNPCs = CasaLomaGame.getNPCsArray(); // Retrieve NPCs array from CasaLomaGame
    
        npcList.clear(); // Clear the list before spawning
        double totalLOI = 0.0;
    
        // Calculate the total likelihood of interaction for all NPCs
        for (NPCs npc : allNPCs) {
            totalLOI += npc.getLoi();
        }
    
        double randomValue = random.nextDouble() * totalLOI; // Generate a random value within the total LOI range
        double cumulativeProbability = 0.0;
    
        // Select one NPC based on their LOI
        for (NPCs npc : allNPCs) {
            cumulativeProbability += npc.getLoi();
            if (randomValue <= cumulativeProbability) {
                npcList.add(npc); // Add the selected NPC to the room
                break;
            }
        }
    }

       // Method to display NPC tasks or dialogu1es when player interacts with the room
       public void interactWithNPCs() {
        if (npcList.isEmpty()) {
            System.out.println("There are no NPCs in this room right now.");
        } else {
            NPCs npc = npcList.get(0); // Get the single NPC
            Random random = new Random();
            if (random.nextBoolean()) {
                System.out.println(npc.getName() + " has a task for you: " + npc.getRandomJobs());
            } else {
                System.out.println(npc.getName() + " says: " + npc.getRandomLines());
            }
        }
    }
    
}


