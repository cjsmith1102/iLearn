package iLearn;

/**
 * Created by cjsmith1102 on 4/5/2016.
 */
import javafx.application.Application ;
import javafx.scene.control.TableView ;
import javafx.scene.control.TableColumn ;
import javafx.scene.control.cell.PropertyValueFactory ;
import javafx.scene.layout.BorderPane ;
import javafx.scene.Scene ;
import javafx.stage.Stage ;

public class PersonTableApp extends Application {
    private PersonDataAccessor dataAccessor ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        dataAccessor = new PersonDataAccessor(driverName, dbURL, user, password); // provide driverName, dbURL, user, password...

        TableView<Person> personTable = new TableView<>();
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        personTable.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        personTable.getItems().addAll(dataAccessor.getPersonList());

        BorderPane root = new BorderPane();
        root.setCenter(personTable);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        if (dataAccessor != null) {
            dataAccessor.shutdown();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
