package vankhai.bookshop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vankhai.bookshop.dao.HoaDonDao;
import vankhai.bookshop.entity.HoaDon;

@Repository
@Transactional
@Service
public class HoaDonService {

	@Autowired
	private HoaDonDao hoaDonDao;
	public void LuuHoaDon( HoaDon hoadon) {
		 hoaDonDao.LuuHoaDon(hoadon);
	}
}
