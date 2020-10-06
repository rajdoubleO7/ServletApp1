package Model;

public class Product {
	private int productID;
	private String productName;
	private String category;
	private float price;
	private int quantity;
	private int rol;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productID, String productName, String category, float price, int quantity, int rol) {
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.rol = rol;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "productID=" + productID + ", productName=" + productName + ", category=" + category
				+ ", price=" + price + ", quantity=" + quantity + ", rol=" + rol;
	}
	
}
