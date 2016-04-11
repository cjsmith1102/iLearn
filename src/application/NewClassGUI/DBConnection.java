package application.NewClassGUI;
import java.sql.*;

/**
 * Created by Pinal on 4/9/2016.
 */
public class DBConnection {

    private Connection connectObj;
    private Statement stObj;
    private ResultSet rsObj;

    public DBConnection()
    {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connectObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            stObj = connectObj.createStatement();

        }catch (Exception ex) {System.out.println("Error: " + ex);}
    } // End Constructor


    public void getData(){

        try {
            String query = "Select * from persons";
            rsObj = stObj.executeQuery(query);
            System.out.println("Records from DB");

                while (rsObj.next())
                {
                    String name = rsObj.getString("name");
                    String age = rsObj.getString("age");
                    String weight = rsObj.getString("weight");
                    String ethnicity = rsObj.getString("ethnicity");

                    System.out.println("Name: " + name + " Age: " + age + " Wight: " + weight + " Ethnicity: " + ethnicity);

                }

        }catch (Exception ex){System.out.println(ex);}
    }
}
