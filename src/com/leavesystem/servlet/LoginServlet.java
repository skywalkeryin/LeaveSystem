package com.leavesystem.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leavesystem.dao.leaveDAO;
import com.leavesystem.dao.userDAO;
import com.leavesystem.beans.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String USERID =  request.getParameter("userid");
		String PASS = request.getParameter("password");
		String error = null;
		
		if(USERID == null || PASS == null || USERID.length()==0 ||
				PASS.length()==0)
		{
			error="Required uesrname and password!";
			request.setAttribute("ErrorMsg", error);
	        RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
	        rs.include(request, response);
		}
		else
		{
			if(userDAO.checkUser(USERID, PASS))
			{
				User user = new User();
				try {
					user = userDAO.findbyUserid(USERID);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}			
				HttpSession session=request.getSession();  
				session.setAttribute("logineduser", user);
				
				//pass data to table
				List<LeaveRequest> Leaves = leaveDAO.findByStatus("Awaiting for approval");
				request.setAttribute("leavelist", Leaves);
				
				// Redirect to home page
				RequestDispatcher rs = request.getRequestDispatcher("view/home.jsp");				
				rs.forward(request, response);
				
			
				
				 
			}
			else
			{		
				   error = "Invalid username or password!";
				   request.setAttribute("ErrorMsg", error);
		           RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		           rs.include(request, response);
			}
		}
		
		
		
		
	}

}
