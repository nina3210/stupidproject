package warehouse2;

import java.util.*;
public class Order {

	private ArrayList<Product> contents;
	private ProductList productListe;
	private ArrayList<Integer> numbers;
	private List<Shelves> regale;
	
	public Order(ProductList list) {
		contents = new ArrayList<Product>();
		this.productListe = list;
		list.assembleProductList();
		regale = list.getShelfList();
	}
	
	public void addToOrder(Product p, int q) {
		int pID = p.getID();
		int quantity = q;
		contents.add(p);
		numbers.add(q);
		
		if (quantity <= productListe.checkQuantity(pID)) {
			
			Boolean escaper = false;
			//ersetzt in Produktliste

			productListe.getProductList().put(pID, (productListe.checkQuantity(pID)-quantity));
			
			//sucht in regalen und zieht quantitäten ab
			for (Shelves s : regale) {

				//iteriert über alle shelves
				for (int i = 0; i < s.getHeight(); i++) {
					if (escaper == true) {break;}
					for (int j = 0; j < s.getWidth(); j++) {
						
						if (p.getID() == s.getProduct(i, j).getID()) {
						//falls genug abziehen und break
						if (quantity <= s.getProduct(i, j).getQuantity()) {
							s.getProduct(i, j).setQuantity((s.getProduct(i, j).getQuantity()-quantity));
							escaper = true;
							break;
						}
						//wenn nicht genug mit leerem Product ersetzen und quantity um vorhandene anzahl ersetzen
						else {
							int temp = s.getProduct(i, j).getQuantity();
							s.putProduct(i, j, new Product(0, "leer", "leer", 0, false));
							quantity -= temp;
						}
						
						}
					}
				}
			}
		}
		
		else {
			System.out.println("Sorry, too few available!");
		}
		
	}
	
	public HashMap<Integer, Integer> getProductList(){
		return productListe.getProductList();
	}
	
	public List<Shelves> getShelfList() {
		return this.regale;
	}
	public void setShelfList(List<Shelves> l) {
		this.regale = l;
	}
	
	
}
