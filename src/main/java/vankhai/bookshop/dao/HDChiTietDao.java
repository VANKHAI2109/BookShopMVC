package vankhai.bookshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vankhai.bookshop.entity.HDChiTiet;

@Repository(value = "HDChiTietDao")
public class HDChiTietDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void luuHDCT(HDChiTiet hdChiTiet) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(hdChiTiet);
	}
}
