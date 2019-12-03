

package model;

import java.time.LocalTime;

/**
 *
 * @author FrederikDahl
 */
public class Result {
    private String name, disciplin;
    private boolean competition;
    private int time; 
    private int date; 
    
    public Result(String name, int time, Boolean competition, String disciplin, int date){
        this.name = name;
        this.time = time;
        this.competition = competition; 
        this.disciplin = disciplin; 
        this.date = date; 
    }

    public Result(String name, int time, String disc) {
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "\n" + name + ", time: " + time + ", disciplin: "+ disciplin +"\n";
    }

    
    
    
}
