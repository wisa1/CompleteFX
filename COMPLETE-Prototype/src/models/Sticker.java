package models;

import javafx.scene.image.Image;

public class Sticker {
	private int id;
	private String description;
	private int categoryId;
	private Image picture;
	
	public Sticker(int id, String description, int categoryId) {
		this.id = id;
		this.setDescription(description);
		this.setCategoryId(categoryId);
	}
	
	public Sticker(int id, String description, int categoryId, String picturePath) {
		this.id = id;
		this.setDescription(description);
		this.setCategoryId(categoryId);
		this.setPicture(new Image(picturePath));
	}


	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}
}
