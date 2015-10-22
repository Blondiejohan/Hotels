package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Hotel;



public class HotelEditDialogController {
	
	@FXML
	private TextField HotelNameField;
	@FXML
	private TextField StarsField;
	@FXML
	private TextField PopularityField;
	@FXML
	private TextField DistanceField;
	@FXML
	private TextField BreakfastField;
	@FXML
	private TextField BarField;
	@FXML
	private TextField GymField;
	@FXML
	private TextField PetsField;
	@FXML
	private TextField PoolField;


	private Stage dialogStage;
	private Hotel Hotel;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setHotel(Hotel Hotel) {
		this.Hotel = Hotel;

		HotelNameField.setText(Hotel.getHotelName());
		StarsField.setText(Hotel.getStars());
		PopularityField.setText(Hotel.getPopularity());
		DistanceField.setText(Hotel.getDistance());
		BreakfastField.setText(Hotel.getBreakfast());
		BarField.setText(Hotel.getBar());
		GymField.setText(Hotel.getGym());
		PoolField.setText(Hotel.getPool());
		PetsField.setText(Hotel.getPets());
	
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			Hotel.setHotelName(HotelNameField.getText());
			Hotel.setStars(StarsField.getText());
			Hotel.setPopularity(PopularityField.getText());
			Hotel.setDistance(DistanceField.getText());
			Hotel.setBreakfast(BreakfastField.getText());
			Hotel.setBar(BarField.getText());
			Hotel.setGym(GymField.getText());
			Hotel.setPool(PoolField.getText());
			Hotel.setPets(PetsField.getText());

			okClicked = true;
			dialogStage.close();
		}
	}

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

		if (HotelNameField.getText() == null || HotelNameField.getText().length() == 0) {
			errorMessage += "No valid Hotel name \n"; 
		}
		if (StarsField.getText() == null || StarsField.getText().length() == 0) {
			errorMessage += "Not a correct amount of stars \n"; 
		}
		if (PopularityField.getText() == null || PopularityField.getText().length() == 0) {
			errorMessage += "Not a correct amount of popularity \n"; 
		}

		if (DistanceField.getText() == null || DistanceField.getText().length() == 0) {
			errorMessage += "Not a valid distance \n"; 
		}

		if (errorMessage.length() == 0) {
			return true;
			
		} else {
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