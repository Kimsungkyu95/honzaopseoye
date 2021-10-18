package dto;

import java.util.List;

public class MemberDTO {
	private int memberNo;
	private String memberID;
	private String memberPwd;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String memberBirth;
	private String memberJoinDate;
	private int memberExp;
	private String profileImage;
	
	private List<ReviewDTO> reviewList;
	private List<StoryDTO> storyList;
	
	public MemberDTO() {}

	public MemberDTO(int memberNo, String memberID, String memberPwd, String memberName, String memberEmail, String memberPhone,
			String memberBirth, String memberJoinDate, int memberExp, String profileImage, List<ReviewDTO> reviewList,
			List<StoryDTO> storyList) {
		super();
		this.memberNo = memberNo;
		this.memberID = memberID;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberJoinDate = memberJoinDate;
		this.memberExp = memberExp;
		this.profileImage = profileImage;
		this.reviewList = reviewList;
		this.storyList = storyList;
	}

	public MemberDTO(String memberID, String memberPwd, String memberName, String memberEmail, String memberPhone, String memberBirth,
			String profileImage) {
		super();
		this.memberID = memberID;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.profileImage = profileImage;
	}
	
	public MemberDTO(int memberNo, String memberID, String memberName, String MemberJoinDate, int memberExp) {
		this.memberNo = memberNo;
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberJoinDate = memberJoinDate;
		this.memberExp = memberExp;
	}


	public MemberDTO(String memberID, String memberPwd, String memberName) {
		super();
		this.memberID = memberID;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
	}

	public MemberDTO(int memberNo, String memberID, String memberPwd, String memberName, String memberEmail, String memberPhone, String memberBirth, String joinDate, int membeExp, String profileImage) {
		this.memberNo = memberNo;
		this.memberID = memberID;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberExp = memberExp;
		this.profileImage = profileImage;
	}

	public MemberDTO(String memberID, String memberPwd) {
		super();
		this.memberID = memberID;
		this.memberPwd = memberPwd;
	}

	public MemberDTO(int memberNo, String memberName, String memberEmail, String memberPhone, String memberBirth) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberJoinDate() {
		return memberJoinDate;
	}

	public void setMemberJoinDate(String memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}

	public int getMemberExp() {
		return memberExp;
	}

	public void setMemberExp(int memberExp) {
		this.memberExp = memberExp;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}

	public List<StoryDTO> getStoryList() {
		return storyList;
	}

	public void setStoryList(List<StoryDTO> storyList) {
		this.storyList = storyList;
	}
	
	

	
}
