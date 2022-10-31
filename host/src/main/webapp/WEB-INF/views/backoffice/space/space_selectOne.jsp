<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>selectOne.jsp</h1>
	
					<a href="update?num=${param.num}">회원수정</a>
					<a href="delete?num=${param.num}">회원삭제</a>


	 <div id="selectOne">
        <ul>          
          <li><label for="space_type">공간종류 : </label>${space2.space_type}</li>
          <li><label for="space_name">공간명 : </label>${space2.space_name}</li>
          <li><label for="space_name">공간소개 : </label>${space2.space_detail}</li>
          <li><label for="space_post">공간주소 : </label>(${space2.postcode}) ${space2.address} ${space2.detail_address}</li>
          <li><label for="reg_code">사업자번호 : </label>${space2.reg_code}</li>
           <label for="space_img">공간사진:</label>
        	<img alt="${space2.space_img}" src="../resources/upload/space/${space2.space_img}">
<!--         	세부공간테이블에서 세부공간 이름, 타입, 가격, 운영시작,마감, 세부공간사진 추가 -->
        </ul>
      </div>

</body>
</html>