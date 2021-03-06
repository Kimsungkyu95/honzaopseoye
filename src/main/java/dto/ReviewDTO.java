package dto;

/**
 * 리뷰 DTO
 * */
public class ReviewDTO {
	private int reviewNo;
	private int memberNo;
	private String memberName;
	private String restaurantName;

	private int restaurantNo;
	private int reviewScore;
	private String reviewContent;
	private String reviewRegdate;
	
	
	public ReviewDTO() { }
	public ReviewDTO(int reviewNo, int memberNo, String memberName, String restaurantName, int restaurantNo,
			int reviewScore, String reviewContent, String reviewRegdate) {
		super();
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.restaurantName = restaurantName;
		this.restaurantNo = restaurantNo;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewRegdate = reviewRegdate;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public ReviewDTO(int reviewNo, int reviewScore, String reviewContent, String reviewRegdate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewRegdate = reviewRegdate;
	}

	public ReviewDTO(int reviewNo, int memberNo,
			int restaurantNo, int reviewScore, String reviewContent, String reviewRegdate) {
		this(reviewNo,reviewScore,reviewContent,reviewRegdate);
		this.reviewContent = reviewContent;
		this.reviewRegdate = reviewRegdate;
	}
	
	public ReviewDTO(int reviewScore, String reviewContent, String reviewRegdate) {
		this.reviewScore=reviewScore;
		this.reviewContent=reviewContent;
		this.reviewRegdate=reviewRegdate;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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

	
	
	
}
