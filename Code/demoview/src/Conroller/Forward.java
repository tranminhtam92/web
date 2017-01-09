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
import Model.Giohang;
import Model.KhachhangDAO;
import Model.Monhang;

/**
 * Servlet implementation class Forward
 */
@WebServlet(urlPatterns={"/Forward"})
public class Forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forward() {
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
		HttpSession ss=request.getSession();
		String username =(String)ss.getAttribute("username");
		DondathangDAO ddhDAO=new DondathangDAO();
		ArrayList<Dondathang> listorder=new ArrayList<>();
		String a=request.getParameter("filler_order");
		String filler_order="";
		switch (a) {
		case "1":
			
			listorder=ddhDAO.get_allorderofuser(username);
			filler_order="Tất cả đơn đặt hàng";
		
		
			break;
		case "2":
			listorder=ddhDAO.get_orderofuseronemonth(username);
			filler_order="Đơn đặt hàng trong 1 tháng";
		
			break;
		case "3":
			listorder=ddhDAO.get_orderofuseroneweek(username);
			filler_order="Đơn đặt hàng trong 1 tuần";
			break;
		case "4":
			listorder=ddhDAO.get_payorderofuseronemont(username);
			filler_order="Đơn đặt hàng đã thanh toán trong 1 tháng";
			break;
		case "5":
			listorder=ddhDAO.get_unpayorderofuseronemont(username);
			filler_order="Đơn đặt hàng chưa thanh toán trong 1 tháng";
			break;
		case "6":
			listorder=ddhDAO.get_payorderofuseroneweek(username);
			filler_order="Đơn đặt hàng đã thanh toán trong 1 tuần";
			
			break;
		case "7":
			listorder=ddhDAO.get_unpayorderofuseroneweek(username);
			filler_order="Đơn đặt hàng chưa thanh toán trong 1 tuần";
			break;
		case "8":
			listorder=ddhDAO.get_ship_orderofuseronemonth(username);
			filler_order="Đơn đặt hàng đã vận chuyển trong 1 tháng";
			break;
		case "9":
			listorder=ddhDAO.get_unship_orderofuseronemonth(username);
			filler_order="Đơn đặt hàng chưa vận chuyển trong 1 tháng";
			break;
		case "10":
			listorder=ddhDAO.get_ship_orderofuseroneweek(username);
			filler_order="Đơn đặt hàng đã vận chuyển trong 1 tuần";
			break;
		case "11":
			listorder=ddhDAO.get_unship_orderofuseroneweek(username);
			filler_order="Đơn đặt hàng chưa vận chuyển trong 1 tuần";
			break;
		default:
			break;
		}
		request.setAttribute("filler",a);
		request.setAttribute("listorder", listorder);
		request.setAttribute("filler_order",filler_order);
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/View/Vieworder.jsp");
        dispatcher.forward(request, response);
			//response.getWriter().append(a);
	
	}

}
