package com.hsbc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOA.DoaImpl;
import DOA.ProductRepo;
import Model.Product;

/**
 * Servlet implementation class ShowListProduct
 */
@WebServlet("/showListProduct")
public class ShowListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ProductRepo proRep;
    public ShowListProduct() {
        super();
        proRep = DoaImpl.getInstance();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		ArrayList<Product> list = (ArrayList<Product>)proRep.showAll();
		for(int i=0;i<list.size();i++) {
			Product p = list.get(i);
			resp.getWriter().println("<h2>"+p+"<h2>");
		}
	}

	

}
