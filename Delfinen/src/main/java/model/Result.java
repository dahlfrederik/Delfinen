package model;
/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class Result {
    private String name, disciplin;
    private boolean competition;
    private double time; 
    private int date; 
    
    public Result(String name, double time, Boolean competition, String disciplin, int date){
        this.name = name;
        this.time = time;
        this.competition = competition; 
        this.disciplin = disciplin; 
        this.date = date; 
    }

    public Result(String name, double time, String disc) {
        this.name = name;
        this.time = time;
        this.disciplin = disc; 
    }

    public int getDate() {
        return date;
    }
    
   public void setDate(int date) {
       this.date = date;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public boolean isCompetition() {
        return competition;
    }

    public void setCompetition(boolean competition) {
        this.competition = competition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "\n" + name + ", time: " + time + ", disciplin: "+ disciplin +"\n";
    }

    
    
}
