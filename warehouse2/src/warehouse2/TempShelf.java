package warehouse2;

public class TempShelf implements Shelves{
	
	private Product[] regal;
	private int height;
	private int width;
	private double xDistance;
	private double yDistance;
	
	public TempShelf(int xD, int yD) {
		this.xDistance 	= xD;
		this.yDistance 	= yD;
		this.height		= 12;
		this.width		= 1;
		
		//TempShelf ist eine Linie, keine Y Koordinate
		regal = new Product[12];
		
		for (int i = 0; i<=11; i++) {
			regal[i] = new Product(0, "leer", "leer", 0, false);
		}
	}
	
	//i gibt Fach an 0 = Z1, 11 = Z12
	public void putProduct(int i, int j, Product p) {
		if ( i == 0 && p.getQuantity() <= 30) {
			regal[i] = p;
		}
		if ( i == 1 && p.getQuantity() <= 30) {
			regal[i] = p;
		}
		if ( i == 2 && p.getQuantity() <= 60) {
			regal[i] = p;
		}
		if ( i == 3 && p.getQuantity() <= 30) {
			regal[i] = p;
		}
		if ( i == 4 && p.getQuantity() <= 30) {
			regal[i] = p;
		}
		if ( i == 5 && p.getQuantity() <= 120) {
			regal[i] = p;
		}
		if ( i == 6 && p.getQuantity() <= 120) {
			regal[i] = p;
		}
		if ( i == 7 && p.getQuantity() <= 120) {
			regal[i] = p;
		}
		if ( i == 8 && p.getQuantity() <= 360) {
			regal[i] = p;
		}
		if ( i == 9 && p.getQuantity() <= 60) {
			regal[i] = p;
		}
		if ( i == 10 && p.getQuantity() <= 60) {
			regal[i] = p;
		}
		if ( i == 11 && p.getQuantity() <= 120) {
			regal[i] = p;
		}
		else System.out.println("Size too big!" + p.getQuantity());
	}
	
	public double getRelDistance() {
		return Math.sqrt(((xDistance * xDistance) + (yDistance * yDistance)));
	}
	
	public Boolean isTemp() {
		return true;
	}
	
	public Product getProduct(int x, int y) {
		return regal[x];
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public double getCompartmentSpace(int i) {
		if ( i == 0) {
			return 30;
		}
		if ( i == 1) {
			return 30;
		}
		if ( i == 2) {
			return 60;
		}
		if ( i == 3) {
			return 30;
		}
		if ( i == 4) {
			return 30;
		}
		if ( i == 5) {
			return 120;
		}
		if ( i == 6) {
			return 120;
		}
		if ( i == 7) {
			return 120;
		}
		if ( i == 8) {
			return 360;
		}
		if ( i == 9) {
			return 60;
		}
		if ( i == 10) {
			return 60;
		}
		if ( i == 11) {
			return 120;
		}
		return 30;
		
	}
	
	public String getShelfID() {
		return "Regalposition " + "X: " + xDistance + " Y: " + yDistance;
	}
	
	public void getPositions(int prodid) {
		for (int i = 0; i <height; i++) {
			for (int j = 0; j < width; j++) {
				if (getProduct(i, j).getID() == prodid) {
					System.out.println( "Hier :" + getShelfID() + " "+i + j);
				}
			}
		}
	}

}
