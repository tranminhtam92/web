package Conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Khachhang;
import Model.KhachhangDAO;
import sun.rmi.runtime.NewThreadAction;

/**
 * Servlet implementation class Information_customer
 */
@WebServlet(urlPatterns={"/Information_customer"})
public class Information_customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Information_customer() {
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
		String submit=request.getParameter("sm");
		String username=(String)session.getAttribute("username");
		KhachhangDAO khDAO=new KhachhangDAO();
		RequestDispatcher dispatcher ;
		switch (submit) {
		case "thông tin cá nhân":
		
			request.setAttribute("customer",khDAO.getKhachhang(username));
			dispatcher = request.getServletContext()
	                 .getRequestDispatcher("/View/Customer.jsp");
	         dispatcher.forward(request, response);
			break;
		case "sua":
			String fullname=request.getParameter("fullname");
			String address=request.getParameter("address");
			String tel=request.getParameter("tel");
			khDAO.updateKhachhang(username, fullname, address, tel);
			
			request.setAttribute("customer",khDAO.getKhachhang(username));
			request.setAttribute("success","thay đổi thành công");
			dispatcher = request.getServletContext()
	                 .getRequestDispatcher("/View/Customer.jsp");
	         dispatcher.forward(request, response);
			break;	
		case "đổi mật khẩu":
			String passold=request.getParameter("passold");
			String passnew=request.getParameter("passnew");
			String re_passnew=request.getParameter("re_passnew");
			Khachhang kh=new Khachhang();
			kh=khDAO.getKhachhang(username);
			String notify="";
			if(!kh.getMatkhau().trim().equals(passold))
				notify="lỗi, mật khẩu cũ không chính xác";
			else{
				if(!passnew.equals(re_passnew))
					notify="lỗi, nhập lại mật khẩu mới không giống nhau";
				else{
					khDAO.updatepassword(username, passnew);
					notify="thay đổi mật khẩu thành công";
				}
			}
			request.setAttribute("notify",notify);
			dispatcher = request.getServletContext()
	                 .getRequestDispatcher("/View/changepassword.jsp");
	         dispatcher.forward(request, response);
			break;	
		default:
			break;
		}
	}

}
