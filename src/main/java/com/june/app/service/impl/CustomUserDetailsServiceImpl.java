package com.june.app.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.UserInfo;
import com.june.app.repository.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		UserInfo userInfos = userRepository.getUserByLogin(userId);
		/*Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		List<UserRoleInfo> userRoleInfos = userInfos.getUserRoleInfos();
		for (UserRoleInfo userRoleInfo : userRoleInfos) {
			SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(userRoleInfo.getRoleInfo().getRole());
			authorities.add(userAuthority);
		}*/
		
		/**유저 권한 1:1 매핑으로 수정*/
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(userInfos.getRole());
		authorities.add(userAuthority);
	

		UserDetails user = new User(userInfos.getUser_id(), userInfos.getPassword(), true, true, true, true,
				authorities);
		return user;
	}
}