package dto;

/**
 * 추천 알고리즘 관련 DTO
 * */
public class RecommendDTO {
	private String restaurantImg;
	private String restaurantName;
	private int reviewScore;
	private String gu;
	private String menuName;
	private String categoryName;
	private String categoryDetailsName;
	private int restaurantNo;
	
	public RecommendDTO() {}
	public RecommendDTO(String restaurantImg, String restaurantName, int reviewScore, String gu,
			String menuName) {
	
		this.restaurantImg = restaurantImg;
		this.restaurantName = restaurantName;
		this.reviewScore = reviewScore;
		this.gu = gu;
		this.menuName = menuName;
	}
	public RecommendDTO(String restaurantImg, String restaurantName, int reviewScore, String gu,
			String categoryName, String categoryDetailsName, int restaurantNo) {
	
		this.restaurantImg = restaurantImg;
		this.restaurantName = restaurantName;
		this.reviewScore = reviewScore;
		this.gu = gu;
		this.categoryName = categoryName;
		this.categoryDetailsName = categoryDetailsName;
		this.restaurantNo=restaurantNo;
	}
	
	public RecommendDTO(String restaurantImg, String restaurantName, String gu,
			String categoryName, String categoryDetailsName, int restaurantNo) {
	
		this.restaurantImg = restaurantImg;
		this.restaurantName = restaurantName;
		this.gu = gu;
		this.categoryName = categoryName;
		this.categoryDetailsName = categoryDetailsName;
		this.restaurantNo=restaurantNo;
	}
	public RecommendDTO(String restaurantImg, String restaurantName, int reviewScore, String gu) {
	
		this.restaurantImg = restaurantImg;
		this.restaurantName = restaurantName;
		this.reviewScore = reviewScore;
		this.gu = gu;
	}
	public String getRestaurantImg() {
		return restaurantImg;
	}
	public void setRestaurantImg(String restaurantImg) {
		this.restaurantImg = restaurantImg;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String Gu) {
		this.gu = gu;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDetailsName() {
		return categoryDetailsName;
	}
	public void setCategoryDetailsName(String categoryDetailsName) {
		this.categoryDetailsName = categoryDetailsName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	
	
	
	

}
