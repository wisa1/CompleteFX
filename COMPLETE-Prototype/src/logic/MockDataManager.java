package logic;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Sticker;
import models.StickerCategory;
import models.TradeOffer;
import models.User;

//Mock-DataManager to simulate later implementations using actual DataSources
//Only for Development & Prototyping purposes - hardcoded returns
public class MockDataManager implements DataManager  {
	private static MockDataManager instance;
	private MockDataManager() {};
	
	public static MockDataManager getInstance() {
		if(instance == null) {
			instance = new MockDataManager();
		}
		return instance;
	}

	
	@Override
	public ArrayList<StickerCategory> getStickerCategories() {
		ArrayList<StickerCategory> catList = new ArrayList<>();
		catList.add(new StickerCategory(1,"Ägypten"));
		catList.add(new StickerCategory(2,"Marocco"));
		catList.add(new StickerCategory(3,"Nigeria"));
		catList.add(new StickerCategory(4,"Senegal"));
		catList.add(new StickerCategory(5,"Tunesien"));
		catList.add(new StickerCategory(6,"Australien"));
		catList.add(new StickerCategory(7,"Iran"));
		catList.add(new StickerCategory(8,"Japan"));
		catList.add(new StickerCategory(9,"Südkorea"));
		catList.add(new StickerCategory(10,"Belgien"));	
		catList.add(new StickerCategory(11,"Kroatien"));
		catList.add(new StickerCategory(12,"Dänemark"));
		catList.add(new StickerCategory(13,"England"));
		catList.add(new StickerCategory(14,"Deutschland"));
		catList.add(new StickerCategory(15,"Island"));
		catList.add(new StickerCategory(16,"Polen"));
		
		return catList;
	}
	@Override
	public ArrayList<Sticker> getStickersByCategoryId(int categoryId) {
		ArrayList<Sticker> stickList = new ArrayList<>();
		stickList.add(new Sticker(1, "Nickolas Way", 1));
		stickList.add(new Sticker(2, "Levi Galeana", 1));
		stickList.add(new Sticker(3, "Stephan Cardwell", 1));
		stickList.add(new Sticker(4, "Denis Leventhal", 1));
		stickList.add(new Sticker(5, "Jeff Mose", 1));
		stickList.add(new Sticker(6, "Deon Ferrell", 1));
		stickList.add(new Sticker(7, "Jefferson Beaman", 1));
		stickList.add(new Sticker(8, "Esteban Maxie", 1));
		stickList.add(new Sticker(9, "Giuseppe Griner", 1));
		stickList.add(new Sticker(10, "Adan Sudderth", 1));
		stickList.add(new Sticker(11, "Waldo Irwin", 1));
		stickList.add(new Sticker(12, "Stephen Orsini", 1));
		stickList.add(new Sticker(13, "Marcelino Harriss", 1));
		stickList.add(new Sticker(14, "Dante Ruddell", 1));
		stickList.add(new Sticker(15, "Donnie Gammage", 1));
		stickList.add(new Sticker(16, "Nelson Amaker", 1));
		return stickList;
	}

	@Override
	public ObservableList<TradeOffer> getOpenOffersByUserId(int userId) {
		ObservableList<TradeOffer> offers  = FXCollections.observableArrayList();
		ArrayList<Sticker> offered = new ArrayList<>();
		ArrayList<Sticker> wanted = new ArrayList<>();
		
		offered.add(new Sticker(1, "Nickolas Way", 1));
		offered.add(new Sticker(2, "Levi Galeana", 1));
		
		wanted.add(new Sticker(12, "Stephen Orsini", 1));
		wanted.add(new Sticker(16, "Nelson Amaker", 1));
		
		offers.add(new TradeOffer(1, 1, 2, offered, wanted));
		return offers;
	}

	@Override
	public User getUserById(int id) {
		if(id == 1) return new User(1, "Johannes", "","","","","");
		if(id == 2) return new User(2, "Franz", "", "","","","");
		return null;
	}
	
}
