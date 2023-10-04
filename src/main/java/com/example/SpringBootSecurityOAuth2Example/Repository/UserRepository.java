package com.example.SpringBootSecurityOAuth2Example.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.SpringBootSecurityOAuth2Example.Entity.UserManagment;



@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserManagment, String> {
	
	public UserManagment findByUserNameAndEnabled(String userName, short enabled);
	
	public UserManagment findByUserName(String userName);

	public List<UserManagment> findAllByEnabled(short enabled);

	public UserManagment findById(Integer id);


	public void deleteById(Integer id);
}