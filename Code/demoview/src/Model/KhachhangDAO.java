package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

public class KhachhangDAO {
	public boolean checkuser(String username){
		Connection cn=ConnectDB.getconnectDB();
		String sql="select tendangnhap from khachhang where tendangnhap=?";
		try {
			PreparedStatement stm=cn.prepareCall(sql);
			stm.setString(1, username);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				cn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkpass(String password){
		Connection cn=ConnectDB.getconnectDB();
		String sql="select matkhau from khachhang where matkhau=?";
		try {
			PreparedStatement stm=cn.prepareCall(sql);
			stm.setString(1, password);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				cn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void insertKhachhang(String tendangnhap,String matkhau,String hoten,String sodienthoai,String diachi){
		Connection cn= ConnectDB.getconnectDB();
		String sql="insert into khachhang values (?,?,?,?,?)";
		try {
			PreparedStatement stm=cn.prepareCall(sql);
			stm.setString(1, tendangnhap);
			stm.setString(2, matkhau);
			stm.setString(3, hoten);
			stm.setString(4, sodienthoai);
			stm.setString(5, diachi);
			int rs=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Khachhang> getallKhachhang(){
		ArrayList<Khachhang> listkh=new ArrayList<>();
		Connection cn= ConnectDB.getconnectDB();
		String sql="select * from khachhang";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			
			ResultSet rs= stm.executeQuery();
			while(rs.next()){
				Khachhang kh= new Khachhang();
				kh.setTendangnhap(rs.getString("tendangnhap"));
				kh.setHoten(rs.getString("hoten"));
				kh.setDiachi(rs.getString("diachi"));
				kh.setSodienthoai(rs.getString("sodienthoai"));
				kh.setMatkhau(rs.getString("matkhau"));
				listkh.add(kh);
			}
			cn.close();
			return listkh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listkh;
		
	}
	public Khachhang getKhachhang(String tendangnhap){
		Khachhang kh= new Khachhang();
		Connection cn= ConnectDB.getconnectDB();
		String sql="select * from khachhang where tendangnhap=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, tendangnhap);
			ResultSet rs= stm.executeQuery();
			while(rs.next()){
				kh.setTendangnhap(rs.getString("tendangnhap"));
				kh.setHoten(rs.getString("hoten"));
				kh.setDiachi(rs.getString("diachi"));
				kh.setSodienthoai(rs.getString("sodienthoai"));
				kh.setMatkhau(rs.getString("matkhau"));
				return kh;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kh;
		
	}
	public void updateKhachhang(String tendangnhap,String hoten,String diachi,String sodienthoai){
	
		Connection cn= ConnectDB.getconnectDB();
		String sql="update khachhang set hoten=?,diachi=?,sodienthoai=? where tendangnhap=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, hoten);
			stm.setString(2, diachi);
			stm.setString(3, sodienthoai);
			stm.setString(4, tendangnhap);
			int temp= stm.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updatepassword(String tendangnhap,String passnew){
		
		Connection cn= ConnectDB.getconnectDB();
		String sql="update khachhang set matkhau=? where tendangnhap=?";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			stm.setString(1, passnew);
		
			stm.setString(2, tendangnhap);
			int temp= stm.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Khachhang> searchtendangnhap(String noidung){
		ArrayList<Khachhang> listkh=new ArrayList<>();
		Connection cn= ConnectDB.getconnectDB();
		String sql="select * from khachhang where tendangnhap like '%"+noidung+"%'";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			
			ResultSet rs= stm.executeQuery();
			while(rs.next()){
				Khachhang kh= new Khachhang();
				kh.setTendangnhap(rs.getString("tendangnhap"));
				kh.setHoten(rs.getString("hoten"));
				kh.setDiachi(rs.getString("diachi"));
				kh.setSodienthoai(rs.getString("sodienthoai"));
				kh.setMatkhau(rs.getString("matkhau"));
				listkh.add(kh);
			}
			cn.close();
			return listkh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listkh;
		
	}
	public ArrayList<Khachhang> searchhoten(String noidung){
		ArrayList<Khachhang> listkh=new ArrayList<>();
		Connection cn= ConnectDB.getconnectDB();
		String sql="select * from khachhang where hoten like '%"+noidung+"%'";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			
			ResultSet rs= stm.executeQuery();
			while(rs.next()){
				Khachhang kh= new Khachhang();
				kh.setTendangnhap(rs.getString("tendangnhap"));
				kh.setHoten(rs.getString("hoten"));
				kh.setDiachi(rs.getString("diachi"));
				kh.setSodienthoai(rs.getString("sodienthoai"));
				kh.setMatkhau(rs.getString("matkhau"));
				listkh.add(kh);
			}
			cn.close();
			return listkh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listkh;
		
	}
	public ArrayList<Khachhang> searchdiachi(String noidung){
		ArrayList<Khachhang> listkh=new ArrayList<>();
		Connection cn= ConnectDB.getconnectDB();
		String sql="select * from khachhang where diachi like '%"+noidung+"%'";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			
			ResultSet rs= stm.executeQuery();
			while(rs.next()){
				Khachhang kh= new Khachhang();
				kh.setTendangnhap(rs.getString("tendangnhap"));
				kh.setHoten(rs.getString("hoten"));
				kh.setDiachi(rs.getString("diachi"));
				kh.setSodienthoai(rs.getString("sodienthoai"));
				kh.setMatkhau(rs.getString("matkhau"));
				listkh.add(kh);
			}
			cn.close();
			return listkh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listkh;
		
	}
	public ArrayList<Khachhang> searchsodienthoai(String noidung){
		ArrayList<Khachhang> listkh=new ArrayList<>();
		Connection cn= ConnectDB.getconnectDB();
		String sql="select * from khachhang where sodienthoai like '%"+noidung+"%'";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
			
			ResultSet rs= stm.executeQuery();
			while(rs.next()){
				Khachhang kh= new Khachhang();
				kh.setTendangnhap(rs.getString("tendangnhap"));
				kh.setHoten(rs.getString("hoten"));
				kh.setDiachi(rs.getString("diachi"));
				kh.setSodienthoai(rs.getString("sodienthoai"));
				kh.setMatkhau(rs.getString("matkhau"));
				listkh.add(kh);
			}
			cn.close();
			return listkh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listkh;
		
	}
	public static void main(String[] arg){
		KhachhangDAO khdao= new KhachhangDAO();
		if(khdao.checkuser("")){
			System.out.println("dung");
		}
		else{
			System.out.println("sai");
		}
		String tendangnhap="lala";
		String matkhau="123456";
		String hoten="Tâm";
		String sodienthoai="0987654321";
		String diachi="Hiền vương";
		String sql="insert into khachhang values ('"+tendangnhap+"','"+matkhau+"',N'"+hoten+"','"+sodienthoai+"',N'"+diachi+"')";
		System.out.println(sql);
	}
}
