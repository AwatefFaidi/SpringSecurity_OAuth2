package com.example.SpringBootSecurityOAuth2Example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.SpringBootSecurityOAuth2Example.Entity.UserManagment;
import com.example.SpringBootSecurityOAuth2Example.Service.UserService;

@SpringBootApplication
public class SpringBootSecurityOAuth2ExampleApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityOAuth2ExampleApplication.class, args);
	}
	@Bean
    CommandLineRunner start(UserService userService){
        return args->{
        	
        	
        	/*Integer obj1 = 1;
        	userService.addUser(new UserManagment (2,"med","1234","admin",obj1.shortValue()));*/
           
           
            
            
        };
    }
    

	

}
