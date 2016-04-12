package application;

import java.sql.*;
import java.util.ArrayList;


public class DBConnect{

    private Connection con;
    private PreparedStatement statement;
    private ResultSet result;
    private static DBConnect DBCon;

    private DBConnect(String host, String username, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, username, password);
            //System.out.println("\n======================\nConnected Successfully\n======================\n");
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static DBConnect getInstance(String host, String username, String password){
        if(DBCon == null){
            DBCon = new DBConnect(host, username, password);
        }
        return DBCon;
    }

    public void shutdown(){
    	try{
            if (con != null) {
                con.close();
            }
    	}
        catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public ResultSet select(String query){
        try{
            statement = con.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return result;
    }

    public void deleteUser(String username){
        try{
            statement = con.prepareStatement("DELETE FROM users WHERE Fname LIKE ?");
            statement.setString(1, username);
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void deleteClass(String title, String instructor){
        try{
            statement = con.prepareStatement("DELETE FROM classes WHERE Title LIKE ? AND Instructor LIKE ?");
            statement.setString(1, title);
            statement.setString(2, instructor);
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public boolean insertClass(String title, String location, String instructor, int capacity, String start, String end, String term){
        try{
            statement = con.prepareStatement("INSERT INTO classes(Title, Location, Instructor, Capacity, StartTime, EndTime, Term) VALUES(?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, location);
            statement.setString(3, instructor);
            statement.setInt(4, capacity);
            statement.setString(5, start);
            statement.setString(6, end);
            statement.setString(7, term);

            statement.execute();
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return true;
    }

    public boolean insertUser(String firstName, String lastName, String address, String email, String phoneNumber, String password, int superuser){
        try{
            statement = con.prepareStatement("INSERT INTO users(Fname, Lname, Address, Email, Phone, Password, Super) VALUES(?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setString(6, password);
            statement.setInt(7, superuser);
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return true;
    }

}
