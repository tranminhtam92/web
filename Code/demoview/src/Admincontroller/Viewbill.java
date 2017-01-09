package Admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ChitietdondathangDAO;
import Model.ChitietdonnhaphangDAO;
import Model.Dondathang;
import Model.DondathangDAO;
import Model.Monhang;

/**
 * Servlet implementation class Viewbill
 */
@WebServlet(urlPatterns={"/Viewbill"})
public class Viewbill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewbill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ChitietdondathangDAO ctddhDAO=new ChitietdondathangDAO();
		int maddh = Integer.parseInt(request.getParameter("ordercode"));
		Dondathang ddh=new Dondathang();
		DondathangDAO ddhDAO=new DondathangDAO();
		ddh=ddhDAO.getddh(maddh);
		ArrayList<Monhang> listmh = ctddhDAO.get_detailorder(maddh);
		request.setAttribute("order",ddh);
		request.setAttribute("detailorder", listmh);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/Exportbill.jsp");
		dispatcher.forward(request, response);
	}

}
