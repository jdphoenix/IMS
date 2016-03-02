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



}
