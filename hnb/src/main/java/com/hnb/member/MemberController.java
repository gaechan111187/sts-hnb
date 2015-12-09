package com.hnb.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberVO member;
	@Autowired
	MemberServiceImpl service;
	@RequestMapping("/admin_home")
	public String adminHome(){
		logger.info("admin_home 진입");
		return "/member/admin_home";
	}
	@RequestMapping("/provision")
	public String provision(){
		logger.info("provision 진입");
		return "/member/provision";
	}
	
	@RequestMapping("/join_member")
	public String joinMember(Model model,
			String id, String password, String name,
			String birth, String addr, String gender,
			String email, String phone
			){
		model.addAttribute("id");
		model.addAttribute("password");
		model.addAttribute("name");
		model.addAttribute("birth");
		model.addAttribute("addr");
		model.addAttribute("gender");
		model.addAttribute("email");
		model.addAttribute("phone");
		logger.info("가입 id: "+id);
		logger.info("가입 패스워드: "+password);
		logger.info("가입 이름: "+name);
		logger.info("가입 생년: "+birth);
		logger.info("가입 주소: "+addr);
		logger.info("가입 성별: "+gender);
		logger.info("가입 이메일: "+email);
		logger.info("가입 전화번호: "+phone);
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setAddr(addr);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		
		int result =service.join(member);
		if (result == 1) {
			logger.info("회원가입 성공");
			model.addAttribute("result", "success");
			model.addAttribute("name", member.getName());
			logger.info("model");
		} else {
			logger.info("회원가입실패");
			model.addAttribute("result", "fail");
		}
		return "/member/join_member";
	}
	@RequestMapping("/join_Result")
	public String joinResult(){
		return "/member/join_Result";
	}
	@RequestMapping("/logout")
	public Model logout(Model model){
		logger.info("Member 로그아웃 진입");
		model.addAttribute("result", "success");
		return model;
	}
	@RequestMapping("/login")
	public @ResponseBody MemberVO login(String id, String password, Model model){
		logger.info("Member 로그인 진입");
		model.addAttribute("id");
		model.addAttribute("pw");
		logger.info("유저아이디 : {}", id);
		logger.info("유저비번 : {}", password);
		member = service.login(id, password);
		if (member==null) {
			model.addAttribute("result","fail");
		} else {
			model.addAttribute("result", "success");
			model.addAttribute("id", id);
			model.addAttribute("pw", password);
			if (id.equals("choa")) {
				model.addAttribute("admin", "yes");
			} else {
				model.addAttribute("admin", "no");
			}
		}
		
		return member;
	}
	@RequestMapping("/check_Overlap")
	public Model checkOverlap(Model model, String id){
		logger.info("컨트롤러/중복체크로 진입");
		model.addAttribute("id");
		if (service.selectById(id) == null) {
			model.addAttribute("result", "usable");
			model.addAttribute("id", id);
		} else {
			model.addAttribute("result", "usable");
			model.addAttribute("id", id);
		}
		return model;
	}
	@RequestMapping("/mypage")
	public String mypage(){
		logger.info("마이페이지 진입");
		return "/member/mypage";
	}
	@RequestMapping("/detail")
	public Model detail(Model model){
		logger.info("Detail 진입");
		return model;
	}
}
