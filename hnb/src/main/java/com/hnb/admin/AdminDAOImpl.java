package com.hnb.admin;

public class AdminDAOImpl implements AdminMapper{
	private static AdminMapper instance = new AdminDAOImpl();
	private AdminDAOImpl() {}
	public static AdminMapper getInstance(){
		return instance;
	}
}
