/*=========================
 * EmpListController.java
 * -사용자 정의 컨트롤러
 * -리스트 페이지 요청에 대한 액션 처리
 * (단, 일반 사원 적용)
=========================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//	사용자 정의 컨트롤러 클래스를 구성한다.

public class EmpListController implements Controller
{
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
		
		// 자격 검증
		//-- 정상적인 로그인 과정을 거쳤는지의 여부 확인
		//	→ 세션에 대한 확인으로 처리

		HttpSession session = request.getSession();
		
		if (session.getAttribute("name")==null)			//-- 로그인이 되어있지 않은 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		try
		{
			employeeList =dao.list();
			
			mav.addObject("employeeList",employeeList);
			
			mav.setViewName("/WEB-INF/view/EmpList.jsp");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	
		return mav;
	}


	
}