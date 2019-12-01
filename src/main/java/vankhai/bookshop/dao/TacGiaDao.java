package vankhai.bookshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vankhai.bookshop.entity.TacGia;

/**
 * @author OS
 *
 */
/**
 * @param idTacGia
 * @return
 */
@Repository(value = "TacGiaDao")
@Transactional(rollbackFor = Exception.class)
public class TacGiaDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<TacGia> getAll(){
		Session session =this.sessionFactory.getCurrentSession();
		String sql="from " +TacGia.class.getName();
		Query<TacGia> query=session.createQuery(sql);
		return query.getResultList();
	}
	
	public TacGia selectTacGia(int idTacGia) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(TacGia.class, idTacGia);	
	
	}
	
}
