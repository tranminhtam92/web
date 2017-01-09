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
import Model.Loaisanpham;
import Model.LoaisanphamDAO;

/**
 * Servlet implementation class AdminProducttype
 */
@WebServlet(urlPatterns={"/AdminProducttype"})
public class AdminProducttype extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProducttype() {
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
		if(ConnectDB.getconnectDB(username, password)){
			String key=request.getParameter("key");
			String maloai="";
			String tenloai="";
			int vitri;
			String mausac="";
			String kieuchu="";
			LoaisanphamDAO lspDAO=new LoaisanphamDAO();
			ArrayList<Loaisanpham> listlsp=new ArrayList<>();
			RequestDispatcher dispatcher;
			switch (key) {
			case "edit":
				maloai=request.getParameter("producttypecode");
				tenloai=request.getParameter("producttypename");
				mausac=request.getParameter("producttypecolor");
				kieuchu=request.getParameter("producttypefront");
				vitri=Integer.parseInt(request.getParameter("producttypeposition"));
				lspDAO.updateloaisanpham(maloai, tenloai, vitri, mausac, kieuchu);
				listlsp=lspDAO.getallloaisanpham();
				request.setAttribute("list_producttype", listlsp);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_producttype.jsp");
		        dispatcher.forward(request, response);
				response.getWriter().append(maloai).append(request.getContextPath());
				break;
			case "add":
				maloai=request.getParameter("producttypecode");
				tenloai=request.getParameter("producttypename");
				mausac=request.getParameter("producttypecolor");
				kieuchu=request.getParameter("producttypefront");
				vitri=Integer.parseInt(request.getParameter("producttypeposition"));
				//lspDAO.updateloaisanpham(maloai, tenloai, vitri, mausac, kieuchu);
				listlsp=lspDAO.getallloaisanpham();
				request.setAttribute("list_producttype", listlsp);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_producttype.jsp");
		        dispatcher.forward(request, response);
				response.getWriter().append(maloai).append(request.getContextPath());
				break;
			default:
				
		
				listlsp=lspDAO.getallloaisanpham();
				request.setAttribute("list_producttype", listlsp);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_producttype.jsp");
		         dispatcher.forward(request, response);
				break;
			}
		}
	}

}
