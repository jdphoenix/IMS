package application.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Data for the gui is stored as a property and needs getters that return a
 * property and the value within the property, also a setter for each. Each model
 * class follows the same structure.
**/
public class Customer {

	private final IntegerProperty customerID;
    private final StringProperty fullName;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty homeTeleNo;
    private final StringProperty mobileTeleNo;
    private final FloatProperty credit;
    private final StringProperty status;



    // default constructor
    public Customer() {
        this(0, null);
    }

    // constructor with initial data
    public Customer(int id, String fullName) {
        this.customerID = new SimpleIntegerProperty(id);
        this.fullName = new SimpleStringProperty(fullName);

        // dummy data for testing
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.homeTeleNo = new SimpleStringProperty("123456789");
        this.mobileTeleNo = new SimpleStringProperty("987654321");
        this.credit = new SimpleFloatProperty(10000);
        this.status = new SimpleStringProperty("ActiveT");



    }

    // id //
	public int getCustomerID() {
		return customerID.get();
	}

	public void setCustomerID(int customerID) {
		this.customerID.set(customerID);
	}

	public IntegerProperty customerIDProperty() {
		return customerID;
	}

	// full name //
	public String getFullName() {
		return fullName.get();
	}

	public void setFullName(String fullName) {
		this.fullName.set(fullName);
	}

	public StringProperty fullNameProperty() {
		return fullName;
	}

	// date of birth //
	public LocalDate getBirthday() {
		return birthday.get();
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday.set(birthday);
	}

	public ObjectProperty<LocalDate> birthdayProperty() {
		return birthday;
	}

	// home telephone number //
	public String getHomeTeleNo() {
		return homeTeleNo.get();
	}

	public void setHomeTeleNo(String homeTeleNo) {
		this.homeTeleNo.set(homeTeleNo);
	}

	public StringProperty homeTeleProperty() {
		return homeTeleNo;
	}

	// mobile telephone number //
	public String getMobileTeleNo() {
		return mobileTeleNo.get();
	}

	public void setMobileTeleNo(String mobileTeleNo) {
		this.mobileTeleNo.set(mobileTeleNo);
	}

	public StringProperty mobileTeleNoProperty() {
		return mobileTeleNo;
	}

	// credit //
	public float getCredit() {
		return credit.get();
	}

	public void setCredit(float credit) {
		this.credit.set(credit);
	}

	public FloatProperty creditProperty() {
		return credit;
	}

	// status //
	public String getStatus() {
		return status.get();
	}

	public void setStatus(String status) {
		this.status.set(status);
	}

	public StringProperty statusProperty() {
		return status;
	}

}
