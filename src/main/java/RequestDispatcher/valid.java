package RequestDispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@WebServlet("/valid")
public class valid extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String pass=request.getParameter("password");
		
		if(user.equals("shubham")&&pass.equals("shubham"))
		{
			RequestDispatcher r=request.getRequestDispatcher("welcome");
			r.forward(request, response);
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("valid.html");
			r.include(request, response);
			out.println("<h1>Invalid UserName and Password</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
