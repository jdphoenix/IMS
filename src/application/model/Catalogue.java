package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Data for the GUI is stored as a property and needs getters & setters
 * These return a property & the value within the property
 * Each model class follows the same structure
**/

public class Catalogue {

	private final IntegerProperty productID;
	private final StringProperty  productName;
	private final FloatProperty   productPrice;
	private final StringProperty  productPicture;
	private final StringProperty  productDescription;



// Default Constructor //

	public Catalogue() {
		this(0, null);
	}



// Constructor with Dummy Data for Testing

	public Catalogue(int productID, String productName) {
		this.productID   = new SimpleIntegerProperty(productID);
		this.productName = new SimpleStringProperty(productName);

		this.productPrice       = new SimpleFloatProperty(0.0f);
		this.productPicture     = new SimpleStringProperty();
		this.productDescription = new SimpleStringProperty();

	}



// Product ID //

	public int getProductID() {
		return productID.get();
	}

	public void setProductID(int newProductID) {
		this.productID.set(newProductID);
	}

	public IntegerProperty productIDProperty() {
		return productID;
	}



// Product Name //

	public String getProductName() {
		return productName.get();
	}

	public void setProductName(String newProductName) {
		this.productName.set(newProductName);
	}

	public StringProperty productNameProperty() {
		return productName;
	}



// Product Price //

	public float getProductPrice() {
		return productPrice.get();
	}

	public void setPrice(float newProductPrice) {
		this.productPrice.set(newProductPrice);
	}

	public FloatProperty productPriceProperty() {
		return productPrice;
	}



// Product Picture //

	public String getProductPicture() {
		return productPicture.get();
	}

	public void setProductPicture(String newProductPicture) {
		this.productPicture.set(newProductPicture);
	}

	public StringProperty productPictureProperty() {
		return productPicture;
	}



// Product Description //

	public String getProductDescription() {
		return productDescription.get();
	}
	public void setProductDescription(String newProductDescription) {
		this.productDescription.set(newProductDescription);
	}

	public StringProperty productDescriptionProperty() {
		return productDescription;
	}
}
