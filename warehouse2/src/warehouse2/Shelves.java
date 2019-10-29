package warehouse2;

public interface Shelves {
	
	public Boolean isTemp();
	public int getHeight();
	public int getWidth();
	public Product getProduct(int i, int j);
	public void putProduct (int x, int y, Product p);
	public double getRelDistance();
	public double getCompartmentSpace(int x);
	public String getShelfID();
	public void getPositions(int i);
}
