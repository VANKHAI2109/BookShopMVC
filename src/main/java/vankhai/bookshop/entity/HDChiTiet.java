package vankhai.bookshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="hdchitiet")
public class HDChiTiet implements Serializable{

	private int idDh;
	private int idSach;
	private float donGia;
	private int soLuong;
	private float thanhTien;
	
	
	
	public HDChiTiet() {
		super();
	}

	

	public HDChiTiet(int idDh, int idSach, float donGia, int soLuong, float thanhTien) {
		super();
		this.idDh = idDh;
		this.idSach = idSach;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}



	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idHoaDon")
	public int getIdDh() {
		return idDh;
	}

	public void setIdDh(int idDh) {
		this.idDh = idDh;
	}
	
	@Column(name="idSach")
	public int getIdSach() {
		return idSach;
	}

	public void setIdSach(int idSach) {
		this.idSach = idSach;
	}

	@Column(name="DonGia")
	public float getGia() {
		return donGia;
	}

	public void setGia(float donGia) {
		this.donGia = donGia;
	}

	
	@Column(name="SoLuong")
	public int getSoLuong() {
		return soLuong;
	}



	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	@Column(name="ThanhTien")
	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
}
