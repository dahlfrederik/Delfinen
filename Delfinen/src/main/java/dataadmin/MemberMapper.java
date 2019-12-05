package dataadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Member;

/**
 *
 * @author Josef, Thor, Hallur og Frederik 
 */
public class MemberMapper {
       private Connection con = DatabaseConnector.getConnection();
       private Statement stmt;
    
       public void insertMember(Member member) {
        try {
            String SQL = "INSERT INTO members (name, phonenr, age, team, active, paystatus) VALUES (?, ?, ?, ?, ?, ?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,member.getName());
            ps.setInt(2, member.getNr());
            ps.setInt(3,member.getAge()); 
            ps.setString(4, member.getTeam());
            ps.setBoolean(5, member.isActive());
            ps.setBoolean(6, member.isPaystatus());
            ps.executeUpdate();
            
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            //Tager autoincrementet id fra DB og sætter værdien i member.
            member.setId(id);
            
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte medlem.");
        }
      }
       
        
     public ArrayList<Member> getMembers() {
        ArrayList<Member> memberList = new ArrayList();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.members");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int nr = rs.getInt("phonenr"); 
                int age = rs.getInt("age"); 
                String team = rs.getString("team"); 
                boolean active = rs.getBoolean("active"); 
                boolean paystatus = rs.getBoolean("paystatus"); 
                Member member = new Member(id,name,nr,age,team,active,paystatus);
                memberList.add(member);
            }
            System.out.println(memberList);
        } catch (SQLException ex) {
            System.out.println("Fejl, medlem blev ikke fundet");
        }
        return memberList;
    }
     
    public void deleteMember(int id){
        try {
            String SQL = "DELETE FROM members WHERE id = (?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id); 
            ps.execute();
            ps.close(); 
            
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte medlem.");
        }
    }
    
     public Member searchSpecificMember(int memberId) {
        Member member = null;
        try {
            con = DatabaseConnector.getConnection();
            String SQL = "SELECT * FROM delfinen.members WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, memberId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int nr = rs.getInt("phonenr"); 
                int age = rs.getInt("age"); 
                String team = rs.getString("team"); 
                boolean active = rs.getBoolean("active"); 
                boolean paystatus = rs.getBoolean("paystatus"); 
                member = new Member(id,name,nr,age,team,active,paystatus);
            }
        } catch (SQLException ex) {
            System.out.println("Fejl, medlem blev ikke fundet");
        }
        return member;
    }
     
     public ArrayList<Member> notPaid(){
         ArrayList<Member> notPaidList = new ArrayList(); 
         try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.members WHERE paystatus = 'false'");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int nr = rs.getInt("phonenr"); 
                int age = rs.getInt("age"); 
                String team = rs.getString("team"); 
                boolean active = rs.getBoolean("active"); 
                boolean paystatus = rs.getBoolean("paystatus"); 
                Member member = new Member(id,name,nr,age,team,active,paystatus);
                notPaidList.add(member);
            }
        } catch (SQLException ex) {
            System.out.println("Fejl, medlemmer i restance blev ikke tilføjet");
        }
         
         
         return notPaidList; 
     }

public ArrayList<Member> getMembersInfo() {
        ArrayList<Member> memberList = new ArrayList();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.members");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int nr = rs.getInt("phonenr"); 
                int age = rs.getInt("age"); 
                String team = rs.getString("team"); 
                boolean active = rs.getBoolean("active"); 
                boolean paystatus = rs.getBoolean("paystatus"); 
                Member member = new Member(id,name,nr,age,team,active,paystatus);
                memberList.add(member);
            }
            for (Member member : memberList) {
                System.out.println(member.printId());
            }
        } catch (SQLException ex) {
            System.out.println("Fejl, medlem blev ikke fundet");
        }
        return memberList;
    }

}