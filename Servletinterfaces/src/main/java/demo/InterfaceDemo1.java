package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InterfaceDemo1
 */
public class InterfaceDemo1 extends HttpServlet {
    ServletConfig config=null;
	private ServletResponse res;
    public void init(ServletConfig config){
        this.config=config;
        System.out.println("Initialization complete");
     }

    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("In destroy() method");
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
        return config;
		
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
        return "This is a sample servlet info";
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter pwriter=response.getWriter();
        pwriter.print("<html>");
        pwriter.print("<body>");
        pwriter.print("In the service() method<br>");
        pwriter.print("</body>");
        pwriter.print("</html>");

	}

}
