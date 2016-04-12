package application.UserModel;

import application.DBConnect;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {

	private DBConnect con;
	private String host = "jdbc:mysql://localhost/ilearn";
	private String username = "root";
	private String password = "";
	
	@FXML
	public Button SubmitButton;
	public Button CancelButton;
	
	public TextField FirstName;
	public TextField LastName;
	public TextField Address;
	public TextField Email;
	public TextField PhoneNumber;
	public TextField Password;
	public ComboBox<String> UserType;


	public void onSubmit(){
		con = DBConnect.getInstance(host, username, password);
		String firstName = FirstName.getText();
		String lastName = LastName.getText();
		String address = Address.getText();
		String email = Email.getText();
		String phone = PhoneNumber.getText();
		String password = Password.getText();
		int userType = 0;
		String type = UserType.getValue();
		if(type.equalsIgnoreCase("student")){
			userType = 1;
		}
		else if(type.equalsIgnoreCase("teacher")){
			userType = 2;
		}
		con.insertUser(firstName, lastName, address, email, phone, password, userType);
		System.out.println("SUCCESS");
	}
	
	public void onCancel(){
		//System.out.println("TODO");
		System.exit(0);
	}
}
