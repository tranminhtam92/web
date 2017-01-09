package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDB.ConnectDB;

public class Tygiado {
	public float getdo(){
		float dola=0;
		Connection cn=ConnectDB.getconnectDB();
		String sql="select tigia from tygiado";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				dola=rs.getFloat("tigia");
				return dola;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dola;
	}
	public void updatedo(float tygiamoi){
		Connection cn=ConnectDB.getconnectDB();
		String sql="update tygiado set tigia=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setFloat(1, tygiamoi);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
