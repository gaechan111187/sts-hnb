package com.hnb.theme;

import org.springframework.stereotype.Component;

@Component
public class ThemeVO {
	private int themeNO;
	private String themeName;
	public int getThemeNO() {
		return themeNO;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeNO(int themeNO) {
		this.themeNO = themeNO;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
}
