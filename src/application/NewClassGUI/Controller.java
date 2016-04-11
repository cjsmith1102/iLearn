package application.NewClassGUI;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.time.temporal.Temporal;

import application.DBConnect;

public class Controller {
	
	private DBConnect con;
	private String host = "jdbc:mysql://localhost/ilearn";
	private String username = "root";
	private String password = "";
	public Button SubmitButton;
	public ComboBox<String> CourseOption;
	public ComboBox<String> InstructorOption;
	public ComboBox<String> LocationOption;
	public ComboBox<String> TermOption;
	public ComboBox<String> StartTimeOption;
	public ComboBox<String> EndTimeOption;

	
	public void onSubmit(){
		SubmitButton.setText("HELLO WORLD");
		con = DBConnect.getInstance(host, username, password);
		String title = CourseOption.getValue();
		String instructor = InstructorOption.getValue();
		String location = LocationOption.getValue();
		String term = TermOption.getValue();
		String start = StartTimeOption.getValue();
		String end = EndTimeOption.getValue();
		con.insertClass(title, location, instructor, 0, start, end, term);
		System.out.println("Course: " + title);
		System.out.println("Instructor: " + instructor);
		System.out.println("Location: " + location);
		System.out.println("Term: " + term);
		System.out.println("Start Time: " + start);
		System.out.println("End Time: " + end);

	}
}
