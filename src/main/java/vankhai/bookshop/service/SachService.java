package vankhai.bookshop.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vankhai.bookshop.dao.SachDao;
import vankhai.bookshop.dao.UserDao;
import vankhai.bookshop.entity.Sach;
import vankhai.bookshop.entity.TheLoai;

@Repository
@Transactional
@Service
public class SachService {
	
	@Autowired
	private SachDao sachDao;
	
	public List<Sach> getAll(){
		return sachDao.getAll();
	}

	
}
