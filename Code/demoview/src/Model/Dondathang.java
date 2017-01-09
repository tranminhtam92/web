package Model;

import java.util.Date;

public class Dondathang {
	private int maddh;
	private Date ngay;
	private Date ngaythanhtoan;
	private Date ngayvanchuyen;
	private String tennguoinhan;
	private String diachi;
	private String sodienthoai;
	private boolean thanhtoan;
	private boolean vanchuyen;
	private String tendangnhap;
	private String tenkhachhang;
	private int tongtien;
	private String manhanvienvanchuyen;
	private String nhanvienvanchuyen;
	private String manhanvien;
	private String nhanvien;
	private boolean duyetdon;
	private boolean xemdon;
	public Dondathang() {

	}

	public Dondathang(int maddh, Date ngay, String tennguoinhan, String diachi, String sodienthoai, boolean thanhtoan,
			boolean vanchuyen, String tendangnhap,String tenkhachhang,int tongtien,String manhanvienvanchuyen,
			String nhanvienvanchuyen,String manhanvien,String nhanvien) {

		this.maddh = maddh;
		this.ngay = ngay;
		this.tennguoinhan = tennguoinhan;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.thanhtoan = thanhtoan;
		this.vanchuyen = vanchuyen;
		this.tendangnhap = tendangnhap;
		this.tongtien=tongtien;
		this.nhanvienvanchuyen=nhanvienvanchuyen;
		this.nhanvien=nhanvien;
		this.manhanvienvanchuyen=manhanvienvanchuyen;
		this.manhanvien=manhanvien;
		this.tenkhachhang=tenkhachhang;
	}

	public int getMaddh() {
		return maddh;
	}

	public void setMaddh(int maddh) {
		this.maddh = maddh;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public String getTennguoinhan() {
		return tennguoinhan;
	}

	public void setTennguoinhan(String tennguoinhan) {
		this.tennguoinhan = tennguoinhan;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public boolean getThanhtoan() {
		return thanhtoan;
	}

	public void setThanhtoan(boolean thanhtoan) {
		this.thanhtoan = thanhtoan;
	}

	public boolean getVanchuyen() {
		return vanchuyen;
	}

	public void setVanchuyen(boolean vanchuyen) {
		this.vanchuyen = vanchuyen;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public Date getNgaythanhtoan() {
		return ngaythanhtoan;
	}

	public void setNgaythanhtoan(Date ngaythanhtoan) {
		this.ngaythanhtoan = ngaythanhtoan;
	}

	public Date getNgayvanchuyen() {
		return ngayvanchuyen;
	}

	public void setNgayvanchuyen(Date ngayvanchuyen) {
		this.ngayvanchuyen = ngayvanchuyen;
	}

	public String getManhanvien() {
		return manhanvien;
	}

	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}

	public boolean isDuyetdon() {
		return duyetdon;
	}

	public void setDuyetdon(boolean duyetdon) {
		this.duyetdon = duyetdon;
	}

	public boolean isXemdon() {
		return xemdon;
	}

	public void setXemdon(boolean xemdon) {
		this.xemdon = xemdon;
	}

	public String getManhanvienvanchuyen() {
		return manhanvienvanchuyen;
	}

	public void setManhanvienvanchuyen(String manhanvienvanchuyen) {
		this.manhanvienvanchuyen = manhanvienvanchuyen;
	}

	public String getNhanvienvanchuyen() {
		return nhanvienvanchuyen;
	}

	public void setNhanvienvanchuyen(String nhanvienvanchuyen) {
		this.nhanvienvanchuyen = nhanvienvanchuyen;
	}

	public String getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(String nhanvien) {
		this.nhanvien = nhanvien;
	}
	

}
