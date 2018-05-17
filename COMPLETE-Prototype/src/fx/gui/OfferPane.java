package fx.gui;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import logic.DataManager;
import logic.DataManagerFactory;
import models.TradeOffer;

public class OfferPane extends ScrollPane{
	//public TableView<TradeOffer> table;
	public OfferPane(){
		/*
		 * this should work using a tableView according to documentation. 
		 * however at least on my machine this always leads to "Program not responding" at runtime
		 * workaround below using labels
		table = new TableView<>();
		TableColumn<TradeOffer, String> nameCol = new TableColumn<>("Angeboten von");
		nameCol.setMinWidth(200);
		nameCol.setCellValueFactory(
				cellData -> cellData.getValue().offeredByUserNameProperty());
				//new PropertyValueFactory<TradeOffer, String>("offeredByUserName"));
				
		
		
		TableColumn<TradeOffer, Number>  offeredCol = new TableColumn<>("Sticker angeboten");
		offeredCol.setMinWidth(200);
		offeredCol.setCellValueFactory(
				cellData -> cellData.getValue().getOfferedCardCountProperty());
				//new PropertyValueFactory<TradeOffer, Number>("offeredCardCount"));
		
		TableColumn<TradeOffer, Number> wantedCol = new TableColumn<>("Sticker verlangt");
		wantedCol.setMinWidth(200);
		wantedCol.setCellValueFactory(
				cellData -> cellData.getValue().getOfferedCardCountProperty());
				new PropertyValueFactory<TradeOffer, Number>("wantedCardCount"));
		
		
		table.getColumns().addAll(nameCol , offeredCol, wantedCol );
		table.setMinHeight(Double.MAX_VALUE);
		
		DataManager dataManager = DataManagerFactory.getInstance();
		table.setEditable(false);
		
		table.setItems(dataManager.getOpenOffersByUserId(1));
		this.setContent(table);
		*/
			
		DataManager dataManager = DataManagerFactory.getInstance();
		List<TradeOffer> offers = dataManager.getOpenOffersByUserId(1);
		
		
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
		
		this.setContent(offersBox);
	}
}

//
