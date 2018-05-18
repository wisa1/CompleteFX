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
			imageView = new ImageView("http://via.placeholder.com/130x190");
		}
		imageView.setFitWidth(130);
		imageView.setFitHeight(190);
		
		this.getChildren().add(imageView);
		
		Label nameLabel = new Label("#" + sticker.getId() + " " + sticker.getDescription());
		this.getChildren().add(nameLabel);
	}
}
