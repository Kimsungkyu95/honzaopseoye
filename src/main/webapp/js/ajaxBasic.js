/**
 * 
 */

$(function(){
 		//alert(1);
 		//전체검색하기 
 		function selectAll(){
 			$.ajax({
  				url : "../selectAll", 	//서버요청주소 
  				type : "post", 	// method방식(get,post,put,delete)
  				dataType : "json",	//서버가 응답해주는 데이터의 type(text, html, xml, json)
  				//data : {keyWord: $(this).val()}, 	 
  				success : function(result){
  					//alert(result);
  					//결과를 테이블에 넣는다. 
  					let str="";
  					$.each(result, function(index, item){
  						str+="<tr>";
  						str+="<td>"+(index+1)+"</td>";
  						str+=`<td><a href='#'>${item.id}</a></td>`;
  						str+=`<td>${item.name}</td>`;
						str+=`<td>${item.age}</td>`;
						str+=`<td>${item.tel}</td>`;
						str+=`<td>${item.addr}</td>`;
						str+=`<td><input type='button' value='삭제' id='${item.id}'></td>`;
  						str+="</tr>";
  					})
  					//$("#listTable").append(str);
  					$("#listTable tr:gt(0)").remove();
  					$("#listTable tr:eq(0)").after(str);
  					
  					$("a").css("textDecoration", "none");
  				},		
  				error : function(err){
  					alert(err+"발생했어요.")
  					//실패했을때 함수
  				}		
  				
  			}); //ajax끝 
 		}
 		//////////////////////////////
 		//중복체크하기 
 		$("#id").keyup(function(){
 			if($(this).val()==""){
 				$("span").text("");
 				return; //함수를 빠져나가라.
 			}
 			$.ajax({
  				url : "../idCheck", 	//서버요청주소 
  				type : "post", 	// method방식(get,post,put,delete)
  				dataType : "text",	//서버가 응답해주는 데이터의 type(text, html, xml, json)
  				data : {id: $(this).val()}, 	 
  				success : function(result){
  					//console.log("result :"+ result);
  					$("span").text(result);
  					
  				},		
  				error : function(err){
  					alert(err+"발생했어요.")
  					//실패했을때 함수
  				}		
  				
  			}); //ajax끝 
 		});
 		
 		////////////////////
 		//가입하기 or 수정하기 
 		$("#btn").click(function(){
 			let urlAddr="../insert";
 			let state = true; //등록이나 수정을 해야하는지 여부를 판단하는 상태변수(true이면 ajax실행, false이면 안한다.)
 			//유효성체크한다. 
 			$("input[type=text]").each(function(index, element){ //element는 <input요소>
 				if($(this).val() == ""){
 					alert("값을 입력하세요.");
 					$(this).focus();// 커서놓기 
 					//return;//each안에 있는 하나의 function만 빠져나간다. 
 					state = false; //ajax실행(가입 또는수정) x 
 					return false; //each빠져나가라!! 
 				}
 			});
 			
 			if(state){ //등록 또는 수정
 				if($(this).val()=="수정하기"){
 					urlAddr = "../update";
 					$("#id").removeAttr("readonly"); //속성제거 
 					$("span").show();
 					$("#btn").val("가입하기");
 					
 				}
 				$.ajax({
 	  				url : urlAddr, 	//서버요청주소 
 	  				type : "post", 	// method방식(get,post,put,delete)
 	  				dataType : "text",	//서버가 응답해주는 데이터의 type(text, html, xml, json)
 	  				data : $("#inForm").serialize(), //폼전송
 	  				success : function(result){ //0, 1
 	  					if(result==0){
 	  						alert("실패하였습니다.")
 	  					}else{
 	  						//text박스 지우기 
 	  						//document.getElementById("#inForm").reset();
 	  						
 	  						$("input[type=text]").val("");
 	  						$("span").text("중복결과여부");
 	  						//화면갱신 
 	  						selectAll();
 	  					}
 	  				},		
 	  				error : function(err){
 	  					alert(err+"발생했어요.")
 	  					//실패했을때 함수
 	  				}		
 	  				
 	  				});//ajax끝 
 				}//if문 
 	 		}); //clickEnd 
 			/////////////////////////////
 			/*
 				아이디를 클릭햇을때(a태그) 처리할 이벤트 - 동적으로 생성 
 			*/
 			$(document).on("click", "#listTable > tbody > tr > td:nth-child(2) > a",  function(){
 				let name = $(this).parent().next(); //<td>
 				let age = name.next(); 
 				let tel = age.next(); 
 				let addr = tel.next(); 
 				
 				$("#id").val( $(this).text() );
 				$("#name").val(name.text());
 				$("#age").val(age.text());
 				$("#tel").val(tel.text());
 				$("#addr").val(addr.text());
 				
 				//////////////////
 				//아이디 박스를 비활성화
 				$("#id").attr("readonly", "readonly");
 				
 				//버튼 글씨를 수정하기로 변경 
 				$("#btn").val("수정하기");
 				
 				//span태그를 감추기 
 				$("span").hide();
 			});
 			///////////////////////////////////////////////////
 			//삭제하기 기능 
 			$(document).on("click","[value=삭제]", function(){
 				//alert($(this).attr("id"))
 				$.ajax({
 	  				url : "../delete", 	//서버요청주소 
 	  				type : "post", 	// method방식(get,post,put,delete)
 	  				dataType : "text",	//서버가 응답해주는 데이터의 type(text, html, xml, json)
 	  				data : {id : $(this).attr("id")}, 
 	  				success : function(result){ //0, 1
 	  					if(result==0){
 	  						alert("삭제되지 않았습니다.")
 	  					}else{
 	  						selectAll();
 	  					}
 	  				},		
 	  				error : function(err){
 	  					alert(err+"발생했어요.")
 	  			
 	  				}		
 				});
 		////////////////////////////////	
 			selectAll();
 				
 })//readyEnd 
})