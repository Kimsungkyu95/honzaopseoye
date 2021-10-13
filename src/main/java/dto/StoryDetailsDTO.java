package dto;

public class StoryDetailsDTO {
	private int storyDetailsNo;
	private int restaurantNo;
	private int storyNo;
	private String storyContent;
	
	
	public StoryDetailsDTO() {}

	public StoryDetailsDTO(int storyDetailsNo, int restaurantNo, int storyNo, String storyContent) {
		super();
		this.storyDetailsNo = storyDetailsNo;
		this.restaurantNo = restaurantNo;
		this.storyNo = storyNo;
		this.storyContent = storyContent;
	}

	public int getStoryDetailsNo() {
		return storyDetailsNo;
	}

	public void setStoryDetailsNo(int storyDetailsNo) {
		this.storyDetailsNo = storyDetailsNo;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	
	public int getStoryNo() {
		return storyNo;
	}

	public void setStoryNo(int storyNo) {
		this.storyNo = storyNo;
	}

	public String getStoryContent() {
		return storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}

	
	
}
