package dto;

public class LevelUpExpDTO {
	
	private int memberExp;
	private int memberLevel;
	private int minExp;
	private int maxExp;
	
	
	
	public LevelUpExpDTO(int memberExp, int memberLevel, int minExp, int maxExp) {
		super();
		this.memberExp = memberExp;
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
	public int getMemberExp() {
		return memberExp;
	}
	public void setMemberExp(int memberExp) {
		this.memberExp = memberExp;
	}
		
}
