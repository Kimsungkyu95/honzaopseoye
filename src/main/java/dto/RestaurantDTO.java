package dto;

import java.util.List;

public class RestaurantDTO {
	private int restaurantNo;
	private String restaurantName;
	private String restaurantPhone;
	private String restaurantAddr;
	private int restaurantLongitude;
	private int restaurantLatitude;
	private String restaurantRegDate;
	private int restaurantVisited;
	private List<ReviewDTO> reviewList;
	private List<StoryDetailsDTO> storyDetailsList;
	private List<String>hashTagName;
	private List<MenuDTO> menuList;
	
	public RestaurantDTO() { }

	public RestaurantDTO(int restaurantNo, String restaurantName, String restaurantPhone, String restaurantAddr,
			int restaurantLongitude, int restaurantLatitude, String restaurantRegDate, int restaurantVisited,
			List<String> hashTagName) {
		super();
		this.restaurantNo = restaurantNo;
		this.restaurantName = restaurantName;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddr = restaurantAddr;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantLatitude = restaurantLatitude;
		this.restaurantRegDate = restaurantRegDate;
		this.restaurantVisited = restaurantVisited;
		this.hashTagName = hashTagName;
	}
	

	public RestaurantDTO(int restaurantNo, String restaurantName, String restaurantPhone, String restaurantAddr,
			int restaurantLongitude, int restaurantLatitude, String restaurantRegDate, int restaurantVisited,
			List<ReviewDTO> reviewList, List<StoryDetailsDTO> storyDetailsList, List<String> hashTagName,
			List<MenuDTO> menuList) {
		super();
		this.restaurantNo = restaurantNo;
		this.restaurantName = restaurantName;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddr = restaurantAddr;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantLatitude = restaurantLatitude;
		this.restaurantRegDate = restaurantRegDate;
		this.restaurantVisited = restaurantVisited;
		this.reviewList = reviewList;
		this.storyDetailsList = storyDetailsList;
		this.hashTagName = hashTagName;
		this.menuList = menuList;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

	public String getRestaurantAddr() {
		return restaurantAddr;
	}

	public void setRestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}

	public int getRestaurantLongitude() {
		return restaurantLongitude;
	}

	public void setRestaurantLongitude(int restaurantLongitude) {
		this.restaurantLongitude = restaurantLongitude;
	}

	public int getRestaurantLatitude() {
		return restaurantLatitude;
	}

	public void setRestaurantLatitude(int restaurantLatitude) {
		this.restaurantLatitude = restaurantLatitude;
	}

	public String getRestaurantRegDate() {
		return restaurantRegDate;
	}

	public void setRestaurantRegDate(String restaurantRegDate) {
		this.restaurantRegDate = restaurantRegDate;
	}

	public int getRestaurantVisited() {
		return restaurantVisited;
	}

	public void setRestaurantVisited(int restaurantVisited) {
		this.restaurantVisited = restaurantVisited;
	}

	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}

	public List<StoryDetailsDTO> getStoryDetailsList() {
		return storyDetailsList;
	}

	public void setStoryDetailsList(List<StoryDetailsDTO> storyDetailsList) {
		this.storyDetailsList = storyDetailsList;
	}

	public List<String> getHashTagName() {
		return hashTagName;
	}

	public void setHashTagName(List<String> hashTagName) {
		this.hashTagName = hashTagName;
	}
	
	
}
