package application.view;

import java.awt.Label;

import application.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.DateUtil;

public class SearchDialogController {

    @FXML
    private TextField searchField;

    private Stage searchStage;
    private Product product;
    private boolean searchClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage searchStage) {
        this.searchStage = searchStage;
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isSearchClicked() {
        return searchClicked;
    }

    private void handleSearch() {
    	 if (isInputValid()) {
    		
    		 String search = searchField.getText();
    		 // goto someclass.getstock(Search)
    		 
    		 int retur = 2;
    		 
    		 
         	

             searchClicked = true;
             searchStage.close();
         }

    }

    private boolean isInputValid() {
    	String errorMessage = "";

    	if (searchField.getText() == null || searchField.getText().length() == 0) {
    		errorMessage += "No valid ID!\n";
    	}
    	
    	 if (errorMessage.length() == 0) {
             return true;
    	 } else {
             // Show the error message.
             Alert alert = new Alert(AlertType.ERROR);
             alert.initOwner(searchStage);
             alert.setTitle("Invalid ID");
             alert.setHeaderText("Please enter a valid ID");
             alert.setContentText(errorMessage);

             alert.showAndWait();

             return false;
         }
    }


}
