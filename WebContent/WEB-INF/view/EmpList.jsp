<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		// 테스트
		//alert("확인~!!!");
				
		// 수정 버튼 클릭 시 액션 처리
		$(".updateBtn").click(function()
		{
			// 테스트
			//alert("수정 버튼 클릭");
			//alert($(this).val());
			 
			 $(location).attr("href", "employeeupdateform.action?employeeId=" + $(this).val());
			
		});
		
		$(".deleteBtn").click(function()
		{
			
			//alert("삭제 버튼 클릭");
			if (confirm("현재 선택한 데이터를 정말 삭제하시겠습니까?"))
			{
				$(location).attr("href","employeedelete.action?employeeId=" +$(this).val());
			}
		});
		
	});

</script>
</head>
<body>

<!--
	#15
	-ElployeeList.jsp
	-직원 리스트 출력 페이지
	-관리자가 접근하는 직원 데이터 출력 페이지
		→ 관리 기능 포함
		→ 일반 직원이 접근하는 직원 데이터 출력 페이지
			EmpList.jsp 로 구성할 예정
  -->

<div>
	<!--메뉴 영역  -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	<!--콘텐츠 영역  -->
	<div>
		<h1>
			[직원 목록 (일반직원 전용)]
		</h1>
		<hr />
			<!--직원 추가 div 제거  -->
		<br /><br />
		<!--

			EMPLOYEEID NAME DEPARTMENTNAME POSITIONNAME REGIONNAME GRADE                 
		
		  -->
		  <table id="customers" class="table">
		  	<tr>
		  		<th>번호</th>
		  		<th>이름</th>
		  		<th>지역</th>
		  		<th>부서</th>
		  		<th>직위</th>
		  		<th>등급</th>
				
			</tr>
			<c:forEach var="employee" items="${employeeList }">
				<tr>
					<td>${employee.employeeId }</td>
		  			<td>${employee.name }</td>
			  		<td>${employee.regionName }</td>
			  		<td>${employee.departmentName }</td>
			  		<td>${employee.positionName }</td>
			 		<td>${employee.grade == 0 ? "관리자" : "일반회원" }</td>
			 
				</tr>
				</c:forEach>
		  </table>
		
	</div>
</div>

</body>
</html>