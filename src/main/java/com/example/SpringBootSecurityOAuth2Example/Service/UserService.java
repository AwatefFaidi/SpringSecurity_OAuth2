package com.example.SpringBootSecurityOAuth2Example.Service;

import java.util.List;

import com.example.SpringBootSecurityOAuth2Example.Entity.UserManagment;

public interface UserService {

	public UserManagment getUserInfoByUserName(String userName) ;
		
	public List<UserManagment> getAllActiveUserInfo() ;
	
	public UserManagment getUserInfoById(Integer id) ;

	public UserManagment addUser(UserManagment userInfo) ;

	public UserManagment updateUser(Integer id, UserManagment userRecord) ;

	public void deleteUser(Integer id);

	public UserManagment updatePassword(Integer id, UserManagment userRecord) ;

	public UserManagment updateRole(Integer id, UserManagment userRecord) ;
}
