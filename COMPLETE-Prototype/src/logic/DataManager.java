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
	public int authenticate(String username, String password);
	public ObservableList<User> getAllUsers();
	public ObservableList<User> getPotentialPartners(User forUser);
	public User getUserByName(String name);
}
