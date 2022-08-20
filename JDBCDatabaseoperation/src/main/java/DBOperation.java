
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.ecommerce.DBConnection;
/**
 * Servlet implementation class DBOperation
 */
public class DBOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DBOperation() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            
           InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
           Properties props = new Properties();
           props.load(in);
           
           
           DBConnection conn = new DBConnection(props.getProperty("jdbc:mysql://localhost:3306/ecommerce"), props.getProperty("root"), props.getProperty("12345678"));
           Statement stmt = conn.getConnection().createStatement();
           stmt.executeUpdate("create database ecommerce");
           out.println("Created database: ecommerce<br>");
           stmt.executeUpdate("use ecommerce");
           out.println("Selected database: ecommerce<br>");
           stmt.executeUpdate("drop database ecommerce");
           stmt.close();
           out.println("Dropped database: ecommerce<br>");
           conn.closeConnection();
           out.println("</body></html>");
           conn.closeConnection();
           
   } catch (ClassNotFoundException e) {
           e.printStackTrace();
   } catch (SQLException e) {
           e.printStackTrace();
   }

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
