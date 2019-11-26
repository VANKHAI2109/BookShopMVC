package vankhai.bookshop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import vankhai.bookshop.dao.UserDao;
import vankhai.bookshop.entity.Sach;
import vankhai.bookshop.entity.TheLoai;
import vankhai.bookshop.entity.User;
import vankhai.bookshop.service.SachService;
import vankhai.bookshop.service.TheLoaiService;
import vankhai.bookshop.service.UserService;

@Controller
public class Home {

	@Autowired
	private UserService userService;

	@Autowired
	private TheLoaiService theLoaiService;
	
	@Autowired
	private SachService sachService;

	@Autowired
	private UserDao userDao;

	@RequestMapping("login")
	public String login(Model model) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		return "login";
	}

	@RequestMapping("productindex")
	public String productIndex(Model model) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		return "productindex";
	}

	@RequestMapping("AdminIndex")
	public String AdminIndex() {
		return "AdminIndex";
	}

	@RequestMapping("register")
	public String register(Model model) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		return "register";
	}

	@RequestMapping(value = { "saveUser" }, method = RequestMethod.POST)
	public String register(Model model, HttpServletRequest req) {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		String email = req.getParameter("email");
		User user = new User(username, pass, email);
		String pass2 = req.getParameter("password2");
		if (pass.equals(pass2) == false) {
			req.setAttribute("NOTE", "Mật khẩu không trùng khớp");
		} else {
			userService.saverUser(user);
			req.setAttribute("NOTE", "Đăng ký thành công");
		}

		return "register";
	}

	@RequestMapping(value = { "xuly" }, method = RequestMethod.POST)
	public String checklogin(HttpServletRequest req) {
		String username = req.getParameter("name");
		String pass = req.getParameter("pass");
		if (username.equals("gam") && pass.equals("123")) {
			return "AdminIndex";
		} else {
			boolean kq = userService.checklogin(username, pass);
			if (kq == true) {
				req.setAttribute("TenNguoiDung", username);
				return "index";
			} else {
				req.setAttribute("Note", "Vui lòng kiểm tra lại thông tin");
			}
		}

		return "login";
	}
	
	

	@RequestMapping(value = { "/", "index" })
	public String List(Model model) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		
		List<Sach> listSach = sachService.getAll();
		model.addAttribute("list", listSach);
		return "index";
	}
	
	

}
