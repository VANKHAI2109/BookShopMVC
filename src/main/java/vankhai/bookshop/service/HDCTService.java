package vankhai.bookshop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vankhai.bookshop.dao.HDChiTietDao;
import vankhai.bookshop.entity.HDChiTiet;

@Repository
@Transactional
@Service
public class HDCTService {
	@Autowired
	private HDChiTietDao hdChiTietDao;
	public void luuHDCT(HDChiTiet hdChiTiet) {
		hdChiTietDao.luuHDCT(hdChiTiet);
	}
}
