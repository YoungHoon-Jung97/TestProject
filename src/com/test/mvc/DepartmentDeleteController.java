/*=========================
 * DepartmentDeleteController.java
 * - 사용자 정의 컨트롤러
=========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//    사용자 정의 컨트롤러 클래스를 구성한다. (Spring 3.x 이전 방식)

public class DepartmentDeleteController implements Controller
{
	// IDepartmentDAO 타입의 dao 객체 선언
	// 이 객체는 부서 데이터 삭제를 처리하는 기능을 담당
	private IDepartmentDAO dao;
	
	// 외부에서 dao 객체를 주입받기 위한 setter 메서드
	public void setDao(IDepartmentDAO dao)
	{
		this.dao = dao;
	}

	// Controller 인터페이스에서 요구하는 handleRequest() 메서드 구현
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// Controller가 수행해야 할 액션 코드 작성
		
		// ModelAndView 객체 생성: 컨트롤러가 반환할 데이터와 뷰 정보
		ModelAndView mav = new ModelAndView();
		
		// 세션 객체를 사용하여 현재 사용자의 로그인 상태를 확인
		HttpSession session = request.getSession();
		
		// 세션에 "name" 속성이 없으면 로그인되지 않은 상태로 간주
		if (session.getAttribute("name") == null)        // 로그인 안되어 있을 경우
		{
			// 로그인 폼으로 리다이렉트
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		// 세션에 "admin" 속성이 없으면 관리자 권한이 없는 것으로 간주
		else if(session.getAttribute("admin") == null)  // 관리자 아이디로 다시 로그인
		{
			// 관리자 권한이 없으면 로그아웃 처리
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		// 이전 페이지(→ DepartmentList.jsp)에서 넘어온 부서 ID를 받음
		String departmentId = request.getParameter("departmentId");
		
		try
		{
			// 부서 삭제 기능 실행 (dao 객체의 remove() 메서드 호출)
			dao.remove(departmentId);
			
			// 부서 삭제 후, 부서 목록 페이지로 리다이렉트
			mav.setViewName("redirect:departmentlist.action");
		
		} catch (Exception e)
		{
			// 예외 발생 시 콘솔에 에러 메시지 출력
			System.out.println(e.toString());
		}
		
		// 최종적으로 ModelAndView 객체 반환
		return mav;
	}
}
