package vankhai.bookshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="sach")
public class Sach implements Serializable {
	
	private int idSach;
	private String tenSach;
	private String hinhAnh;
	private String ghiChu;
	private float donGia;
	
	private TacGia tacGia;
	private TheLoai theLoai;
	
	
	public Sach() {
		
	}

	
	
	public Sach(int idSach, String tenSach, String hinhAnh, String ghiChu, float donGia, TacGia tacGia,
			TheLoai theLoai) {
		super();
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.hinhAnh = hinhAnh;
		this.ghiChu = ghiChu;
		this.donGia = donGia;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
	}



	/*
	 * public Sach(int idSach, String tenSach, int idTacGia, int idTheLoai, String
	 * hinhAnh, String ghiChu, float donGia) { super(); this.idSach = idSach;
	 * this.tenSach = tenSach; this.hinhAnh = hinhAnh; this.ghiChu = ghiChu;
	 * this.donGia = donGia; }
	 */


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idsach")
	public int getIdSach() {
		return idSach;
	}
	public void setIdSach(int idSach) {
		this.idSach = idSach;
	}
	
	@Column(name="TenSach")
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	
	//Do là khóa phụ, nên khi set cả bảng tác giả vào, nó sẽ tự set idtg vào bảng sách
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idTacGia", foreignKey = @ForeignKey(name = "SACH_TG_FK"))
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idTheLoai", foreignKey = @ForeignKey(name = "SACH_TL_FK"))
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}


	@Column(name="HinhAnh")
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	@Column(name="GhiChu")
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	@Column(name="DonGia")
	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
		
	
}
