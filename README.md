# honzaopseoye(혼자옵서예)
## :pushpin:주제 및 개요
- 서울시 내의 혼밥 맛집 추천이라는 주제를 가지고 프로젝트를 진행하였습니다. `혼저옵서예`라는 제주도 방언이 있습니다. 이 말은  `어서오세요`라는 뜻입니다. 점차 1인 가구가 증가하고 생활의 템포가 빨라지면서, 혼자 밥 먹는 사람도 많이 늘어났습니다. 하지만 혼자 가기엔 분명 부담스러운 맛집들이 있고, 밖에서 혼자 밥 먹는 것을 꺼리는 사람들도 있습니다. 저희는 이처럼 혼자 밥 먹는 것을 어려워하는 사람들을 위한 서비스를 개발하고자 하였고, 혼밥인들이여 `두려워하지 말고 어서오라`라는 의미에서 `혼자옵서예`라는 프로젝트를 기획하였습니다. 사용자는 혼밥 레벨테스트를 통해 혼밥 레벨을 부여받고 맛집들에도 혼밥 레벨을 부여하여 사용자가 혼자 밥 먹을 맛집을 더욱 편하게 선택하고, 또 추천받을 수 있도록 하는 것이 저희 서비스의 목적입니다. 
## :pushpin:개발 일정
![개발일정](https://user-images.githubusercontent.com/69083280/138586686-8d15fb72-c369-4d14-9839-f75080f1b716.png)
## :pushpin:개발 환경
사용Tool: Eclipse, SQLDeveloper<br>
Language: Java, HTML5, CSS, JavaScript, Jquery, Bootstrap<br>
Server: Apache Tomcat 9.0<br>
DB: AWS RDS Oracle 12c<br>
버전관리 및 협업: GitHub, Notion
## :pushpin:초기 데이터 세팅
1. 통계청에서 제공하는 서울시 행정동 정보 엑셀 파일을 기반으로, Java에서 손쉬운 사용을 위해 편집
2. 맛집의 종류를 19개의 세부 카테고리로 나누고 Kakao 지역검색 API로 ~동 ~맛집이라는 키워드로 검색하여 JSON 데이터를 가져와서 DB에 저장
3. JSON 데이터에 포함된 Kakao 플레이스 URL로 접근하여 맛집 이미지 크롤링
## :pushpin:ER-Diagram
![erd](https://user-images.githubusercontent.com/69083280/138587425-3e65fc53-1b05-4a20-828f-c99cfd8f2e5c.PNG)
## :pushpin:기능요구사항 
|기능|요구사항|
|----|------|
|계정관리|개인정보수정, 로그인로그아웃, ID&PASSWORD찾기, 회원가입기능, 회원탈퇴기능|
|검색/카테고리|사용자위치기반검색, 카테고리에 대한 검색, 맛집에 따른 검색 |
|맛집|별점매기는기능, 리뷰쓰는기능, 맛집등록, 수정, 삭제,조회|
|추천|레벨에 따른 추천, 조회수 기준 추천, 태그에 따른 메뉴 추천|
|레벨|경험치에 따른 레벨업 기능, 회원가입시 레벨 테스트를 통해서 각 회원마다 초기 레벨 설정|
|스토리|스토리 전체 조회, 스토리 상세 조회, 스토리 등록, 스토리 수정, 스토리 삭제|
## :pushpin:프로젝트 흐름도 
![프로젝트흐름도](https://user-images.githubusercontent.com/76465997/138594915-65a4fd72-6975-48cd-a8ac-2e0dcf2ea4ba.png)
## :pushpin:화면 
메인
<img width="1440" alt="메인" src="https://user-images.githubusercontent.com/76465997/138592778-154d7ca9-bec2-49c4-bf1f-2cc661556f66.png">
<hr>
태그별 추천
<img width="1440" alt="태그별" src="https://user-images.githubusercontent.com/76465997/138592769-09e8ce35-60b2-40d6-9e3a-3518214020f4.png">
<hr>
레벨별 추천
<img width="1440" alt="레벨별" src="https://user-images.githubusercontent.com/76465997/138592776-0a664b7e-09eb-44c7-b361-4b82297751ad.png">
<hr>
관리자 맛집
<img width="1440" alt="관리자맛집" src="https://user-images.githubusercontent.com/76465997/138592765-a4c3eb35-188c-4372-b6a2-6ca59b75f93d.png">


