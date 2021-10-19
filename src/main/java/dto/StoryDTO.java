package dto;

import java.util.List;

public class StoryDTO {
	private int storyNo;
	private int memberNo;
	private String storyTitle;
	private String storyRegdate;
	private int storyVisited;
	private String storyPassword;
	
	private List<String> storyImgList;
	
	public StoryDTO() {}
	
	public StoryDTO(int storyNo, int memberNo, String storyTitle, String storyRegdate, int storyVisited,
			String storyPassword, List<String> storyImgList) {
		super();
		this.storyNo = storyNo;
		this.memberNo = memberNo;
		this.storyTitle = storyTitle;
		this.storyRegdate = storyRegdate;
		this.storyVisited = storyVisited;
		this.storyPassword = storyPassword;
		this.storyImgList = storyImgList;
	}

	public int getStoryNo() {
		return storyNo;
	}

	public void setStoryNo(int storyNo) {
		this.storyNo = storyNo;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

	public String getStoryRegdate() {
		return storyRegdate;
	}

	public void setStoryRegdate(String storyRegdate) {
		this.storyRegdate = storyRegdate;
	}

	public int getStoryVisited() {
		return storyVisited;
	}

	public void setStoryVisited(int storyVisited) {
		this.storyVisited = storyVisited;
	}

	public String getStoryPassword() {
		return storyPassword;
	}

	public void setStoryPassword(String storyPassword) {
		this.storyPassword = storyPassword;
	}

	public List<String> getStoryImgList() {
		return storyImgList;
	}

	public void setStoryImgList(List<String> storyImgList) {
		this.storyImgList = storyImgList;
	}
}
