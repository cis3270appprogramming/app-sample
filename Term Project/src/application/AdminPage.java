package application;

import java.sql.Connection;
import java.sql.ResultSet;

import common.Action;
import common.Admin;
import common.Customer;
import database.Queries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminPage {

	ObservableList<String> securityQuestionsList = FXCollections.observableArrayList("Departure", "Destination", "Date",
			"Time", "Passengers");

	@FXML
	private TableView<FlightDetails> tableFlight;
	@FXML
	private TableColumn<FlightDetails, String> columnFlightNumber;
	@FXML
	private TableColumn<FlightDetails, String> columnDeparture;
	@FXML
	private TableColumn<FlightDetails, String> columnDestination;
	@FXML
	private TableColumn<FlightDetails, String> columnDate;
	@FXML
	private TableColumn<FlightDetails, String> columnTime;
	@FXML
	private TableColumn<FlightDetails, String> columnPassengerCount;
	@FXML
	private TableColumn<FlightDetails, String> columnBook;
	@FXML
	private Button btnLoad;
	@FXML
	private TextField input;
	@FXML
	private Label result;

	ScreensController myController;
	Customer currentUser;
	Admin currentAdmin;

	private ObservableList<FlightDetails> data;

	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;

	}

	// Takes user back to BookingPage Page
	public void back(ActionEvent event) {

		myController.setScreen(Main.userFlightsID);
	}

	// Takes user back to home page
	public void home(ActionEvent event) {

		myController.setScreen(Main.homePageID);

	}

	public void deleteFlight(ActionEvent e) {

	}

	public void insertFlight(ActionEvent e) {

	}

	public void updateFlight(ActionEvent e) {

	}

	@FXML
	private void loadDataFromDatabase(ActionEvent event) throws Exception {
		try {
			Connection con = Queries.getConnection();
			data = FXCollections.observableArrayList();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `world`.`flights`");
			while (rs.next()) {
				data.add(new FlightDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception ex) {
			System.out.println("Error" + ex);
		}

		columnFlightNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		columnDeparture.setCellValueFactory(new PropertyValueFactory<>("departure"));
		columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
		columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));
		columnPassengerCount.setCellValueFactory(new PropertyValueFactory<>("passengerCount"));

		tableFlight.setItems(null);
		tableFlight.setItems(data);

	}

}
