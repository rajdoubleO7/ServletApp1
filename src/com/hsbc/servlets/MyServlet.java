package com.hsbc.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet({ "/MyServlet"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        System.out.println("Constructor called");
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html");
		resp.getWriter().println("<h2>Get Request Responce<h2>");
		resp.getWriter().println("<h2>Hello World<h2>");
		resp.getWriter().println("<h2>Hello World "+new java.util.Date().toString()+"<h2>");
		resp.getWriter().flush();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, String[]> map = request.getParameterMap();
		Set<String> set = map.keySet();
		Iterator it = set.iterator();
		System.out.println("array:");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
//		response.setContentType("text/html");
		System.out.println("PID:  "+request.getParameterValues("productID"));//("productID"));
		int pid = Integer.parseInt(request.getParameter("productID"));
		String pname = request.getParameter("productName");
		String category = request.getParameter("category");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int rol = Integer.parseInt(request.getParameter("rol"));
		Product p = new Product(pid,pname,category,price,quantity,rol);
		System.out.println("Going to add");
//		int i = proRepo.add(p);
//		if(i>0)
//			response.getWriter().println("<h2>Data Successfully added<h2>");
//		else {
//			response.getWriter().println("<h2>Server Error<h2>");
//		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub	
//		response.getWriter().println("Hello EveryOne");
//		response.getWriter().flush();
//	}

}
