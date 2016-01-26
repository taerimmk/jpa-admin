package com.june.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.UserInfo;
import com.june.app.model.UserRoleInfo;

public interface UserRepository {

	Collection<UserInfo> getUsers(UserInfo user) throws DataAccessException;

	int getUsersCnt(UserInfo user) throws DataAccessException;

	void setUser(UserInfo user) throws DataAccessException;

	UserInfo getUser(String username) throws DataAccessException;

	UserInfo getUserByLogin(String username) throws DataAccessException;

	Long selectUserId(String userId) throws DataAccessException;

	UserInfo registerUser(UserInfo userInfo) throws DataAccessException;

	UserRoleInfo registerRole(UserRoleInfo vo) throws DataAccessException;

	UserInfo getUserById(UserInfo user) throws DataAccessException;
	
	List<UserInfo> getUsersAll(UserInfo user) throws DataAccessException;

}
