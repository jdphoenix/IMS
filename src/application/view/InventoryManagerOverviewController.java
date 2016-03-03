package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import util.DateUtil;
import application.MainApp;
import application.model.Customer;

// Must be placed within the view package else the SceneBuilder won't find it

public class InventoryManagerOverviewController {
	 @FXML
	 private TableView<Customer> productTable;
	 @FXML
	 private TableColumn<Customer, String> idColumn;
	 @FXML
	 private TableColumn<Customer, String> nameColumn;
	
	
	@FXML
    private Label productID;
    @FXML
    private Label name;
    @FXML
    private Label quantity;
    @FXML
    private Label price;
    @FXML
    private Label status;
  
	
	// Reference to the main application.
    private MainApp mainApp;
	
	  /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
