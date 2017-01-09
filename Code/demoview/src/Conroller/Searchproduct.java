package Conroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Searchproduct
 */
@WebServlet(urlPatterns={"/Searchproduct"})
public class Searchproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productname=request.getParameter("productname");
		SanphamDAO spDAO=new SanphamDAO();
		ArrayList<Sanpham> listproduct=spDAO.searchproduct(productname);
		request.setAttribute("listproduct",listproduct);
		request.setAttribute("productname", productname);
		 RequestDispatcher dispatcher = request.getServletContext()
                 .getRequestDispatcher("/View/Searchproduct.jsp");
         dispatcher.forward(request, response);
	}

}
