// menu Open Close 함수
function menutabOpen() {
    const menutab = document.getElementById('menutab');
    menutab.setAttribute('style','display:block');
    }
    function menutabClose(login) {
        const menutab = document.getElementById('menutab');
        menutab.setAttribute('style','display:none');
        if(login != null) {
            pageMove('@login/login.html');
        }
    }

// 예약상태
$(document).ready(function(){
    const reservationStatus = document.getElementsByClassName('reservationStatus');
    const reservationDate = document.getElementsByClassName('reservationDate');
    for (let i = 0; i < reservationStatus.length; i++) {
        let p = document.createElement("p");
        let text = reservationStatus[i].innerText
        let date = reservationDate[i].innerText
        
        if(text == "예약완료") {
            reservationStatus[i].setAttribute('style','background-color:rgb(159, 221, 143); color:white');
        } else if(text == "이용완료") {
            reservationStatus[i].setAttribute('style','background-color:rgb(143, 177, 221); color:white');
        } else if(text == "이용자취소") {
            reservationStatus[i].setAttribute('style','background-color:red; color:white');
            reservationDate[i].innerText = "취소일"+date.slice(3,-1)	;
        } else if(text == "호스트취소") {
            reservationStatus[i].setAttribute('style','background-color:red; color:white');
            reservationDate[i].innerText = "취소일"+date.slice(3,-1);
        }
        if(text == "예약완료") {
            p.setAttribute("class","reservationCancel");
            p.innerHTML = "예약취소";
            reservationStatus[i].after(p);
        } else if(text == "이용완료") {
            p.setAttribute("class","reviewInsert");
            p.innerHTML = "후기작성";
            reservationStatus[i].after(p);
        }
    }
})


// 예약취소
$('.reservation').on('click', '.reservationCancel', function(){
	const close = $(this)
    const selectThis = $(this).parent().children('.reservationStatus');
    const r_date = $(this).parent().children('.r_date').val();
    const r_num = $(this).parent().children('.r_num').val();
    const reservationDate = $(this).parent().children('.reservationDate');
    const cancel_reason = "내맘이다."
    console.log(r_date,r_num,cancel_reason,reservationDate);
    if(confirm('정말 취소하시겠습니까?')) {
    	close.detach();
    	console.log("여기");
        $.ajax({
            type : "post",
            url : '/user/reservation/cancel.do',
            data : {
            	r_num : r_num,
            	r_date : r_date,
            	cancel_reason : cancel_reason,
            },
            success : function(data) {
            	console.log(data);
            	console.log(data.r_date);
            	reservationDate.text("취소일 : "+data.r_date+" / 예약일 : "+data.r_start);
                selectThis.text("이용자취소");
                selectThis.css({'background-color':'red', 'color':'white'});
            }
        })
    }
})