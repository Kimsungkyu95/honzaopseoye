<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>map</title>
<style>

</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" >
	
</script>
</head>
<body>

<div id="map" style="width:450px; height:450px;">
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5ca07a49c944c9276cbfe517db8d17c&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.508841, 127.100017), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

var reName = new Array();
var lat = new Array();
var lng = new Array();
<c:forEach items="${requestScope.list}" var="restaurant" varStatus="state">
	reName.push("${restaurant.restaurantName}"); 
	lat.push("${restaurant.restaurantLatitude}");
	lng.push("${restaurant.restaurantLongitude}");
</c:forEach>
for ( var i = 0; i < reName.length; i++) {
	 	console.log(reName[i])
	 	console.log(lat[i])
	 	console.log(lng[i])
} 
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
for (var i = 0; i < reName.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position:  new kakao.maps.LatLng(lat[i], lng[i]), // 마커를 표시할 위치
        title : reName[i], // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
}
</script>
</div>
</body>
</html>
