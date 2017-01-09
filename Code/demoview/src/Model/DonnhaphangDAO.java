package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;

public class DonnhaphangDAO {
	String sqltennhanvien="(select tennv from nhanvien where nhanvien.manv=Donnhaphang.manv) as tennhanvien";
	String sqltennhacungcap="(select tennhacungcap from nhacungcap where nhacungcap.manhacungcap=Donnhaphang.manhacungcap) as tennhacungcap";
	public int getmaxmadnh(){
		int max=0;
		Donnhaphang dnh=new Donnhaphang();
		Connection cn=ConnectDB.getconnectDB();
		String sql="select max(madonnhaphang) as max from donnhaphang";
		try {
			PreparedStatement stm=cn.prepareStatement(sql);
		
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				max=rs.getInt("max");
				return max;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
public Donnhaphang getDonnhaphang(int madnh){
	Donnhaphang dnh=new Donnhaphang();
	Connection cn=ConnectDB.getconnectDB();
	String sql="select *,"+sqltennhanvien+","+sqltennhacungcap+ " from donnhaphang where madonnhaphang=?";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setInt(1, madnh);
		ResultSet rs=stm.executeQuery();
		while(rs.next()){
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			return dnh;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dnh;
}
public ArrayList<Donnhaphang> getallDonnhaphang(){
	ArrayList<Donnhaphang> listdnh=new ArrayList<>();
	Connection cn=ConnectDB.getconnectDB();
	String sql="select *,"+sqltennhanvien+","+sqltennhacungcap+ "  from donnhaphang";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);

		ResultSet rs=stm.executeQuery();
		while(rs.next()){
			Donnhaphang dnh=new Donnhaphang();
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			listdnh.add(dnh);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listdnh;
}
public ArrayList<Donnhaphang> get_importproducttoday(){
	ArrayList<Donnhaphang> listdnh=new ArrayList<>();
	Connection cn = ConnectDB.getconnectDB();
	
	String sql = " select *,"+sqltennhanvien+","+sqltennhacungcap+ "  from donnhaphang where datediff(DAY,ngaynhaphang,GETDATE())<1 order by madonnhaphang desc";
	try {
		PreparedStatement stm = cn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			Donnhaphang dnh=new Donnhaphang();
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
	
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			listdnh.add(dnh);
		}
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listdnh;
}
public ArrayList<Donnhaphang> get_importproductoneweek(){
	ArrayList<Donnhaphang> listdnh=new ArrayList<>();
	Connection cn = ConnectDB.getconnectDB();
	
	String sql = " select *,"+sqltennhanvien+","+sqltennhacungcap+ "  from donnhaphang where datediff(DAY,ngaynhaphang,GETDATE())<7 order by madonnhaphang desc";
	try {
		PreparedStatement stm = cn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			Donnhaphang dnh=new Donnhaphang();
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
	
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			listdnh.add(dnh);
		}
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listdnh;
}
public ArrayList<Donnhaphang> get_importproductonemonth(){
	ArrayList<Donnhaphang> listdnh=new ArrayList<>();
	Connection cn = ConnectDB.getconnectDB();
	
	String sql = " select *,"+sqltennhanvien+","+sqltennhacungcap+ "  from donnhaphang where datediff(MONTH,ngaynhaphang,GETDATE())<1 order by madonnhaphang desc";
	try {
		PreparedStatement stm = cn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			Donnhaphang dnh=new Donnhaphang();
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
	
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			listdnh.add(dnh);
		}
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listdnh;
}
public void insertdonnhaphang(String ngaynhaphang, boolean thanhtoan,int tongtien,String manv,String mancc){
	Connection cn=ConnectDB.getconnectDB();
	String sql="insert into donnhaphang values(?,?,?,?,?)";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setString(1, ngaynhaphang);
		stm.setBoolean(2, thanhtoan);
		stm.setInt(3, tongtien);
		stm.setString(5, manv);
		stm.setString(4, mancc);
		stm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void updatedonnhaphang(int madnh,String ngaynhaphang, boolean thanhtoan,int tongtien,String manv,String mancc){
	Connection cn=ConnectDB.getconnectDB();
	String sql="update donnhaphang set ngaynhaphang=?, thanhtoan=?, tongtien=?, manhanvien=?, manhacungcap=? where madonnhaphang=?";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setInt(6, madnh);
		stm.setString(1, ngaynhaphang);
		stm.setBoolean(2, thanhtoan);
		stm.setInt(3, tongtien);
		stm.setString(4, manv);
		stm.setString(5, mancc);
		stm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void updatetongtien(int madnh, int tongtien){
	Connection cn=ConnectDB.getconnectDB();
	String sql="update donnhaphang set  tongtien=tongtien+? where madonnhaphang=?";
	try {
		PreparedStatement stm=cn.prepareStatement(sql);
		stm.setInt(2, madnh);

		stm.setInt(1, tongtien);
		stm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public ArrayList<Donnhaphang> searchemployeecode(String manv){
	ArrayList<Donnhaphang> listdnh=new ArrayList<>();
	Connection cn = ConnectDB.getconnectDB();
	
	String sql = " select *,"+sqltennhanvien+","+sqltennhacungcap+ "  from donnhaphang where manv like '%"+manv+"%'";
	try {
		PreparedStatement stm = cn.prepareStatement(sql);
	
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			Donnhaphang dnh=new Donnhaphang();
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
	
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			listdnh.add(dnh);
		}
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listdnh;
}
public ArrayList<Donnhaphang> searchmanufactorcode(String mancc){
	ArrayList<Donnhaphang> listdnh=new ArrayList<>();
	Connection cn = ConnectDB.getconnectDB();
	
	String sql = " select *,"+sqltennhanvien+","+sqltennhacungcap+ "  from donnhaphang where manhacungcap like '%"+mancc+"%'";
	try {
		PreparedStatement stm = cn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			Donnhaphang dnh=new Donnhaphang();
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
	
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			listdnh.add(dnh);
		}
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listdnh;
}
public ArrayList<Donnhaphang> filler_importproductonemonth(String ngay){
	ArrayList<Donnhaphang> listdnh=new ArrayList<>();
	Connection cn = ConnectDB.getconnectDB();
	
	String sql = " select *,"+sqltennhanvien+","+sqltennhacungcap+ "  from donnhaphang where datediff(MONTH,?,ngaynhaphang)=0 and datediff(DAY,?,ngaynhaphang)>=0";
	try {
		PreparedStatement stm = cn.prepareStatement(sql);
		stm.setString(1, ngay);
		stm.setString(2, ngay);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			Donnhaphang dnh=new Donnhaphang();
			dnh.setMadnh(rs.getInt("madonnhaphang"));
			dnh.setNgaynhaphang(rs.getDate("ngaynhaphang"));
	
			dnh.setTongtien(rs.getInt("tongtien"));
			dnh.setThanhtoan(rs.getBoolean("thanhtoan"));
			dnh.setManhanvien(rs.getString("manv"));
			dnh.setMancc(rs.getString("manhacungcap"));
			dnh.setTennhanvien(rs.getString("tennhanvien"));
			dnh.setTennhacungcap(rs.getString("tennhacungcap"));
			listdnh.add(dnh);
		}
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listdnh;
}
}
