package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

public class ThongkesanphamDAO {
	public ArrayList<Thongkesanpham> getthongkesanpham(){
		ArrayList<Thongkesanpham> list_tksp=new ArrayList<>();
		Connection cn=ConnectDB.getconnectDB();
		String sql="execute thongkesoluongsanphamtonkho";
		try {
			PreparedStatement stm=cn.prepareCall(sql);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				Thongkesanpham tksp=new Thongkesanpham();
				tksp.setMasp(rs.getString("masp"));
				tksp.setTensp(rs.getString("tensp"));
				tksp.setSoluong(rs.getInt("soluong"));
				tksp.setSoluongdat(rs.getInt("soluongdat"));
				list_tksp.add(tksp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_tksp;
	}
}
