package warehouse2;


import java.util.*;

public class Cart {
	
	private int size;
	private List<Shelves> regale;
	private int load;
	private ArrayList<Product> loadedProducts;
	private ProductList productListe;
	private ArrayList<Integer> fachWeitePosition;
	private ArrayList<Integer> fachHoehePosition;
	private ArrayList<String> regalPosition;
	
	public Cart(int s, ProductList prod) {
		
		this.productListe = prod;
		this.size = s;
		this.regale = prod.getShelfList();
		load = 0;
		loadedProducts = new ArrayList<Product>();
		fachHoehePosition = new ArrayList<Integer>();
		fachWeitePosition = new ArrayList<Integer>();
		regalPosition = new ArrayList<String>();
	}
	
//	public void addToCart(Product p) {
//		
//		if (load + p.getQuantity() <= size) {
//			System.out.println(load + "hi");
//			load = load + p.getQuantity();
//			loadedProducts.add(p);
//			System.out.println(Arrays.toString(loadedProducts.toArray()));
//			return;
//		}
//		else (load + p.getQuantity() > size) {
//			productListe.printInventory();
//			for (Product pa : loadedProducts) {
//			putOnShelves(pa);
//			}
//
//			loadedProducts.clear();
//
//			for (int i = 0; i<fachHoehePosition.size(); i++) {
//				System.out.println("Shelves in order " + regalPosition.get(i) + " Compartments in order:" + fachHoehePosition.get(i) + " " + fachWeitePosition.get(i));
//			}
//			fachHoehePosition.clear();
//			fachWeitePosition.clear();
//			regalPosition.clear();
//
//		}
//
//		productListe.assembleProductList();
//		loadedProducts.add(p);
//		load = p.getQuantity();
//
//	}
	
	public void addToCart(Product p) {
		
		if (load +p.getQuantity()<size) {
			load = load + p.getQuantity();
			//System.out.println(load);
			loadedProducts.add(p);
		}
		
		else if (load +p.getQuantity() >= size) {
		//	System.out.println("blob");
			for (Product lp : loadedProducts) {
				putOnShelves(lp);
			}
			loadedProducts.clear();
			load = 0;
			for (int i = 0; i<fachHoehePosition.size(); i++) {
				System.out.println("Shelves in order " + regalPosition.get(i) + " Compartments in order:" + fachHoehePosition.get(i) + " " + fachWeitePosition.get(i));
			}
			fachHoehePosition.clear();
			fachWeitePosition.clear();
			regalPosition.clear();
			loadedProducts.add(p);
			load = p.getQuantity();

		}
	}

	public List<Shelves> getShelfList() {
		return this.regale;
	}
	
	

	public void putOnShelves(Product lp) {
		Boolean done = false;
			for (Shelves s : regale) {


			if (s instanceof HighFreqShelf == false) {

				for (int i = 0; i < s.getHeight(); i++) {

					for (int j = 0; j <s.getWidth(); j++) {
						if (s.getProduct(i, j).getProductName().equals("leer") && (s.getCompartmentSpace(i)> lp.getQuantity())){

							s.putProduct(i, j, lp);
						//	System.out.println(s.getProduct(i, j).getQuantity());
							fachWeitePosition.add(j);
							fachHoehePosition.add(i);
							regalPosition.add(s.getShelfID());
							return;
							}
							
						}
					}
				}

		}
		
	}
	
//	public void putOnShelves(Product lp) {
//		Boolean loopbreaker = false;
//		int fachcount = 0;
//		
//
//			for (Shelves s : regale) {
//			if (s instanceof HighFreqShelf == false) {
//				if (loopbreaker == true) {
//					break;
//				}
//				for (int i = 0; i < s.getHeight(); i++) {
//					if (loopbreaker == true) {
//						break;
//					}
//					for (int j = 0; j <s.getWidth(); j++) {
//						if (s.getProduct(i, j).getProductName().equals("leer")){
//						if(s.getCompartmentSpace(i)> lp.getQuantity()) {
//							s.putProduct(i, j, lp);
//
//							loopbreaker = true;
//							fachWeitePosition.add(j);
//							fachHoehePosition.add(i);
//							regalPosition.add(s.getShelfID());
//							productListe.assembleProductList();
//							return;
//								}
//							}
//						}
//					}
//				}
//
//			
//		}
		
	}
	
	


