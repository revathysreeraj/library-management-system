package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String home(Model mem)
	{
		
		
		List<Member> m=service.getAllmember();
		mem.addAttribute("member");
		return "index";
	}
	
	
	
	@GetMapping("/addmember")
	public String addmemberForm()
	{
		
		return "add_member";
	}
	
	@PostMapping("/register")
	public String membRegister(@ModelAttribute Member m,HttpSession session) {
		
		System.out.println(m);
		service.addMember(m);
		session.setAttribute("msg", "New Member Added Successfully");
		return "redirect:/";
	}
	
	
	@GetMapping("/login")
		
	  public String login()
	{ 
//		Member member=new Member();
//		model.addAttribute("member",member);
	  
		return "login"; 
	}
	 
	
	
	
//	@PostMapping("/memberLogin")
//	public String memberlogin(@ModelAttribute("member") Member  member)
//	{
//		System.out.println(member);
//		System.out.println(member.getId());
//		System.out.println(member.getPassword());
//		
//		return "home";
//	}
	

}
