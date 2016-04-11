package application.userModel;

/**
 * Created by cjsmith1102 on 4/5/2016.
 */
import javafx.application.Application;
import javafx.scene.control.TableView ;
import javafx.scene.control.TableColumn ;
import javafx.scene.control.cell.PropertyValueFactory ;
import javafx.scene.layout.BorderPane ;
import javafx.scene.Scene ;
import javafx.stage.Stage ;

import application.DBConnect;

public class UserTableApp extends Application {
    private DBConnect DBCon ;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	String host = "jdbc:mysql://localhost/ilearn";
    	String username = "root";
    	String password = "";
    	
        DBCon = DBConnect.getInstance(host, username, password); // provide driverName, dbURL, user, password...

        TableView<User> userTable = new TableView<User>();
        TableColumn<User, String> firstNameCol = new TableColumn<>("First Name");
        //firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<User, String> lastNameCol = new TableColumn<>("Last Name");
        //lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<User, String> emailCol = new TableColumn<>("Email");
        //emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        userTable.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        userTable.getItems().addAll(DBCon.getUsers());

        BorderPane root = new BorderPane();
        root.setCenter(userTable);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        if (DBCon != null) {
            DBCon.shutdown();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
