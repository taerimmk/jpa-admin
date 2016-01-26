package com.june.app.model;

public class Login {

	boolean isLogin = false;

	UserInfo userInfo;

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Login [isLogin=" + isLogin + ", userInfo=" + userInfo + "]";
	}

}
