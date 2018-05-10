package models;

public class StickerCategory {
	private int id; 
	private String description;
	
	public StickerCategory(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {return this.id;};
	public void setDescription(String value) {this.description = value;}
	public String getDescription() {return this.description;}
}
