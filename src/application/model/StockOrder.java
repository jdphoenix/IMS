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

public class StockOrder {

	private final IntegerProperty stockOrderID;
	private final ObjectProperty<LocalDate> datePlaced;
    private final ObjectProperty<LocalDate> dateRecieved;
    private final StringProperty orderStatus;
    private final IntegerProperty supplierID;

    // default constructor

    public StockOrder() {
    	this(0);
    }

    public StockOrder(int id) {
    	this.stockOrderID = new SimpleIntegerProperty(id);

        // dummy data for testing
    	this.datePlaced = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 10, 20));
    	this.dateRecieved = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 10, 20));
    	this.orderStatus = new SimpleStringProperty("Waiting");
    	this.supplierID = new SimpleIntegerProperty(-1);
    }

    // stock order id //
    public int getStockOrderID() {
    	return stockOrderID.get();
    }

    public void setStockOrderID(int newStockOrderID) {
    	this.stockOrderID.set(newStockOrderID);
    }

    public IntegerProperty stockOrderIDProperty() {
    	return stockOrderID;
    }

    // date placed //
    public LocalDate getDatePlaced() {
    	return datePlaced.get();
    }

    public void setDatePlaced(LocalDate datePlaced) {
    	this.datePlaced.set(datePlaced);
    }

    public ObjectProperty<LocalDate> datePlacedProperty() {
    	return datePlaced;
    }

    // date received //
    public LocalDate getDateRecieved() {
    	return dateRecieved.get();
    }

    public void setDateRecieved(LocalDate dateRecieved) {
    	this.dateRecieved.set(dateRecieved);
    }

    public ObjectProperty<LocalDate> dateRecievedProperty() {
    	return dateRecieved;
    }

    // order status //

    public String getOrderStatus() {
    	return orderStatus.get();
    }

    public void setOrderStatus(String orderStatus) {
    	this.orderStatus.set(orderStatus);
    }

    public StringProperty orderStatusProperty() {
    	return orderStatus;
    }

    // supplier id //
    public int getSupplierID() {
    	return supplierID.get();
    }

    public void setSupplierID(int newSupplierID) {
    	this.supplierID.set(newSupplierID);
    }

    public IntegerProperty supplierIDProperty() {
    	return supplierID;
    }



}
