package com.example.SpringBootSecurityOAuth2Example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringBootSecurityOAuth2Example.Entity.UserManagment;
import com.example.SpringBootSecurityOAuth2Example.Repository.UserRepository;
import com.example.SpringBootSecurityOAuth2Example.Service.UserService;
@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UserRepository userDatailsRepository;

	public UserManagment getUserManagmentByUserName(String userName) {
		short enabled = 1;
		return userDatailsRepository.findByUserNameAndEnabled(userName, enabled);
	}

	public List<UserManagment> getAllActiveUserManagment() {
		return userDatailsRepository.findAllByEnabled((short) 1);
	}

	public UserManagment getUserManagmentById(Integer id) {
		return userDatailsRepository.findById(id);
	}

	public UserManagment addUser(UserManagment UserManagment) {
		UserManagment.setPassword(new BCryptPasswordEncoder().encode(UserManagment.getPassword()));
		return userDatailsRepository.save(UserManagment);
	}

	public UserManagment updateUser(Integer id, UserManagment userRecord) {
		UserManagment UserManagment = userDatailsRepository.findById(id);
		UserManagment.setUserName(userRecord.getUserName());
		UserManagment.setPassword(userRecord.getPassword());
		UserManagment.setRole(userRecord.getRole());
		UserManagment.setEnabled(userRecord.getEnabled());
		return userDatailsRepository.save(UserManagment);
	}

	public void deleteUser(Integer id) {
		userDatailsRepository.deleteById(id);
	}

	public UserManagment updatePassword(Integer id, UserManagment userRecord) {
		UserManagment UserManagment = userDatailsRepository.findById(id);
		UserManagment.setPassword(userRecord.getPassword());
		return userDatailsRepository.save(UserManagment);
	}

	public UserManagment updateRole(Integer id, UserManagment userRecord) {
		UserManagment UserManagment = userDatailsRepository.findById(id);
		UserManagment.setRole(userRecord.getRole());
		return userDatailsRepository.save(UserManagment);
	}

	@Override
	public UserManagment getUserInfoByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserManagment> getAllActiveUserInfo() {
		return userDatailsRepository.findAllByEnabled((short) 1);
	}

	@Override
	public UserManagment getUserInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}
