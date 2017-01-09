package Model;

public class Monhang {
private String masp;
private String tensp;
private String anh;
private int gia;
private int soluong;
private int khuyenmai;
public Monhang(){
	
}
public Monhang(String masp,String tensp,int gia,String anh, int soluong,int khuyenmai){
	this.masp=masp;
	this.tensp=tensp;
	this.gia=gia;
	this.anh=anh;
	this.soluong=soluong;
	this.khuyenmai=khuyenmai;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public String getMasp() {
	return masp;
}
public void setMasp(String masp) {
	this.masp = masp;
}
public String getTensp() {
	return tensp;
}
public void setTensp(String tensp) {
	this.tensp = tensp;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public int getKhuyenmai() {
	return khuyenmai;
}
public void setKhuyenmai(int khuyenmai) {
	this.khuyenmai = khuyenmai;
}

}
