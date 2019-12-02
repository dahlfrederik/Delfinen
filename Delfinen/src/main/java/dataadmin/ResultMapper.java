

package dataadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Result;

/**
 *
 * @author FrederikDahl
 */
public class ResultMapper {
    private Connection con = DatabaseConnector.getConnection();
    private Statement stmt;
    
    public void insertTime(Result result){
        try {
            String SQL = "INSERT INTO members (name, phonenr, age, team, active, paystatus) VALUES (?, ?, ?, ?, ?, ?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,result.getName());
            ps.setBoolean(2, result.isCompetition());
            ps.setString(3,result.getDisciplin()); 
           
            ps.executeUpdate();
                        
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte tid.");
        }
    }
}
