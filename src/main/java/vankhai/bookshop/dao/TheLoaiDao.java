package vankhai.bookshop.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vankhai.bookshop.entity.TheLoai;

@Repository(value = "TheLoaiDao")
@Transactional(rollbackFor = Exception.class)
public class TheLoaiDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<TheLoai> getAll(){
		Session session =this.sessionFactory.getCurrentSession();
		String sql="from " +TheLoai.class.getName();
		Query<TheLoai> query=session.createQuery(sql);
		return query.getResultList();
	}
	
	public TheLoai selectTacGia(int idTheLoai) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(TheLoai.class, idTheLoai);	
	
	}
}
