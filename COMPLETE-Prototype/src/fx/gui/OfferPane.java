package fx.gui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.DataManager;
import logic.DataManagerFactory;
import models.Sticker;
import models.TradeOffer;

public class OfferPane extends ScrollPane{
	public TableView<TradeOffer> table;
	public OfferPane(){
		table = new TableView<>();
		TableColumn<TradeOffer, String> nameCol = new TableColumn<>("Angeboten von");
		nameCol.setMinWidth(200);
		nameCol.setCellValueFactory(
				new PropertyValueFactory<TradeOffer, String>("offeredByUserName"));
		
		TableColumn<TradeOffer, Integer>  offeredCol = new TableColumn<>("Sticker angeboten");
		offeredCol.setMinWidth(200);
		offeredCol.setCellValueFactory(
				new PropertyValueFactory<TradeOffer, Integer>("offeredCardCount"));
		
		TableColumn<TradeOffer, Integer> wantedCol = new TableColumn<>("Sticker verlangt");
		wantedCol.setMinWidth(200);
		wantedCol.setCellValueFactory(
				new PropertyValueFactory<TradeOffer, Integer>("wantedCardCount"));
		
		table.getColumns().addAll(nameCol, offeredCol, wantedCol);
		table.setMinHeight(Double.MAX_VALUE);
		
		DataManager dataManager = DataManagerFactory.getInstance();
		table.setEditable(false);
		
//		ObservableList<TradeOffer> x = FXCollections.observableArrayList();
//		x.addAll(new TradeOffer(1,1,2,null,null));
		
		
		table.setItems(dataManager.getOpenOffersByUserId(1));
		this.setContent(table);
	}
}

//
//this.setLeft(null);
//this.setCenter(null);
//
//DataManager dataManager = MockDataManager.getInstance();
//ArrayList<TradeOffer> offers = dataManager.getOpenOffersByUsername("user");
//
//ScrollPane scrollPane = new ScrollPane();
//Pane offersBox = new VBox();
//
//int labelWidth = 150;
//for(TradeOffer offer : offers) {
//	Pane line = new HBox();
//	Label byLabel = new Label("Von: " + dataManager.getUserById(offer.getOfferedByUserId()).getName());
//	byLabel.setMinWidth(labelWidth);
//	byLabel.setMaxWidth(labelWidth);
//	line.getChildren().add(byLabel);
//	
//	Label offeredLabel = new Label("Sticker angeboten: " + offer.getOfferedCards().size());
//	offeredLabel.setMinWidth(labelWidth);
//	offeredLabel.setMaxWidth(labelWidth);
//	line.getChildren().add(offeredLabel);
//	
//	Label wantedLabel = new Label("Im Tausch gegen " + offer.getWantedCards().size() + " Sticker");
//	wantedLabel.setMinWidth(labelWidth);
//	wantedLabel.setMaxWidth(labelWidth);
//	line.getChildren().add(wantedLabel);
//	
//	offersBox.getChildren().add(line);
//}
//scrollPane.setContent(offersBox);
//this.setCenter(scrollPane);