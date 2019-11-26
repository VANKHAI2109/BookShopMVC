package vankhai.bookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vankhai.bookshop.dao.TheLoaiDao;
import vankhai.bookshop.entity.TheLoai;

@Repository
@Transactional
@Service
public class TheLoaiService {
	@Autowired
	private TheLoaiDao theLoaiDao;
	
	public List<TheLoai> getAll(){
		return theLoaiDao.getAll();
	}
	
	
}
