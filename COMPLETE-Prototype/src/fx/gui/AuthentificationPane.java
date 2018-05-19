package fx.gui;

import javax.swing.JPasswordField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class AuthentificationPane extends Pane{
	AuthentificationPane parent = this;
	Button loginButton;
	PasswordField passwordText;
	TextField userNameText;
	public AuthentificationPane() {
		VBox parentBox = new VBox();
		parentBox.setPadding(new Insets(200,0,0,240));
		
		
		HBox userNameHBox = new HBox();
		Label userNameLabel = new Label("Username:");
		userNameLabel.setMinWidth(120);
		userNameText = new TextField();
		userNameText.setMinWidth(150);
		userNameHBox.getChildren().addAll(userNameLabel, userNameText);
		
		HBox passwordHBox = new HBox();
		Label passwordLabel = new Label("Password:");
		passwordLabel.setMinWidth(120);
		passwordText = new PasswordField();
		passwordText.setMinWidth(150);
		passwordHBox.getChildren().addAll(passwordLabel, passwordText);
		
		loginButton = new Button("Login");
		loginButton.setMinWidth(270);
		parentBox.getChildren().addAll(userNameHBox, passwordHBox, loginButton);
		
		this.getChildren().add(parentBox);
	}
}
