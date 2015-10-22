package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.App;
import ch.makery.address.model.Hotel;

public class HotelOverviewController {
	
	@FXML
	private TableView<Hotel> HotelTable;
	@FXML
	private TableColumn<Hotel, String> HotelNameColumn;
	@FXML
	private Label HotelNameLabel;
	@FXML
	private Label StarsLabel;
	@FXML
	private Label PopularityLabel;
	@FXML
	private Label DistanceLabel;
	@FXML
	private Label BreakfastLabel;
	@FXML
	private Label BarLabel;
	@FXML
	private Label GymLabel;
	@FXML
	private Label PetsLabel;
	@FXML
	private Label PoolLabel;


	private App App;
	
	private void showHotelDetails(Hotel Hotel) {
		if (Hotel != null) {
			
			HotelNameLabel.setText(Hotel.getHotelName());
			StarsLabel.setText(Hotel.getStars());
			PopularityLabel.setText(Hotel.getPopularity());
			DistanceLabel.setText(Hotel.getDistance());
			BreakfastLabel.setText(Hotel.getBreakfast());
			BarLabel.setText(Hotel.getBar());	 
			GymLabel.setText(Hotel.getGym());	
			PetsLabel.setText(Hotel.getPets());
		}else{

			HotelNameLabel.setText("");
			StarsLabel.setText("");
			PopularityLabel.setText("");
			DistanceLabel.setText("");
			BreakfastLabel.setText("");
			BarLabel.setText("");
			GymLabel.setText("");
			PoolLabel.setText("");
			PetsLabel.setText("");
		}
	}


@FXML
private void handleNewHotel() {
	Hotel tempHotel = new Hotel();
	boolean okClicked = App.showHotelEdit(tempHotel);
	if (okClicked) {
		App.getHotelData().add(tempHotel);
	}
}


@FXML
private void handleEditHotel() {
	Hotel selectedHotel = HotelTable.getSelectionModel().getSelectedItem();
	if (selectedHotel != null) {
		boolean okClicked = App.showHotelEdit(selectedHotel);
		if (okClicked) {
			showHotelDetails(selectedHotel);
		}

	} else {
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.initOwner(App.getPrimaryStage());
		alert.setTitle("No Selection");
		alert.setHeaderText("No Hotel Selected");
		alert.setContentText("Please select a Hotel in the Label.");
		alert.showAndWait();
	}
}

@FXML
private void handleDeleteHotel() {
	int selectedIndex = HotelTable.getSelectionModel().getSelectedIndex();
	if (selectedIndex >= 0) {
		HotelTable.getItems().remove(selectedIndex);
	} else {
		Alert alert = new Alert(AlertType.WARNING);
		alert.initOwner(App.getPrimaryStage());
		alert.setTitle("No Selection");
		alert.setHeaderText("No Hotel Selected");
		alert.setContentText("Please select a Hotel in the Label.");
		alert.showAndWait();
	}
}

public HotelOverviewController() {
}


@FXML
private void initialize() {
	HotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().HotelNameProperty());
	showHotelDetails(null);
	HotelTable.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> showHotelDetails(newValue));
}


public void setGothenburgHotels(App GothenburgHotels) {
	this.App = GothenburgHotels;
	HotelTable.setItems(GothenburgHotels.getHotelData());
}
}