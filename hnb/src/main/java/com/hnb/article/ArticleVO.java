package com.hnb.article;

import org.springframework.stereotype.Component;

@Component
public class ArticleVO {
	private int rcdNo; //글번호
	private int grpNo; //글 그룹 번호
	private String usrName; //작성자 이름
	private String usrMail; //작성자 이메일
	private String usrSubject; //글 제목
	private String usrContent; //글 내용
	private String usrPass; //글 비번
	private String usrFileName; //업로드 되는 파일 이름
	private int usrFileSize; //업로드 되는 파일 크기
	private String usrDate; //글 작성일
	private int usrRefer; //글 참조횟수
	private int rcdLevel; //글 레벨
	private int rcdOrder; //글 그룹에서의 글의 출력 순서
	public ArticleVO() {
	}
	public ArticleVO(int rcdNo, int grpNo, String usrNmae, String usrMail, String usrSubject,
					String usrContent, String usrPass, String usrFileName, int usrFileSize, 
					String usrDate, int usrRefer, int rcdLevel, int rcdOrder) {
		this.rcdNo = rcdNo;
		this.grpNo = grpNo;
		this.usrName = usrNmae;
		this.usrMail = usrMail;
		this.usrSubject = usrSubject;
		this.usrContent = usrContent;
		this.usrPass = usrPass;
		this.usrFileName = usrFileName;
		this.usrFileSize = usrFileSize;
		this.usrDate = usrDate;
		this.usrRefer = usrRefer;
		this.rcdLevel = rcdLevel;
		this.rcdOrder = rcdOrder;
	}
	public int getRcdNo() {
		return rcdNo;
	}
	public int getGrpNo() {
		return grpNo;
	}
	public String getUsrName() {
		return usrName;
	}
	public String getUsrMail() {
		return usrMail;
	}
	public String getUsrSubject() {
		return usrSubject;
	}
	public String getUsrContent() {
		return usrContent;
	}
	public String getUsrPass() {
		return usrPass;
	}
	public String getUsrFileName() {
		return usrFileName;
	}
	public int getUsrFileSize() {
		return usrFileSize;
	}
	public String getUsrDate() {
		return usrDate;
	}
	public int getUsrRefer() {
		return usrRefer;
	}
	public int getRcdLevel() {
		return rcdLevel;
	}
	public int getRcdOrder() {
		return rcdOrder;
	}
	public void setRcdNo(int rcdNo) {
		this.rcdNo = rcdNo;
	}
	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public void setUsrMail(String usrMail) {
		this.usrMail = usrMail;
	}
	public void setUsrSubject(String usrSubject) {
		this.usrSubject = usrSubject;
	}
	public void setUsrContent(String usrContent) {
		this.usrContent = usrContent;
	}
	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}
	public void setUsrFileName(String usrFileName) {
		this.usrFileName = usrFileName;
	}
	public void setUsrFileSize(int usrFileSize) {
		this.usrFileSize = usrFileSize;
	}
	public void setUsrDate(String usrDate) {
		this.usrDate = usrDate;
	}
	public void setUsrRefer(int usrRefer) {
		this.usrRefer = usrRefer;
	}
	public void setRcdLevel(int rcdLevel) {
		this.rcdLevel = rcdLevel;
	}
	public void setRcdOrder(int rcdOrder) {
		this.rcdOrder = rcdOrder;
	}
	
	
}
