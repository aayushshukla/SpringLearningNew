package com.infosys.aopexample.services;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SecurityServiceImpl implements SecurityService {

	Logger logger = Logger.getLogger(SecurityServiceImpl.class.getName());
	@Override
	@Before("execution(* com.infosys.aopexample.beans.User.show())")
	public void validateUser() {
		// TODO Auto-generated method stub
		logger.info("User validation is started in background");
		
	}

}
