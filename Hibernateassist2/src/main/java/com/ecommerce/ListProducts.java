package com.ecommerce;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import javax.xml.bind.*;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ecommerce.Eproduct;
import com.ecommerce.HibernateUtil;


/**
 * Servlet implementation class ListProducts
 */
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
            SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();
            // using HQL
            List<Eproduct> list = session.createQuery("from Eproduct").list();
            
            session.close();
            
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
             out.println("<b>Product Listing</b><br>");
             for(Eproduct p: list) {
                     out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                     ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
            
         out.println("</body></html>");
         
         
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
