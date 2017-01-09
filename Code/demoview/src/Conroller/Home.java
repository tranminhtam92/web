package Conroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Loaisanpham;
import Model.LoaisanphamDAO;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet(urlPatterns = { "/Home"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		
		LoaisanphamDAO loaispDAO=new LoaisanphamDAO();
		ArrayList<Loaisanpham> loaisp=new ArrayList<>();
		loaisp=loaispDAO.getallloaisanpham();
		request.setAttribute("loaisanpham",loaisp);
		for(int i=0;i<loaisp.size()-1;i++){
			for(int j=i+1;j<loaisp.size();j++){
				if(loaisp.get(i).getVitri()>loaisp.get(j).getVitri()){
					Loaisanpham tam=new Loaisanpham();
					tam=loaisp.get(i);
					loaisp.set(i, loaisp.get(j));
					loaisp.set(j, tam);
				}
			}
		}
		request.setAttribute("danhmuc", loaisp);
		SanphamDAO spDAO=new SanphamDAO();
		ArrayList<Sanpham> spbanchay=new ArrayList<>();
		spbanchay=spDAO.get4sanphambanchay();
		request.setAttribute("spbanchay",spbanchay);
		for(int i=0;i<loaisp.size();i++){
			ArrayList<Sanpham> listsp= new ArrayList<>();
			listsp=spDAO.get4sanphamtheoloai(loaisp.get(i).getMaloai());
			request.setAttribute("loaisanpham"+i,listsp);
		}
		 RequestDispatcher dispatcher = request.getServletContext()
                 .getRequestDispatcher("/View/Index.jsp");
         dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
