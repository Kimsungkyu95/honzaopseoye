package dto;

public class RestaurantImgDTO {
	private int restaurantImgNo;
	private int restaurantNo;
	private String restaurantImg;
	
	public RestaurantImgDTO() {
		
	}

	public RestaurantImgDTO(int restaurantImgNo, int restaurantNo, String restaurantImg) {
		super();
		this.restaurantImgNo = restaurantImgNo;
		this.restaurantNo = restaurantNo;
		this.restaurantImg = restaurantImg;
	}

	public int getRestaurantImgNo() {
		return restaurantImgNo;
	}

	public void setRestaurantImgNo(int restaurantImgNo) {
		this.restaurantImgNo = restaurantImgNo;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getRestaurantImg() {
		return restaurantImg;
	}

	public void setRestaurantImg(String restaurantImg) {
		this.restaurantImg = restaurantImg;
	}
	
}
