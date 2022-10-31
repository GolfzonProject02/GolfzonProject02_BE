<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>selectAll.jsp</h1>
	
<!-- 	<form action="searchList.do" method="get"> -->
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<td><select name="searchKey" id="searchKey"> -->
<!-- 						<option value="name">name</option> -->
<!-- 						<option value="age">age</option> -->
<!-- 				</select></td> -->
<!-- 				<td><input type="text" name="searchWord" id="searchWord" -->
<!-- 					value="ki">  -->
					
<!-- 					</td> -->
<!-- 					<td> -->
<!-- 					<input type="submit"> -->
<!-- 					</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 	</form> -->
	

 <!-- selectAll -->
		<div id="space_container">
      <c:forEach var="space" items="${space_list}">
        <div class="space_box">
          <ul>
            <a href="/host/backoffice/space_selectOne.do?space_num=${space.space_num}">
              <li><img id="space_img" alt="${space.space_img}" src="../resources/upload/space/${space.space_img}"></li>
			<!--  공간명 -->
              <li id=space_name>${space.space_name}</li>
			<!--  주소 -->
              <li id=address>${space.address}</li>              
			<!--  공간종류 -->
               <script>
	                    // 1:데스크, 2:회의실, 3:오피스
	                    var space_type = ${space.space_type};
	                    if(space_type == 1) {
	                        document.write("데스크");
	                    } else if(space_type == 2) {
	                        document.write("회의실");
	                    } else if(space_type == 3) {
	                        document.write("오피스");
	                    }
                  </script>
		<!--   평점이랑 리뷰갯수는 리뷰 구현하고 추가할게욥 -->
            </a>
          </ul>
        </div>
      </c:forEach>
    </div>
    
</body>
</html>