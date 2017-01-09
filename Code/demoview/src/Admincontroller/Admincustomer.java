package Admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnectDB.ConnectDB;
import Model.Khachhang;
import Model.KhachhangDAO;


/**
 * Servlet implementation class Admincustomer
 */
@WebServlet(urlPatterns={"/Admincustomer"})
public class Admincustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admincustomer() {
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
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	HttpSession session=request.getSession();
	String username=(String)session.getAttribute("adminusername");
	String password=(String)session.getAttribute("adminpassword");
	RequestDispatcher dispatcher;
	if(ConnectDB.getconnectDB(username, password)){
		ArrayList<Khachhang>listkh=new ArrayList<>();
		KhachhangDAO khDAO=new KhachhangDAO() ;
		String key=request.getParameter("key");
		String tendangnhap="";
		String matkhau="";
		String hoten="";
		String sodienthoai="";
		String diachi="";
		switch (key) {
		case "edit":
			tendangnhap=request.getParameter("customercode");
			hoten=request.getParameter("customername");
			diachi=request.getParameter("customeraddress");
			sodienthoai=request.getParameter("customertel");
			matkhau=request.getParameter("customerpass");
			khDAO.updateKhachhang(tendangnhap, hoten, diachi, sodienthoai);
			khDAO.updatepassword(tendangnhap, matkhau);
			listkh=khDAO.getallKhachhang();
			request.setAttribute("list_customer", listkh);
			dispatcher = request.getServletContext()
	                 .getRequestDispatcher("/admin/Manager_customer.jsp");
	        dispatcher.forward(request, response);
			//response.getWriter().append(maloai).append(request.getContextPath());
			break;
		case "view":
			listkh=khDAO.getallKhachhang();
			request.setAttribute("list_customer", listkh);
			dispatcher = request.getServletContext()
	                 .getRequestDispatcher("/admin/Manager_customer.jsp");
	         dispatcher.forward(request, response);
			break;
		case "search":
			String information=request.getParameter("information");
			String searchtype=request.getParameter("searchtype");
			switch (searchtype) {
			case "username":
				listkh=khDAO.searchtendangnhap(information);
				break;
			case "fullname":
				listkh=khDAO.searchhoten(information);
				break;
			case "address":
				listkh=khDAO.searchdiachi(information);
				break;
			case "tel":
				listkh=khDAO.searchsodienthoai(information);
				break;



			}
			
			request.setAttribute("list_customer", listkh);
			dispatcher = request.getServletContext()
	                 .getRequestDispatcher("/admin/Manager_customer.jsp");
	         dispatcher.forward(request, response);
			break;	
		default:
			
			break;
		}
	}
		
	}

}
