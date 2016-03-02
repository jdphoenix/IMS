package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import util.DateUtil;
import application.MainApp;
import application.model.Customer;


// Must be placed within the view package else the SceneBuilder won't find it

public class CustomerOverviewController {
	  @FXML
	    private TableView<Customer> customerTable;
	    @FXML
	    private TableColumn<Customer, String> idColumn;
	    @FXML
	    private TableColumn<Customer, String> fullNameColumn;

	    @FXML
	    private Label customerIDLabel;
	    @FXML
	    private Label fullNameLabel;
	    @FXML
	    private Label dateOfBirthLabel;
	    @FXML
	    private Label homeTeleLabel;
	    @FXML
	    private Label mobileTeleLabel;
	    @FXML
	    private Label creditLabel;
	    @FXML
	    private Label statusLabel;

	    // Reference to the main application.
	    private MainApp mainApp;

	    /**
	     * The constructor.
	     * The constructor is called before the initialize() method.
	     */
	    public CustomerOverviewController() {
	    }

	    /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */

	    @FXML
	    private void initialize() {
	        // Initialize the person table with the two columns.
	        idColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty().asString());
	        fullNameColumn.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());

	        // clear the details
	        showCustomerDetails(null);

	        // listen for selection changes and show a customers details when changed
	        customerTable.getSelectionModel().selectedItemProperty().addListener((
	        		observable, oldValue, newValue)->showCustomerDetails(newValue));
	    }

	    /**
	     * Fills all text fields to show details about the person.
	     * If the specified person is null, all text fields are cleared.
	     *
	     * @param person the person or null
	     */
	    private void showCustomerDetails(Customer customer) {
	        if (customer != null) {
	            // Fill the labels with info from the person object.
	            customerIDLabel.setText(Integer.toString(customer.getCustomerID()));
	            fullNameLabel.setText(customer.getFullName());
	            dateOfBirthLabel.setText(DateUtil.format(customer.getBirthday()));
	            homeTeleLabel.setText(customer.getHomeTeleNo());
	            mobileTeleLabel.setText(customer.getMobileTeleNo());
	            creditLabel.setText(Float.toString(customer.getCredit()));
	            statusLabel.setText(customer.getStatus());

	            // TODO: We need a way to convert the birthday into a String!
	            // birthdayLabel.setText(...);
	        } else {
	            // Person is null, remove all the text.
	        	customerIDLabel.setText("");
	        	fullNameLabel.setText("");
	        	dateOfBirthLabel.setText("");
	        	homeTeleLabel.setText("");
	        	mobileTeleLabel.setText("");
	        	creditLabel.setText("");
	        	statusLabel.setText("");
	        }
	    }


	    /**
	     * Called when the user clicks the new button. Opens a dialog to edit
	     * details for a new person.
	     */
	    @FXML
	    private void handleNewCustomer() {
	    	Customer tempCustomer = new Customer();
	        boolean okClicked = mainApp.showCustomerEditDialog(tempCustomer);
	        if (okClicked) {
	            mainApp.getCustomerData().add(tempCustomer);
	        }
	    }

	    /**
	     * Called when the user clicks the edit button. Opens a dialog to edit
	     * details for the selected person.
	     */
	    @FXML
	    private void handleEditCustomer() {
	    	Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
	        if (selectedCustomer != null) {
	            boolean okClicked = mainApp.showCustomerEditDialog(selectedCustomer);
	            if (okClicked) {
	                showCustomerDetails(selectedCustomer);
	            }

	        } else {
	            // Nothing selected.
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Customer Selected");
	            alert.setContentText("Please select a customer in the table.");

	            alert.showAndWait();
	        }
	    }

	    /**
	     * Called when the user clicks on the delete button.
	     */
	    @FXML
	    private void handleDeletePerson() {
	        int selectedIndex = customerTable.getSelectionModel().getSelectedIndex();
	        if(selectedIndex >= 0) {
	        	customerTable.getItems().remove(selectedIndex);
	        }
	        else {
	        	// no selection
	        	Alert alert = new Alert(AlertType.WARNING);
	        	alert.initOwner(mainApp.getPrimaryStage());
	        	alert.setTitle("No Selection");
	        	alert.setHeaderText("No Customer Selected");
	        	alert.setContentText("Please select a customer in the table.");

	        	alert.showAndWait();
	        }
	    }

	    /**
	     * Is called by the main application to give a reference back to itself.
	     *
	     * @param mainApp
	     */
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;

	        // Add observable list data to the table
	        customerTable.setItems(mainApp.getCustomerData());
	    }
}
