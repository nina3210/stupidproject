package warehouse2;
import java.util.*;

public class ProductList {
	
	// Product ID = key, quantity = value
	private HashMap<Integer, Integer> productListe;
	private List<Shelves> regale;
	private Product lister;
	private Integer iD;
	
	public ProductList() {
		
		productListe = new HashMap<Integer, Integer>();
		regale = new ArrayList<Shelves>();
		lister = new Product(0, "leer", "leer", 0, false);

		
		//regale.add(new Midshelf(8, 12, 100, 22, 33) );


	}
	
	public void addShelf(Shelves s) {
		regale.add(s);
	}
	
	public void removeShelf(Shelves s) {
		regale.remove(s);
	}
	
	public HashMap<Integer, Integer> getProductList(){
		return this.productListe;
	}
	
	public void setProductList(HashMap<Integer, Integer> pl) {
		this.productListe = pl;
	}
	
	public List<Shelves> getShelfList() {
		return this.regale;
	}
	public void setShelfList(List<Shelves> l) {
		this.regale = l;
	}
	
	public void printShelfList() {
		for (Shelves s : regale) {
			System.out.println(s.getRelDistance());
		}
	}
	
	public int checkQuantity(int id) {
		return productListe.get(id);
	}
	
	public void printInventory() {
	System.out.println(Collections.singletonList(productListe));
	}
	
	public void assembleProductList() {
		int iD = 0;
		for (Shelves shelf : regale) {
				

			for (int i = 0; i < shelf.getHeight(); i++) {
				for (int j = 0; j < shelf.getWidth(); j++) {
					iD= 0;
					
					lister = shelf.getProduct(i, j);

					iD = lister.getID();
					if (!lister.getProductName().equals("leer")) {
						if (productListe.containsKey(iD) == false) {
							productListe.put(lister.getID(), lister.getQuantity());
						}
					else if (productListe.containsKey(iD) == true) {
					int currentQuantity = productListe.get(iD);
					productListe.put(iD, (currentQuantity+lister.getQuantity()));
					
					}
					}
				}
			}
			

		}
	}
	
	
	
	
}
	

