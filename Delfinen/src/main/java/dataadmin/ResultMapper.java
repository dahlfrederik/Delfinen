

package dataadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FrederikDahl
 */
public class ResultMapper {
    private Connection con = DatabaseConnector.getConnection();
    private Statement stmt;
    
    public void insertTime(){
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
                        
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte tid.");
        }
    }
}
