package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

public class NhacungcapDAO {
	public ArrayList<Nhacungcap> getallnhacungcap(){
		ArrayList<Nhacungcap> listncc=new ArrayList<>();
		Connection cn=ConnectDB.getconnectDB();
		String sql="select * from nhacungcap";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				Nhacungcap ncc=new Nhacungcap();
				ncc.setManhacungcap(rs.getString("manhacungcap"));
				ncc.setTennhacungcap(rs.getString("tennhacungcap"));
				ncc.setDiachi(rs.getString("diachi"));
				ncc.setSodienthoai(rs.getString("sodienthoai"));
				listncc.add(ncc);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listncc;
	}
	public Nhacungcap getnhacungcap(String manhacungcap){
		Nhacungcap ncc=new Nhacungcap();
		Connection cn=ConnectDB.getconnectDB();
		String sql="select * from nhacungcap where manhacungcap=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, manhacungcap);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				
				ncc.setManhacungcap(rs.getString("manhacungcap"));
				ncc.setTennhacungcap(rs.getString("tennhacungcap"));
				ncc.setDiachi(rs.getString("diachi"));
				ncc.setSodienthoai(rs.getString("sodienthoai"));
				return ncc;
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ncc;
	}
	public boolean checknhacungcap(String manhacungcap){
		Nhacungcap ncc=new Nhacungcap();
		Connection cn=ConnectDB.getconnectDB();
		String sql="select * from nhacungcap where manhacungcap=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, manhacungcap);
			ResultSet rs=stm.executeQuery();
			if(rs.next()){
				return true;
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void update_nhacungcap(String manhacungcap,String tennhacungcap,String diachi,String sodienthoai){
		Connection cn=ConnectDB.getconnectDB();
		String sql="update nhacungcap set tennhacungcap=?, diachi=?, sodienthoai=? where manhacungcap=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, tennhacungcap);
			stm.setString(2, diachi);
			stm.setString(3, sodienthoai);
			stm.setString(4, manhacungcap);
			int a=stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert_nhacungcap(String manhacungcap,String tennhacungcap,String diachi,String sodienthoai){
		Connection cn=ConnectDB.getconnectDB();
		String sql="insert into nhacungcap values(?,?,?,?)";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, manhacungcap);
			stm.setString(2, tennhacungcap);
			stm.setString(3, diachi);
			stm.setString(4, sodienthoai);
			
			int a=stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
