package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

public class ChitietdonnhaphangDAO {
	String sqltensp="(select tensp from sanpham where sanpham.masp=chitietdonnhaphang.masp) as tensp";
	public ArrayList<Chitietdonnhaphang> getChitietdonnhaphang(int madnh){
		ArrayList<Chitietdonnhaphang> listctdnh=new ArrayList<>();
		Connection cn=ConnectDB.getconnectDB();
		String sql="select *,"+sqltensp+" from chitietdonnhaphang where madonnhaphang=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setInt(1, madnh);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				Chitietdonnhaphang ctdnh=new Chitietdonnhaphang();
				ctdnh.setMadnh(rs.getInt("madonnhaphang"));
				ctdnh.setMasp(rs.getString("masp"));
				ctdnh.setSoluong(rs.getInt("soluong"));
				ctdnh.setGia(rs.getInt("gia"));
				ctdnh.setTensp(rs.getString("tensp"));
				listctdnh.add(ctdnh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listctdnh;
	}
	public void insertChitietdnh(int madnh,String masp,int soluong,int gia){
		Connection cn=ConnectDB.getconnectDB();
		String sql="insert into chitietdonnhaphang values(?,?,?,?)";
		PreparedStatement stm;
		try {
			stm = cn.prepareStatement(sql);
			stm.setInt(1, madnh);
			stm.setString(2, masp);
			stm.setInt(3, soluong);
			stm.setInt(4, gia);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
