package fx.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import models.User;

public class MainPane extends BorderPane {
	Pane navPane;
	ToggleButton albumButton;
	ToggleButton offersButton;
	ToggleButton partnerButton;
	User loggedInUser;
	
	public MainPane(User loggedInUser) {
		createNavPane();
		this.setTop(navPane);	
	}

	private void createNavPane() {
		navPane = new HBox();
		navPane.setMinWidth(800);
		
		ToggleGroup tgroup = new ToggleGroup();
		
		albumButton = new ToggleButton("ALBUM");
		offersButton = new ToggleButton("ANGEBOTE");
		partnerButton = new ToggleButton("PARTNERSUCHE");
		
		albumButton.setToggleGroup(tgroup);
		offersButton.setToggleGroup(tgroup);
		partnerButton.setToggleGroup(tgroup);
		
		albumButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				loadAlbum();
			}
		});
		offersButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				loadOffers();
			}
		});
		partnerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				loadPartner();
			}
		});
		
		navPane.getChildren().addAll(albumButton, offersButton, partnerButton);
		navPane.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0.0), new Insets(0.0))));

		albumButton.setMaxWidth(Double.MAX_VALUE);
		offersButton.setMaxWidth(Double.MAX_VALUE);
		partnerButton.setMaxWidth(Double.MAX_VALUE);
		
		HBox.setHgrow(albumButton, Priority.ALWAYS);
		HBox.setHgrow(offersButton, Priority.ALWAYS);
		HBox.setHgrow(partnerButton, Priority.ALWAYS);
	}

	protected void loadPartner() {
		this.setCenter(new PartnerPane(loggedInUser));	
	}

	protected void loadOffers() {
		this.setCenter(new OfferPane());
	}

	protected void loadAlbum() {
		this.setCenter(new AlbumPane());
		
	}


}
