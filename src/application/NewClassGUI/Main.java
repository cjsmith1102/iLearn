package application.NewClassGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

   // DBConnection connect = new DBConnection();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        primaryStage.setTitle("iLearn");
        Scene rootScene = new Scene(root, 600, 380);
        primaryStage.setScene(rootScene);
        primaryStage.setResizable(false);
        primaryStage.show();

    //    connect.getData();



}


    public static void main(String[] args) {
        launch(args);
    }
}
