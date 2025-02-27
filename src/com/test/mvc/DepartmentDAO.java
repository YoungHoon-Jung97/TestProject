/*=======================
 * DepartmentDAO.java
 	- 데이터베이스 액션 처리 클래스
 	- 부서 데이터 출력, 입력, 수정, 삭제 액션
 		→ IDepartmentDAO 인터페이스 implements
 	- Connection 객체에 대한 의존성 주입을 위한 준비
 	→ 인터페이스 형태의 속성 구성(DataSource)
 	→ setter 메소드 형태
=======================*/

package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class DepartmentDAO implements IDepartmentDAO
{
	// 주요 속성 구성
	// DataSource 객체를 사용하여 데이터베이스 연결을 관리
	private DataSource dataSource;
	
	// DataSource 객체를 설정하는 메서드
	// 외부에서 DataSource를 주입받기 위해 setter 메서드 사용
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 부서 목록을 가져오는 메서드
	@Override
	public ArrayList<Department> list() throws SQLException
	{
		// 부서 데이터를 담을 리스트 생성
		ArrayList<Department> result = new ArrayList<Department>();
		
		// 데이터베이스 연결을 위해 Connection 객체 생성
		Connection conn = dataSource.getConnection();
		
		// SQL 쿼리를 실행하기 위한 Statement 객체 생성
		Statement stmt = conn.createStatement();
		
		// 부서 정보를 조회할 SQL 쿼리
		String sql = "SELECT DEPARTMENTID, DEPARTMENTNAME, DELCHECK FROM DEPARTMENTVIEW";
		
		// SQL 쿼리를 실행하고 결과를 ResultSet에 저장
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet에서 데이터를 하나씩 꺼내서 리스트에 추가
		while (rs.next())
		{
			Department department = new Department();
			
			// ResultSet에서 각 컬럼 값을 꺼내서 department 객체에 설정
			department.setDepartmentId(rs.getString("DEPARTMENTID"));
			department.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			department.setDelCheck(rs.getInt("DELCHECK"));
			
			// department 객체를 리스트에 추가
			result.add(department);
		}
		
		// 자원 해제: ResultSet, Statement 객체를 닫음
		rs.close();
		stmt.close();
		
		// 결과로 생성된 부서 리스트 반환
		return result;
	}

	// 부서를 추가하는 메서드
	@Override
	public int add(Department department) throws SQLException
	{
		// 데이터베이스 연결을 위해 Connection 객체 생성
		Connection conn = dataSource.getConnection();
		
		// 부서 추가를 위한 SQL 쿼리
		String sql = "INSERT INTO DEPARTMENT(DEPARTMENTID, DEPARTMENTNAME)"
				+ " VALUES(DEPARTMENTSEQ.NEXTVAL, ?)";
		
		// PreparedStatement 객체를 사용하여 SQL 쿼리 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 부서 이름을 쿼리에 매핑
		pstmt.setString(1, department.getDepartmentName());
		
		// 쿼리 실행
		int result = pstmt.executeUpdate();
		
		// 실행 결과(삽입된 행의 개수) 반환
		return result;
	}

	// 부서를 삭제하는 메서드
	@Override
	public int remove(String departmentId) throws SQLException
	{
		// 데이터베이스 연결을 위해 Connection 객체 생성
		Connection conn = dataSource.getConnection();
		
		// 부서 삭제를 위한 SQL 쿼리
		String sql = "DELETE FROM DEPARTMENT WHERE DEPARTMENTID=?";
		
		// PreparedStatement 객체를 사용하여 SQL 쿼리 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 삭제할 부서 ID를 쿼리에 매핑
		pstmt.setString(1, departmentId);
		
		// 쿼리 실행
		int result = pstmt.executeUpdate();
		
		// 실행 결과(삭제된 행의 개수) 반환
		return result;
	}
	
	// 부서 ID로 부서를 조회하는 메서드
	@Override
	public Department search(String departmentId) throws SQLException
	{
		// 데이터베이스 연결을 위해 Connection 객체 생성
		Connection conn = dataSource.getConnection();
		Department result = new Department();
		
		// 부서 ID로 조회하는 SQL 쿼리
		String sql = "SELECT DEPARTMENTID, DEPARTMENTNAME FROM DEPARTMENTVIEW WHERE DEPARTMENTID = ?";
		
		// PreparedStatement 객체를 사용하여 SQL 쿼리 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 부서 ID를 쿼리에 매핑
		pstmt.setString(1, departmentId);
		
		// 쿼리 실행하여 결과를 ResultSet에 저장
		ResultSet rs = pstmt.executeQuery();
		
		// 결과가 있으면 부서 정보를 가져와 객체에 설정
		if (rs.next())
		{
			result.setDepartmentId(rs.getString("DEPARTMENTID"));
			result.setDepartmentName(rs.getString("DEPARTMENTNAME"));
		}
		
		// 조회한 부서 객체 반환
		return result;
	}
	
	// 부서 이름으로 부서를 조회하는 메서드
	public Department searchName(String departmentName) throws SQLException
	{
		// 데이터베이스 연결을 위해 Connection 객체 생성
		Connection conn = dataSource.getConnection();
		Department result = null;
		
		// 부서 이름으로 조회하는 SQL 쿼리
		String sql = "SELECT DEPARTMENTID, DEPARTMENTNAME FROM DEPARTMENTVIEW WHERE DEPARTMENTNAME = ?";
		
		// PreparedStatement 객체를 사용하여 SQL 쿼리 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 부서 이름을 쿼리에 매핑
		pstmt.setString(1, departmentName);
		
		// 쿼리 실행하여 결과를 ResultSet에 저장
		ResultSet rs = pstmt.executeQuery();
		
		// 결과가 있으면 부서 정보를 가져와 객체에 설정
		if (rs.next())
		{
			result = new Department();
			result.setDepartmentId(rs.getString("DEPARTMENTID"));
			result.setDepartmentName(rs.getString("DEPARTMENTNAME"));
		}
		
		// 조회한 부서 객체 반환
		return result;
	}

	// 부서 정보를 수정하는 메서드
	@Override
	public int modify(Department department) throws SQLException
	{
		// 데이터베이스 연결을 위해 Connection 객체 생성
		Connection conn = dataSource.getConnection();
		
		// 부서 수정을 위한 SQL 쿼리
		String sql = "UPDATE DEPARTMENT SET DEPARTMENTNAME=? WHERE DEPARTMENTID=?";
		
		// PreparedStatement 객체를 사용하여 SQL 쿼리 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 부서 이름과 부서 ID를 쿼리에 매핑
		pstmt.setString(1, department.getDepartmentName());
		pstmt.setString(2, department.getDepartmentId());
		
		// 쿼리 실행
		int result = pstmt.executeUpdate();
		
		// 실행 결과(수정된 행의 개수) 반환
		return result;
	}
}
