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
import Model.Dondathang;
import Model.DondathangDAO;
import Model.Khachhang;
import Model.KhachhangDAO;
import Model.Loaisanpham;
import Model.LoaisanphamDAO;
import Model.Nhacungcap;
import Model.NhacungcapDAO;
import Model.Nhanvien;
import Model.NhanvienDAO;
import Model.Nhanvienduyetdon;
import Model.NhanvienduyetdonDAO;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Forward_edit
 */
@WebServlet(urlPatterns = { "/AdminForward_edit" })
public class AdminForward_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminForward_edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html; charset=UTF-8");
		String key = request.getParameter("key");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("adminusername");
		String password = (String) session.getAttribute("adminpassword");
		if (ConnectDB.getconnectDB(username, password)) {
			NhanvienDAO nvDAO=new NhanvienDAO();
			LoaisanphamDAO lspDAO=new LoaisanphamDAO();
			NhanvienduyetdonDAO nhanvienduyetdonDAO=new NhanvienduyetdonDAO();
			switch (key) {
			case "edit_producttype":
				String producttypecode = request.getParameter("producttypecode");
				Loaisanpham producttype=new Loaisanpham();
			
				producttype=lspDAO.getloaisanpham(producttypecode);
				request.setAttribute("producttype", producttype);
				RequestDispatcher dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Edit_producttype.jsp");
		         dispatcher.forward(request, response);
				break;
			case "edit_product":
				String productcode = request.getParameter("productcode");
				Sanpham product=new Sanpham();
				SanphamDAO spDAO=new SanphamDAO();
				ArrayList<Loaisanpham> listlsp=new ArrayList<>();
				listlsp=lspDAO.getallloaisanpham();
				product=spDAO.getsanpham(productcode);
				request.setAttribute("product", product);
				request.setAttribute("list_producttype", listlsp);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Edit_product.jsp");
		         dispatcher.forward(request, response);
				break;
			case "add_product":
				
		
				ArrayList<Loaisanpham> listlsp1=new ArrayList<>();
				listlsp1=lspDAO.getallloaisanpham();
				request.setAttribute("list_producttype", listlsp1);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Add_product.jsp");
		         dispatcher.forward(request, response);
				break;
			case "edit_employee":
				String employeecode = request.getParameter("employeecode");
				Nhanvien nv=new Nhanvien();
				
				nv=nvDAO.getnhanvien(employeecode);
				request.setAttribute("employee", nv);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Edit_employee.jsp");
		         dispatcher.forward(request, response);
				break;
			case "edit_manufactor":
				String manufactorcode = request.getParameter("manufactorcode");
				Nhacungcap ncc=new Nhacungcap();
				NhacungcapDAO nccDAO=new NhacungcapDAO();
				ncc=nccDAO.getnhacungcap(manufactorcode);
				request.setAttribute("manufactor", ncc);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Edit_manufactor.jsp");
		         dispatcher.forward(request, response);
				break;
			case "edit_customer":
				String customercode = request.getParameter("customercode");
				Khachhang kh=new Khachhang();
				KhachhangDAO khDAO=new KhachhangDAO();
				kh=khDAO.getKhachhang(customercode);
				request.setAttribute("customer", kh);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Edit_customer.jsp");
		         dispatcher.forward(request, response);
				break;
			case "edit_order":
				int ordercode = Integer.parseInt(request.getParameter("ordercode"));
				Dondathang ddh=new Dondathang();
				DondathangDAO ddhDAO=new DondathangDAO();
				ddh=ddhDAO.getddh(ordercode);
				request.setAttribute("order", ddh);
				ArrayList<Nhanvien> listnv=new ArrayList<>();
				listnv=nvDAO.getallnhanvien();
				request.setAttribute("list_employee", listnv);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Edit_order.jsp");
		         dispatcher.forward(request, response);
				break;
			case "add_importproduct":
				
				
				ArrayList<Nhanvienduyetdon> listnv1=new ArrayList<>();
				listnv1=nhanvienduyetdonDAO.getallnhanvien();
				ArrayList<Nhacungcap> listncc=new ArrayList<>();
				NhacungcapDAO nccDAO1=new NhacungcapDAO();
				listncc=nccDAO1.getallnhacungcap();
				request.setAttribute("list_employee", listnv1);
				request.setAttribute("list_manufactor", listncc);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Add_importproduct.jsp");
		         dispatcher.forward(request, response);
				break;
			default:
				break;
			}

		}
	}

}
