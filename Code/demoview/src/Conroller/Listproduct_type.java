package Conroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Loaisanpham;
import Model.LoaisanphamDAO;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/sanphamtheoloai"})
public class Listproduct_type extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listproduct_type() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		SanphamDAO spDAO = new SanphamDAO();
		ArrayList<Sanpham> listsp;
		Loaisanpham lsp;
		LoaisanphamDAO lspDAO=new LoaisanphamDAO();
		RequestDispatcher dispatcher;
		switch (type) {
		case "typeCode":
			String maloai=(String)request.getParameter("maloai");
			lsp=lspDAO.getloaisanpham(maloai);
			listsp = spDAO.getsanphamtheoloai(maloai);
			request.setAttribute("producttypename", lsp.getTenloai());
			request.setAttribute("listsp", listsp);
			dispatcher = request.getServletContext()
	                .getRequestDispatcher("/View/sanphamtheoloai.jsp");
	        dispatcher.forward(request, response);
			break;
		case "productCode":
			String masp=(String)request.getParameter("productId");
			Sanpham sp= spDAO.getsanpham(masp);
			listsp = spDAO.get4sanphamtheoloai(sp.getMaloai());
	
			request.setAttribute("sp", sp);
			request.setAttribute("listsp", listsp);
			dispatcher = request.getServletContext()
	                .getRequestDispatcher("/View/chitietsanpham.jsp");
	        dispatcher.forward(request, response);
			break;
		default:
			break;
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
