package Admincontroller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ConnectDB.ConnectDB;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Adminproduct
 */
@WebServlet(urlPatterns={"/Adminproduct"})
public class Adminproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
			ArrayList<Sanpham>listproduct=new ArrayList<>();
			SanphamDAO spDAO=new SanphamDAO();
			String key=request.getParameter("key");
			switch (key) {
			case "search":
				String information =request.getParameter("information");
				String searchtype=request.getParameter("searchtype");
				switch (searchtype) {
				case "productname":
					listproduct=spDAO.searchproduct(information);
					break;
				case "productcode":
					listproduct=spDAO.searchproductcode(information);
					break;
				case "producttype":
					listproduct=spDAO.searchproducttype(information);
					break;
			
				}
				request.setAttribute("list_product", listproduct);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_product.jsp");
		         dispatcher.forward(request, response);
				break;

			default:
				listproduct=spDAO.searchproduct("");
				request.setAttribute("list_product", listproduct);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_product.jsp");
		         dispatcher.forward(request, response);
				break;
			}
		}
		
	}

}
