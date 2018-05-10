package models;

public class User {
	private int id;
	private String name;
	private String address;
	private String country;
	private String region;
	private String email;
	private String password;
	
	public User(int id, String name, String address, String country, String region, String email, String password) {
		this.id = id;
		this.name=name;
		this.address=address;
		this.country = country;
		this.region = region;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
