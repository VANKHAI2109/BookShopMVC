package vankhai.bookshop.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vankhai.bookshop.entity.User;

@Repository(value = "UserDao")
@Transactional(rollbackFor = Exception.class)
public class UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public User timTaiKhoan(String id){
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}
	
	public boolean checklogin(String username, String password ) {
		
		Session session = this.sessionFactory.getCurrentSession();//
		String sql = "FROM "+User.class.getName()+" e where e.name like '"+username+"' and e.password like '"+password+"'";
		Query<?> query = session.createQuery(sql);
		if(query.list().size() >= 1)
			return true;
		return false;
		
	}
	public boolean checktrunguser(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "from "+User.class.getName()+" e where e.name like '"+username+"'";
		Query<?> query = session.createQuery(sql);
		if(query.list().size() >= 1)
			return true;
		return false;
	}
	public void saveUser(User user) {
		User save=new User();
		save.setName(user.getName());
		save.setPassword(user.getPassword());
		save.setEmail(user.getEmail());
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(save);
		
		
	}
}
