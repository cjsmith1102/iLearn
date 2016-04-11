package application.userModel;
/**
 * Created by cjsmith1102 on 4/5/2016.
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName");
    public StringProperty firstNameProperty() {
        return firstName ;
    }
    public final String getFirstName() {
        return firstNameProperty().get();
    }
    public final void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    private final StringProperty lastName = new SimpleStringProperty(this, "lastName");
    public StringProperty lastNameProperty() {
        return lastName ;
    }
    public final String getLastName() {
        return lastNameProperty().get();
    }
    public final void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }

    private final StringProperty email = new SimpleStringProperty(this, "email");
    public StringProperty emailProperty() {
        return email ;
    }
    public final String getEmail() {
        return emailProperty().get();
    }
    public final void setEmail(String email) {
        emailProperty().set(email);
    }

    public User() {}

    public User(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

}
