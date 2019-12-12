package vankhai.bookshop.controller;

import java.util.ArrayList;
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

import vankhai.bookshop.entity.Item;
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
	
	@RequestMapping("doimatkhau/{id}")
	public String DoiMatKhau(@RequestParam(value="id") int id,Model model) {
		userService.getIdUser(id);
		List<User> listUser=userService.getAll();
		model.addAttribute("user", listUser);
		return "doimatkhau";
	}
	
	@RequestMapping("AdminIndex")
	public String AdminIndex() {
		return "AdminIndex";
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
		List<User> listUser=userService.getAll();
		model.addAttribute("listuser", listUser);
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
	
	@PostMapping("xuLySua")
	public String xulySua(@RequestParam("tensach") String tenSach,
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
		sachService.suaSach(sach);
		return "redirect:productindex";
	}
	
	@RequestMapping(value= {"/delete"})
	public String xoaSach(@RequestParam(value="idSach") int id){
		sachService.xoaSach(id);
		return "redirect:/productindex";
	}
	
	@RequestMapping("update")
	public String update(@RequestParam("idSach") int id,Model model) {
		Sach sach=sachService.getId(id);

		TacGia tacGiaCuaSach;
		TheLoai theLoaiCuaSach;
		List<TacGia> allTacGia;
		List<TheLoai> allTheLoai;
		//này để hiển thị trong value option, còn hiển thị ở ngoài là cả bảng tacgia
		tacGiaCuaSach = tacGiaService.selectTacGia(sach.getTacGia().getId());
		theLoaiCuaSach = theLoaiService.selectTheLoai(sach.getTheLoai().getId());
		
		allTacGia = tacGiaService.getAll();
		allTheLoai=theLoaiService.getAll();
		model.addAttribute("allTacGia", allTacGia);
		model.addAttribute("allTheLoai", allTheLoai);
		model.addAttribute("theLoai", theLoaiCuaSach);
		model.addAttribute("tacGia", tacGiaCuaSach);
		model.addAttribute("list", sach);
		
		return "SuaSach";
	}
	
	@RequestMapping("giohang")
	public String giohang() {
		return "giohang";
	}
	//Xóa giỏ hàng
	@RequestMapping("deleteShopCart")
	public String deleteGioHang(Model model, HttpSession session) {
		session.removeAttribute("cart");
		return "giohang";
	}
	
	//Xóa giỏ hàng
	@RequestMapping("muaHang")
	public String TiepTucMuaHang(Model model, HttpSession session) {
		return "redirect:index";
	}
	
	//Xóa sách trong giỏ
	@RequestMapping("xoa")
	public String XoaSach(Model model, HttpSession session,
			@RequestParam(value = "idSach", defaultValue = "0") int idSach) {
		List<Item> cart = (java.util.List<Item>) session.getAttribute("cart");
		  
		  for(int i = 0; i<cart.size(); i++) 
		  {
			  if(cart.get(i).getSach().getIdSach() == idSach) 
			  {
				  cart.remove(i);
			  }
		  }
		  
		  session.setAttribute("cart", cart);
		return "giohang";
	}
	
	@RequestMapping(value= {"muahang"})
	public String cart(Model model, HttpSession session,
			@RequestParam(value = "idSach", defaultValue = "0") int idSach) {
		
		  //Nếu chưa có tạo mói
		  if(session.getAttribute("cart")==null) 
		  { 
			  List<Item> cart=new ArrayList<Item>(); 
			  cart.add(new Item(this.sachService.getId(idSach),1));
			  session.setAttribute("cart", cart); 
			  }
		  else 
		  {
			  List<Item> cart = (java.util.List<Item>) session.getAttribute("cart");
			  Sach sach= sachService.getId(idSach);
			  int Check =0;
			  for(int i = 0; i<cart.size(); i++) 
			  {
				  if(cart.get(i).getSach().getIdSach() == sach.getIdSach()) 
				  {
					  int SoLuong = cart.get(i).getQuantity() +1;
					  cart.get(i).setQuantity(SoLuong);
					  Check = 1;
				  }
			  }
			  
			  if(Check == 0) 
			  {
				  cart.add(new Item(sach,1));
			  }
			  session.setAttribute("cart", cart); 
		  }
		return "giohang";
	}

	

}
