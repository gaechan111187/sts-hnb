package com.hnb.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hnb.member.MemberService;
import com.hnb.member.MemberServiceImpl;

@Service
public class AdminServiceImpl implements AdminService{
	private static AdminService instance = new AdminServiceImpl();
	private AdminServiceImpl() {}
	public static AdminService getInstance(){
		return instance;
	}
	AdminDAO dao = AdminDAOImpl.getInstance();
	@Override
	public List getMemberList() {
		List list = new ArrayList<>();
		return list;
	}
}
