package tdd.chap08.subs;

public class Product {

	private String id;
	private int defaultPoint;

	public Product(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public int getDefaultPoint() {
		return defaultPoint;
	}

	public void setDefaultPoint(int defaultPoint) {
		this.defaultPoint = defaultPoint;
	}
}
