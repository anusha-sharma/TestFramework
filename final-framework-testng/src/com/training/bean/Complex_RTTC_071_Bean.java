package com.training.bean;

public class Complex_RTTC_071_Bean {
	private String userName;
	private String password;
	private String ProductName;
	private String MetaTitle;
	private String Model;
	private String Price;
	private String Category;
	private String Quantity;
	private String DiscountPrice;
	private String Points;

	public Complex_RTTC_071_Bean() {
	}

	public Complex_RTTC_071_Bean(String userName, String password, String ProductName, String MetaTitle, String Model, String Price, String Category, String Quantity, String DiscountPrice, String Points) {
		super();
		this.userName = userName;
		this.password = password;
		this.ProductName = ProductName;
		this.MetaTitle = MetaTitle;
		this.Model = Model;
		this.Price = Price;
		this.Category = Category;
		this.Quantity = Quantity;
		this.DiscountPrice = DiscountPrice;
		this.Points = Points;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public String getMetaTitle() {
		return MetaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.MetaTitle = metaTitle;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		this.Model = model;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		this.Price = price;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		this.Quantity = quantity;
	}

	public String getDiscountPrice() {
		return DiscountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.DiscountPrice = discountPrice;
	}

	public String getPoints() {
		return Points;
	}

	public void setPoints(String points) {
		this.Points = points;
	}

	@Override
	public String toString() {
		return "Complex_RTTC_071_Bean [userName=" + userName + ", password=" + password + ", ProductName=" + ProductName
				+ ", MetaTitle=" + MetaTitle + ", Model=" + Model + ", Price=" + Price + ", Category=" + Category
				+ ", Quantity=" + Quantity + ", DiscountPrice=" + DiscountPrice + ", Points=" + Points + "]";
	}

}
