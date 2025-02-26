/*=========================
 * EmployeeListController.java
 * -사용자 정의 컨트롤러
 * -리스트 페이지 요청에 대한 액션처리
 * -DAO 객체에 대한 의존성 주입을 위한 준비
 *  → 인터페이스 형태의 자료형을 속성으로 구성
 *  → setter 구성
=========================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.activation.DataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//	사용자 정의 컨트롤러 클래스를 구성한다.

public class EmployeeListController implements Controller
{
	// 주요속성 구성 → 인터페이스
	private IEmployeeDAO dao;
	



	public void setDao(IEmployeeDAO dao)
	{
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// Controller 가 수행해야 할 액션 코드
		
		ModelAndView mav = new ModelAndView();
		
		// 세션 처리과정 추가 -----------------------------------------------------
		HttpSession session = request.getSession();
		
		if (session.getAttribute("name")==null)			//-- 로그인이 되어있지 않은 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if (session.getAttribute("admin")==null)	//-- 로그인은 되었지만 관리자가 아닌 상황
		{
			mav.setViewName("redirect:logout.action");
			return mav;
			//-- 로그인은 되어 있지만 이 때 클라이언트는
			//   일반 직원으로 로그인 되어있는 상황이므로
			//   기존의 로그인 내용을 없애고 로그아웃 액션 처리하여
			//   다시 관리자로 로그인할 수 있도록 처리
		}		
		// ----------------------------------------------------- 세션 처리과정 추가

		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();

		try
		{
			employeeList = dao.list();
			mav.addObject("employeeList", employeeList);
			mav.setViewName("/WEB-INF/view/EmployeeList.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	
		return mav;
	}
	
}