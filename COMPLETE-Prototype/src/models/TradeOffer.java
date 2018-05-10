package models;

import java.util.ArrayList;

public class TradeOffer {
	private int offerId;
	private int offeredByUserId;
	private int offeredToUserId;
	private ArrayList<Sticker> offeredCards;
	private ArrayList<Sticker> wantedCards;
	private boolean accepted = false;
	
	public TradeOffer(int offerId, int offeredByUserId, int offeredToUserId, ArrayList<Sticker> offeredCards, ArrayList<Sticker> wantedCards) {
		this.offerId = offerId;
		this.offeredByUserId = offeredByUserId;
		this.offeredToUserId = offeredToUserId;
		this.offeredCards = offeredCards;
		this.wantedCards = wantedCards;
	}
	
	
	public int getOfferedByUserId() {
		return offeredByUserId;
	}
	public int getOfferedToUserId() {
		return offeredToUserId;
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
		return offerId;
	}
}
