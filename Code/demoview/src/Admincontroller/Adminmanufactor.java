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
import Model.Nhacungcap;
import Model.NhacungcapDAO;
import Model.Nhanvien;
import Model.NhanvienDAO;

/**
 * Servlet implementation class Adminmanufactor
 */
@WebServlet(urlPatterns={"/Adminmanufactor"})
public class Adminmanufactor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminmanufactor() {
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
			ArrayList<Nhacungcap>listncc=new ArrayList<>();
			NhacungcapDAO nccDAO=new NhacungcapDAO();
			String key=request.getParameter("key");
			String manhacungcap="";
			String tennhacungcap="";
			String sodienthoai="";
			String diachi="";
			switch (key) {
			case "edit":
				manhacungcap=request.getParameter("manufactorcode");
				tennhacungcap=request.getParameter("manufactorname");
				diachi=request.getParameter("manufactoraddress");
				sodienthoai=request.getParameter("manufactortel");
				nccDAO.update_nhacungcap(manhacungcap, tennhacungcap, diachi, sodienthoai);
				listncc=nccDAO.getallnhacungcap();
				request.setAttribute("list_manufactor", listncc);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_manufactor.jsp");
		        dispatcher.forward(request, response);
				//response.getWriter().append(maloai).append(request.getContextPath());
				break;
			case "add":
				manhacungcap=request.getParameter("manufactorcode");
				tennhacungcap=request.getParameter("manufactorname");
				diachi=request.getParameter("manufactoraddress");
				sodienthoai=request.getParameter("manufactortel");
				Nhacungcap ncc=new Nhacungcap();
				if(!nccDAO.checknhacungcap(manhacungcap)){
					nccDAO.insert_nhacungcap(manhacungcap, tennhacungcap, diachi, sodienthoai);
					listncc=nccDAO.getallnhacungcap();
					request.setAttribute("list_manufactor", listncc);
					dispatcher = request.getServletContext()
			                 .getRequestDispatcher("/admin/Manager_manufactor.jsp");
			        dispatcher.forward(request, response);
				}
				else{
					ncc.setManhacungcap(manhacungcap);
					ncc.setTennhacungcap(tennhacungcap);
					ncc.setDiachi(diachi);
					ncc.setSodienthoai(sodienthoai);
					request.setAttribute("manufactor", ncc);
					request.setAttribute("error", "Lỗi, Tên nhà cung cấp đã tồn tại");
					dispatcher = request.getServletContext()
			                 .getRequestDispatcher("/admin/Add_manufactor.jsp");
			        dispatcher.forward(request, response);
				}
				//response.getWriter().append(maloai).append(request.getContextPath());
				break;
			default:
				listncc=nccDAO.getallnhacungcap();
				request.setAttribute("list_manufactor", listncc);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_manufactor.jsp");
		         dispatcher.forward(request, response);
				break;
			}
		}
	
	}

}
