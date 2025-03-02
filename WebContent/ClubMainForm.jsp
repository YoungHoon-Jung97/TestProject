<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://fonts.googleapis.com/css?family=Stylish:400" rel="stylesheet">



<style type="text/css">
	body {
    font-family: "Stylish", sans-serif;
}
	

	.head{
		display: flex; /*가로  */
		align-items: center;
	}
	
	.logo {
    	margin-right: auto; /* .logo를 왼쪽으로 고정 */
	}

	.search {
	    flex-grow: 1; /* 검색창이 가능한 넓게 차지하도록 */
	    
	    justify-content: flex-end; /* 검색창을 오른쪽 정렬 */
	}
	
	fieldset{
		border: none;
	}
	
	.blind{
		display: none;
		clip: rect(0 0 0 0);
		overflow: hidden;
		position: absolute;
	}
	
	.gnb_bar {
    	background: linear-gradient(to right, #ff7e5f, #feb47b);
    	padding: 10px 0;
	}
	.gnb_list_clear{
		display: flex;
	}
	
	li{
		list-style: none;
		margin-left: 10px;
	}
	
	.left_top_content {
	    border: 1px solid gray;
	    width: 400px;
	    height: 300px;
	    margin-bottom: 20px;  /* ✅ 아래 여백 추가 */
	}




	.left_bottom_content {
	    width: 400px;
	    min-height: 300px;  /* ✅ 최소 높이 설정 */
	    border: 1px solid gray;
	    padding: 20px;
	    text-align: center;
	}



	#calendar {
	    width: 100%;
	}
	
	.calendar-header {
	    display: flex;
	    justify-content: space-between;
	    align-items: center;
	    padding: 10px;
	    background: #ff7e5f;
	    color: white;
	    font-weight: bold;
	    border-radius: 5px;
	}
	
	.calendar-header button {
	    background: white;
	    border: none;
	    cursor: pointer;
	    font-size: 18px;
	    padding: 5px 10px;
	    border-radius: 5px;
	}
	
	.calendar-header button:hover {
	    background: #feb47b;
	    color: white;
	}
	
	table {
	    width: 100%;
	    border-collapse: collapse;
	    margin-top: 10px;
	}
	
	th, td {
	    border: 1px solid #ddd;
	    text-align: center;
	    padding: 8px;
	    width: 14.2%;
	}
	
	th {
	    background: #eee;
	}
	
	td {
	    height: 50px;
	}
	
	.today {
	    background: #ff7e5f;
	    color: white;
	    border-radius: 50%;
	}
	
	
	
</style>
</head>
<body>

<!--페이지 최상단  -->
<header class="hearder">
	<div class="head">
		<!--로고  -->
		<div class="logo">
			<!--로고 링크  -->
			<a href="https://www.google.com">
				<img src="./img/google.png" alt="동호회 보기" style="width: 100px; height: 50px;" >
			</a>
			<!--//로고 링크  -->
		</div>
		<!--//로고  -->
		<!--최상단 검색창  -->
		<div class="search">
			<form action="" id="searchform" name="search_process">
				<fieldset>
					<legend class="blind">동호회 정보</legend>
					<!--검색창  -->
					<div class="top_search">
						<div class="inner_search">
							<input type="text" id="keyword" class="keyword" name="search"
							placeholder="동호회정보 검색"/>
							<button type="submit" id="searchSubmit">
							확인
							</button>
						</div>
					</div>
					<!--//검색창  -->
				</fieldset>
			</form>
		</div>
		<!--//최상단 검색창  -->
	</div>
</header>
<!--//페이지 최상단   -->

<!--GNB  -->
<div class="gnb_bar">
	<nav class="gnb clear">
		<h2 class="blind">GNB</h2>
		<!--리스트 메뉴 -->
		<ul class="gnb_list_clear">
			<!--첫 번째 리스트  -->
			<li>
				<a href="">
					게시판
				</a>
			</li>
			<!--//첫 번째 리스트  -->
			<!--두 번째 리스트  -->
			<li>
				<a href="">
					투표			
				</a>
			</li>
			<!--//두 번째 리스트  -->
			<!--세 번째 리스트  -->
			<li>
				<a href="">
					일정
				</a>
			</li>
			<!--//세 번째 리스트  -->
			<!--네 번째 리스트  -->
			<li>
				<a href="">
					동호회원
				</a>
			</li>
		</ul>
		<!--리스트 메뉴 -->
		
	</nav>
</div>
<!--//GNB  -->

<main>
	<!--왼쪽 화면  -->
	<div class="wrap_left">
		<h2 class="blind">메인 컨텐츠 영역</h2>
		
		<!--공지사항  -->
		<section class="left_top_content">
			<!--공지사항 게시판  -->
			<article>
				<!--공지사항 리스트  -->
					<table class="ann_list">
						<caption>공지사항 리스트</caption>
						<!--컬럼 너비 조절  -->
						<colgroup>
							<col style="width: 3%"/>
							<col style="width:6%">
							<col style="width:3%">
							<col style="width:3%">
							<col style="width:3%">
						</colgroup>
						<!--공지사항 속성  -->
						<thead>
						   <tr>
						        <th scope="col">번호</th>
						        <th scope="col">제목</th>
						        <th scope="col">작성자</th>
						        <th scope="col">작성일</th>
						        <th scope="col">조회</th>
						    </tr>
						</thead>
	
						<!--공지사항 내용  -->
						<tbody class="ann_contents">
							<tr class="content">
								<td class="ann_num">30495</td>
								<td class="ann_subject">
									<a href="">
										<em class="icon">
										</em>
										팀프로젝트
									</a>
								</td>
								<td class="ann_writer">
									<span class="nickname">
										<em>정영훈</em>
									</span>
								</td>
								<td class="ann_date">
									2025-03-02 
								</td>
								<td class="ann_count">
									553
								</td>
							</tr>
						</tbody>
					</table>
				<!--//공지사항 리스트  -->
			</article>
			<!--//공지사항 게시판  -->
		</section>
		<!--//공지사항  -->
		
		<!--일정  -->
		<section class="left_bottom_content">
	   		<div id="calendar">
	       		<div class="calendar-header">
	           		<button id="prevMonth">&lt;</button>
	           		<h2 id="currentMonth">3</h2>
	           		<button id="nextMonth">&gt;</button>
	       		</div>
	       		<table>
	           		<thead>
	                	<tr>
		                    <th>일</th>
		                    <th>월</th>
		                    <th>화</th>
		                    <th>수</th>
		                    <th>목</th>
		                    <th>금</th>
		                    <th>토</th>
	                	</tr>
	           		</thead>
	           		<tbody id="calendarBody">
	           			<tr>
	           				<td></td>
	           				<td></td>
	           				<td></td>
	           				<td></td>
	           				<td></td>
	           				<td></td>
	           				<td>1</td>
	           			</tr>
	           			<tr>
	           				<td>2</td>
	           				<td>3</td>
	           				<td>4</td>
	           				<td>5</td>
	           				<td>6</td>
	           				<td>7</td>
	           				<td>8</td>
	           			</tr>
	           			<tr>
	           				<td>9</td>
	           				<td>10</td>
	           				<td>11</td>
	           				<td>12</td>
	           				<td>13</td>
	           				<td>14</td>
	           				<td>15</td>
	           			</tr>
	           			<tr>
	           				<td>16</td>
	           				<td>17</td>
	           				<td>18</td>
	           				<td>19</td>
	           				<td>20</td>
	           				<td>21</td>
	           				<td>22</td>
	           			</tr>
	           			<tr>
	           				<td>23</td>
	           				<td>24</td>
	           				<td>25</td>
	           				<td>26</td>
	           				<td>27</td>
	           				<td>28</td>
	           				<td>29</td>
	           			</tr>
	           			<tr>
	           				<td>30</td>
	           				<td>31</td>
	           				<td></td>
	           				<td></td>
	           				<td></td>
	           				<td></td>
	           				<td></td>
	           			</tr>
	           		</tbody>
	       		</table>
	   		</div>
		</section>
		<!--//일정  -->
	</div>
	<!--//왼쪽 화면  -->
	
	<!--오른쪽 화면  -->
	<div class="wrap_right">
		<!--동호회 정보 맴버 리스트  -->
		<div class="section">
			<!--동호회 맴버 정보  -->
			<div class="section_head">
				<div class="section_title"> 주요 멤버</div>
			</div>
			<div class="section_list">
				<li>
					<a href="">
						<div class="member_profile"></div>
						<div class="member_inform">
							<p class="member_name">정영훈</p>
							<span class="member_level">아마추어3</span>
						</div>
					</a>
				</li>
				<li>
					<a href="">
						<div class="member_profile"></div>
						<div class="member_inform">
							<p class="member_name">김민승</p>
							<span class="member_level">비기너1</span>
						</div>
					</a>
				</li>
			</div>
		</div>
		<!--//동호회 정보 맴버 리스트  -->
		
		<!--동호회 정보 리스트  -->
		<section class="section">
			<div class="section_head">
				<div class="section_title">팀정보</div>
			</div>
			<div class="section_list_wrapper">
				<div class="club_region">
					<span>지역</span>
					<span class="region_name">
						인천
					</span>
				</div>
				<div class="club_homeground">
					<span>홈 구장</span>
					<span class="homeground_name">
						인천 계양 고고풋살
					</span>
				</div>
				<div class="club_age">
					<span>평균 나이</span>
					<span class="age_average">
						26세
					</span>
				</div>
				<div class="club_member">
					<span>멤버</span>
					<span class="member_count">
						4명
					</span>
				</div>
				<div class="club_level">
					<span>레벨</span>
					<span class="level">
						프로
					</span>
				</div>
			</div>
		</section>
		<!--//동호회 정보 리스트  -->
	</div>
	<!--//오른쪽 화면  -->
</main>


</body>
</html>