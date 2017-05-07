package com.leavesystem.beans;



public class LeaveRequest {
	public int leaveId;
	public String leaveTitle;
	
	public String leaveUserid;
	public String leaveReason;
	public String leaveStart;
	public String leaveEnd;
	public String leaveStatus;
	public String leaveApproverId;
	
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveTitle() {
		return leaveTitle;
	}
	public void setLeaveTitle(String leaveTitle) {
		this.leaveTitle = leaveTitle;
	}

	public String getLeaveUserid() {
		return leaveUserid;
	}
	public void setLeaveUserid(String leaveUserid) {
		this.leaveUserid = leaveUserid;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String  getLeaveStart() {
		return leaveStart;
	}
	public void setLeaveStart(String leaveStart) {
		this.leaveStart = leaveStart;
	}
	public String getLeaveEnd() {
		return leaveEnd;
	}
	public void setLeaveEnd(String leaveEnd) {
		this.leaveEnd = leaveEnd;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String  getLeaveApproverId() {
		return leaveApproverId;
	}
	public void setLeaveApproverId( String leaveApproverId) {
		this.leaveApproverId = leaveApproverId;
	}
	public LeaveRequest(int leaveId, String leaveTitle, String leaveUserid, String leaveReason, String leaveStart,
			String leaveEnd, String leaveStatus, String leaveApproverId) {
		super();
		this.leaveId = leaveId;
		this.leaveTitle = leaveTitle;
		this.leaveUserid = leaveUserid;
		this.leaveReason = leaveReason;
		this.leaveStart = leaveStart;
		this.leaveEnd = leaveEnd;
		this.leaveStatus = leaveStatus;
		this.leaveApproverId = leaveApproverId;
	}
	public LeaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


}
