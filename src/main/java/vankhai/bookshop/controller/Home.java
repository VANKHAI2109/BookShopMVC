
package vankhai.bookshop.controller;

import java.util.Date;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vankhai.bookshop.entity.HDChiTiet;
import vankhai.bookshop.entity.HoaDon;
import vankhai.bookshop.entity.Item;
import vankhai.bookshop.entity.Sach;
import vankhai.bookshop.entity.TacGia;
import vankhai.bookshop.entity.TheLoai;
import vankhai.bookshop.entity.User;
import vankhai.bookshop.service.HDCTService;
import vankhai.bookshop.service.HoaDonService;
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
	
	@Autowired 
	private HoaDonService hoaDonService;
	
	@Autowired
	private HDCTService hdChitietService;

	// Trang login
	@RequestMapping("login")
	public String login(Model model,HttpServletRequest req,  @RequestParam(value = "idTL", defaultValue = "0") int idTL) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list2", listTheLoai);
		List<Sach> listSach = sachService.getAll();
		model.addAttribute("list", listSach);
		
		
		List<Sach> listSachTL = sachService.getSachTL(idTL);
		model.addAttribute("listTL", listSachTL);
		List<User> listUser=userService.getAll();
		model.addAttribute("listuser", listUser);
		
		HttpSession session=req.getSession();
		session.removeAttribute("user");
		session.removeAttribute("erro");
		return "login";
	}

	//Trang quáº£n lÃ½ sáº£n pháº©m
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
	
	//Trang Ä‘Äƒng kÃ½
	@RequestMapping("register")
	public String register(Model model, HttpSession session) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list", listTheLoai);
		List<User> listUser=userService.getAll();
		model.addAttribute("listuser", listUser);
		session.removeAttribute("erro");
		return "register";
	}
	
	// HÃ m xá»­ lÃ½ thÃªm user
	@PostMapping("saveUser")
	public String register(Model model, HttpServletRequest req, HttpSession sesion) {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		String email = req.getParameter("email");
		User user = new User(username, pass, email);
		String pass2 = req.getParameter("password2");
		if(userService.checktrunguser(username)==true) {
			sesion.setAttribute("erro", "TrÃ¹ng user");
		
		}
		else if (pass.equals(pass2) == false) {
			sesion.setAttribute("erro", "Mật khẩu không trung khớp");
			
		}
		else {		
			userService.saverUser(user);
			sesion.setAttribute("erro", "Đăng ký thành công!");
			
		}

		return "register";
	}

	//kiá»ƒm tra trÃ¹ng user
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
				session.setAttribute("erro", "Vui lòng kiểm tra lại thông tin!");
				
			}
		}
		return "login";
	}
	
	
	//Trang index
	@RequestMapping(value = { "/", "index" })
	public String List(Model model, @RequestParam(value = "idTL", defaultValue = "0") int idTL) {
		List<TheLoai> listTheLoai = theLoaiService.getAll();
		model.addAttribute("list2", listTheLoai);
		List<Sach> listSach = sachService.getAll();
		model.addAttribute("list", listSach);
		
		List<Sach> listSachTL = sachService.getSachTL(idTL);
		model.addAttribute("listTL", listSachTL); 
		List<User> listUser=userService.getAll();
		model.addAttribute("listuser", listUser);
		return "index";
	}
	
	//Xá»­ lÃ½ thÃªm sÃ¡ch
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
	
	//Xá»­ lÃ½ sá»­a sÃ¡ch
	@PostMapping("xuLySua")
	public String xulySua(Model model,//@RequestParam("tensach") String tenSach,
			//@RequestParam("idtacgia") int idTacGia,
			//@RequestParam("idtheloai") int idTheLoai,
			//@RequestParam("image") MultipartFile file,
			//@RequestParam("ghichu") String ghiChu,
			//@RequestParam("dongia") Float donGia,
			HttpServletRequest req) {
		
		String tenSach = req.getParameter("tenSach");
		int idTacGia = Integer.parseInt(req.getParameter("idtacgia"));
		int idTheLoai = Integer.parseInt(req.getParameter("idtheloai"));
		String ghiChu = req.getParameter("ghichu");
		float donGia = Float.parseFloat(req.getParameter("dongia"));
		
		Sach sach=new Sach();
		sach.setTenSach(tenSach);
		sach.setTacGia(tacGiaService.selectTacGia(idTacGia));
		sach.setTheLoai(theLoaiService.selectTheLoai(idTheLoai));
		//sach.setHinhAnh(sachService.processFile(file));
		sach.setGhiChu(ghiChu);
		sach.setDonGia(donGia);
		sachService.suaSach(sach);
		return "redirect:/productindex";
	}
	
	//Xá»­ lÃ½ xÃ³a sÃ¡ch
	@RequestMapping(value= {"/delete"})
	public String xoaSach(@RequestParam(value="idSach") int id){
		sachService.xoaSach(id);
		return "redirect:/productindex";
	}
	
	//Xá»­ lÃ½ sá»­a sÃ¡ch
	@RequestMapping("update")
	public String update(@RequestParam("idSach") int id,Model model) {
		Sach sach=sachService.getId(id);

		TacGia tacGiaCuaSach;
		TheLoai theLoaiCuaSach;
		List<TacGia> allTacGia;
		List<TheLoai> allTheLoai;
		//nÃƒÂ y Ã„â€˜Ã¡Â»Æ’ hiÃ¡Â»Æ’n thÃ¡Â»â€¹ trong value option, cÃƒÂ²n hiÃ¡Â»Æ’n thÃ¡Â»â€¹ Ã¡Â»Å¸ ngoÃƒÂ i lÃƒÂ  cÃ¡ÂºÂ£ bÃ¡ÂºÂ£ng tacgia
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
	
	/*
	 * @RequestMapping("test") public String test(Model model,@RequestParam(value =
	 * "idTL", defaultValue = "0") int idTL) { List<Sach> listSachTL =
	 * sachService.getSachTL(idTL); model.addAttribute("list", listSachTL);
	 * 
	 * return "test"; }
	 */
	//XÃƒÂ³a giÃ¡Â»ï¿½ hÃƒÂ ng
	@RequestMapping("deleteShopCart")
	public String deleteGioHang(Model model, HttpSession session) {
		session.removeAttribute("cart");
		return "giohang";
	}
	
	@RequestMapping("muaHang")
	public String TiepTucMuaHang(Model model, HttpSession session) {
		return "redirect:index";
	}
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
	//Update giÃ¡Â»ï¿½ hÃƒÂ ng
	@RequestMapping("updateShopcart")
	public String updateQuantiy(Model model,HttpServletRequest req, HttpSession session) {
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		String []quantity=req.getParameterValues("quantity");
		for(int i = 0; i<cart.size(); i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantity[i]));
		}
		session.setAttribute("cart", cart);
		return "giohang";
	}
	
	//Xá»­ lÃ½ thÃªm vÃ o giá»� hÃ ng
	@RequestMapping(value= {"muahang"})
	public String cart(Model model, HttpSession session,
			@RequestParam(value = "idSach", defaultValue = "0") int idSach) {
		
		  //NÃ¡ÂºÂ¿u chÃ†Â°a cÃƒÂ³ tÃ¡ÂºÂ¡o mÃƒÂ³i
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

	//Xem chi tiáº¿t sÃ¡ch
	@RequestMapping("xemchitiet")
	public String xemchitiet(Model model, HttpSession session,
			@RequestParam(value = "idSach", defaultValue = "0") int idSach) {
		
		Sach sach=sachService.getId(idSach);
		
		TacGia tacGiaCuaSach;
		TheLoai theLoaiCuaSach;
		List<TacGia> allTacGia;
		List<TheLoai> allTheLoai;

		tacGiaCuaSach = tacGiaService.selectTacGia(sach.getTacGia().getId());
		theLoaiCuaSach = theLoaiService.selectTheLoai(sach.getTheLoai().getId());
	
		model.addAttribute("theloai", theLoaiCuaSach);
		model.addAttribute("tacGia", tacGiaCuaSach);
		
		List<Sach> listSach = sachService.getAll();
		model.addAttribute("list", listSach);
		model.addAttribute("xemchitiet",sach);
		return "xemchitiet";
	}
	
	//Trang thanh toÃ¡n
	@RequestMapping("thanhtoan")
	public String thanhtoan(HttpSession session) {	
		
		if(session.getAttribute("user")==null) {
			return "redirect:login";
		}
		else {
			
			return "thanhtoan";
		}		
	}
	
	@RequestMapping("AdminIndex")
	public String admin(HttpSession session) {	
			
			return "AdminIndex";	
	}

	@RequestMapping("xlthanhtoan")
	public String XLThanhToan(HttpSession session,HttpServletRequest req,Model model) {
		
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		String tenKhachHang=req.getParameter("name");
		String diaChi=req.getParameter("address");
		int sdt=Integer.parseInt(req.getParameter("sdt"));
		String name=(String) session.getAttribute("user");
		
		HoaDon hoadon=new HoaDon();
		hoadon.setNgayDatHang(new Date());
		hoadon.setTenKhachHang(tenKhachHang);
		hoadon.setDiaChi(diaChi);
		hoadon.setSdt(sdt);
		hoadon.setName(name);
		
		hoaDonService.LuuHoaDon(hoadon);
		
		for(int i = 0; i<cart.size(); i++) {
			HDChiTiet hdChiTiet= new HDChiTiet();
			
			hdChiTiet.setIdDh(hoadon.getId());
			hdChiTiet.setIdSach(cart.get(i).getSach().getIdSach());
			hdChiTiet.setGia(cart.get(i).getSach().getDonGia());
			hdChiTiet.setSoLuong(cart.get(i).getQuantity());
			hdChiTiet.setThanhTien(cart.get(i).getQuantity()*cart.get(i).getSach().getDonGia());
			hdChitietService.luuHDCT(hdChiTiet);
		}
		session.removeAttribute("cart");

		model.addAttribute("kq", "Đặt hàng thành công! Vui lòng đợi thông tin từ Shop ^^");
		return "giohang";
	}
	

	

	@RequestMapping("timkiem")
	public String timkiem(Model model, HttpServletRequest req) {
		String tenSach=req.getParameter("key");
		List<Sach> kq=sachService.timkiem(tenSach);
		if(kq.size()>=1) {
			model.addAttribute("kq", kq);
		}
		else{
			model.addAttribute("Null", "Không tìm thấy sản phầm nào phù hợp?");
			return "KetQuaTimKiem";	
		}
		
		return "KetQuaTimKiem";	
	}


	@RequestMapping("diachi")
	public String diaChi() {
		return "diachi";
	}
	
	@RequestMapping("dangxuat")
	public String DangXuat(HttpSession session) {
		session.removeAttribute("cart");
		session.removeAttribute("user");
		return "login";
	}
	


	

}
