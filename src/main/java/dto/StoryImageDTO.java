package dto;

public class StoryImageDTO {
	private int storyImgNo;
	private int storyDetailsNo;
	private String storyImg;
	
	public StoryImageDTO() {
		
	}
	
	public StoryImageDTO(int storyImgNo, int storyDetailsNo, String storyImg) {
		super();
		this.storyImgNo = storyImgNo;
		this.storyDetailsNo = storyDetailsNo;
		this.storyImg = storyImg;
	}
	public int getStoryImgNo() {
		return storyImgNo;
	}
	public void setStoryImgNo(int storyImgNo) {
		this.storyImgNo = storyImgNo;
	}
	public int getStoryDetailsNo() {
		return storyDetailsNo;
	}
	public void setStoryDetailsNo(int storyDetailsNo) {
		this.storyDetailsNo = storyDetailsNo;
	}
	public String getStoryImg() {
		return storyImg;
	}
	public void setStoryImg(String storyImg) {
		this.storyImg = storyImg;
	}
	
}
