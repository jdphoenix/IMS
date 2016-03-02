package application;

import java.io.IOException;

import application.model.Customer;
import application.view.CustomerEditDialogController;
import application.view.CustomerOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Customer> customerData = FXCollections.observableArrayList();

    public MainApp() {
        // Add some sample data
    	customerData.add(new Customer(1, "Muster"));
    	customerData.add(new Customer(2, "Mueller"));
    	customerData.add(new Customer(3, "Kurz"));
    	customerData.add(new Customer(4, "Meier"));
    	customerData.add(new Customer(5, "Meyer"));
    	customerData.add(new Customer(6, "Kunz"));
    	customerData.add(new Customer(7, "Best"));
    	customerData.add(new Customer(8, "Meier"));
    	customerData.add(new Customer(9, "Mueller"));
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dynaform Management Systemn Smug Duncan Goat Build 0.000001");
        this.primaryStage.getIcons().add(new Image("file:resources/images/Kitchen_Bold_Line_Color_Mix-23-128.png"));


        initRootLayout();

        showGenericOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * testing different layouts here
     */
    public void showGenericOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CustomerOverview.fxml"));
            AnchorPane userLogin = (AnchorPane)loader.load();

            // Set user login into the centre of root layout.
            rootLayout.setCenter(userLogin);

            // Give the controller access to the main app.
            CustomerOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showCustomerEditDialog(Customer customer) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CustomerEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Customer");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            CustomerEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCustomer(customer);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Returns the data as an observable list of Customers.
     * @return
     */
    public ObservableList<Customer> getCustomerData() {
        return customerData;
    }


    public static void main(String[] args) {
        launch(args);
    }
}