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
import Model.ChitietdondathangDAO;
import Model.Chitietdonnhaphang;
import Model.ChitietdonnhaphangDAO;
import Model.Dondathang;
import Model.DondathangDAO;
import Model.Donnhaphang;
import Model.DonnhaphangDAO;
import Model.Monhang;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Adminimportproduct
 */
@WebServlet(urlPatterns={"/Adminimportproduct"})
public class Adminimportproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminimportproduct() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("adminusername");
		String password = (String) session.getAttribute("adminpassword");
		RequestDispatcher dispatcher;
		if (ConnectDB.getconnectDB(username, password)) {
			ArrayList<Donnhaphang> listdnh = new ArrayList<>();
			Donnhaphang dnh = new Donnhaphang();
			DonnhaphangDAO dnhDAO = new DonnhaphangDAO();
			ChitietdonnhaphangDAO ctdnhDAO = new ChitietdonnhaphangDAO();
			ArrayList<Chitietdonnhaphang> listctdnh=new ArrayList<>();
			Chitietdonnhaphang ctdnh=new Chitietdonnhaphang();
			ArrayList<Sanpham> listsp=new ArrayList<>();
			SanphamDAO spDAO=new SanphamDAO();
			Sanpham sp=new Sanpham();
			String masp="";
			int soluong=0;
			int gia=0;
			String key = request.getParameter("key");
			int madnh;

			switch (key) {
			case "edit":
				/*madnh = Integer.parseInt(request.getParameter("ordercode"));
				boolean thanhtoan = Boolean.parseBoolean(request.getParameter("pay"));
				boolean vanchuyen = Boolean.parseBoolean(request.getParameter("transport"));
				String ngaythanhtoan = request.getParameter("datepay");
				String ngayvanchuyen = request.getParameter("datetransport");
				String manhanvien = request.getParameter("employeecode");
				ddhDAO.update_order(thanhtoan, maddh, vanchuyen, ngaythanhtoan, ngayvanchuyen, manhanvien);
				listddh.add(ddhDAO.getddh(maddh));
				request.setAttribute("list_order", listddh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_order.jsp");
				dispatcher.forward(request, response);
				break;*/
			case "view":
				listdnh = dnhDAO.get_importproducttoday();
				request.setAttribute("list_importproduct", listdnh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Importproduct.jsp");
				dispatcher.forward(request, response);
				break;
			case "add":
				
				boolean thanhtoan = Boolean.parseBoolean(request.getParameter("ispay"));
				
				String ngaynhaphang = request.getParameter("importproductdate");
				String manhanvien = request.getParameter("employeecode");
				String manhacungcap = request.getParameter("manufactorcode");
				dnhDAO.insertdonnhaphang(ngaynhaphang, thanhtoan,0, manhanvien, manhacungcap);
				madnh = dnhDAO.getmaxmadnh();
				listsp=spDAO.searchproduct("");
				request.setAttribute("list_product",listsp);
				request.setAttribute("importproductcode",madnh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Add_detailimportproduct.jsp");
				dispatcher.forward(request, response);
				break;
			case "next":
				madnh = Integer.parseInt(request.getParameter("importproductcode"));
				masp=request.getParameter("productcode");
				soluong = Integer.parseInt(request.getParameter("quantity"));
				gia = Integer.parseInt(request.getParameter("amount"));
				ctdnhDAO.insertChitietdnh(madnh, masp, soluong, gia);
				spDAO.updatesoluongsanpham(masp, soluong);
				dnhDAO.updatetongtien(madnh,gia*soluong);
				listsp=spDAO.searchproduct("");
				request.setAttribute("list_product",listsp);
				request.setAttribute("importproductcode",madnh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Add_detailimportproduct.jsp");
				dispatcher.forward(request, response);
				break;
			case "end":
				madnh = Integer.parseInt(request.getParameter("importproductcode"));
				masp=request.getParameter("productcode");
				soluong = Integer.parseInt(request.getParameter("quantity"));
				gia = Integer.parseInt(request.getParameter("amount"));
				ctdnhDAO.insertChitietdnh(madnh, masp, soluong, gia);
		
				spDAO.updatesoluongsanpham(masp, soluong);
				dnhDAO.updatetongtien(madnh,gia*soluong);
				listdnh.add(dnhDAO.getDonnhaphang(madnh));
				request.setAttribute("list_importproduct",listdnh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Importproduct.jsp");
				dispatcher.forward(request, response);
				break;
			case "detail":
				madnh = Integer.parseInt(request.getParameter("importproductcode"));
				listctdnh=ctdnhDAO.getChitietdonnhaphang(madnh);
				request.setAttribute("list_detail", listctdnh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Detailimportproduct.jsp");
				dispatcher.forward(request, response);
				break;
			case "delete":
				/*maddh = Integer.parseInt(request.getParameter("ordercode"));
				ctddhDAO.delete_detailorder(maddh);
				ddhDAO.delete_order(maddh);
				listddh = ddhDAO.get_ordertoday();
				request.setAttribute("list_order", listddh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_order.jsp");
				dispatcher.forward(request, response);
				break;*/
			case "search":
				String information = request.getParameter("information");

				String searchtype = request.getParameter("searchtype");
				switch (searchtype) {
				case "importproductcode":
					try {
						int code = Integer.parseInt(information);
						listdnh.add(dnhDAO.getDonnhaphang(code));
					} catch (NumberFormatException e) {
						// xử lý khi số nhập vào ko đúng
						request.setAttribute("error", "mã đơn nhập hàng phải là số");
						listdnh = dnhDAO.get_importproducttoday();
					}
					
					break;
				case "employeecode":
					listdnh = dnhDAO.searchemployeecode(information);
					break;
				case "manufactorcode":
					listdnh=dnhDAO.searchmanufactorcode(information);

					break;

				}
				request.setAttribute("list_importproduct", listdnh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Importproduct.jsp");
				dispatcher.forward(request, response);
				break;
			case "filler":
			
				String fillorder = request.getParameter("fillorder");
				switch (fillorder) {
				case "1"://don nhap hang hom nay
					listdnh=dnhDAO.get_importproducttoday();
					break;
				case "2"://tat ca don nhap hang
					listdnh=dnhDAO.getallDonnhaphang();
					break;
					
				case "3"://don nhap hnag trong 1 thang
					listdnh=dnhDAO.get_importproductonemonth();
					break;
				case "4"://don nhap hang trong 1 tuan
					listdnh=dnhDAO.get_importproductoneweek();
					break;
				
				
				}
				request.setAttribute("list_importproduct", listdnh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Importproduct.jsp");
				dispatcher.forward(request, response);
				break;
			
			default:

				break;
			}
		}
		
	}

}
