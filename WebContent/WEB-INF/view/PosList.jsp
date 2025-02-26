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

</head>
<body>

<!--
	-PositionList.jsp
	-지역 리스트 출력 페이지
	-일반 직원이 접근하는 직원 데이터 출력 페이지
		→ 관리 기능 포함
		→ 일반 직원이 접근하는 직원 데이터 출력 페이지
			PosList.jsp 로 구성할 예정
  -->

<div>
	<!--메뉴 영역  -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	<!--콘텐츠 영역  -->
	<div>
		<h1>
			[직위 목록 (일반직원 전용)]
		</h1>
		<hr />
		<br /><br />
		  <table id="customers" class="table">
		  	<tr>
		  		<th>직위 번호</th>
		  		<th>직위 이름</th>
				
			</tr>
			<c:forEach var="position" items="${positions }">
				<tr>
					<td>${position.positionId }</td>
		  			<td>${position.positionName }</td>
				</tr>
				</c:forEach>
		  </table>
		
	</div>
</div>

</body>
</html>