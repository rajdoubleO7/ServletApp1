package com.hsbc.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOA.DoaImpl;
import DOA.ProductRepo;
import Model.Product;


@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductRepo proRepo;
    public AddProduct() {
        super();
        proRepo = DoaImpl.getInstance();;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 response.getWriter().println("<h2>IN GET</h2>");
	}

//	private int productID;
//	private String productName;
//	private String category;
//	private float price;
//	private int quantity;
//	private int rol;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		int pid = Integer.parseInt(request.getParameter("productID"));
		String pname = request.getParameter("productName");
		String category = request.getParameter("category");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int rol = Integer.parseInt(request.getParameter("rol"));
		Product p = new Product(pid,pname,category,price,quantity,rol);
		System.out.println("Going to add");
		int i = proRepo.add(p);
		if(i>0)
			response.getWriter().println("<h2>Data Successfully added<h2>");
		else {
			response.getWriter().println("<h2>Server Error<h2>");
		}
	}

}
