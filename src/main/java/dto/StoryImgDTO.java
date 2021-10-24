package dto;

/**
 * 스토리 이미지 DTO
 * */
public class StoryImgDTO {
	private int storyImgNo;
	private int storyDetailsNo;
	private String storyImg;
	
	public StoryImgDTO() {}
	
	public StoryImgDTO(int storyImgNo, int storyDetailsNo, String storyImg) {
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
