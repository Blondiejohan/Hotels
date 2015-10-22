package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Hotel;
import ch.makery.address.view.HotelEditDialogController;
import ch.makery.address.view.HotelOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("GothenburgHotels");
		initRootLayout();
		showHotelOverview();
	}
	
	
	// This is where the database goes.
	private ObservableList<Hotel> HotelData = FXCollections.observableArrayList();
	
	//This is a temporary list.
	public App() {
		HotelData.add(new Hotel("Best Western", "3", "4", "2km", "yes", "no", "yes", "no", "yes"));
		HotelData.add(new Hotel("Crown", "4", "3", "1km", "no", "yes", "yes", "no", "yes"));
		HotelData.add(new Hotel("Gotia Towers", "4", "5", "0.2km", "yes", "yes", "yes", "yes", "yes"));
		HotelData.add(new Hotel("Radison", "2", "3", "3km", "yes", "yes", "no", "no", "no"));
		HotelData.add(new Hotel("Clarion", "4", "4", "1km", "yes", "no", "no", "no", "yes"));
		HotelData.add(new Hotel("First Hotel G", "4", "3", "0.1km", "yes", "yes", "yes", "no", "yes"));
	}

	// Also temporary.
	public ObservableList<Hotel> getHotelData() {
		return HotelData;
	}
	
	// Initiates the page where everything is showed.
	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showStage(){
	    primaryStage.show();
	}
	
	private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(App.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = primaryStage.getScene();
        if (scene == null) {
            scene = new Scene(page, 700, 450);
            scene.getStylesheets().add(App.class.getResource("demo.css").toExternalForm());
            primaryStage.setScene(scene);
        } else {
        	primaryStage.getScene().setRoot(page);
        }
        primaryStage.sizeToScene();
        return page;
    }
	
	// This brings up the "Edit Hotel" page.
	public boolean showHotelEdit(Hotel Hotel) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/HotelEditDialog.fxml"));
			AnchorPane HotelEdit = (AnchorPane)loader.load();

			
			rootLayout.setCenter(HotelEdit);

			Scene edit = new Scene(HotelEdit);
			primaryStage.setScene(edit);
			primaryStage.show();

			HotelEditDialogController controller = loader.getController();
			controller.setHotel(Hotel);
			controller.setPrimaryStage(getPrimaryStage());

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void showHotelOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/HotelOverview.fxml"));
			AnchorPane HotelOverview = (AnchorPane) loader.load();
			
			rootLayout.setCenter(HotelOverview);


			HotelOverviewController controller = loader.getController();
			controller.setGothenburgHotels(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}