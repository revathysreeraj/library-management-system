package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;
@Service
public class MemberService {
	
	@Autowired
	private MemberRepo repo;
	
	public void addMember(Member m)
	{
		repo.save(m);
	}

	public List<Member> getAllmember() {
		return repo.findAll();
	}
	
	
	
	

}
