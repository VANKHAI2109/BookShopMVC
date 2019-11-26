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
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vankhai.bookshop.entity.Sach;
import vankhai.bookshop.entity.TheLoai;

@Repository(value = "SachDao")
@Transactional(rollbackFor = Exception.class)
public class SachDao {
	
	@Autowired
	SessionFactory sessionFactory;
		   //Save the uploaded file to this folder
		   // return new root file
		    public String processFile(MultipartFile file){
		    	String UPLOADED_FOLDER = "D:/JavaWeb/BookShopMVC/src/main/webapp/image/";
		        try {

		            // Get the file and save it somewhere
		            byte[] bytes = file.getBytes();
		            Path path = (Path) Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		            Files.write(path, bytes);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return "/BookShopMVC/src/main/webapp/image/"+file.getOriginalFilename();

		    }
		    public List<Sach> getAll(){
				Session session =this.sessionFactory.getCurrentSession();
				String sql="from " +Sach.class.getName();
				Query<Sach> query=session.createQuery(sql);
				return query.getResultList();
			}

}
