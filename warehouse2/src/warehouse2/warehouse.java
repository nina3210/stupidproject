package warehouse2;

public class warehouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductList produktListe = new ProductList();

		Product buch = new Product(1, "1Buch", "1Hersteller", 95, true);
		
		System.out.println(buch.toString());
		

		Product buch2 = new Product(2, "1Buch", "1Hersteller", 40, true);
		Product buch3 = new Product(3, "1Buch", "1Hersteller", 150, true);
		Product buch4 = new Product(4, "1Buch", "1Hersteller", 2, true);
		

		Midshelf blob = new Midshelf(8, 12, 1.0, 11, 14);
		blob.putProduct(5, 1, buch4);
		System.out.println(blob.getProduct(5, 1).toString());
		TempShelf tempShelf1 = new TempShelf (3, 3);
		
		

		tempShelf1.putProduct(5, 1, buch4);
		//produktListe.printShelfList();
		
		int xDCounter = 0;
		int yDCounter = 0;
		for (int i = 0; i < 60; i++) {
			produktListe.addShelf(new Midshelf(8, 12, 1.0, xDCounter, yDCounter));
			xDCounter += 7;
			yDCounter += 5;
		}
		BigShelf testBig = new BigShelf(1000, 1000);
		produktListe.addShelf(testBig);
//		produktListe.printShelfList();
		
		
		
		produktListe.assembleProductList();
		produktListe.printInventory();
		
		//System.out.println(produktListe.checkQuantity(4747));
		
		Order bestellung1 = new Order(produktListe);
		
		//produktListe.printInventory();
		//block für eine bestellung
		{
		//bestellung1.addToOrder(buch3, 2);
		//produktListe.setShelfList(bestellung1.getShelfList());
		}
		produktListe.printInventory();
		
		Cart testCart = new Cart(600, produktListe);
		testCart.addToCart(buch);
		produktListe.setShelfList(testCart.getShelfList());
		testCart.addToCart(buch2);
		produktListe.setShelfList(testCart.getShelfList());
		testCart.addToCart(buch);
		produktListe.setShelfList(testCart.getShelfList());
		produktListe.printInventory();
		testCart.addToCart(buch3);
		produktListe.setShelfList(testCart.getShelfList());
		produktListe.printInventory();
		testCart.addToCart(buch3);
		produktListe.setShelfList(testCart.getShelfList());
		testCart.addToCart(buch3);
		produktListe.setShelfList(testCart.getShelfList());
		for (int i = 0; i < 200; i++) {
		testCart.addToCart(buch3);
			produktListe.setShelfList(testCart.getShelfList());
		}
		produktListe.printInventory();
		
		produktListe.setShelfList(testCart.getShelfList());
		produktListe.printInventory();
	}

}
