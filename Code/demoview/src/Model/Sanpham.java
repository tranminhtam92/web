package Model;

import java.util.Date;

public class Sanpham {
	private String masp;
	private String tensp;
	private int gia;
	private String donvitinh;
	private int soluong;
	private String mota;
	private String anh;
	private Date ngay;
	private String maloai;
	private int khuyenmai;
	private boolean sanphammoi;
	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp.trim();
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getDonvitinh() {
		return donvitinh;
	}

	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public int getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(int khuyenmai) {
		this.khuyenmai = khuyenmai;
	}

	public boolean isSanphammoi() {
		return sanphammoi;
	}

	public void setSanphammoi(boolean sanphammoi) {
		this.sanphammoi = sanphammoi;
	}

}
