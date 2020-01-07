package vankhai.bookshop.service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> bf51659f05b5fdf1a34fa58a4db86b13fac09abc
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vankhai.bookshop.dao.HoaDonDao;
import vankhai.bookshop.entity.HoaDon;
<<<<<<< HEAD
import vankhai.bookshop.entity.Sach;
=======
>>>>>>> bf51659f05b5fdf1a34fa58a4db86b13fac09abc

@Repository
@Transactional
@Service
public class HoaDonService {

	@Autowired
	private HoaDonDao hoaDonDao;
	public void LuuHoaDon( HoaDon hoadon) {
		 hoaDonDao.LuuHoaDon(hoadon);
	}
<<<<<<< HEAD
	
	public List<HoaDon> thongtinHD(String tenuser){
		return hoaDonDao.thongtinHD(tenuser);
	}
=======
>>>>>>> bf51659f05b5fdf1a34fa58a4db86b13fac09abc
}
