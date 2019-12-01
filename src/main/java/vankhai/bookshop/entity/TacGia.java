package vankhai.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tacgia")
public class TacGia {
	private int id;
	private String tenTacGia;
	
	
	public TacGia() {
		super();
	}


	public TacGia(int id, String tenTacGia) {
		super();
		this.id = id;
		this.tenTacGia = tenTacGia;
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


	@Column(name="TenTacGia")
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	
	
	
	
}
