package Admincontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dondathang;
import Model.DondathangDAO;
import Model.Donnhaphang;
import Model.DonnhaphangDAO;
import Model.Reportdemo;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Reportsellingproducts
 */
@WebServlet(urlPatterns={"/Reportsellingproducts"})
public class Reportsellingproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportsellingproducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String thang=request.getParameter("month");
		String nam=request.getParameter("year");
		SanphamDAO spDAO=new SanphamDAO();
		 Calendar cal = Calendar.getInstance();
		if(thang==null){
			thang=String.valueOf(cal.get(Calendar.MONTH)+1);
		}
		if(nam==null){
			nam=String.valueOf(cal.get(Calendar.YEAR));
		}
		String date=thang+"/1/"+nam;
		
			ArrayList<Sanpham> listsp=spDAO.getsanphambanchaytheothang(date);
			request.setAttribute("list_products", listsp);
			request.setAttribute("month", thang);
			request.setAttribute("year", nam);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/report_sellingproducts.jsp");
			dispatcher.forward(request, response);
		
	
		
	}

}
