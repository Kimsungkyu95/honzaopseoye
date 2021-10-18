package dto;

public class LevelUpExpDTO {
	private int memberLevel;
	private int minExp;
	private int maxExp;
	public LevelUpExpDTO(int memberLevel, int minExp, int maxExp) {
		super();
		this.memberLevel = memberLevel;
		this.minExp = minExp;
		this.maxExp = maxExp;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}
	public int getMinExp() {
		return minExp;
	}
	public void setMinExp(int minExp) {
		this.minExp = minExp;
	}
	public int getMaxExp() {
		return maxExp;
	}
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}
	
	
}
