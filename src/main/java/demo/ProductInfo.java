package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductInfo
 */
public class ProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int productid=Integer.parseInt(request.getParameter("product_id"));
		String productname=request.getParameter("product_name");
		int Price=Integer.parseInt(request.getParameter("price"));
		int Quantity=Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session=request.getSession();  
        session.setAttribute("product_id",  productid);

        session.setAttribute("product_name",  productname);

        session.setAttribute("price",  Price);

        session.setAttribute("quantity",  Quantity);
        response.sendRedirect("portal.jsp");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
