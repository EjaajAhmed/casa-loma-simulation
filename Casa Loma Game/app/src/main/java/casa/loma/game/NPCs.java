package casa.loma.game;

import java.util.ArrayList;
import java.util.Random;

//Class to create objects of NPCs
/*
4 Main NPCs:
    Bob
    Alejandro
    Guest Service Worker
    Security
*/
public class NPCs{
    private String name;
    private double loi; //Likelyhood of interaction (loi)
    private ArrayList<String> jobs = new ArrayList<>();
    private ArrayList<String> lines = new ArrayList<>();

    public NPCs(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setLoi(double loi){
        this.loi = loi;
    }

    public double getLoi(){
        return loi;
    }

    public void setJobs(String job){
        jobs.add(job);
    }

    public void setLines(String line){
        lines.add(line);
    }

    public String getRandomJobs(){
        Random ran = new Random();
        int random = ran.nextInt(jobs.size());
        String temp = jobs.get(random);
        return temp;
    }

    public String getRandomLines(){
        Random ran = new Random();
        int random = ran.nextInt(lines.size());
        String temp = lines.get(random);
        return temp;
    }
 

}
