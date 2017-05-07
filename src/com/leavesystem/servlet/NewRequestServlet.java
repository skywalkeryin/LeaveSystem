package com.leavesystem.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leavesystem.beans.User;
import com.leavesystem.dao.*;

/**
 * Servlet implementation class NewRequestServlet
 */
@WebServlet("/NewRequestServlet")
public class NewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 

		 RequestDispatcher rs = request.getRequestDispatcher("view/NewRequest.jsp");
         rs.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		
		String LeaveTitle = request.getParameter("leavetitle");
		String LeaveReason = request.getParameter("leavereason");
		String StartDate = request.getParameter("startdate");
		
		Date startDate = null;
		try {
			startDate = format.parse(StartDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String EndDate = request.getParameter("enddate");
		Date endDate = null;
		try {
			endDate = format.parse(EndDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String LeaveUserId ="";
		//get session 
		HttpSession session = request.getSession(true);
		User userSession = (User) session.getAttribute("logineduser");
		if(userSession !=null){
			 LeaveUserId = userSession.getUserid();
		}
		String LeaveStatus = "Awaiting for approval";
		
		try {
			leaveDAO.addLeave(LeaveUserId, LeaveReason, new java.sql.Date(startDate.getTime()), new java.sql.Date(endDate.getTime()), LeaveStatus,LeaveTitle);
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
		
	
		
	}

}
