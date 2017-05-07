package com.leavesystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

import com.leavesystem.beans.User;
import com.leavesystem.beans.LeaveRequest;
import com.leavesystem.db.DBUtils;

public class leaveDAO {

	public static void addLeave(String leave_user_id,String leave_reason,Date  data_start,Date data_end,String leave_status,String leave_title ) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql ="insert into tbl_leave (leave_user_id, leave_reason,data_start,data_end,leave_status,leave_title) values(?,?,?,?,?,?)";
		try{
			conn= DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, leave_user_id);
			ps.setString(2, leave_reason);
			ps.setDate(3, (java.sql.Date) data_start);
			ps.setDate(4, (java.sql.Date) data_end);
			ps.setString(5, leave_status);
			ps.setString(6, leave_title);
			ps.executeUpdate();
			
		}catch(SQLException e){
			
			e.printStackTrace();
			throw new SQLException("failed add user");
		}finally{
			DBUtils.close(null, ps, conn);			
		}
				
	}
	
	public static LeaveRequest findbyLeaveID(String LeaveID) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LeaveRequest LR =null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql ="Select leave_id,leave_user_id,leave_reason,data_start,data_end,leave_status,leave_approver_id from tbl_leave where leave_id=?";
		try{
			conn= DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, LeaveID);
			rs= ps.executeQuery();
			if(rs.next()){
				 LR = new LeaveRequest();
				LR.setLeaveId(rs.getInt(1));
				LR.setLeaveUserid(rs.getString(2));
				LR.setLeaveReason(rs.getString(3));					
                LR.setLeaveStart(format.format(rs.getString(4)));
                LR.setLeaveEnd(format.format(rs.getString(5)));		
                LR.setLeaveStatus(rs.getString(6));
                LR.setLeaveApproverId(rs.getString(7));
			}       		
		}catch(Exception e){
			
			e.printStackTrace();
			throw new SQLException("failed to find user by id");
		}finally{
			DBUtils.close(rs, ps, conn);			
		}
		return LR;
		
	}
	
	public static List<LeaveRequest> findByStatus(String Status)  {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LeaveRequest LR =null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<LeaveRequest> Leaves = new ArrayList<LeaveRequest>();
		String sql ="Select leave_id,leave_user_id,leave_reason,data_start,data_end,leave_status,leave_approver_id,leave_title from tbl_leave where leave_status=?";
		try{
			conn= DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Status);
			rs= ps.executeQuery();
			while(rs.next()){
				LR = new LeaveRequest();
				LR.setLeaveId(Integer.parseInt(rs.getString(1)));
				LR.setLeaveUserid(rs.getString(2));
				LR.setLeaveReason(rs.getString(3));							
                LR.setLeaveStart(rs.getString(4));
                LR.setLeaveEnd(rs.getString(5));		
                LR.setLeaveStatus(rs.getString(6));
                LR.setLeaveApproverId(rs.getString(7));
                LR.setLeaveTitle(rs.getString(8));
                Leaves.add(LR);
			}       		
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			DBUtils.close(rs, ps, conn);			
		}
		return Leaves;
		
	}
	
	

}
