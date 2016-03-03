package application.view;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PortalViewController {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label errorMsg;

	private boolean loginClicked = false;

	// Reference the main application
	private MainApp mainApp;

	public PortalViewController() {

	}

	@FXML
	private void initialize() {

	}


	@FXML
	private void handleLogin() {
		String user = username.getText();
		String pass = password.getText();

		System.out.println(user);
		System.out.println(pass);

		if(!validateLogin()) {
			errorMsg.setText(user + pass);
			

		} else {
			errorMsg.setText("Invalid username or password");
		}
	}

	private boolean validateLogin() {


		return false;
	}
	 /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
