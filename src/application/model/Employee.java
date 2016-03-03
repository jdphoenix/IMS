package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Data for the GUI is stored as a property and needs getters & setters
 * These return a property & the value within the property
 * Each model class follows the same structure
**/

public class Employee {

	private final IntegerProperty employeeID;
	private final StringProperty  employeeName;
	private final BooleanProperty forklift;
	private final StringProperty  role;
	private final StringProperty  username;
	private final StringProperty  password;



// Default Constructor //

	public Employee() {
		this(0, null);
	}



// Constructor with Dummy Data for Testing //

	public Employee(int employeeID, String employeeName) {
		this.employeeID   = new SimpleIntegerProperty(employeeID);
		this.employeeName = new SimpleStringProperty(employeeName);

		this.forklift     = new SimpleBooleanProperty(false);
		this.role         = new SimpleStringProperty();
		this.username     = new SimpleStringProperty();
		this.password     = new SimpleStringProperty("1234");

	}



// Employee ID //

	public int getEmployeeID() {
		return employeeID.get();
	}

	public void setEmployeeID(int newEmployeeID) {
		this.employeeID.set(newEmployeeID);
	}

	public IntegerProperty employeeIDProperty() {
		return employeeID;
	}



// Employee Name //

	public String getEmployeeName() {
		return employeeName.get();
	}

	public void setEmployeeName(String newEmployeeName) {
		this.employeeName.set(newEmployeeName);
	}

	public StringProperty employeeNameProperty() {
		return employeeName;
	}



// Employee Forklift //

	public Boolean getForklift() {
		return forklift.get();
	}

	public void setForklift(Boolean newForklift) {
		this.forklift.set(newForklift);
	}

	public BooleanProperty employeeForklift() {
		return forklift;
	}



// Role //

	public String getRole() {
		return role.get();
	}

	public void setRole(String newRole) {
		this.role.set(newRole);
	}

	public StringProperty roleProperty() {
		return role;
	}



// Employee Username //

	public String getUsername() {
		return username.get();
	}

	public void setUsername(String newUsername) {
		this.username.set(newUsername);
	}

	public StringProperty usernameProperty() {
		return username;
	}



// Employee Password //

	public String getPassword() {
		return employeeName.get();
	}

	public void setPassword(String newPassword) {
		this.password.set(newPassword);
	}

	public StringProperty passwordProperty() {
		return password;
	}
}