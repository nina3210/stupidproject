package warehouse2;

public class Product {
	
	private int productID;
	private String productName;
	private String manufacturer;
	// quantity = VE
	private int quantity;
	private Boolean highFreq;
	
	public Product (int id, String pName, String mName, int q, Boolean freq) {
		this.productID 		= id;
		this.productName 	= pName;
		this.manufacturer 	= mName;
		this.quantity 		= q;
		this.highFreq		= freq;
	}
	
	@Override
	public String toString() {
		return "Produkt-ID: " + this.productID  + " " + productName + " " + manufacturer;
	}
	
	public int getID() {
		return this.productID;
	}
	public void setID(int i) {
		productID = i;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int i) {
		this.quantity = i;
	}
	
	public Boolean getFreq() {
		return this.highFreq;
	}
	
	public void setFreq(Boolean b) {
		this.highFreq = b;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String s) {
		this.productName = s;
	}
}
