package vankhai.bookshop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hoadon")
public class HoaDon implements Serializable{

	private int id;
	private String name;
	private Date ngayDatHang;
	private String tenKhachHang;
	private String diaChi;
	public HoaDon() {
		super();
	}
	public HoaDon(int id, String name, Date ngayDatHang, String tenKhachHang, String diaChi) {
		super();
		this.id = id;
		this.name = name;
		this.ngayDatHang = ngayDatHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
	}
	public HoaDon(String name, Date ngayDatHang, String tenKhachHang, String diaChi) {
		super();
		this.name = name;
		this.ngayDatHang = ngayDatHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="ngaydat")
	public Date getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	
	@Column(name="tenkhachhang")
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	
	@Column(name="diachi")
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
	
}
