package fx.gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.DataManager;
import logic.MockDataManager;
import models.Sticker;
import models.StickerCategory;
import models.TradeOffer;

public class MainPane extends BorderPane {
	Pane navPane;
	ToggleButton albumButton;
	ToggleButton offersButton;
	ToggleButton partnerButton;
	
	private final int CATEGORY_PANEL_WIDTH = 200;
	
	public MainPane() {
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
		// TODO Auto-generated method stub
		
	}

	protected void loadOffers() {
		this.setLeft(null);
		this.setCenter(null);
		
		DataManager dataManager = MockDataManager.getInstance();
		ArrayList<TradeOffer> offers = dataManager.getOpenOffersByUsername("user");
		
		ScrollPane scrollPane = new ScrollPane();
		Pane offersBox = new VBox();
		
		int labelWidth = 150;
		for(TradeOffer offer : offers) {
			Pane line = new HBox();
			Label byLabel = new Label("Von: " + dataManager.getUserById(offer.getOfferedByUserId()).getName());
			byLabel.setMinWidth(labelWidth);
			byLabel.setMaxWidth(labelWidth);
			line.getChildren().add(byLabel);
			
			Label offeredLabel = new Label("Sticker angeboten: " + offer.getOfferedCards().size());
			offeredLabel.setMinWidth(labelWidth);
			offeredLabel.setMaxWidth(labelWidth);
			line.getChildren().add(offeredLabel);
			
			Label wantedLabel = new Label("Im Tausch gegen " + offer.getWantedCards().size() + " Sticker");
			wantedLabel.setMinWidth(labelWidth);
			wantedLabel.setMaxWidth(labelWidth);
			line.getChildren().add(wantedLabel);
			
			offersBox.getChildren().add(line);
		}
		scrollPane.setContent(offersBox);
		this.setCenter(scrollPane);
	}

	protected void loadAlbum() {
		this.setLeft(null);
		this.setCenter(null);
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.minWidth(CATEGORY_PANEL_WIDTH-13);
		scrollPane.setMaxWidth(Double.MAX_VALUE);
		scrollPane.setFitToWidth(true); //supposed to disable horizontal scrolling - not working though :( 
		
		VBox categoriesPane = new VBox();
		categoriesPane.setMinWidth(CATEGORY_PANEL_WIDTH-13);
		
		DataManager dataManager = MockDataManager.getInstance();
		ArrayList<StickerCategory> catList = dataManager.getStickerCategories();
		
		ToggleGroup toggleGroup = new ToggleGroup();
		for(StickerCategory cat : catList) {
			ToggleButton catButton = new ToggleButton(cat.getDescription());
			catButton.setToggleGroup(toggleGroup);
			catButton.setId(String.valueOf(cat.getId()));
			catButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					loadAlbumCenter((ToggleButton)e.getSource());
				}
			});
			catButton.setMinWidth(CATEGORY_PANEL_WIDTH);
			catButton.setMinHeight(50);
			
			
			categoriesPane.getChildren().add(catButton);
		}
		
		ToggleButton first = (ToggleButton)categoriesPane.getChildren().get(0);
		first.fire();
		
		scrollPane.setContent(categoriesPane);
		this.setLeft(scrollPane);
	}

	protected void loadAlbumCenter(ToggleButton source) {
		ScrollPane scrollPane = new ScrollPane();
		GridPane gridPane = new GridPane();
		gridPane.setHgap(12);
		gridPane.setVgap(5);
		
		DataManager dataManager = MockDataManager.getInstance();
		ArrayList<Sticker> stickList = dataManager.getStickersByCategoryId(1);
		for(int i = 0 ; i < stickList.size(); i++) {
			StickerPane sp = new StickerPane(stickList.get(i));
			gridPane.add(sp, i % 4, i / 4);
		}
		
		scrollPane.setMaxWidth(700);
		scrollPane.setContent(gridPane);
		this.setCenter(scrollPane);
	}
}
