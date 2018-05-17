package logic;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import models.Sticker;
import models.StickerCategory;
import models.TradeOffer;
import models.User;

public interface DataManager {
	//public User getUserByName(String userName);
	public User getUserById(int id);
	public ArrayList<StickerCategory> getStickerCategories();
	//public ArrayList<Sticker> getAllStickers();
	public ArrayList<Sticker> getStickersByCategoryId(int categoryId);
	public ObservableList<TradeOffer> getOpenOffersByUserId(int userId);
	public Boolean authenticate(String username, String password);
}
