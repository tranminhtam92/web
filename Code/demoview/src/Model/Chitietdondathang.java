package Model;

public class Chitietdondathang {
private int maddh;
private String masp;
private String tensp;
private int soluong;
private int gia;
private int khuyenmai;
public Chitietdondathang(){
	
}
public Chitietdondathang(int maddh, String masp,String tensp, int soluong, int gia,int khuyenmai) {
	this.maddh = maddh;
	this.masp = masp;
	this.tensp = tensp;
	this.soluong = soluong;
	this.gia = gia;
	this.khuyenmai=khuyenmai;
}
public int getMaddh() {
	return maddh;
}
public void setMaddh(int maddh) {
	this.maddh = maddh;
}
public String getMasp() {
	return masp;
}

public String getTensp() {
	return tensp;
}
public void setTensp(String tensp) {
	this.tensp = tensp;
}
public void setMasp(String masp) {
	this.masp = masp;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public int getKhuyenmai() {
	return khuyenmai;
}
public void setKhuyenmai(int khuyenmai) {
	this.khuyenmai = khuyenmai;
}


}
