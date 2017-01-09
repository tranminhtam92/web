package Admincontroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnectDB.ConnectDB;
import Model.ChitietdondathangDAO;
import Model.Dondathang;
import Model.DondathangDAO;
import Model.Khachhang;
import Model.KhachhangDAO;
import Model.Monhang;
import Model.SanphamDAO;

/**
 * Servlet implementation class Adminorder
 */
@WebServlet(urlPatterns = { "/Adminorder" })
public class Adminorder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Adminorder() {
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
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("adminusername");
		String password = (String) session.getAttribute("adminpassword");
		RequestDispatcher dispatcher;
		if (ConnectDB.getconnectDB(username, password)) {
			ArrayList<Dondathang> listddh = new ArrayList<>();
			Dondathang ddh = new Dondathang();
			DondathangDAO ddhDAO = new DondathangDAO();
			ArrayList<Monhang> listmh = new ArrayList<>();
			ChitietdondathangDAO ctddhDAO = new ChitietdondathangDAO();
			String key = request.getParameter("key");
			int maddh;

			switch (key) {
			case "edit":
				maddh = Integer.parseInt(request.getParameter("ordercode"));
				//boolean thanhtoan = Boolean.parseBoolean(request.getParameter("pay"));
				//boolean vanchuyen = Boolean.parseBoolean(request.getParameter("transport"));
				//String ngaythanhtoan = request.getParameter("datepay");
				String ngayvanchuyen = request.getParameter("datetransport");
				String manhanvien = request.getParameter("employeecode");
				ddhDAO.update_Vieworder(true, maddh);
				ddhDAO.update_Checkorder(true, maddh);
				ddhDAO.update_order( maddh,ngayvanchuyen, manhanvien);
				ddhDAO.update_nhanvien(maddh, username);
				listddh.add(ddhDAO.getddh(maddh));
				request.setAttribute("list_order", listddh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_order.jsp");
				dispatcher.forward(request, response);
				break;
			case "view":
				listddh = ddhDAO.get_notvieworder();
				request.setAttribute("list_order", listddh);
				session.setAttribute("reprot", "view");
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_order.jsp");
				dispatcher.forward(request, response);
				break;
			case "updatecheckorder":
				maddh = Integer.parseInt(request.getParameter("ordercode"));
				boolean duyetdon = Boolean.parseBoolean(request.getParameter("checkorder"));
				if(duyetdon){
					ddhDAO.update_Vieworder(true, maddh);
					ddhDAO.update_Checkorder(duyetdon, maddh);
					ddhDAO.update_nhanvien(maddh, username);
				}
				
				break;
			case "updatevieworder":
				maddh = Integer.parseInt(request.getParameter("ordercode"));
				boolean xemdon = Boolean.parseBoolean(request.getParameter("vieworder"));
				ddhDAO.update_Vieworder(xemdon, maddh);
				ddhDAO.update_nhanvien(maddh, username);
				break;
			case "updatepayorder":
				maddh = Integer.parseInt(request.getParameter("ordercode"));
				boolean pay = Boolean.parseBoolean(request.getParameter("payorder"));
				ddhDAO.update_Thanhtoanorder(pay, maddh);
				ddhDAO.update_nhanvien(maddh, username);
				if(pay==true){
					ddhDAO.update_Vieworder(true, maddh);
					ddhDAO.update_Checkorder(true, maddh);
					
					response.getWriter().write(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
				}
				else{
					ddh=ddhDAO.getddh(maddh);
					if(ddh.getVanchuyen()){
						
						SanphamDAO spDAO=new SanphamDAO();
						spDAO.updatethanhtoanfalse(maddh);
					}
					ddhDAO.update_Vanchuyenorder(false, maddh);
					response.getWriter();
				}
				break;
			case "updatetransportorder":
				maddh = Integer.parseInt(request.getParameter("ordercode"));
				boolean transport = Boolean.parseBoolean(request.getParameter("transportorder"));
				
				SanphamDAO spDAO=new SanphamDAO();
				ddh=new Dondathang();
				ddh=ddhDAO.getddh(maddh);
				if(!transport){
					spDAO.updatethanhtoanfalse(maddh);
				}
				if(ddh.getNgayvanchuyen()!=null && ddhDAO.checktrasport(maddh)){
					ddhDAO.update_Vanchuyenorder(transport, maddh);
					ddhDAO.update_nhanvien(maddh, username);
					if(transport){
						
						ddhDAO.update_Vieworder(true, maddh);
						ddhDAO.update_Checkorder(true, maddh);
						ddhDAO.update_Thanhtoanorder(true, maddh);
						spDAO.updatesoluongsanpham(maddh);
						if(!ddh.getThanhtoan()){
							response.getWriter().write(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
						}
					}
				}
				else{
					response.getWriter().write("error");
				}
				
				//response.getWriter().write(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
				break;
			case "detail":
				maddh = Integer.parseInt(request.getParameter("ordercode"));
				listmh = ctddhDAO.get_detailorder(maddh);
				request.setAttribute("maddh",maddh);
				request.setAttribute("detailorder", listmh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_detailorder.jsp");
				dispatcher.forward(request, response);
				break;
			case "delete":
				maddh = Integer.parseInt(request.getParameter("ordercode"));
				ctddhDAO.delete_detailorder(maddh);
				ddhDAO.delete_order(maddh);
				listddh = ddhDAO.get_ordertoday();
				request.setAttribute("list_order", listddh);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_order.jsp");
				dispatcher.forward(request, response);
				break;
			case "search":
				String information = request.getParameter("information");

				String searchtype = request.getParameter("searchtype");
				switch (searchtype) {
				case "username":
					listddh = ddhDAO.search_orderofcustomercode(information);
					break;
				case "fullname":
					listddh = ddhDAO.search_orderofreceiver(information);
					break;
				case "date":
					try {
						Date date=new SimpleDateFormat("dd/MM/yyyy").parse(information);
						//response.getWriter().append("Served at: ").append( new SimpleDateFormat("MM/dd/yyyy").format(date));
						
						listddh = ddhDAO.search_orderdate( new SimpleDateFormat("MM/dd/yyyy").format(date));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					break;
				case "ordercode":
					try {
						int code = Integer.parseInt(information);
						listddh.add(ddhDAO.getddh(code));
					} catch (NumberFormatException e) {
						// xử lý khi số nhập vào ko đúng
						request.setAttribute("error", "mã đơn nhập hàng phải là số");
						listddh = ddhDAO.get_ordertoday();
					}

					break;

				}
				request.setAttribute("searchtype", searchtype);
				request.setAttribute("information", information);
				request.setAttribute("list_order", listddh);
				session.setAttribute("report","search");
				session.setAttribute("searchtype",searchtype);
				session.setAttribute("information", information);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_order.jsp");
				dispatcher.forward(request, response);
				break;
			case "filler":
				/*
				 * <option value="1" selected="selected">Đơn đặt hàng hôm
				 * nay</option> <option value="2" >Tất cả đơn đặt hàng</option>
				 * <option value="3">Đơn đặt hàng trong 1 tháng</option> <option
				 * value="4">Đơn đặt hàng trong 1 tuần</option> <option
				 * value="5">Đơn đặt hàng đã thanh toán trong 1 tháng</option>
				 * <option value="6">Đơn đặt hàng đã thanh toán trong 1
				 * tuần</option> <option value="7">Đơn đặt hàng chưa thanh toán
				 * trong 1 tháng</option> <option value="8">Đơn đặt hàng chưa
				 * thanh toán trong 1 tuần</option> <option value="9">Đơn đặt
				 * hàng đã vận chuyển trong 1 tháng</option> <option
				 * value="10">Đơn đặt hàng đã vạn chuyển trong 1 tuần</option>
				 * <option value="11">Đơn đặt hàng chưa vận chuyển trong 1
				 * tháng</option> <option value="12">Đơn đặt hàng chưa vận
				 * chuyển trong 1 tuần</option>
				 */
				String fillorder = request.getParameter("fillorder");
				switch (fillorder) {
				case "1":
					listddh=ddhDAO.get_ordertoday();
					break;
				case "2":
					listddh=ddhDAO.get_allorder();
					break;
				case "3":
					listddh=ddhDAO.get_orderonemonth();
					break;
				case "4":
					listddh=ddhDAO.get_orderoneweek();
					break;
				case "5":
					listddh=ddhDAO.get_payorderonemont();
					break;
				case "6":
					listddh=ddhDAO.get_payorderoneweek();
					break;
				case "7":
					listddh=ddhDAO.get_unpayorderonemont();
					break;
				case "8":
					listddh=ddhDAO.get_unpayorderoneweek();
					break;
				case "9":
					listddh=ddhDAO.get_ship_orderonemonth();
					break;
				case "10":
					listddh=ddhDAO.get_ship_orderoneweek();
					break;
				case "11":
					listddh=ddhDAO.get_unship_orderonemonth();
					break;
				case "12":
					listddh=ddhDAO.get_unship_orderoneweek();
					break;
				
				}
				request.setAttribute("filler",fillorder);
				request.setAttribute("list_order", listddh);
				session.setAttribute("report","filler");
				session.setAttribute("fillcase", fillorder);
				dispatcher = request.getServletContext().getRequestDispatcher("/admin/Manager_order.jsp");
				dispatcher.forward(request, response);
				break;
			default:

				break;
			}
		}
	}

}
