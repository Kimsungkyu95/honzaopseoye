package dto;

public class StoryDetailsDTO {
	private int storyDetailsNo;
	private int restaurantNo;
	private String storyContent;
	private int storyNo;
	
	public StoryDetailsDTO() {}

	public StoryDetailsDTO(int storyDetailsNo, int restaurantNo, String storyContent, int storyNo) {
		super();
		this.storyDetailsNo = storyDetailsNo;
		this.restaurantNo = restaurantNo;
		this.storyContent = storyContent;
		this.storyNo = storyNo;
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

	public String getStoryContent() {
		return storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}

	public int getStoryNo() {
		return storyNo;
	}

	public void setStoryNo(int storyNo) {
		this.storyNo = storyNo;
	}
	
}
