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

		if(validateLogin()) {
			selectView(2);

		} else {
			errorMsg.setText("Invalid username or password");
		}
	}

	private boolean validateLogin() {
		// retrive the username and password combos for login
		// compare them with the entries in the text/password fields
		// return true if they match
		// return false if they do not match

		return true;
	}

	// for now i am enumerating the roles from 1 to 4
	private boolean selectView(int role) {

		if(role < 1 || role > 4) {
			return false;
		} else {

			switch(role) {
				case 1:
					mainApp.showGenericOverview();
					break;
				case 2:
					mainApp.showSalesOverview();
					break;
				case 3:
					mainApp.showGenericOverview();
					break;
				case 4:
					mainApp.showGenericOverview();
					break;
				default:
					return false;
			}
		}

		return true;
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
