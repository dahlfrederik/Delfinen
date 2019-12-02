

package model;

/**
 *
 * @author FrederikDahl
 */
public class Result {
    private String name, competition;
    private int time; 
    
    public Result(String name, int time, String competition){
        this.name = name;
        this.time = time;
        this.competition = competition; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
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
