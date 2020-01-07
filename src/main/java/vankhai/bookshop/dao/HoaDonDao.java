package vankhai.bookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vankhai.bookshop.entity.HoaDon;
import vankhai.bookshop.entity.Sach;

@Repository(value = "HoaDonDao")
@Transactional(rollbackFor = Exception.class)
public class HoaDonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void LuuHoaDon( HoaDon hoadon) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(hoadon);
	}
}
