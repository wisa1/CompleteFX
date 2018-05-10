package fx.gui;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import models.Sticker;

public class StickerPane extends VBox{
	ImageView imageView;
	public StickerPane(Sticker sticker) {
		if(sticker.getPicture() != null) {
			imageView = new ImageView(sticker.getPicture());
		} else {
			imageView = new ImageView("https://image.stern.de/7572518/16x9-940-529/15713a713281661d53d67ae1f36f3114/sg/marouane-fellaini.jpg");
		}
		imageView.setFitWidth(130);
		imageView.setFitHeight(190);
		
		this.getChildren().add(imageView);
		
		Label nameLabel = new Label("#" + sticker.getId() + " " + sticker.getDescription());
		this.getChildren().add(nameLabel);
	}
}
