package com.june.app.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.UserInfo;
import com.june.app.repository.UserRepository;
import com.june.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<UserInfo> getUsers(UserInfo user) throws DataAccessException {
		return userRepository.getUsers(user);
	}

	@Override
	@Transactional(readOnly = true)
	public int getUsersCnt(UserInfo user) throws DataAccessException {
		return userRepository.getUsersCnt(user);
	}

	@Override
	@Transactional
	public void setUser(UserInfo user) throws DataAccessException {
		userRepository.setUser(user);
	}

	@Override
	@Transactional(readOnly = true)
	public UserInfo getUser(String userId) throws DataAccessException {
		return userRepository.getUser(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public Long selectUserId(String userId) throws DataAccessException {
		return userRepository.selectUserId(userId);
	}

	@Override
	@Transactional
	public UserInfo registerUser(UserInfo userInfo) throws DataAccessException {

		userInfo.setStatus("A");
		String userPass = userInfo.getPassword();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(userPass);
		userInfo.setPassword(hashedPassword);
		userInfo.setRole("ROLE_USER");
		UserInfo userInfoResult = userRepository.registerUser(userInfo);

		return userInfoResult;

	}
	
	@Override
	@Transactional(readOnly = true)
	public UserInfo getUserById(UserInfo user) throws DataAccessException {
		return userRepository.getUserById(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserInfo> getUsersAll(UserInfo user) throws DataAccessException {
		return userRepository.getUsersAll(user);
	}
}
