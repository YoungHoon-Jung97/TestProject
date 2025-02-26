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
<title>DepList.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

</head>
<body>

<!--
	-DepartmentList.jsp
	-지역 리스트 출력 페이지
	-일반 직원이 접근하는 직원 데이터 출력 페이지
		→ 관리 기능 포함
		→ 일반 직원이 접근하는 직원 데이터 출력 페이지
			DepList.jsp 로 구성할 예정
  -->

<div>
	<!--메뉴 영역  -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	<!--콘텐츠 영역  -->
	<div>
		<h1>
			[부서 목록 (일반직원 전용)]
		</h1>
		<hr />
		<br /><br />
		  <table id="customers" class="table">
		  	<tr>
		  		<th>부서 번호</th>
		  		<th>부서 이름</th>
				
			</tr>
			<c:forEach var="department" items="${departments }">
				<tr>
					<td>${department.departmentId }</td>
		  			<td>${department.departmentName }</td>
				</tr>
				</c:forEach>
		  </table>
		
	</div>
</div>

</body>
</html>