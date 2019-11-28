

package dataadmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Member;

/**
 *
 * @author FrederikDahl
 */
public class TeamMapper {
    private Connection con = DatabaseConnector.getConnection();
       private Statement stmt;
    
     //TODO HUSK AT SØRGE FOR AT FORMAND SKAL VÆLGE FRA EN LISTE SPECIFIKT. 
     public ArrayList<Member> getJunior() {
        ArrayList<Member> juniorList = new ArrayList();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.members WHERE team = 'Junior'");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int nr = rs.getInt("phonenr"); 
                int age = rs.getInt("age"); 
                String team = rs.getString("team"); 
                boolean active = rs.getBoolean("active"); 
                boolean paystatus = rs.getBoolean("paystatus"); 
                Member member = new Member(id,name,nr,age,team,active,paystatus);
                juniorList.add(member);
            }
            System.out.println(juniorList);
        } catch (SQLException ex) {
            System.out.println("Fejl, juniors blev ikke fundet");
        }
        return juniorList;
    }
    
     public ArrayList<Member> getSenior() {
        ArrayList<Member> seniorList = new ArrayList();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.members WHERE team = 'Senior'");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int nr = rs.getInt("phonenr"); 
                int age = rs.getInt("age"); 
                String team = rs.getString("team"); 
                boolean active = rs.getBoolean("active"); 
                boolean paystatus = rs.getBoolean("paystatus"); 
                Member member = new Member(id,name,nr,age,team,active,paystatus);
                seniorList.add(member);
            }
            System.out.println(seniorList);
        } catch (SQLException ex) {
            System.out.println("Fejl, seniors blev ikke fundet");
        }
        return seniorList;
    }
     
    
}
