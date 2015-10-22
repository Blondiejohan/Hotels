package ch.makery.address.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


public class Hotel {

	private final StringProperty HotelName;
	private final StringProperty Stars;
	private final StringProperty Popularity;
	private final StringProperty Distance;
	private final StringProperty Breakfast;
	private final StringProperty Bar;
	private final StringProperty Gym;
	private final StringProperty Pets;
	private final StringProperty Pool;

	
	public Hotel() {
		this(null, null, null, null, null, null, null, null, null);
	}

	
	
	public Hotel(String HotelName, String Stars, String Popularity, String Distance, String Breakfast, String Bar, String Gym, String Pets, String Pool) {
		this.HotelName = new SimpleStringProperty(HotelName);
		this.Stars = new SimpleStringProperty(Stars);
		this.Popularity = new SimpleStringProperty(Popularity);
		this.Distance = new SimpleStringProperty(Distance);
		this.Breakfast = new SimpleStringProperty(Breakfast);
		this.Bar = new SimpleStringProperty(Bar);
		this.Gym = new SimpleStringProperty(Gym);
		this.Pets = new SimpleStringProperty(Pets);
		this.Pool = new SimpleStringProperty(Pool);
	}

	
	//HotelName
	public String getHotelName() {
		return HotelName.get();
	}

	public void setHotelName(String HotelName) {
		this.HotelName.set(HotelName);
	}

	public StringProperty HotelNameProperty() {
		return HotelName;
	}


	//Stars
	public String getStars() {
		return Stars.get();
	}

	public void setStars(String Stars) {
		this.Stars.set(Stars);
	}

	public StringProperty StarsProperty() {
		return Stars;
	}

	//Popularity
	public String getPopularity() {
		return Popularity.get();
	}

	public void setPopularity(String Popularity) {
		this.Popularity.set(Popularity);
	}

	public StringProperty StarsPopularity() {
		return Popularity;
	}


	//Distance
	public String getDistance() {
		return Distance.get();
	}

	public void setDistance(String Distance) {
		this.Distance.set(Distance);
	}

	public StringProperty DistanceProperty() {
		return Distance;
	}


	//Breakfast
	public String getBreakfast() {
		return Breakfast.get();
	}

	public void setBreakfast(String Breakfast) {
		this.Breakfast.set(Breakfast);
	}

	public StringProperty BreakfastProperty() {
		return Breakfast;
	}


	//Bar
	public String getBar() {
		return Bar.get();
	}

	public void setBar(String Bar) {
		this.Bar.set(Bar);
	}

	public StringProperty BarProperty() {
		return Bar;
	}
	
	
	// Gym
	public String getGym() {
		return Gym.get();
	}

	public void setGym(String Gym) {
		this.Gym.set(Gym);
	}

	public StringProperty GymProperty() {
		return Gym;
	}
	
	
	//Pets
	public String getPets() {
		return Pets.get();
	}

	public void setPets(String Pets) {
		this.Pets.set(Pets);
	}

	public StringProperty PetsProperty() {
		return Pets;
	}
	
	
	//Pool
	public String getPool() {
		return Pool.get();
	}

	public void setPool(String Pool) {
		this.Pool.set(Pool);
	}

	public StringProperty PoolProperty() {
		return Pool;
	}
}


