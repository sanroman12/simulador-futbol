package act24;

import java.lang.Comparable;

public class Rectangle implements Comparable<Rectangle>{
	private double base;
	private double height;
	private static int instancesCount = 0;
	
	public int x = 0;
	
	public static final double MIN_BASE = 1.0;
	public static final double MIN_HEIGHT = 1.0;
	public static final double MAX_BASE = 100.0;
	public static final double MAX_HEIGHT = 100.0;

	// Constructores
	public Rectangle() {
		base = MIN_BASE;
		height = MIN_HEIGHT;
		instancesCount++;
	}

	public Rectangle(double side) {
		setBase(side);
		setHeight(side);
		instancesCount++;
	}
	
	public Rectangle(double base,double height) {
		setBase(base);
		setHeight(height);
		instancesCount++;
	}
	
	
	// Métodos setters
	public void setBase(double base) {
		if(base>=MIN_BASE && base<=MAX_BASE)
			this.base = base;
	}
	public void setHeight(double height) {
		if(height>=MIN_HEIGHT && height<=MAX_HEIGHT)
			this.height = height;
	}
	
	// Getters
	public double getBase() {
		return base;
	}
	public double getHeight() {
		return height;
	}
	
	public double getPerimeter() {
		return 2 * base + 2* height;
	}

	public static double getPerimeter(double base,double height) {
		return 2 * base + 2* height;
	}
	
	public double getArea() {
		return base * height;
	}
	
	public static double getArea(double base,double height) {
		return base * height;
	}
	
	public Rectangle clone() {
		return new Rectangle(base,height);
	}
	
	public boolean equals(Object o) {
		boolean retValue = false;
		if(o instanceof Rectangle) {
			Rectangle r = (Rectangle) o;
			retValue = r.getBase() == this.base && r.getHeight() == this.height;
		}
		return retValue;
	}
	
	public static int getInstancesCount() {
		return instancesCount;
	}
	
	public String toString() {
		return "\"Rectangle\":{"+
				"\"base:\""+base+","+
				"\"height:\""+height+
				"}";
	}
	
	public int compareTo(Rectangle o1, Rectangle o2) {
		return (int) (o1.getArea()-o2.getArea());
	}


	@Override
	public int compareTo(Rectangle o) {
		return 0;
	}
}
