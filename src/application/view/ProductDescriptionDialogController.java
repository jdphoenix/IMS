package application.view;

import application.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProductDescriptionDialogController {

	@FXML
    private Label descriptionLabel;
	@FXML
	private Label nameLabel;

	private Product product;
    private Stage dialogStage;
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
     * Sets the description in the dialog.
     *
     * @param product
     */
    public void setDescription(Product product) {
        this.product = product;
        nameLabel.setText(product.getProductName());
        descriptionLabel.setText(product.getDescription());
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
     * Called when the user clicks Ok.
     */
    @FXML
    private void handleOk() {
        dialogStage.close();
    }



}
