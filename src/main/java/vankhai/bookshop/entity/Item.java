package vankhai.bookshop.entity;

public class Item {
	private Sach sach=new Sach();
	private int quantity;
	public Item(Sach sach, int quantity) {
		super();
		this.sach = sach;
		this.quantity = quantity;
	}
	//nghĩa. để tui sửa cái id
	//rooif ă. ông chạy lại thử
	public Item() {
		super();
	}
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
