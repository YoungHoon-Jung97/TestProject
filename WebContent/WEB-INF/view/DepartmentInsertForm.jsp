<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/jquery-ui.css">
<style>
    /* 테이블 크기 조정 */
    table.table {
        width: 50%; /* 테이블 너비를 50%로 설정 */
        border-collapse: collapse; /* 테이블 경계선 중복 제거 */
       
    }
    table.table th,
	table.table td {
	    text-align: left; /* 가운데 정렬을 없애고 왼쪽 정렬로 변경 */
	}
    

</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/jquery-ui.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#submitBtn").click(function(){
			
			//alert("확인");
			//데이터 검사
			//-- 누락된 입력값이 있는지 없는지에 대한 여부 확인
			//	이름, 주민번호앞, 주민번호 뒷, 생년월일, 전화번호, 기본급 항목 누락 시
			//	→ 필수 입력 항목이 누락되었음을 안내
			
			//최소 기본급에 대해 유효성 검사
			//-- 직급별 최소 기본급 > 사용자 입력 기본급
			//	→ 입력한 기본급이 최소 기본급보다 작음을 안내
			
			//폼 submit 액션 처리
			
			dataMissing();
			
		});
		
	});
	
	function dataMissing(){
		
		var name = $("#name").val();

		if (name == "" ) {
		    $("#error").html("필수정보를 입력하세요");
		    $("#error").css('display', 'block');
		    return;
		 
		}

		
		$("#departmentForm").submit();
		
		
	}
	
	

</script>

</head>
<body>

<!-------------------------------------------------------- 
	#21. EmployeeInsertForm.jsp
	     - 직원 데이터 입력 페이지
	     - 관리자만 접근 허용
--------------------------------------------------------->

<div>

	<!--  메뉴 영역 -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>

	<!-- 콘텐츠 영역 -->
	<div id="content">
	
		<h1>[ 지역 추가 ]</h1>
		<hr>
		
		<form action="departmentinsert.action" method="post" id="departmentForm">
			<table class="table">
				<tr>
					<th>지역 이름</th>
					<td>
						<input type="text" id="name" name="name" placeholder="부서 이름" >
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<br><br>
						
						<button type="button" class="btn" id="submitBtn"
						style="width: 40%; height: 50%;">부서 추가</button>
						<button type="button" class="btn" id="listBtn"
						style="width: 40%; height: 50%;" onclick="location.href=departmentlist.action'">지역 리스트</button>
						<br><br>
						
						<span id="error" style="color: red; font-weight: bold; display: none;">
						</span>
						
					</td>
				</tr>
				
			</table>
		</form>
	
	</div>

	<!-- 회사 소개 및 어플리케이션 소개 영역 -->
	<div id="footer">
	</div>

</div>

</body>
</html>