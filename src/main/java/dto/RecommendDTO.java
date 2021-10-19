package dto;

public class RecommendDTO {
	private String restaurantImg;
	private String restaurantName;
	private int reviewScore;
	private String gu;
	private String menuName;
	
	public RecommendDTO() {}
	public RecommendDTO(String restaurantImg, String restaurantName, int reviewScore, String gu,
			String menuName) {
	
		this.restaurantImg = restaurantImg;
		this.restaurantName = restaurantName;
		this.reviewScore = reviewScore;
		this.gu = gu;
		this.menuName = menuName;
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
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	
	
	

}
