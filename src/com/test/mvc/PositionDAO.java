/*=======================
 * PositionDAO.java
 	-데이터베이스 액션 처리 클래스
 	-직위데이터 출력, 입력, 수정, 삭제 액션
 		→ IDepartmentDAO 인터페이스 implements
 	-Connection 객체에 대한 의존성 주입을 위한 준비
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

public class PositionDAO implements IPositionDAO
{
	//주요 속성 구성
		private DataSource dataSource;
		
		public void setDataSource(DataSource dataSource)
		{
			this.dataSource = dataSource;
		}

		@Override
		public ArrayList<Position> list() throws SQLException
		{
			ArrayList<Position> result = new ArrayList<Position>();
			
			Connection conn = dataSource.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String sql="SELECT POSITIONID, POSITIONNAME, MINBASICPAY, DELCHECK FROM POSITIONVIEW";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Position position = new Position();
				
				position.setPositionId(rs.getString("POSITIONID"));
				position.setPositionName(rs.getString("POSITIONNAME"));
				position.setMinBasicPay(rs.getInt("MINBASICPAY"));
				position.setDelCheck(rs.getInt("DELCHECK"));
			
				
				result.add(position);
				
			}
			
			rs.close();
			stmt.close();
			return result;
		}

		@Override
		public int add(Position position) throws SQLException
		{
			
			Connection conn = dataSource.getConnection();
			
			String sql = "INSERT INTO POSITION(POSITIONID, POSITIONNAME,MINBASICPAY)"
					+ " VALUES(POSITIONSEQ.NEXTVAL, ?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,position.getPositionName());
			pstmt.setInt(2,position.getMinBasicPay());
			
			int result = pstmt.executeUpdate();
			
			return result;
		}

		@Override
		public int remove(String positionId) throws SQLException
		{
			Connection conn = dataSource.getConnection();
			
			String sql = "DELETE FROM POSITION WHERE POSITIONID=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,positionId);
			
			int result = pstmt.executeUpdate();
			
			return result;
		}

		@Override
		public int modify(Position position) throws SQLException
		{
			Connection conn = dataSource.getConnection();
			
			String sql = "UPDATE POSITION SET POSITIONNAME=? ,MINBASICPAY=? WHERE POSITIONID=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,position.getPositionName());
			pstmt.setInt(2,position.getMinBasicPay());
			pstmt.setString(3,position.getPositionId());
			
			int result = pstmt.executeUpdate();
			
			return result;
		}
		
		@Override
		public Position search(String positionId) throws SQLException
		{
			Connection conn = dataSource.getConnection();
			Position result = new Position();
			
			String sql = "SELECT POSITIONID, POSITIONNAME, MINBASICPAY FROM POSITION WHERE POSITIONID = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,positionId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				
				result.setPositionId(rs.getString("POSITIONID"));
				result.setPositionName(rs.getString("POSITIONNAME"));
				result.setMinBasicPay(rs.getInt("MINBASICPAY"));
			}
			
			return result;
		}
		
}
