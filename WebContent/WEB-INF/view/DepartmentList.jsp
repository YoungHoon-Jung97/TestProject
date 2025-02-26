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
<title>DepartmentList.jsp</title>
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
			 
			 $(location).attr("href", "departmentupdateform.action?departmentId=" + $(this).val());
			
		});
		
		$(".deleteBtn").click(function()
		{
			
			//alert("삭제 버튼 클릭");
			if (confirm("현재 선택한 데이터를 정말 삭제하시겠습니까?"))
			{
				$(location).attr("href","departmentdelete.action?departmentId=" +$(this).val());
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
			[부서 관리 (관리자 전용)]
		</h1>
		<hr />
		<div>
			<form action="">
				<input type="button" class="btn"  value="부서 추가"
				onclick="location.href='departmentinsertform.action'"/>
			</form>
		</div>
		<br /><br />
		  <table id="customers" class="table">
		  	<tr>
		  		<th>부서 번호</th>
		  		<th>부서 명</th>
				<th>수정</th>
				<th>삭제</th>
				
			</tr>
			<c:forEach var="department" items="${departments }">
				<tr>
					<td>${department.departmentId }</td>
		  			<td>${department.departmentName}</td>

					<c:choose>
						<c:when test="${department.delCheck == 0 }">
			  				<td><button type="button" class="updateBtn" value="${department.departmentId}">수정</button></td>
							<td><button type="button" class="deleteBtn" value="${department.departmentId}">삭제</button></td>
						</c:when>
						<c:otherwise>
							<td><button type="button" class="updateBtn" value="${department.departmentId}">수정</button></td>
							<td><button type="button" class="deleteBtn" value="${department.departmentId}" disabled="disabled">삭제</button></td>
						</c:otherwise>
					</c:choose>
				</tr>
				</c:forEach>
				
		  </table>
		  <div id="worring">${params.message }</div>
		
	</div>
</div>

</body>
</html>