<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>워크토크</title>
    <link rel="stylesheet" href="../resources/css/spacePage.css">
    <link rel="stylesheet" href="../resources/css/header/header.css">
    <link rel="stylesheet" href="../resources/css/footer/footer.css">
    <link rel="stylesheet" href="../resources/css/home/home.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
    <div id="header">
        <div id="headerarea">
            <a href="/host/backoffice/main.do">
                <img id="logo" src="../resources/css/image/logo.png">
            </a>
            <form id="searchspace" action="space_searchList.do" method="get">
                <input id="searchText" type="text" name="searchWord">
                <input id="searchIcon"  type="image" src="../resources/css/image/icon/search-removebg.png">
            </form>
            <img id="menutab_buttom" src="../resources/css/image/icon/catalog.png" onclick="menutabOpen()">
            <div id="menutab">
                <img id="menutab_close" src="../resources/css/image/icon/close.png" onclick="menutabClose()">
                <div id="login">
                </div>
                <div id="mypage_package">
                    <div>
                        <a href="예약리스트 페이지">
                        <img src="../resources/css/image/icon/reservation.png"><br>
                        <p>예약리스트</p>
                        </a>
                    </div>
                    <div>
                        <a href="이용후기 Q&A관리 페이지">
                        <img src="../resources/css/image/icon/qna.png"><br>
                        <p>이용후기<br>Q&A 관리</p>
                        </a>
                    </div>
                    <div>
                        <a href="결제내역 마일리지 페이지">
                        <img src="../resources/css/image/icon/payment.png"><br>
                        <p>결제내역<br>마일리지</p>
                        </a>
                    </div>
                </div>
                <div id="menutab_bottom">
                    <div class="menutab_bottom_item">
                        <a href="1:1문의 페이지">
                            1:1문의
                        </a>
                    </div>
                    <div class="menutab_bottom_item">
                        <a href="공지사항 페이지">
                            공지사항
                        </a>
                    </div>
                    <div class="menutab_bottom_item">
                        <a href="이용가이드">
                            이용가이드
                        </a>
                    </div>
                    <div class="menutab_bottom_item">
                        <a href="워크토크 소개">
                            워크토크 소개
                        </a>
                    </div>
                    <div class="menutab_bottom_item">
                        <a>공급자페이지로 이동</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="body">
        <div id="bodyarea">
            <form action="/host/backoffice/space_insertOK.do" method="post" enctype="multipart/form-data">
   			 <input type="text" name="space_type" id="spaceType" value="1" hidden readonly>
              <input type="text" name="host" value="kim" hidden>
                <p id="spaceTypeTitle">공간종류</p>
                <div id="space_category">
                    <div class="space_category_item" value="1">
                        <img class="spaceType" src="../resources/css/image/icon/table.png" alt="데스크공간">
                        <p>데스크</p>
                    </div>
                    <div class="space_category_item" value="2">
                        <img class="spaceType" src="../resources/css/image/icon/meeting2.png" alt="회의실공간">
                        <p>회의실</p>
                    </div>
                    <div class="space_category_item" value="3">
                        <img class="spaceType" src="../resources/css/image/icon/office.png" alt="오피스공간">
                        <p>오피스</p>
                    </div>
                </div>
                <div class="box">
                    <p>공간명</p>
                    <p id="spaceName_textCount">0/20자</p>
                    <input type="text" name="space_name" id="spaceName" placeholder="공간의 이름을 작성해주세요." value="test">
                </div>
                <div class="box">
                    <p>공간소개</p>
                    <p id="spaceInfo_textCount">0/100자</p>
                    <textarea name="space_detail" id="spaceInfo" cols="30" rows="10" placeholder="공간을 소개해 주세요.">tttt</textarea>
                </div>
                <div>
                    <p>공간주소</p>
                    <input type="text" name="postcode" id="postcode" placeholder="우편번호" value="12345">
                    <input type="button" id="postcodeBtn" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                    <input type="text" name="address" id="address" placeholder="주소" value="12345"><br>
                    <input type="text" name="detail_address" id="detailAddress" placeholder="상세주소" value="12345">
                </div>
                <div>
                    <p>사업자번호</p>
                    <input type="text" name="reg_code" id="reg_code" oninput="phoneFormat(this)" maxlength="13" placeholder="예) 132-45-67890" value="12345">
                </div>
                <div>
                    <p>대표이미지</p>
                    <input type="file" id="spaceImg" style="border: 0; font-size: 15px;" name="multipartFile">
                </div>
                <input type="submit" value="등록">
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_area">
            <div>로고</div>
            <div>
                프로젝트명 : 워크토크
                팀원 : 이재석 이주희 최수연
                GIT : 주소....
            </div>
            <div>
                프로젝트이야기 : 노션?
            </div>
        </div>
    </div>
    <div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
    <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../resources/js/spacePage.js"></script>
</html>