package application;

import common.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home implements ControlledScreen{
	
	ScreensController myController;
	
	static User currentUser;
	
	public static void setCurrentUser(User a) {
		currentUser = a;
	}
	
	public  static User getCurrentUser() {
		return currentUser;
	}
	
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
		
	}

	//Opens profile page when Profile button is clicked
	public void profileButtonPushed(ActionEvent event) {
			setCurrentUser(LoginPage.getUser());
;			myController.setScreen(Main.profilePageID);
			
			
	}
	
	//Displays scene for booking flights
	public void bookingButtonPushed(ActionEvent event) throws Exception{
		
		myController.setScreen(Main.bookingPageID);
		
	}
	
	public void Logout(ActionEvent event) {
		
		myController.setScreen(Main.loginPageID);
	}

	
	
	
}
