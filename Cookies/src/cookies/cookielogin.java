package cookies;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookielogin
 */
public class cookielogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookielogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie cookie[]=request.getCookies();
		System.out.println("this is cookie result"+request.getCookies()+" "+cookie);
		int found=0;
		RequestDispatcher view=request.getRequestDispatcher("error.html");
		
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		if(request.getCookies()==null)
		{
			System.out.println("this should redirect now");
			view.forward(request, response);
			return;
		}
			
			for (Cookie cookie2 : cookie) {
				if(cookie2.getName().compareTo(uid)==0 && cookie2.getValue().compareTo(pass)==0)
				{
					found=1;
					break;
				}
			}
			if(found==0)
	response.sendRedirect("error.html");
			else
				response.sendRedirect("success.html");
	}		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
