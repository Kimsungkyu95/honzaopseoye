package dto;

public class ReviewContent {
	private int restaurantNo;
	private int restaurantLevel;
	private String restaurantName;
	
	private int reviewScore;
	private String reviewContent;
	private String reviewRegdate;
	
	public ReviewContent(int restaurantNo, int restaurantLevel, String restaurantName, int reviewScore,
			String reviewContent, String reviewRegdate) {
		this.restaurantNo = restaurantNo;
		this.restaurantLevel = restaurantLevel;
		this.restaurantName = restaurantName;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewRegdate = reviewRegdate;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public int getRestaurantLevel() {
		return restaurantLevel;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public String getReviewRegdate() {
		return reviewRegdate;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public void setRestaurantLevel(int restaurantLevel) {
		this.restaurantLevel = restaurantLevel;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public void setReviewRegdate(String reviewRegdate) {
		this.reviewRegdate = reviewRegdate;
	}
	
	
	
	
}
