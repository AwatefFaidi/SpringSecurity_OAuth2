package com.example.SpringBootSecurityOAuth2Example.serviceImpl;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringBootSecurityOAuth2Example.Entity.UserManagment;
import com.example.SpringBootSecurityOAuth2Example.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//UserInfo userInfo = userInfoDAO.getUserInfoByUserName(userName);
		UserManagment userInfo =  userRepository.findByUserName(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		System.out.println(new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority)));
		return new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
	}
}
