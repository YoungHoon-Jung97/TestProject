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
<title>EmployeeUpdateForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/jquery-ui.css">
<style>
    /* 테이블 크기 조정 */
    table.table {
        width: 50%; /* 테이블 너비를 50%로 설정 */
        border-collapse: collapse; /* 테이블 경계선 중복 제거 */
       
    }
    
	/* 테이블 크기 조정 */
	table.table {
	    width: 45%; /* 테이블 너비를 50%로 설정 */
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

			//폼 submit 액션 처리
			
			dataMissing();
			
		});
		
	});
	
	function dataMissing(){
		
		var name = $("#name").val();
		var minBasicPay = $("#minBasicPay").val();
		
		
		if (name == "" || minBasicPay=="") {
		    $("#error").html("필수정보를 입력하세요");
		    $("#error").css('display', 'block');
		    return;
		 
		}

		
		$("#positionForm").submit();
		
		
	}
	

</script>

</head>
<body>

<!-------------------------------------------------------- 
	#39
	-RegionUpdateForm.jsp
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
	
		<h1>[ 직위 변경 ]</h1>
		<hr>
		
		<form action="positionupdate.action" method="post" id="positionForm">
			<table class="table">
				<!-- 기존 입력 폼과 비교했을 때 주가되는 항목 -->
				<!--사원 번호 -->
				<tr>
					<th>직위 번호</th>
					<td>
						<input type="text" id="id" name="id" readonly="readonly"
						value ="${position.positionId}"/>
					</td>
				</tr>
			
				<tr>
					<th>직위 이름</th>
					<td>
						<input type="text" id="name" name="name" placeholder="직위 이름" 
						value="${position.positionName }">
					</td>
				</tr>
				<tr>
					<th>최소 금액</th>
					<td>
						<input type="text" id="minBasicPay" name="minBasicPay" placeholder="직위 이름" 
						value="${position.minBasicPay }">
					</td>
				</tr>
				
					<td colspan="2" align="center">
						<br><br>
						
						<button type="button" class="btn" id="submitBtn"
						style="width: 40%; height: 50%;">직위 변경</button>
						<button type="button" class="btn" id="listBtn"
						style="width: 40%; height: 50%;" onclick="location.href='regionlist.action'">직위 리스트</button>
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