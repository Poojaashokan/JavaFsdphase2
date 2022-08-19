

package com.ProductDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@WebServlet("/productDAO")
public class productDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public productDAO() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("p_id"));
		
		String pname = request.getParameter("p_name");
		int price = Integer.parseInt(request.getParameter("p_price"));
		int quantity = Integer.parseInt(request.getParameter("p_quantity"));
		
		Product pd=new Product();
		pd.setP_name(pname);
		pd.setP_price(price);
		pd.setP_quantity(quantity);
		pd.setP_id(pid);
		
		Configuration config=new Configuration();
		SessionFactory sessionFactory=config.configure().buildSessionFactory();
		
		//open connection
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	
		//save object as record
		int i=(Integer)session.save(pd);
		
		
		session.getTransaction().commit();
		
		session.close();
				
				PrintWriter out = response.getWriter();
				if (i > 0)
					out.println("Record inserted");
				else
					out.println("Record not inserted");
		
	}
}