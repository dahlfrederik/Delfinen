

package model;

import java.sql.Date;

/**
 *
 * @author FrederikDahl
 */
public class Result {
    private String name, disciplin;
    private boolean competition;
    private int time; 
    private Date date; 
    
    public Result(String name, int time, Boolean competition, String disciplin){
        this.name = name;
        this.time = time;
        this.competition = competition; 
        this.disciplin = disciplin; 
    }

    public Date getDate() {
        return date;
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
        return "Result for: " + "name: " + name + ", competition: " + competition + ", time: " + time + '}';
    }
    
    
}
