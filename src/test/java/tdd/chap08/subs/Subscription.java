package tdd.chap08.subs;

import java.time.LocalDate;

public class Subscription {

	private String userId;
	private String productId;
	private LocalDate expiryDate;
	private Grade grade;

	public Subscription(String userId, LocalDate expiryDate, Grade grade) {
		this.userId = userId;
		this.expiryDate = expiryDate;
		this.grade = grade;
	}

	public String getUserId() {
		return userId;
	}

	public String getProductId() {
		return productId;
	}

	public Grade getGrade() {
		return grade;
	}

	public boolean isFinished(LocalDate now) {
		return now.isAfter(expiryDate);
	}
}
