package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Hotel;
import ch.makery.address.view.HotelEditDialogController;
import ch.makery.address.view.HotelOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GothenburgHotels extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("GothenburgHotels");
		initRootLayout();
		showHotelOverview();
	}
	
	private ObservableList<Hotel> HotelData = FXCollections.observableArrayList();


	public GothenburgHotels() {
		HotelData.add(new Hotel("Best Western", "3", "4", "2km", "yes", "no", "yes", "no", "yes"));
		HotelData.add(new Hotel("Crown", "4", "3", "1km", "no", "yes", "yes", "no", "yes"));
		HotelData.add(new Hotel("Gotia Towers", "4", "5", "0.2km", "yes", "yes", "yes", "yes", "yes"));
		HotelData.add(new Hotel("Radison", "2", "3", "3km", "yes", "yes", "no", "no", "no"));
		HotelData.add(new Hotel("Clarion", "4", "4", "1km", "yes", "no", "no", "no", "yes"));
		HotelData.add(new Hotel("First Hotel G", "4", "3", "0.1km", "yes", "yes", "yes", "no", "yes"));
	}


	public ObservableList<Hotel> getHotelData() {
		return HotelData;
	}

	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GothenburgHotels.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public boolean showHotelEditDialog(Hotel Hotel) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GothenburgHotels.class.getResource("view/HotelEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();


			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Hotel");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);


			HotelEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setHotel(Hotel);
			

			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void showHotelOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GothenburgHotels.class.getResource("view/HotelOverview.fxml"));
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