package estudioPoo;

public class circulo {
	
	private int x, y, radius;

	public circulo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.radius = 1;
	}

	public circulo(int x, int y, int radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "circulo [x=" + x + ", y=" + y + ", radius=" + radius + "]";
	}

}
