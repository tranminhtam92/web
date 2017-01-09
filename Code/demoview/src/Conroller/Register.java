package Conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Model.Khachhang;
import Model.KhachhangDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns={"/Register"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html; charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String re_password=request.getParameter("re_password");
		String fullname=request.getParameter("fullname");
		String tel_number=request.getParameter("tel_number");
		String address=request.getParameter("address");
	    
	      
	        
	      
		Khachhang kh=new Khachhang();
		kh.setTendangnhap(username);
		kh.setMatkhau(password);
		kh.setHoten(fullname);
		kh.setSodienthoai(tel_number);
		kh.setDiachi(address);
	
		KhachhangDAO khDAO= new KhachhangDAO();
		
		if(username=="" || password=="" || fullname=="" || tel_number=="" || address==""){
			request.setAttribute("error","không được để trống ô nhập liệu");
			request.setAttribute("hoten","trần minh tâm");
			request.setAttribute("user",kh);
			RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/View/Register.jsp");
	        dispatcher.forward(request, response);
	        return;
		}
		if(khDAO.checkuser(username)){
			request.setAttribute("error","Tên đăng nhập đã tồn tại");
			request.setAttribute("user",kh);
			RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/View/Register.jsp");
	        dispatcher.forward(request, response);
	        return;
		}
		if(!re_password.equals(password)){
			request.setAttribute("error","nhập lại mật khẩu không chính xác");
			request.setAttribute("user",kh);
			RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/View/Register.jsp");
	        dispatcher.forward(request, response);
	        return;
		}
		HttpSession ss= request.getSession();
		khDAO.insertKhachhang(username, password, fullname, tel_number, address);
		ss.setAttribute("username",username);
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/");
        dispatcher.forward(request, response);
	}

}
