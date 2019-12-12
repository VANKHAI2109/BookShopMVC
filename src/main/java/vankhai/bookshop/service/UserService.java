package vankhai.bookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vankhai.bookshop.dao.UserDao;
import vankhai.bookshop.entity.User;

@Repository
@Transactional
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User getIdUser(int id) {
		return userDao.getIdUser(id);
	}
	
	public boolean checklogin(String username,String password) {
		boolean kq = userDao.checklogin(username,password);
		if(kq==true)
			return true;
		return false;
	}
	
	public boolean checktrunguser(String username) {
		boolean kq = userDao.checktrunguser(username);
		if(kq==true)
			return true;
		return false;
	}
	
	public void saverUser(User user) {
		userDao.saveUser(user);
	}
	
	public List<User> getAll(){
		return userDao.getAll();
	}
}
