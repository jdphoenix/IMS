package application;

import java.io.IOException;

import application.model.Customer;
import application.view.CustomerEditDialogController;
import application.view.CustomerOverviewController;
import application.view.InventoryManagerOverviewController;
import application.view.PortalViewController;
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
        // add some sample data
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

    // automatically called when the program is launched
    @Override
    public void start(Stage primaryStage) {
    	// a stage is the container window
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dynaform Management Systemn Smug Duncan Goat Build 0.000001");
        // adds a cool icon
        this.primaryStage.getIcons().add(new Image("file:resources/images/Kitchen_Bold_Line_Color_Mix-23-128.png"));

        // this initialises the container layout, most other layouts inherit from this one
        initRootLayout();

        // here we would switch between the different layouts based on which department has logged in
        //
        //

        //showPortalView();
        showGenericOverview();


    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // load root layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPortalView() {
    	try {
    		// load view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PortalView.fxml"));
            AnchorPane portalPane = (AnchorPane)loader.load();

            // set user login into the centre of root layout
            rootLayout.setCenter(portalPane);


            // give the controller access to the main app
            PortalViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    public void showInventoryManagerOverview() {
    	try {
    		// load view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/InventoryManagerOverview.fxml"));
            AnchorPane pane = (AnchorPane)loader.load();

            // set user login into the centre of root layout
            rootLayout.setCenter(pane);


            // give the controller access to the main app
            InventoryManagerOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * testing different layouts here
     */
    public void showGenericOverview() {
        try {
            // load view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CustomerOverview.fxml"));
            AnchorPane genericPane = (AnchorPane)loader.load();

            // set view to the centre of root layout
            rootLayout.setCenter(genericPane);

            // give the controller access to the main app
            CustomerOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * testing dialog options
     */
    public boolean showCustomerEditDialog(Customer customer) {
        try {
            // load the fxml file and create a new stage for the popup dialog
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CustomerEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Customer");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // set the customer into the controller
            CustomerEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCustomer(customer);

            // show the dialog and wait until the user closes it
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