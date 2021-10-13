package dto;

public class ReviewDTO {
	private int reviewNo;
	private int reviewScore;
	private String reviewContent;
	private String reviewRegdate;
	private int memberNo;
	private int restaurantNo;
	
	public ReviewDTO() { }

	public ReviewDTO(int reviewNo, int reviewScore, String reviewContent, String reviewRegdate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewRegdate = reviewRegdate;
	}

	

	public ReviewDTO(int reviewNo, int reviewScore, String reviewContent, String reviewRegdate, int memberNo,
			int restaurantNo) {
		super();
		this.reviewNo = reviewNo;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewRegdate = reviewRegdate;
		this.memberNo = memberNo;
		this.restaurantNo = restaurantNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewRegdate() {
		return reviewRegdate;
	}

	public void setReviewRegdate(String reviewRegdate) {
		this.reviewRegdate = reviewRegdate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	
	
}
