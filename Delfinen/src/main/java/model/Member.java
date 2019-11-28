package model;

/**
 *
 * @author FrederikDahl
 */
public class Member {
    private int id, age, nr; 
    private String name, team; 
    private boolean paystatus, active; 

    public Member(String name,int nr, int age, String team, boolean paystatus, boolean active) {
        this.nr = nr; 
        this.age = age;
        this.name = name;
        this.team = team;
        this.paystatus = paystatus;
        this.active = active;
    }

    
    
    public Member(int id, String name, int nr, int age, String team, boolean paystatus, boolean active) {
        this.id = id; 
        this.age = age;
        this.nr = nr; 
        this.name = name;
        this.team = team;
        this.paystatus = paystatus;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
    
    public boolean isPaystatus() {
        return paystatus;
    }

    public boolean isActive() {
        return active;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPaystatus(boolean paystatus) {
        this.paystatus = paystatus;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nMemberId: " + id + "\nName: " + name +  "\nAge: " + age +"\nTeam: " + team + "\nPaystatus: " + paystatus + "\nActive: " + active + "\n";
    }
}
