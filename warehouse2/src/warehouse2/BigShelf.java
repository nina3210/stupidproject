package warehouse2;

import java.util.*;
import java.lang.Math; 

public class BigShelf implements Shelves{
	
	private Product [][] regal;
	private int height;
	private int width;
	private double xDistance;
	private double yDistance;

	
	public BigShelf(double xD, double yD) {
		

		this.xDistance 	= xD;
		this.yDistance 	= yD;
		this.height		= 25;
		this.width 		= 40;
		regal = new Product[this.height	][this.width ];
		
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

		regal[x][y] = p;

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
	
	public double getCompartmentSpace(int i) {
		return 600;
	}
	
	public String getShelfID() {
		return "Regalposition " + "X: " + xDistance + " Y: " + yDistance;
	}

}