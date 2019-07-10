package com.lti.training.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.training.DTO.StatusDTO;
import com.lti.training.DTO.UserDTO;
import com.lti.training.dao.RegisterDao;
import com.lti.training.entity.User;
import com.lti.training.service.RegisterService;

@RestController
public class SearchController {

	@Autowired
      RegisterDao dao;

	
	
	 @RequestMapping(path= "/searchUser", method = RequestMethod.GET)
     public String search(@RequestParam("email") String email,
    		 Map<String,Object> model) {
    	 User user = dao.fetch(email);
    	 model.put("userData", user);
    	 
    	 return "/searchResult" ;
}
}
