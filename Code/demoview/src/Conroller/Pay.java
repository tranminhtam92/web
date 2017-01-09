package Conroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Dondathang;
import Model.DondathangDAO;

/**
 * Servlet implementation class Pay
 */
@WebServlet(urlPatterns={"/Pay"})
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
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
		HttpSession session=request.getSession();
		DondathangDAO ddhDAO=new DondathangDAO();
		int odercode=Integer.parseInt(request.getParameter("ordercode"));
		ddhDAO.update_Thanhtoanorder(true, odercode);
		ArrayList<Dondathang> listorder=new ArrayList<>();
		listorder.add(ddhDAO.getddh(odercode));
		request.setAttribute("listorder", listorder);
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/View/Vieworder.jsp");
        dispatcher.forward(request, response);
	}

}
