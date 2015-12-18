package com.hnb.global;

public class Command implements Orderable{
	private String column, keyword; 
	private int pageNo, start, end, themeNo;
	public final int PAGESIZE = 5;
	public Command(String pageNo) {
		this.pageNo = Integer.parseInt(pageNo);
		this.start = (Integer.parseInt(pageNo)-1)*PAGESIZE+1;
		this.end = (Integer.parseInt(pageNo)*PAGESIZE);
	}
	public Command(String pageNo, String themeNo) {
		this.pageNo = Integer.parseInt(pageNo);
		this.start = (Integer.parseInt(pageNo)-1)*PAGESIZE+1;
		this.end = (Integer.parseInt(pageNo)*PAGESIZE);
		this.themeNo = (Integer.parseInt(themeNo));
	}
	public Command(String column, String keyword, String pageNo) {
		this.column = column;
		this.keyword = keyword;
		this.pageNo = Integer.parseInt(pageNo);
		this.start = (Integer.parseInt(pageNo)-1)*PAGESIZE+1;
		this.end = (Integer.parseInt(pageNo)*PAGESIZE);
	}
	public int getPageNo() {
		return pageNo;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public String getColumn() {
		return column;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getThemeNo() {
		return themeNo;
	}
	public void setThemeNo(int themeNo) {
		this.themeNo = themeNo;
	}
	@Override
	public void excute() {
		
	}
}
