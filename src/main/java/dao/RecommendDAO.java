package dao;

import java.util.List;

import dto.RecommendDTO;

/**
 * 추천 페이지 관련 인터페이스
 * */
public interface RecommendDAO {
	
	 /**
     * 첫 화면에 띄울 기본 추천 리스트 검색 메소드
     * @return 추천 맛집 리스트(조회수 높은 순)
     */
    List<RecommendDTO> recByScore();
	 /**
     * 레벨에 따른 추천 리스트 검색 메소드
     * @return 추천 맛집 리스트(레벨별) 
	 * @param 맛집 레벨 번호
     */
	List<RecommendDTO> recByLevel(int levelNo);
	 /**
     * 조회수에 따른 추천 리스트 검색 메소드
     * @return 추천 맛집 리스트(조회수 높은 순)  
     */
	List<RecommendDTO> recByVisited();
	 /**
     * 태그에 따른 추천 리스트 검색 메소드
     * @return  추천 맛집 리스트(태그별)
	 * @param 태그번호
     */
	List<RecommendDTO> recByTag(int tagNo);

}
