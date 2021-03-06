package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ConnectDB.ConnectDB;

public class SanphamDAO {
	String strDateFormat = "dd/MM/yyyy";

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);

	public ArrayList<Sanpham> get4sanphamtheoloai(String maloai) {
		ArrayList<Sanpham> listsp = new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "select top 4 * from sanpham where maloai='" + maloai + "' order by ngay desc";
		try {
			PreparedStatement stm = cn.prepareCall(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Sanpham sp = new Sanpham();
				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				listsp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsp;
	}
	public ArrayList<Sanpham> get4sanphambanchay() {
		ArrayList<Sanpham> listsp = new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "execute sanphambanchay";
		try {
			PreparedStatement stm = cn.prepareCall(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Sanpham sp = new Sanpham();
				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				listsp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsp;
	}
	public ArrayList<Sanpham> getsanphambanchaytheothang(String ngay) {
		ArrayList<Sanpham> listsp = new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "execute sanphambanchaytheothang ?";
		try {
			PreparedStatement stm = cn.prepareCall(sql);
			stm.setString(1, ngay);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Sanpham sp = new Sanpham();
				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("sumsoluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				listsp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsp;
	}
	public ArrayList<Sanpham> getsanphamtheoloai(String maloai) {
		ArrayList<Sanpham> listsp = new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "select * from sanpham where maloai='" + maloai + "' order by ngay desc";
		try {
			PreparedStatement stm = cn.prepareCall(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Sanpham sp = new Sanpham();
				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				listsp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsp;
	}

	public Sanpham getsanpham(String masp) {
		Sanpham sp = new Sanpham();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "select * from sanpham where masp='" + masp + "'";
		try {
			PreparedStatement stm = cn.prepareCall(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {

				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				return sp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp;
	}

	public ArrayList<Sanpham> searchproduct(String productname) {
		ArrayList<Sanpham> listsp = new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "select * from sanpham where tensp like N'%" + productname + "%' order by ngay desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Sanpham sp = new Sanpham();
				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				listsp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsp;
	}
	public ArrayList<Sanpham> searchproductcode(String productcode) {
		ArrayList<Sanpham> listsp = new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "select * from sanpham where masp like N'%" + productcode + "%' order by ngay desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Sanpham sp = new Sanpham();
				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				listsp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsp;
	}
	public ArrayList<Sanpham> searchproducttype(String producttype) {
		ArrayList<Sanpham> listsp = new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "select * from sanpham where maloai like N'%" + producttype + "%' order by ngay desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Sanpham sp = new Sanpham();
				sp.setMasp(rs.getString("masp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setGia(rs.getInt("gia"));
				sp.setDonvitinh(rs.getString("donvitinh"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setMota(rs.getString("mota"));
				sp.setAnh(rs.getString("anh"));
				sp.setNgay(rs.getDate("ngay"));
				sp.setMaloai(rs.getString("maloai"));
				sp.setKhuyenmai(rs.getInt("khuyenmai"));
				sp.setSanphammoi(rs.getBoolean("sanphammoi"));
				listsp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsp;
	}
	public void updatesanpham(String masp,String tensp,int gia,String donvitinh,int soluong,String mota,String anh,
			String ngay,String maloai,int khuyenmai,boolean sanphammoi){
		Connection cn=ConnectDB.getconnectDB();
		String sql="update sanpham set tensp=?,gia=?,donvitinh=?,soluong=?,mota=?,sanphammoi=?,ngay=?,maloai=?,khuyenmai=?,anh=? where masp=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, tensp);
			stm.setInt(2, gia);
			stm.setString(3, donvitinh);
			stm.setInt(4, soluong);
			stm.setString(5, mota);
			stm.setBoolean(6, sanphammoi);
			stm.setString(7, ngay);
			stm.setString(8, maloai);
			stm.setInt(9, khuyenmai);
			stm.setString(10, anh);
			stm.setString(11, masp);
			int a=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updatesanpham(String masp,String tensp,int gia,String donvitinh,int soluong,String mota,
			String ngay,String maloai,int khuyenmai,boolean sanphammoi){
		Connection cn=ConnectDB.getconnectDB();
		String sql="update sanpham set tensp=?, gia=?, donvitinh=?, soluong=?, mota=?, sanphammoi=?, ngay=?, maloai=?, khuyenmai=? where masp=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, tensp);
			stm.setInt(2, gia);
			stm.setString(3, donvitinh);
			stm.setInt(4, soluong);
			stm.setString(5, mota);
			stm.setBoolean(6, sanphammoi);
			stm.setString(7, ngay);
			stm.setString(8, maloai);
			stm.setInt(9, khuyenmai);
			stm.setString(10, masp);
			int a=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatesoluongsanpham(String masp,int soluong){
		Connection cn=ConnectDB.getconnectDB();
		String sql="update sanpham set soluong=soluong+?, ngay=getdate() where masp=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setInt(1, soluong);
			stm.setString(2, masp);
			int a=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatesoluongsanpham(int maddh){
		Connection cn=ConnectDB.getconnectDB();
		String sql="execute soluongtruvanchuyen ?";
		try {
			PreparedStatement stm=cn.prepareCall(sql);
			stm.setInt(1, maddh);
			
			int a=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatethanhtoanfalse(int maddh){
		Connection cn=ConnectDB.getconnectDB();
		String sql="execute soluongcongvanchuyen ?";
		try {
			PreparedStatement stm=cn.prepareCall(sql);
			stm.setInt(1, maddh);
			
			int a=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertsanpham(String masp,String tensp,int gia,String donvitinh,String anh,int soluong,String mota,
			String ngay,String maloai,int khuyenmai,boolean sanphammoi){
		Connection cn=ConnectDB.getconnectDB();
		String sql="insert into sanpham values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, masp);
			stm.setString(2, tensp);
			stm.setInt(3, gia);
			stm.setString(4, donvitinh);
			stm.setInt(5, soluong);
			stm.setString(6, mota);
			stm.setString(7, anh);
			stm.setString(8, ngay);
			stm.setString(9, maloai);
			stm.setInt(10, khuyenmai);
			
			stm.setBoolean(11, sanphammoi);
			
			int a=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] arg) {
		SanphamDAO spdao = new SanphamDAO();
		// ArrayList<Sanpham> listsp=spdao.get4sanphamtheoloai("ca");
		ArrayList<Sanpham> listsp = spdao.searchproduct("c�");
		for (int i = 0; i < listsp.size(); i++) {
			Sanpham sp = new Sanpham();
			sp = listsp.get(i);

			System.out.println(sp.getNgay());

		}
	}
}
