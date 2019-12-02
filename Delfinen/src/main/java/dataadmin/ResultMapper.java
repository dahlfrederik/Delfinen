

package dataadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.Result;

/**
 *
 * @author FrederikDahl
 */
public class ResultMapper {
    private Connection con = DatabaseConnector.getConnection();
    private Statement stmt;
    
    //antager han indtaster imens de svømmer
    public void insertResultToSQL(Result result){
        try {
            String SQL = "INSERT INTO results (name, date, comp, disc, result) VALUES (?, ?, ?, ?, ?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,result.getName());
            LocalDateTime now = LocalDateTime.now();
            Timestamp sqlNow = Timestamp.valueOf(now);
            ps.setTimestamp(2,sqlNow); 
            ps.setBoolean(3, result.isCompetition());
            ps.setString(4,result.getDisciplin()); 
            ps.setInt(5,result.getTime()); 
            
            ps.executeUpdate();
                        
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte resultater.");
        }
    }
    
    public static void main(String[] args) {
        Result result = new Result("Josef",10,true,"100m butterfly"); 
        ResultMapper rm = new ResultMapper(); 
        Result result2 = new Result("Josef",20,true,"200m butterfly"); 
        rm.insertResultToSQL(result);
        rm.insertResultToSQL(result2);
    }
}
