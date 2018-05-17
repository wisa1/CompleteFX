package fx.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class AuthentificationPane extends Pane{
	AuthentificationPane parent = this;
	Button loginButton;
	TextField passwordText;
	TextField userNameText;
	public AuthentificationPane() {
		VBox parentBox = new VBox();
		
		HBox userNameHBox = new HBox();
		Label userNameLabel = new Label("Username:");
		userNameText = new TextField();
		userNameHBox.getChildren().addAll(userNameLabel, userNameText);
		
		HBox passwordHBox = new HBox();
		Label passwordLabel = new Label("Password:");
		passwordText = new TextField();
		passwordHBox.getChildren().addAll(passwordLabel, passwordText);
		
		loginButton = new Button("Login");
		parentBox.getChildren().addAll(userNameHBox, passwordHBox, loginButton);
		
		this.getChildren().add(parentBox);
	}
}
