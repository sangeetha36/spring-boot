package com.lti.training.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.DTO.StatusDTO;
import com.lti.training.DTO.UserDTO;
import com.lti.training.dao.RegisterDao;
import com.lti.training.entity.*;

//@Component
@Service  //the class which contain the bussiness logic and provide service then annotate it as @service
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;
	
	@Transactional
	public StatusDTO register(UserDTO userDTO) {
		
		User user=new User();
		user.setName(userDTO.getName());
		user.setAge(userDTO.getAge());
		user.setEmail(userDTO.getEmail());
		
		int id=registerDao.save(user);
	   
		StatusDTO status= new StatusDTO();
		status.setId(id);
		status.setMessage("All Is Well");
		return status;
		
	
	}
}
