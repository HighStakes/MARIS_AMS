package com.jwt.hibernate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import com.jwt.hibernate.dao.StudentDAO;

/**
 * Servlet implementation class SMSSendControllerServlet
 */
 
public class SMSSendControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMSSendControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    	try{
		StudentDAO studentDao = new StudentDAO();
		String studentId = req.getParameter("sid");
		char classId = req.getParameter("class").charAt(0);
		char section = req.getParameter("section").charAt(0);
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String contact = req.getParameter("contact");
		String gender = req.getParameter("gender");
		System.out.println("GENDER :"+gender);
		String allSubjects = "";
		String[] subjects = req.getParameterValues("subjects");
		 
		for (int i = 0; i < subjects.length; i++) {
			allSubjects = subjects[i]+","+allSubjects;
		}
		if(allSubjects.charAt(allSubjects.length() - 1) == ','){
			allSubjects = allSubjects.substring(0,allSubjects.length() - 1);
		}
		studentDao.saveStudentDetails(studentId,classId,section,fname,lname,contact,gender,allSubjects);
		//sendMessage(fname+" "+lname, contact, msg);
		if(true){
			res.sendRedirect("Success.html");
		}
    	}catch(Exception e){
    		 e.printStackTrace();
    		System.out.println("Message:"+e.getMessage());
    	}
	}

}
