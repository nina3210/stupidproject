package warehouse2;

import java.util.*;
import java.lang.Math; 

public class Midshelf implements Shelves{
	
	private Product [][] regal;
	private int height;
	private int width;
	private double xDistance;
	private double yDistance;
	private double depth;
	
	public Midshelf(int x, int y, double d, double xD, double yD) throws IllegalArgumentException{
		
		if (y != 4 && y != 12) {
			throw new IllegalArgumentException();
		}

		regal = new Product[x][y];
		this.xDistance 	= xD;
		this.yDistance 	= yD;
		this.depth 		= 1 * d;
		this.height		= x;
		this.width 		= y;
		
		Product tester = new Product(77, "es", "klappt", 0, false);
		
		
		for (int i = 0; i< height; i++) {
			for (int j = 0; j < width; j++) {
				regal[i][j] = new Product(0, "leer", "leer", 0, false);
			}
		}
		regal[2][0] = tester;
	}
	
	public void putProduct (int x, int y, Product p) {
		//x y Koordinaten im Regal, x ist Höhe von oben runter

		if ( x == 0 && p.getQuantity() <= (150*depth) ) {
		regal[x][y] = p;
		}
		else if ( x == 1 && p.getQuantity() <= (40*depth) ) {
		regal[x][y] = p;
		}
		else if ( x == 2 && p.getQuantity() <= (40*depth) ) {
		regal[x][y] = p;
		}
		else if ( x == 3 && p.getQuantity() <= (60*depth) ) {
		regal[x][y] = p;
		}
		else if ( x == 4 && p.getQuantity() <= (60*depth) ) {
		regal[x][y] = p;
		}
		else if ( x == 5 && p.getQuantity() <= (50*depth) ) {
		regal[x][y] = p;
		}
		else if ( x == 6 && p.getQuantity() <= (95*depth) ) {
		regal[x][y] = p;
		}
		else if ( x == 7 && p.getQuantity() <= (140*depth) ) {
		regal[x][y] = p;
		}

		else System.out.println("Menge zu groß!");
	}
	
	public Product getProduct(int x, int y) {
		return regal[x][y];
	}
	
	public double getRelDistance() {
		return Math.sqrt(((xDistance * xDistance) + (yDistance * yDistance)));
	}
	
	public Boolean isTemp() {
		return false;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}

	public double getCompartmentSpace(int x) {
		if ( x == 0 ) {
		return (150*depth);
		}
		else if ( x == 1 ){
		return	(40*depth);
		}
		else if ( x == 2) {
		return	(40*depth);
		}
		else if ( x == 3) {
			return	(60*depth);
		}
		else if ( x == 4) {
			return	(40*depth);
		}
		else if ( x == 5) {
			return	(50*depth);
		}
		else if ( x == 6) {
			return	(95*depth);
		}
		else if ( x == 7 ) {
			return	(140*depth);
		}
		return 0;
	}
	
	public String getShelfID() {
		return "Regalposition " + "X: " + xDistance + " Y: " + yDistance;
	}
}