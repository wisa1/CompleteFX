package fx.gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import logic.DataManager;
import logic.MockDataManager;
import models.Sticker;
import models.StickerCategory;

public class AlbumPane extends BorderPane{

	private final int CATEGORY_PANEL_WIDTH = 200;
	
	public AlbumPane() {
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
