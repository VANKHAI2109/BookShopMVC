package vankhai.bookshop.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import vankhai.bookshop.entity.Sach;
import vankhai.bookshop.entity.TacGia;
import vankhai.bookshop.entity.TheLoai;

@Repository(value = "SachDao")
@Transactional(rollbackFor = Exception.class)
public class SachDao {

	@Autowired
	SessionFactory sessionFactory;
	public String processFile(MultipartFile file) {
		String UPLOADED_FOLDER = "E:/BookShopMVC1/src/main/webapp/img/";
		try {
			byte[] bytes = file.getBytes();
			Path path = (Path) Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getOriginalFilename();

	}
	
	public Sach getId(int idSach) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(Sach.class, idSach);
	}
	
	public List<Sach> getSach(int idSach){
		Session session = this.sessionFactory.getCurrentSession();
		String sql=("from" + Sach.class.getName()+idSach);
		Query<Sach> query=session.createQuery(sql);
		return query.getResultList();
		
	}
	public void themSach( Sach sach) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(sach);		
	}
	public void suaSach(Sach sach) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(sach);
	}

	public boolean xoaSach( int idSach) {
		Session session=this.sessionFactory.getCurrentSession();
		Sach sach=session.get(Sach.class, idSach);
		session.delete(sach);
		return true;
		
	}
	
	
	public List<Sach> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from " + Sach.class.getName();
		Query<Sach> query = session.createQuery(sql);
		return query.getResultList();
	}

	public List<Sach> getSachTL(int idtheLoai) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from " + Sach.class.getName() + " s where s.theLoai.id = " +idtheLoai ;
		Query<Sach> query = session.createQuery(sql);
		return query.getResultList();
	}
	
	public List<Sach> timkiem(String tenSach) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from " + Sach.class.getName() + " s where s.tenSach like '%"+tenSach+"%'";
		Query<Sach> query = session.createQuery(sql);
		return query.getResultList();
	}
}
