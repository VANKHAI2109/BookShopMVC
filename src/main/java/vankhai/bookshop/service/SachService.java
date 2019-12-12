package vankhai.bookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vankhai.bookshop.dao.SachDao;
import vankhai.bookshop.entity.Sach;

@Repository
@Transactional
@Service
public class SachService {
	
	@Autowired
	private SachDao sachDao;
	public String processFile(MultipartFile file) {
		return sachDao.processFile(file);
	}
	
	public void themSach( Sach ds) {
		sachDao.themSach(ds);
	}
	
	public void suaSach(Sach sach) {
		sachDao.suaSach(sach);
	}
	public boolean xoaSach( int idSach) {		
		return sachDao.xoaSach(idSach);
	}

	/*
	 * public boolean suaSach( Sach sach) { return sachDao.suaSach(sach); }
	 */
	public List<Sach> getAll(){
		return sachDao.getAll();
	}
	public Sach getId(int idSach) {
		return sachDao.getId(idSach);
	}
	public List<Sach> getSach(int idSach){
		return sachDao.getSach(idSach);
	}

	
}
