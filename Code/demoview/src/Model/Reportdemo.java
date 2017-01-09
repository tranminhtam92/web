package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import ConnectDB.ConnectDB;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Reportdemo {
	public void report(HttpServletResponse response, Map<String, Object> param, String pathjrxml)
			throws FileNotFoundException {
		Connection connection = ConnectDB.getconnectDB();
		try {
			JasperDesign jd = JRXmlLoader.load(pathjrxml);
			String sql = "execute thongkesoluongsanphamtonkho";
			JRDesignQuery newquery = new JRDesignQuery();
			newquery.setText(sql);
			jd.setQuery(newquery);
			// System.out.println(input+"1");
			try {
				JasperReport jsreport = JasperCompileManager.compileReport(jd);
				System.out.println(jsreport + "2");
				JasperPrint print = JasperFillManager.fillReport(jsreport, param, connection);
				System.out.println(print + "3");
				try {
					JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void reportddhfiller(HttpServletResponse response, Map<String, Object> param, String pathjrxml,
			String fillercase) {
		Connection connection = ConnectDB.getconnectDB();
		try {
			JasperDesign jd = JRXmlLoader.load(pathjrxml);
			String sql = "";
			switch (fillercase) {
			case "1":
				sql = " select * from dondathang where datediff(DAY,ngaydathang,GETDATE())<1";
				break;
			case "2":
				sql = " select * from dondathang";
				break;
			case "3":
				sql = " select * from dondathang where  datediff(MONTH,ngaydathang,GETDATE())<1";
				break;
			case "4":
				sql = " select * from dondathang where  datediff(DAY,ngaydathang,GETDATE())<7";
				break;
			case "5":
				sql = " select * from dondathang where  thanhtoan='True' and datediff(MONTH,ngaydathang,GETDATE())<1";
				break;
			case "6":
				sql = " select * from dondathang where thanhtoan='True' and datediff(DAY,ngaydathang,GETDATE())<7";
				break;
			case "7":
				sql = " select * from dondathang where thanhtoan='False' and datediff(MONTH,ngaydathang,GETDATE())<1";
				break;
			case "8":
				sql = " select * from dondathang where thanhtoan='False' and datediff(DAY,ngaydathang,GETDATE())<7";
				break;
			case "9":
				sql = " select * from dondathang where  vanchuyen='True' and datediff(MONTH,ngaydathang,GETDATE())<1";
				break;
			case "10":
				sql = " select * from dondathang where  vanchuyen='True' and datediff(DAY,ngaydathang,GETDATE())<7";
				break;
			case "11":
				sql = " select * from dondathang where vanchuyen='False' and datediff(MONTH,ngaydathang,GETDATE())<1";
				break;
			case "12":
				sql = " select * from dondathang where  vanchuyen='False' and datediff(DAY,ngaydathang,GETDATE())<7";
				break;

			}

			// String sql="execute thongkesoluongsanphamtonkho";
			String sql1="select * from ("+sql+") as t inner join chitietdondathang on t.maddh=chitietdondathang.maddh";
			JRDesignQuery newquery = new JRDesignQuery();
			newquery.setText(sql1);
			jd.setQuery(newquery);
			// System.out.println(input+"1");
			try {
				JasperReport jsreport = JasperCompileManager.compileReport(jd);

				JasperPrint print = JasperFillManager.fillReport(jsreport, param, connection);

				try {
					JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void reportsearchddh(HttpServletResponse response, Map<String, Object> param, String pathjrxml,
			String searchtype, String information) {
		Connection connection = ConnectDB.getconnectDB();
		try {
			JasperDesign jd = JRXmlLoader.load(pathjrxml);
			String sql = "";
			switch (searchtype) {
			case "username":
				sql = " select * from dondathang where tendangnhap like '%"+information+"%'";
				break;
			case "fullname":
				sql = " select * from dondathang where tennguoinhan like '%"+
						information+"%'";
				break;
			case "date":
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(information);
					// response.getWriter().append("Served at: ").append( new
					// SimpleDateFormat("MM/dd/yyyy").format(date));

					// listddh = ddhDAO.search_orderdate( new
					// SimpleDateFormat("MM/dd/yyyy").format(date));
					sql = " select * from dondathang where ngaydathang = '"+new SimpleDateFormat("MM/dd/yyyy").format(date)+"'";
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;
			case "ordercode":

				int code = Integer.parseInt(information);
				sql = " select * from dondathang where maddh="+code;
				break;

			}
			String sql1="select * from ("+sql+") as t inner join chitietdondathang on t.maddh=chitietdondathang.maddh";
			JRDesignQuery newquery = new JRDesignQuery();
			newquery.setText(sql1);
			jd.setQuery(newquery);
			// System.out.println(input+"1");
			try {
				JasperReport jsreport = JasperCompileManager.compileReport(jd);

				JasperPrint print = JasperFillManager.fillReport(jsreport, param, connection);

				try {
					JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void reportddh(HttpServletResponse response, Map<String, Object> param, String pathjrxml){
		Connection connection = ConnectDB.getconnectDB();
		try {
			JasperDesign jd = JRXmlLoader.load(pathjrxml);
			String sql = "select * from (select * from dondathang where xemdon='false') as t"
					+ " inner join chitietdondathang on t.maddh=chitietdondathang.maddh";
			//String sql="select * from haisan.dbo.Dondathang inner join haisan.dbo.Chitietdondathang on Dondathang.maddh=Chitietdondathang.maddh";
			JRDesignQuery newquery = new JRDesignQuery();
			newquery.setText(sql);
			jd.setQuery(newquery);
			// System.out.println(input+"1");
			try {
				JasperReport jsreport = JasperCompileManager.compileReport(jd);

				JasperPrint print = JasperFillManager.fillReport(jsreport, param, connection);

				try {
					JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void reportsanphambanchay(HttpServletResponse response, Map<String, Object> param, String pathjrxml,String ngay)
			throws FileNotFoundException {
		Connection connection = ConnectDB.getconnectDB();
		try {
			JasperDesign jd = JRXmlLoader.load(pathjrxml);
			String sql = "execute sanphambanchaytheothang '"+ngay+"'";
			String[] split=ngay.split("/");
			Map map = new HashMap();
            map.put("month", split[0]);
            map.put("year", split[2]);
			System.out.println(sql+ngay);
			JRDesignQuery newquery = new JRDesignQuery();
			newquery.setText(sql);
			jd.setQuery(newquery);
			// System.out.println(input+"1");
			try {
				JasperReport jsreport = JasperCompileManager.compileReport(jd);
				System.out.println(jsreport + "2");
				JasperPrint print = JasperFillManager.fillReport(jsreport, param, connection);
				print = JasperFillManager.fillReport(jsreport, map, connection);
				System.out.println(print + "3");
				try {
					JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void reportbill(HttpServletResponse response, Map<String, Object> param, String pathjrxml,int maddh)
			throws FileNotFoundException {
		Connection connection = ConnectDB.getconnectDB();
		try {
			JasperDesign jd = JRXmlLoader.load(pathjrxml);
			Dondathang ddh=new Dondathang();
			DondathangDAO ddhDAO=new DondathangDAO();
			ddh=ddhDAO.getddh(maddh);
			String sql = "select tensp=(select tensp from sanpham where sanpham.masp=chitietdondathang.masp),"
					+ "soluong,gia=((gia-(gia*khuyenmai)/100)*soluong) from chitietdondathang where maddh="+maddh;
			
			Map map = new HashMap();
			map.put("tenkhachhang", ddh.getTenkhachhang());
			map.put("tennguoinhan", ddh.getTennguoinhan());
			map.put("ngaydathang", ddh.getNgay());
			map.put("diachi", ddh.getDiachi());
			map.put("sodienthoai",ddh.getSodienthoai());
			map.put("tongtien", ddh.getTongtien());
			
			JRDesignQuery newquery = new JRDesignQuery();
			newquery.setText(sql);
			jd.setQuery(newquery);
			// System.out.println(input+"1");
			try {
				JasperReport jsreport = JasperCompileManager.compileReport(jd);
				System.out.println(jsreport + "2");
				JasperPrint print = JasperFillManager.fillReport(jsreport, param, connection);
				print = JasperFillManager.fillReport(jsreport, map, connection);
				System.out.println(print + "3");
				try {
					JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
