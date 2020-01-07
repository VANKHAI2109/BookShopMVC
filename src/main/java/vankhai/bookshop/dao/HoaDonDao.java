package vankhai.bookshop.dao;

<<<<<<< HEAD
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
=======
import org.hibernate.Session;
import org.hibernate.SessionFactory;
>>>>>>> bf51659f05b5fdf1a34fa58a4db86b13fac09abc
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import vankhai.bookshop.entity.HDChiTiet;
import vankhai.bookshop.entity.HoaDon;
=======
import vankhai.bookshop.entity.HoaDon;
import vankhai.bookshop.entity.Sach;
>>>>>>> bf51659f05b5fdf1a34fa58a4db86b13fac09abc

@Repository(value = "HoaDonDao")
@Transactional(rollbackFor = Exception.class)
public class HoaDonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void LuuHoaDon( HoaDon hoadon) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(hoadon);
	}
<<<<<<< HEAD
	
	public List<HoaDon> thongtinHD(String tenuser) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from " + HoaDon.class.getName() +" where name like '"+tenuser+"'";
		Query<HoaDon> query = session.createQuery(sql);
		return query.getResultList();
	}
=======
>>>>>>> bf51659f05b5fdf1a34fa58a4db86b13fac09abc
}
