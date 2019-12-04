package vankhai.bookshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import vankhai.bookshop.entity.Sach;
import vankhai.bookshop.entity.TacGia;
import vankhai.bookshop.entity.TheLoai;
import vankhai.bookshop.entity.User;
import vankhai.bookshop.service.SachService;
import vankhai.bookshop.service.TacGiaService;
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
	private TacGiaService tacGiaService;

	@RequestMapping("login")
	public String login(Model model,HttpServletRequest req) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		HttpSession session=req.getSession();
		session.removeAttribute("user");
		return "login";
	}

	@RequestMapping("productindex")
	public String productIndex(Model model) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		List<TacGia> listTacGia=tacGiaService.getAll();
		model.addAttribute("list2", listTacGia);
		
		List<Sach> listSach=sachService.getAll();
		model.addAttribute("listsach", listSach);
		
		return "productindex";
	}
	@RequestMapping("diachi")
	public String diaChi() {
		return "diachi";
	}
	
	@RequestMapping("doimatkhau")
	public String DoiMatKhau() {
		return "doimatkhau";
	}
	
	@RequestMapping("AdminIndex")
	public String AdminIndex() {
		return "AdminIndex";
	}
	
	@RequestMapping("giohang")
	public String cart() {
		return "giohang";
	}

	@RequestMapping("thongtinuser")
	public String thongTinUser() {
		return "thongtinuser";
	}
	
	@RequestMapping("register")
	public String register(Model model) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		return "register";
	}

	@PostMapping("saveUser")
	public String register(Model model, HttpServletRequest req) {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		String email = req.getParameter("email");
		User user = new User(username, pass, email);
		String pass2 = req.getParameter("password2");
		if(userService.checktrunguser(username)==true) {
			req.setAttribute("NOTE", "Trùng user");
		}
		else if (pass.equals(pass2) == false) {
			req.setAttribute("NOTE", "Mật khẩu không trùng khớp");
		}
		else {		
			userService.saverUser(user);
			req.setAttribute("NOTE", "Đăng ký thành công");
		}

		return "register";
	}

	@PostMapping("xuly")
	public String checklogin(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String username = req.getParameter("name");
		String pass = req.getParameter("pass");
		if (username.equals("gam") && pass.equals("123")) {
			return "redirect:AdminIndex";
		} else {
			boolean kq = userService.checklogin(username, pass);
			if (kq == true) {
				session.setAttribute("user", username);
				return "redirect:index";
			} else {
				req.setAttribute("Note", "Vui lòng kiểm tra lại thông tin");
			}
		}
		return "login";
	}
	
	
	@RequestMapping(value = { "/", "index" })
	public String List(Model model) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list2", listTheLoai);
		List<Sach> listSach = sachService.getAll();
		model.addAttribute("list", listSach);
		return "index";
	}
	
	@PostMapping("xuLyThemSach")
	public String xyLyAnh(@RequestParam("tensach") String tenSach,
			@RequestParam("idtacgia") int idTacGia,
			@RequestParam("idtheloai") int idTheLoai,
			@RequestParam("image") MultipartFile file,
			@RequestParam("ghichu") String ghiChu,
			@RequestParam("dongia") Float donGia,
			HttpServletRequest req) {
		
		Sach sach=new Sach();
		sach.setTenSach(tenSach);
		sach.setTacGia(tacGiaService.selectTacGia(idTacGia));
		sach.setTheLoai(theLoaiService.selectTheLoai(idTheLoai));
		sach.setHinhAnh(sachService.processFile(file));
		sach.setGhiChu(ghiChu);
		sach.setDonGia(donGia);
		sachService.themSach(sach);
		return "redirect:productindex";
	}
	
	@RequestMapping(value= {"/delete"})
	public String xoaSach(@RequestParam(value="idSach") int id){
		sachService.xoaSach(id);
		return "redirect:/productindex";
	}

}
