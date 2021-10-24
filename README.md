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
## :pushpin: 기능요구사항 
|기능|요구사항|
|------|---|
|테스트1|테스트2|
|테스트1|테스트2|
|테스트1|테스트2|
