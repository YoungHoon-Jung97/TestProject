/*=========================
 * EmployeeDeleteController.java
 * -사용자 정의 컨트롤러
 * -직원 데이터 삭제 액션 처리
 * 	→ DAO 의 remove()메소드 호출
 * 		→ DAO 객체에 대한 의존성 주입(DI)을 위한 준비
 * 		→ setter 구성
 * -처리 후 employeelist.action을 다시 요청할 수 있도록 안내
 * 	 → redirect:employeelist.action
=========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//	사용자 정의 컨트롤러 클래스를 구성한다.

public class EmployeeDeleteController implements Controller
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
		
		String employeeId =  request.getParameter("employeeId");
		
		dao.remove(employeeId);
		
		mav.setViewName("redirect:employeelist.action");
	
		return mav;
	}


	
}