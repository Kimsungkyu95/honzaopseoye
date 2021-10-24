package dto;

import java.util.List;

/**
 * 카테고리 DTO
 * */
public class CategoryDTO {
	private int categoryNo;
	private String categoryName;
	private List<CategoryDetailsDTO> categoryDetailsList;
	
	public CategoryDTO() {}

	public CategoryDTO(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	
	public CategoryDTO(int categoryNo, String categoryName, List<CategoryDetailsDTO> categoryDetailsList) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categoryDetailsList = categoryDetailsList;
	}
	

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
