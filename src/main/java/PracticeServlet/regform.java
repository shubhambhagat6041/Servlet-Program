package PracticeServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class regform extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String salary=request.getParameter("salary");
		int sal=Integer.parseInt(salary);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			PreparedStatement pmt=conn.prepareStatement("insert into employee values(?,?,?)");
			pmt.setString(1, name);
			pmt.setString(2, email);
			pmt.setInt(3, sal);
			int value=pmt.executeUpdate();
			if(value>0)
			{
				out.println("<h1>Data Stored In Database</h1>");
			}
			else
			{
				out.println("<h1>Not</h1>");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
