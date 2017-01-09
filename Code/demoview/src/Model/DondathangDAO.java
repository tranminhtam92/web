package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ConnectDB.ConnectDB;


public class DondathangDAO {
	String sqltenkhackhang="(select hoten from khachhang where khachhang.tendangnhap=Dondathang.tendangnhap) as tenkhachhang";
	String sqlnhanvienvanchuyen="(select tennhanvien from Nhanvienvanchuyen where Nhanvienvanchuyen.manhanvien=Dondathang.manhanvien) as nhanvienvanchuyen";
	String sqlnhanvien="(select tennv from Nhanvien where Nhanvien.manv=Dondathang.manv) as nhanvien";
	SimpleDateFormat timeFormat= new SimpleDateFormat("MM/dd/yyyy");
	public void insert_order( String tennguoinhan, String diachi, String sodienthoai,String tendangnhap,int tongtien) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "insert into Dondathang (ngaydathang,tennguoinhan,diachi,sodienthoai,thanhtoan,vanchuyen,tendangnhap,tongtien,manhanvien,duyetdon,xemdon,manv) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean temp=false;
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			stm.setString(1,timeFormat.format(new Date(System.currentTimeMillis())));
		//	stm.setString(1,"11/11/2016");
			stm.setString(2, tennguoinhan);
			stm.setString(3, diachi);
			stm.setString(4, sodienthoai);
			stm.setBoolean(5, temp);
			stm.setBoolean(6, temp);
			stm.setString(7, tendangnhap);
			stm.setInt(8, tongtien);
			stm.setString(9, "admin");
			stm.setString(10, "false");
			stm.setString(11, "false");
			stm.setString(12, "nv");
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean checktrasport(int maddh){
		Connection cn=ConnectDB.getconnectDB();
		String sql="execute kiemtrasoluongvanchuyen ?";
		try {
			PreparedStatement stm=cn.prepareCall(sql);
			stm.setInt(1, maddh);
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				if(rs.getInt("soluong")<rs.getInt("soluongdat")){
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public void delete_order( int maddh) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "delete from dondathang where maddh=?";
		boolean temp=false;
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
	public int getmaddh(String username){
		Connection cn = ConnectDB.getconnectDB();
		String sql = " select max(maddh) as maddh from dondathang where tendangnhap=?";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1, username);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				return rs.getInt("maddh");
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Dondathang getddh(int maddh){
		Connection cn = ConnectDB.getconnectDB();
		Dondathang ddh=new Dondathang();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where maddh=?";
		//System.out.println(sql);
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setInt(1, maddh);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				return ddh;
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ddh;
	}
	public void update_Thanhtoanorder( boolean thanhtoan,int maddh) {
		Connection cn = ConnectDB.getconnectDB();
		String sql="";
		if(thanhtoan)
		sql = "update dondathang set thanhtoan=?,ngaythanhtoan=GETDATE() where maddh=? ";
		else{
			sql = "update dondathang set thanhtoan=?,ngaythanhtoan=null where maddh=? ";
		}
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			stm.setBoolean(1, thanhtoan);
			stm.setInt(2, maddh);
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update_Vanchuyenorder( boolean vanchuyen,int maddh) {
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = "update dondathang set vanchuyen=? where maddh=? ";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			stm.setBoolean(1, vanchuyen);
			stm.setInt(2, maddh);
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update_Checkorder( boolean duyetdon,int maddh) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "update dondathang set duyetdon=? where maddh=? ";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			stm.setBoolean(1, duyetdon);
			stm.setInt(2, maddh);
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update_Vieworder( boolean xemdon,int maddh) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "update dondathang set xemdon=? where maddh=? ";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			stm.setBoolean(1, xemdon);
			stm.setInt(2, maddh);
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update_nhanvien(int maddh,String manhanvien) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "update dondathang set manv=? where maddh=? and manv='nv' ";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
	
		stm.setString(1,manhanvien);
			stm.setInt(2, maddh);
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update_order(int maddh,String ngayvanchuyen,String manhanvien) {
		Connection cn = ConnectDB.getconnectDB();
		String sql = "update dondathang set ngayvanchuyen=?,manhanvien=? where maddh=? ";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			
		stm.setString(1, ngayvanchuyen);
		stm.setString(2,manhanvien);
			stm.setInt(3, maddh);
			int bl = stm.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Dondathang> get_allorderofuser(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_ordertoday(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where datediff(DAY,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_orderofuseronemonth(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_orderofuseroneweek(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_payorderofuseronemont(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and thanhtoan='True' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unpayorderofuseronemont(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and thanhtoan='False' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_payorderofuseroneweek(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and thanhtoan='True' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unpayorderofuseroneweek(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and thanhtoan='False' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_ship_orderofuseronemonth(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and vanchuyen='True' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unship_orderofuseronemonth(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and vanchuyen='False' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_ship_orderofuseroneweek(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and vanchuyen='True' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unship_orderofuseroneweek(String username){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap=? and vanchuyen='False' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1,username);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_allorder(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_orderonemonth(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where  datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_orderoneweek(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where  datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_payorderonemont(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where  thanhtoan='True' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unpayorderonemont(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where thanhtoan='False' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_payorderoneweek(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where thanhtoan='True' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unpayorderoneweek(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where thanhtoan='False' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
		
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_ship_orderonemonth(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where  vanchuyen='True' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unship_orderonemonth(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where vanchuyen='False' and datediff(MONTH,ngaydathang,GETDATE())<1 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_ship_orderoneweek(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where  vanchuyen='True' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
		
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_unship_orderoneweek(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where  vanchuyen='False' and datediff(DAY,ngaydathang,GETDATE())<7 order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> get_notvieworder(){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+" from dondathang where xemdon='false' order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> search_orderofcustomercode(String tendangnhap){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tendangnhap like '%"+tendangnhap+"%' order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> search_orderdate(String ngay){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where ngaydathang = '"+ngay+"'";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> filler_ordermonth(String ngay){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from Dondathang where DATEDIFF(DAY,?,ngaythanhtoan)>=0 and DATEDIFF(MONTH,?,ngaythanhtoan)=0 and thanhtoan='true'";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			stm.setString(1, ngay);
			stm.setString(2, ngay);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}
	public ArrayList<Dondathang> search_orderofreceiver(String 
			receiver){
		ArrayList<Dondathang> listddh=new ArrayList<>();
		Connection cn = ConnectDB.getconnectDB();
		
		String sql = " select *,"+sqltenkhackhang+","+sqlnhanvienvanchuyen+","+sqlnhanvien+ " from dondathang where tennguoinhan like '%"+
				receiver+"%' order by maddh desc";
		try {
			PreparedStatement stm = cn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Dondathang ddh=new Dondathang();
				ddh.setMaddh(rs.getInt("maddh"));
				ddh.setNgay(rs.getDate("ngaydathang"));
				ddh.setTendangnhap(rs.getString("tendangnhap"));
				ddh.setTennguoinhan(rs.getString("tennguoinhan"));
				ddh.setSodienthoai(rs.getString("sodienthoai"));
				ddh.setDiachi(rs.getString("diachi"));
				ddh.setTongtien(rs.getInt("tongtien"));
				ddh.setThanhtoan(rs.getBoolean("thanhtoan"));
				ddh.setVanchuyen(rs.getBoolean("vanchuyen"));
				ddh.setDuyetdon(rs.getBoolean("duyetdon"));
				ddh.setXemdon(rs.getBoolean("xemdon"));
				ddh.setNgaythanhtoan(rs.getDate("ngaythanhtoan"));
				ddh.setNgayvanchuyen(rs.getDate("ngayvanchuyen"));
				ddh.setManhanvien(rs.getString("manv"));
				ddh.setManhanvienvanchuyen(rs.getString("manhanvien"));
				ddh.setNhanvienvanchuyen(rs.getString("nhanvienvanchuyen"));
				ddh.setNhanvien(rs.getString("nhanvien"));
				ddh.setTenkhachhang(rs.getString("tenkhachhang"));
				listddh.add(ddh);
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listddh;
	}

	public static void main(String[] arg){
		DondathangDAO ddhDAO=new DondathangDAO();
		ArrayList<Dondathang>listddh=new ArrayList<>();
		//listddh=ddhDAO.get_allorderofuser("tmtvtt");
		listddh=ddhDAO.get_orderofuseronemonth("tmtvtt");
		for(Dondathang ddh:listddh){
			System.out.println(ddh.getMaddh());
		}
	}
}
