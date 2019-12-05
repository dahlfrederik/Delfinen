package dataadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Member;
import model.Result;

/**
 *
 * @author Frederik, Thor, Josef, Hallur
 */
public class ResultMapper {
    private Connection con = DatabaseConnector.getConnection();
    private Statement stmt;
    

    public void insertResultToSQL(Result result){
        try {
            String SQL = "INSERT INTO results (name, date, comp, disc, result) VALUES (?, ?, ?, ?, ?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,result.getName());
            ps.setInt(2,result.getDate()); 
            ps.setBoolean(3, result.isCompetition());
            ps.setString(4,result.getDisciplin()); 
            ps.setDouble(5,result.getTime()); 
            
            ps.executeUpdate();
                        
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte resultater.");
        }
    }
    
    public ArrayList<Result> showResultsFromSQLComp(){
         ArrayList<Result> resultList = new ArrayList(); 
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.results WHERE comp = true");

            while (rs.next()) {
                String name = rs.getString("name");
                int date = rs.getInt("date");
                Boolean comp = rs.getBoolean("comp"); 
                String disc = rs.getString("disc"); 
                double time = rs.getDouble("result");
                
                Result result = new Result(name,time,comp,disc, date); 
                resultList.add(result);
            }
            
            System.out.println(resultList);
        } catch (SQLException ex) {
            System.out.println("Fejl, resultater blev ikke tilføjet til listen");
        }
        return resultList; 
    }
    
     public ArrayList<Result> showResultsFromSQLTraining(){
         ArrayList<Result> resultList = new ArrayList(); 
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.results WHERE comp = false");

            while (rs.next()) {
                String name = rs.getString("name");
                int date = rs.getInt("date");
                Boolean comp = rs.getBoolean("comp"); 
                String disc = rs.getString("disc"); 
                double time = rs.getDouble("result");
                
                Result result = new Result(name,time,comp,disc, date); 
                resultList.add(result);
            }
            
            System.out.println(resultList);
        } catch (SQLException ex) {
            System.out.println("Fejl, resultater blev ikke tilføjet til listen");
        }
        return resultList; 
    }
    
    public Result showResultForMember(Member member){
        Result result = null; 
        String name1 = member.getName(); 
        try {
            String SQL = "SELECT * FROM delfinen.results WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name1);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                double time = rs.getDouble("result");
                boolean comp = rs.getBoolean("comp");
                String disc = rs.getString("disc");
                int date = rs.getInt("date");
                
                result =  new Result(name, time, comp, disc, date);
            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println("Fejl, medlem blev ikke fundet");
        }
        return result;
    }
 
        public ArrayList<Result> showTop5Comp(String disciplin){
         ArrayList<Result> resultList = new ArrayList(); 
        try {
            stmt = con.createStatement();
            String SQL = "SELECT name AS TOP5, disc,result AS TID FROM delfinen.results WHERE comp = true AND disc = ? ORDER BY result ASC LIMIT 5";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, disciplin);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString("TOP5");
                String disc = rs.getString("disc"); 
                double time = rs.getDouble("TID");
                
                Result result = new Result(name,time,disc); 
                resultList.add(result);
            }
            System.out.println("SHOW TOP5 FROM COMP WITH DISCIPLIN: " + disciplin);
            
            System.out.println(resultList);
        } catch (SQLException ex) {
            System.out.println("Fejl, resultater blev ikke tilføjet til listen");
        }
        return resultList; 
    }
        
    public ArrayList<Result> showTop5Training(String disciplin) {
        ArrayList<Result> resultList = new ArrayList();
        try {
            stmt = con.createStatement();
            String SQL = "SELECT name AS TOP5, disc,result AS TID FROM delfinen.results WHERE comp = false AND disc = ? ORDER BY result ASC LIMIT 5";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, disciplin);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString("TOP5");
                String disc = rs.getString("disc"); 
                double time = rs.getDouble("TID");
                
                Result result = new Result(name,time,disc); 
                resultList.add(result);
            }
            System.out.println("SHOW TOP5 FROM TRAINING");
            System.out.println(resultList);
        } catch (SQLException ex) {
            System.out.println("Fejl, resultater blev ikke tilføjet til listen");
        }
        return resultList;
    }       
    
    public  ArrayList<Result> showTop5All(String disciplin) {
        ArrayList<Result> resultList = new ArrayList();
        try {
            stmt = con.createStatement();
            String SQL = "SELECT name AS TOP5, disc,result AS TID FROM delfinen.results WHERE disc = ? ORDER BY result ASC LIMIT 5";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, disciplin);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString("TOP5");
                String disc = rs.getString("disc"); 
                double time = rs.getDouble("TID");
                
                Result result = new Result(name,time,disc); 
                resultList.add(result);
            }
            System.out.println("SHOW TOP5 FROM TRAINING");
            System.out.println(resultList);
        } catch (SQLException ex) {
            System.out.println("Fejl, resultater blev ikke tilføjet til listen");
        }
        return resultList;
    }       
 }
