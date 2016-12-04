
public class Point {
	
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Point)) {
			return false;
		}
		
		Point compPoint = (Point) o;
		return compPoint.getX() == this.getX() && compPoint.getY() == this.getY();
	}
	
	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
	    hash = 71 * hash + this.x;
	    hash = 71 * hash + this.y;
	    return hash;
	}
}
