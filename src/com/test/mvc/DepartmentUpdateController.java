/*=========================
 * HelloCotroller.java
 * -사용자 정의 컨트롤러
=========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//	사용자 정의 컨트롤러 클래스를 구성한다.

public class DepartmentUpdateController implements Controller
{
	private IDepartmentDAO dao;
	

	public void setDao(IDepartmentDAO dao)
	{
		this.dao = dao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// Controller 가 수행해야 할 액션 코드
		
		ModelAndView mav = new ModelAndView();
	
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("name") == null)		//로그인 안되어 있을 경우
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if(session.getAttribute("admin")==null)	//관리자 아이디로 다시 로그인
		{
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		String departmentId = request.getParameter("id");
		String departmentName = request.getParameter("name");
		
		try
		{
			Department department = new Department();
			
			department.setDepartmentId(departmentId);
			department.setDepartmentName(departmentName);
			dao.modify(department);
			
			mav.setViewName("redirect:departmentlist.action");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	
		return mav;
	}


	
}