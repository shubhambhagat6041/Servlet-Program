package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getcookie")
public class getcookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		Cookie c=new Cookie("u",user);
		c.setMaxAge(60*60*24*90);//3 month
		response.addCookie(c);
		
		Cookie c1=new Cookie("p",pass);
		c.setMaxAge(60*60*24*90);
		response.addCookie(c1);
		
		out.println("<a href='viewcookie'>View Cookie Data</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
