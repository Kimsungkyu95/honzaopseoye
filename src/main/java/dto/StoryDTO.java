package dto;

import java.util.List;

/**
 * 스토리 DTO
 * */
public class StoryDTO {
	private int storyNo;
	private int memberNo;
	private String memberName;
	private String memberId;
	private String storyTitle;
	private String restaurantName;
	private String storyContent;
	private String storyRegdate;
	private int storyVisited;
	private String storyPassword;
	
	private List<String> storyImgList;
	
	public StoryDTO() {}

	public StoryDTO(int storyNo, int memberNo, String storyTitle, String restaurantName, String storyContent,
			String storyRegdate, int storyVisited, String storyPassword, List<String> storyImgList) {
		super();
		this.storyNo = storyNo;
		this.memberNo = memberNo;
		this.storyTitle = storyTitle;
		this.restaurantName = restaurantName;
		this.storyContent = storyContent;
		this.storyRegdate = storyRegdate;
		this.storyVisited = storyVisited;
		this.storyPassword = storyPassword;
		this.storyImgList = storyImgList;
	}
	
	public StoryDTO(int storyNo, int memberNo, String storyTitle, String restaurantName, String storyContent,
			String storyRegdate, int storyVisited, String storyPassword) {
		super();
		this.storyNo = storyNo;
		this.memberNo = memberNo;
		this.storyTitle = storyTitle;
		this.restaurantName = restaurantName;
		this.storyContent = storyContent;
		this.storyRegdate = storyRegdate;
		this.storyVisited = storyVisited;
		this.storyPassword = storyPassword;
	}
	
	

	public StoryDTO(String storyTitle, String restaurantName, String storyContent, String storyPassword,
			List<String> storyImgList) {
		super();
		this.storyTitle = storyTitle;
		this.restaurantName = restaurantName;
		this.storyContent = storyContent;
		this.storyPassword = storyPassword;
		this.storyImgList = storyImgList;
	}

	public StoryDTO(int storyNo, String storyTitle, String restaurantName, String storyContent, String storyPassword,
			List<String> storyImgList) {
		super();
		this.storyNo = storyNo;
		this.storyTitle = storyTitle;
		this.restaurantName = restaurantName;
		this.storyContent = storyContent;
		this.storyPassword = storyPassword;
		this.storyImgList = storyImgList;
	}
	
	public StoryDTO(String memberId, String storyTitle, String restaurantName, String storyContent,
			String storyPassword, List<String> storyImgList) {
		super();
		this.memberId = memberId;
		this.storyTitle = storyTitle;
		this.restaurantName = restaurantName;
		this.storyContent = storyContent;
		this.storyPassword = storyPassword;
		this.storyImgList = storyImgList;
	}

	public StoryDTO(int storyNo, int memberNo, String memberName, String storyTitle, String restaurantName,
			String storyContent, String storyRegdate, int storyVisited, String storyPassword) {
		super();
		this.storyNo = storyNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.storyTitle = storyTitle;
		this.restaurantName = restaurantName;
		this.storyContent = storyContent;
		this.storyRegdate = storyRegdate;
		this.storyVisited = storyVisited;
		this.storyPassword = storyPassword;
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

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getStoryContent() {
		return storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
