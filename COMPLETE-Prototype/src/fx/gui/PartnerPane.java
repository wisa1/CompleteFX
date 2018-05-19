package fx.gui;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.DataManager;
import logic.DataManagerFactory;
import models.*;

public class PartnerPane extends ScrollPane {
	public PartnerPane(User loggedInUser) {
		DataManager dataManager = DataManagerFactory.getInstance();
		List<User> potentialPartners = dataManager.getPotentialPartners(loggedInUser);
		
		VBox parentBox = new VBox();
		
		for(User user : potentialPartners) {
			HBox userBox = new HBox();
			Label userNameLabel = new Label("UserName: ");
			userNameLabel.setMinWidth(150);
			Label userName = new Label(user.getName());
			
			userBox.getChildren().addAll(userNameLabel, userName);
			parentBox.getChildren().add(userBox);
		}
		
		System.out.println(potentialPartners.size());
		this.setContent(parentBox);
	}

}
