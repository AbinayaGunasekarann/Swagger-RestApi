package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User saveUser(User u)
	{
		return userRepo.save(u);
	}
	public String validateUser(String username,String password)
	{
		String result="";
		User u=userRepo.findByUsername(username);
		if(u==null)
		{
			result="Invalid user";
		}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
		return result;
	}
	

}
