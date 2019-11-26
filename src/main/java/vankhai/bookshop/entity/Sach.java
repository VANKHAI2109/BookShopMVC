package vankhai.bookshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="sach")
public class Sach implements Serializable {
	
	private int idSach;
	private String tenSach;
	private String tenTacGia;
	private String theLoai;
	private byte[] hinhAnh;
	private String ghiChu;
	private float donGia;
	
	
	public Sach() {
		
	}

	public Sach(int idSach, String tenSach, String tenTacGia, String theLoai, byte[] hinhAnh, String ghiChu,
			float donGia) {
		super();
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.tenTacGia = tenTacGia;
		this.theLoai = theLoai;
		this.hinhAnh = hinhAnh;
		this.ghiChu = ghiChu;
		this.donGia = donGia;
	}
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
	
	@Column(name="TenTacGia")
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	
	@Column(name="TenTheLoai")
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	
	@Column(name="HinhAnh")
	public byte[] getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
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
