package vankhai.bookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vankhai.bookshop.dao.TacGiaDao;
import vankhai.bookshop.entity.TacGia;

@Repository
@Transactional
@Service
public class TacGiaService {

	@Autowired
	private TacGiaDao tacGiaDao;
	
	public List<TacGia> getAll(){
		return tacGiaDao.getAll();
	}
	
	public TacGia selectTacGia(int idTacGia) {
		return tacGiaDao.selectTacGia(idTacGia);
	}
	
}
