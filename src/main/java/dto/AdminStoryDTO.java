package dto;


public class AdminStoryDTO {
	private int storyNo;
	private int memberNo;
	private String storyTitle;
	private String storyRegdate;
	private int storyVisited;
	
	public AdminStoryDTO() {
		
	}


	public AdminStoryDTO(int storyNo, int memberNo, String storyTitle, String storyRegdate, int storyVisited) {
		super();
		this.storyNo = storyNo;
		this.memberNo = memberNo;
		this.storyTitle = storyTitle;
		this.storyRegdate = storyRegdate;
		this.storyVisited = storyVisited;
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

}