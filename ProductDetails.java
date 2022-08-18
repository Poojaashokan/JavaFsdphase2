
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails
 */
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProductDetails() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con;
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/product?user=root","root","12345678");
		
		Statement stmt;
		
			stmt = con.createStatement();
		int i=Integer.parseInt(request.getParameter("id"));
		String s="select * from prod where pid ="+i+"";
		ResultSet r=stmt.executeQuery(s);
		while(r.next())
		{
				out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+" "+r.getInt(4));
		}
		}
		catch (Exception e)
		{
			PrintWriter out=response.getWriter();
			out.println(e);
		}
			doGet(request, response);
	

}
}