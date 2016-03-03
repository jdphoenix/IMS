package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Data for the gui is stored as a property and needs getters that return a
 * property and the value within the property, also a setter for each. Each model
 * class follows the same structure.
**/

public class Product {

	private final IntegerProperty productID;
	private final StringProperty name;
	private final IntegerProperty quantity;
	private final FloatProperty price;
	private final BooleanProperty status;

	// default constructor

	public Product() {
		this(0, null);
	}

	// constructor with initial dummy data
	public Product(int productID, String name) {
		this.productID = new SimpleIntegerProperty(productID);
		this.name = new SimpleStringProperty(name);

		this.quantity = new SimpleIntegerProperty(0);
		this.price = new SimpleFloatProperty(0.0f);
		this.status = new SimpleBooleanProperty(false);

	}

	// ID //
	public int getProductID() {
		return productID.get();
	}

	public void setProductID(int newProductID) {
		this.productID.set(newProductID);
	}

	public IntegerProperty productIDProperty() {
		return productID;
	}

	// name //
	public String getProductName() {
		return name.get();
	}

	public void setProductName(String newName) {
		this.name.set(newName);
	}

	public StringProperty productNameProperty() {
		return name;
	}

	// quantity //
	public int getQuantity() {
		return quantity.get();
	}

	public void setQuantity(int newQuantity) {
		this.quantity.set(newQuantity);
	}

	public IntegerProperty quantityProperty() {
		return quantity;
	}

	// price //
	public float getPrice() {
		return price.get();
	}

	public void setPrice(float newPrice) {
		this.price.set(newPrice);
	}

	public FloatProperty priceProperty() {
		return price;
	}

	// status //
	public Boolean getStatus() {
		return status.get();
	}

	public void setStatus(Boolean status) {
		this.status.set(status);
	}

	public BooleanProperty statusProperty() {
		return status;
	}

}
