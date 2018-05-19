package fx.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.DataManager;
import logic.DataManagerFactory;
import models.User;

public class COMPLETE extends Application {
	BorderPane rootPane;
	User loggedInUser;

	private static final Border DEFAULT_BORDER = 
			new Border(
					new BorderStroke(
							Color.DIMGRAY,
							BorderStrokeStyle.SOLID,
							new CornerRadii(1.0),null
					));

	public static void main(String[] args)  {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("COMPLETE - Tauschbörse");
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(800);
		primaryStage.setMaxHeight(600);
		primaryStage.setMaxWidth(800);
				
		//Top Part
		Pane banner = createTextBanner("COMPLETE - Tauschbörse", 800, 50);
		rootPane = new BorderPane();
		rootPane.setTop(banner);
		rootPane.setBorder(DEFAULT_BORDER);
		
		AuthentificationPane auth = new AuthentificationPane();
		rootPane.setCenter(auth);
		auth.loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				DataManager dataManager = DataManagerFactory.getInstance();
				int userId = dataManager.authenticate(auth.userNameText.getText(), auth.passwordText.getText());
				loggedInUser = dataManager.getUserById(userId);
				loadMainContent();
			}
		});
		
		Scene scene = new Scene(rootPane);
		
		//BorderPane mainContent = new BorderPane();
		//mainContent.setCenter(new MainPane());
				
		primaryStage.setScene(scene);
		
		
		primaryStage.show(); 
	}

	protected void loadMainContent() {
		//Navigation pane
		BorderPane contPane = new MainPane(loggedInUser);
		HBox.setHgrow(contPane, Priority.ALWAYS);
		rootPane.setCenter(contPane);
	}

	private Pane createTextBanner(String text, int width, int height) {
		Pane p = new VBox();
		p.minHeight(30);
		p.maxHeight(50);
		p.setBorder(DEFAULT_BORDER);
		
		Label l1 = new Label(text);
		l1.setFont(new Font("Arial",20));
		
		p.getChildren().add(l1);
		return p;
	}
}
