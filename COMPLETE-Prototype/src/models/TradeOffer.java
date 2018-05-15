package models;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import logic.DataManager;
import logic.DataManagerFactory;

public class TradeOffer {
	private SimpleIntegerProperty offerId;
	private SimpleIntegerProperty offeredByUserId;
	private SimpleIntegerProperty offeredToUserId;
	private ArrayList<Sticker> offeredCards;
	private ArrayList<Sticker> wantedCards;
	private boolean accepted = false;
	
	private SimpleIntegerProperty offeredCardCount;
	private SimpleIntegerProperty wantedCardCount;
	
	private SimpleStringProperty offeredByUserName;
	
	public TradeOffer(int offerId, int offeredByUserId, int offeredToUserId, ArrayList<Sticker> offeredCards, ArrayList<Sticker> wantedCards) {
		this.offerId = new SimpleIntegerProperty(offerId);
		this.offeredByUserId = new SimpleIntegerProperty(offeredByUserId);
		this.offeredToUserId = new SimpleIntegerProperty(offeredToUserId);
		this.offeredCards = offeredCards;
		this.wantedCards = wantedCards;
		
		if(this.offeredCards != null) {
			this.offeredCardCount = new SimpleIntegerProperty(this.offeredCards.size());
		} else {
			this.offeredCardCount = new SimpleIntegerProperty(0);
		}
		
		if(this.offeredCards != null) {
			this.wantedCardCount = new SimpleIntegerProperty(this.wantedCards.size());
		} else {
			this.wantedCardCount = new SimpleIntegerProperty(0);
		}
				 
		DataManager dataManager = DataManagerFactory.getInstance();
		this.offeredByUserName = new SimpleStringProperty(dataManager.getUserById(1).getName());
	}
	
	
	public int getOfferedByUserId() {
		return offeredByUserId.get();
	}
	public int getOfferedToUserId() {
		return offeredToUserId.get();
	}
	public ArrayList<Sticker> getOfferedCards() {
		return offeredCards;
	}
	public void setOfferedCards(ArrayList<Sticker> offeredCards) {
		this.offeredCards = offeredCards;
	}
	public ArrayList<Sticker> getWantedCards() {
		return wantedCards;
	}
	public void setWantedCards(ArrayList<Sticker> wantedCards) {
		this.wantedCards = wantedCards;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public int getOfferId() {
		return offerId.get();
	}
	
	public int getOfferedCardCount() {
		if(this.offeredCards != null) return this.offeredCards.size();
		return 0;
	}

	public int getWantedCardCount() {
		if(this.wantedCards != null) return this.wantedCards.size();
		return 0;
	}

	public String getOfferedByUserName() {
		return offeredByUserName.get();
	}
}
