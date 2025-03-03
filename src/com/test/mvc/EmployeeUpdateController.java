/*=========================
 * EmployeeUpdateController.java
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

public class EmployeeUpdateController implements Controller
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
		
		String employeeId= request.getParameter("employeeId");
		String name= request.getParameter("name");
		String ssn1= request.getParameter("ssn1");
		String ssn2= request.getParameter("ssn2");
		String birthday= request.getParameter("birthday");
		String lunar= request.getParameter("lunar");
		String telephone= request.getParameter("telephone");
		String regionId= request.getParameter("regionId");
		String departmentId= request.getParameter("departmentId");
		String positionId= request.getParameter("positionId");
		String basicPay= request.getParameter("basicPay");
		String extraPay= request.getParameter("extraPay");
		
		try
		{
			
			Employee employee = new Employee();
			
			employee.setEmployeeId(employeeId);
			employee.setName(name);
			employee.setSsn1(ssn1);
			employee.setSsn2(ssn2);
			employee.setBirthday(birthday);
			employee.setLunar(Integer.parseInt(lunar));
			employee.setTelephone(telephone);
			employee.setRegionId(regionId);
			employee.setDepartmentId(departmentId);
			employee.setPositionId(positionId);
			employee.setBasicPay(Integer.parseInt(basicPay));
			employee.setExtraPay(Integer.parseInt(extraPay));
			
			
			dao.modify(employee);
			
			mav.setViewName("redirect:employeelist.action"); // 리디렉션할 URL 설정
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	
		return mav;
	}


	
}