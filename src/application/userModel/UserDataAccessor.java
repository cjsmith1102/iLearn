package application.userModel;
/**
 * Created by cjsmith1102 on 4/5/2016.
 */

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class UserDataAccessor {

    // in real life, use a connection pool....
    private Connection connection ;

    public UserDataAccessor(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public List<User> getPersonList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from person");
        ){
            List<User> personList = new ArrayList<>();
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email_address");
                User user = new User(firstName, lastName, email);
                personList.add(user);
            }
            return personList ;
        }
    }

    // other methods, eg. addPerson(...) etc
}
