package application.view;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import application.MainApp;
import application.model.Customer;
import application.model.Product;

// Must be placed within the view package else the SceneBuilder won't find it

public class SalesOverviewController {
	 @FXML
	 private TableView<Product> productTable;
	 @FXML
	 private TableColumn<Product, String> idColumn;
	 @FXML
	 private TableColumn<Product, String> nameColumn;


	@FXML
    private Label productIDLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label statusLabel;

	// Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public SalesOverviewController() {

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

    @FXML
    private void initialize() {
        // Initialize the product table with the two columns.
        idColumn.setCellValueFactory(cellData -> cellData.getValue().productIDProperty().asString());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());

        // clear the details
        showProductDetails(null);

        // listen for selection changes and show a products details when changed
        productTable.getSelectionModel().selectedItemProperty().addListener((
        		observable, oldValue, newValue)->showProductDetails(newValue));
    }

    @FXML
    private void showDescription() {
    	Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            boolean okClicked = mainApp.showProductDescriptionDialog(selectedProduct);
            if (okClicked) {
                // do nothing
            }

        } else {
            // nothing selected
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a product in the table.");

            alert.showAndWait();
        }

    }

    /**
     * Fills all text fields to show details about the product.
     * If the specified product is null, all text fields are cleared.
     *
     */
    private void showProductDetails(Product product) {
        if (product != null) {
            // Fill the labels with info from the person object.
            productIDLabel.setText(Integer.toString(product.getProductID()));
            nameLabel.setText(product.getProductName());
            quantityLabel.setText(Integer.toString(product.getQuantity()));
            priceLabel.setText(Float.toString(product.getPrice()));
            statusLabel.setText(Boolean.toString(product.getStatus()));


        } else {
            // Person is null, remove all the text.
        	productIDLabel.setText("");
        	nameLabel.setText("");
        	quantityLabel.setText("");
        	priceLabel.setText("");
        	statusLabel.setText("");
        }
    }


    @FXML
    private void handleLogout() {
    	// may want to show a dialog confirmation box first
    	mainApp.showPortalView();
    }

	  /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        productTable.setItems(mainApp.getProductData());

    }
}
