package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

public class ChitietdondathangDAO {
	public void insert_detailorder(int maddh, String masp, int soluong, int gia,int khuyenmai) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "insert into chitietdondathang (maddh,Masp,soluong,gia,khuyenmai) values(?,?,?,?,?)";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setInt(1, maddh);
			stm.setString(2, masp);
			stm.setInt(3, soluong);
			stm.setInt(4, gia);
			stm.setInt(5, khuyenmai);
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete_detailorder( int maddh) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "delete from chitietdondathang where maddh=?";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
		
			stm.setInt(1,maddh);
			
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Monhang> get_detailorder(int maddh){
		ArrayList<Monhang> list_detail=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		String sql = "execute sanphamtheodondathang ?";
		try {
			PreparedStatement stm = cn.prepareCall(sql);
			stm.setInt(1, maddh);
		
			ResultSet rs= stm.executeQuery();
			while(rs.next()){
				Monhang mh=new Monhang();
				mh.setMasp(rs.getString("masp"));
				mh.setTensp(rs.getString("tensp"));
				mh.setAnh(rs.getString("anh"));
				mh.setSoluong(rs.getInt("soluong"));
				mh.setKhuyenmai(rs.getInt("khuyenmai"));
				mh.setGia(rs.getInt("gia"));
				list_detail.add(mh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_detail;
	}
	public static void main(String[] arg){
		ChitietdondathangDAO ctDAO= new ChitietdondathangDAO();
		ArrayList<Monhang> list_detail=new ArrayList<>();
		list_detail=ctDAO.get_detailorder(6);
		for(int i=0;i<list_detail.size();i++){
			Monhang mh=list_detail.get(i);
			System.out.println(mh.getAnh());
		}
		
	}
	
}
