package Model;

public class Nhanvienduyetdon {
	private String manhanvien;
	private String tennhanvien;
	private String diachi;
	private String sodienthoai;
	private boolean gioitinh;
	private String quyen;
	
	public Nhanvienduyetdon() {
		super();
	}
	
	public Nhanvienduyetdon(String manhanvien, String tennhanvien, String diachi, String sodienthoai, boolean gioitinh,
			String quyen) {
		super();
		this.manhanvien = manhanvien;
		this.tennhanvien = tennhanvien;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.gioitinh = gioitinh;
		this.quyen = quyen;
	}

	public String getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getTennhanvien() {
		return tennhanvien;
	}
	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
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
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	
}
