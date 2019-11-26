package vankhai.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="theloai")
public class TheLoai {
	private int id;
	private String theLoai;
	public TheLoai(int id, String theLoai) {
		super();
		this.id = id;
		this.theLoai = theLoai;
	}
	
	public TheLoai(String theLoai) {
		super();
		this.theLoai = theLoai;
	}
	
	public TheLoai() {
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
	
	@Column(name="TenTheLoai")
	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	
	
}
