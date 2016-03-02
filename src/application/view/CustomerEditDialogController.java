package application.view;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.model.Customer;
import util.DateUtil;


public class CustomerEditDialogController {

    @FXML
    private TextField IDField;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField dateOfBirthField;
    @FXML
    private TextField homeTeleNoField;
    @FXML
    private TextField mobileTeleNoField;
    @FXML
    private TextField creditField;
    @FXML
    private TextField statusField;


    private Stage dialogStage;
    private Customer customer;
    private boolean okClicked = false;

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
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;

        IDField.setText(Integer.toString(customer.getCustomerID()));
        fullNameField.setText(customer.getFullName());
        dateOfBirthField.setText(DateUtil.format(customer.getBirthday()));
        dateOfBirthField.setPromptText("dd.mm.yyyy");
        homeTeleNoField.setText(customer.getHomeTeleNo());
        mobileTeleNoField.setText(customer.getMobileTeleNo());
        creditField.setText(Float.toString(customer.getCredit()));
        statusField.setText(customer.getStatus());

    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	customer.setCustomerID(Integer.parseInt(IDField.getText()));
        	customer.setFullName(fullNameField.getText());
        	customer.setBirthday(DateUtil.parse(dateOfBirthField.getText()));
        	customer.setHomeTeleNo(homeTeleNoField.getText());
        	customer.setMobileTeleNo(mobileTeleNoField.getText());
        	customer.setCredit(Float.parseFloat(creditField.getText()));
        	customer.setStatus(statusField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (IDField.getText() == null || IDField.getText().length() == 0) {
            errorMessage += "No valid ID!\n";
        }
        if (fullNameField.getText() == null || fullNameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }

        if (dateOfBirthField.getText() == null || dateOfBirthField.getText().length() == 0) {
            errorMessage += "No valid date of birth!\n";
        } else {
            if (!DateUtil.validDate(dateOfBirthField.getText())) {
                errorMessage += "No valid date of birth. Use the format dd.mm.yyyy!\n";
            }
        }

        if (homeTeleNoField.getText() == null || homeTeleNoField.getText().length() == 0) {
            errorMessage += "No valid home number!\n";
        }

        if (mobileTeleNoField.getText() == null || mobileTeleNoField.getText().length() == 0) {
            errorMessage += "No valid mobile number!\n";
        }

        if (creditField.getText() == null || creditField.getText().length() == 0) {
            errorMessage += "No valid credit entry!\n";
        } else {
            // try to parse the credit into a float.
            try {
                Float.parseFloat(creditField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Not a valid credit entry, must be a float and less than 10000)!\n";
            }
        }

        if (statusField.getText() == null || statusField.getText().length() == 0) {
            errorMessage += "No valid status!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}