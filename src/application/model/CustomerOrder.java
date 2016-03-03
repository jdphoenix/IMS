package application.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
* Data for the GUI is stored as a property and needs getters & setters
* These return a property & the value within the property
* Each model class follows the same structure
**/

public class CustomerOrder {

	private final IntegerProperty customerOrderID;
	private final IntegerProperty customerID;
	private final ObjectProperty<LocalDate> datePlaced;
 private final ObjectProperty<LocalDate> dateDispatched;
 private final StringProperty orderStatus;



//Default Constructor //

 public CustomerOrder() {
 	this(0);
 }



//Constructor with Dummy Data for Testing

 public CustomerOrder(int id) {
 	this.customerOrderID = new SimpleIntegerProperty(id);

 	this.customerID      = new SimpleIntegerProperty(-1);
 	this.datePlaced      = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 10, 20));
 	this.dateDispatched  = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 10, 22));
 	this.orderStatus     = new SimpleStringProperty("Dispatched");

 }



//Customer Order ID //

 public int getCustomerOrderID() {
 	return customerOrderID.get();
 }

 public void setCustomerOrderID(int newCustomerOrderID) {
 	this.customerOrderID.set(newCustomerOrderID);
 }

 public IntegerProperty customerOrderIDProperty() {
 	return customerOrderID;
 }



//Customer ID //

 public int getcustomerID() {
 	return customerID.get();
 }

 public void setcustomerID(int newcustomerID) {
 	this.customerID.set(newcustomerID);
 }

 public IntegerProperty customerIDProperty() {
 	return customerID;
 }



//Date Placed //

 public LocalDate getDatePlaced() {
 	return datePlaced.get();
 }

 public void setDatePlaced(LocalDate datePlaced) {
 	this.datePlaced.set(datePlaced);
 }

 public ObjectProperty<LocalDate> datePlacedProperty() {
 	return datePlaced;
 }



//Date Dispatched //

 public LocalDate getDateDispatched() {
 	return dateDispatched.get();
 }

 public void setDateDispatched(LocalDate dateDispatched) {
 	this.dateDispatched.set(dateDispatched);
 }

 public ObjectProperty<LocalDate> dateDispatchedProperty() {
 	return dateDispatched;
 }



//Order Status //

 public String getOrderStatus() {
 	return orderStatus.get();
 }

 public void setOrderStatus(String orderStatus) {
 	this.orderStatus.set(orderStatus);
 }

 public StringProperty orderStatusProperty() {
 	return orderStatus;
 }


}