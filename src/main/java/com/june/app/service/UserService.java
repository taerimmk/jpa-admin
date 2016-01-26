package com.june.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.UserInfo;

public interface UserService {

	Collection<UserInfo> getUsers(UserInfo user) throws DataAccessException;

	int getUsersCnt(UserInfo user) throws DataAccessException;
	
	void setUser(UserInfo user) throws DataAccessException;

	UserInfo getUser(String userId) throws DataAccessException;

	Long selectUserId(String userId) throws DataAccessException;

	UserInfo registerUser(UserInfo userInfo) throws DataAccessException;
	
	UserInfo getUserById(UserInfo user) throws DataAccessException;
	
	List<UserInfo> getUsersAll(UserInfo user) throws DataAccessException;

}
