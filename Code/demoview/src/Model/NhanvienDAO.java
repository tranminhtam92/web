package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

public class NhanvienDAO {
public Nhanvien getnhanvien(String manhanvien){
	Connection cn= ConnectDB.getconnectDB();
	Nhanvien nv=new Nhanvien();
	String sql="select * from nhanvienvanchuyen where manhanvien=?";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setString(1, manhanvien);
		ResultSet rs=stm.executeQuery();
		while(rs.next()){
			nv.setManhanvien(rs.getString("manhanvien"));
			nv.setTennhanvien(rs.getString("tennhanvien"));
			nv.setDiachi(rs.getString("diachi"));
			nv.setSodienthoai(rs.getString("sodienthoai"));
			return nv;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return nv;
}
public boolean checknhanvien(String manhanvien){
	Connection cn= ConnectDB.getconnectDB();
	Nhanvien nv=new Nhanvien();
	String sql="select * from nhanvienvanchuyen where manhanvien=?";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setString(1, manhanvien);
		ResultSet rs=stm.executeQuery();
		if(rs.next())
			return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;

}
public ArrayList<Nhanvien> getallnhanvien(){
	Connection cn= ConnectDB.getconnectDB();
	ArrayList<Nhanvien> listnv=new ArrayList<>();
	
	String sql="select * from nhanvienvanchuyen";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);

		ResultSet rs=stm.executeQuery();
		while(rs.next()){
			Nhanvien nv=new Nhanvien();
			nv.setManhanvien(rs.getString("manhanvien"));
			nv.setTennhanvien(rs.getString("tennhanvien"));
			nv.setDiachi(rs.getString("diachi"));
			nv.setSodienthoai(rs.getString("sodienthoai"));
			listnv.add(nv);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listnv;
}
public void addnhanvien(String manhanvien,String tennhanvien,String diachi,String sodienthoai){
	Connection cn=ConnectDB.getconnectDB();
	String sql="insert into nhanvienvanchuyen values (?,?,?,?)";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setString(1, manhanvien);
		stm.setString(2, tennhanvien);
		stm.setString(3, diachi);
		stm.setString(4, sodienthoai);
		int a=stm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void updatnhanvien(String manhanvien,String tennhanvien,String diachi,String sodienthoai){
	Connection cn=ConnectDB.getconnectDB();
	String sql="update nhanvienvanchuyen set tennhanvien=?, diachi=?, sodienthoai=? where manhanvien=?";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setString(1, tennhanvien);
		stm.setString(2, diachi);
		stm.setString(3, sodienthoai);
		stm.setString(4, manhanvien);
		int a=stm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
