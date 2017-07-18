package com.jwt.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jwt.hibernate.dao.LoginDAO;
import com.jwt.hibernate.dao.StudentDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

 
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			PrintWriter pw = res.getWriter();
			LoginDAO loginDao = new LoginDAO();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			if (loginDao.verifyUser(username, password)) {
				System.out.println("In DOGET");
				res.sendRedirect("index.html");
			}else{
				res.sendRedirect("Error.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Message:" + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		try {
//			LoginDAO loginDao = new LoginDAO();
//			String username = req.getParameter("username");
//			String password = req.getParameter("password");
//			
//			if (loginDao.verifyUser(username, password)) {
//				res.sendRedirect("sendSMS");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Message:" + e.getMessage());
//		}
	}

}
