package com.ant.gc.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Personne;
import com.ant.gc.services.CompteService;
import com.ant.gc.services.PersonneService;
import com.ant.gc.services.impl.PersonneServiceImpl;

public class Test {

	public static void main(String[] args) {

		/*
		 * Personne pers = new Personne("554454", "Bounasrii", "Mourad", "Tunis",
		 * "mourad8@gmail.com");
		 * 
		 * PersonneService personneService = new PersonneServiceImpl();
		 * 
		 * MessageResponse result = personneService.save(pers);
		 * System.out.println(result.isSuccess() + " " + result.getMessage());
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		PersonneService perService=(PersonneService) context.getBean("persServ");
		CompteService compteService=(CompteService) context.getBean("cptServ");
		perService.findAll();
		compteService.findAll();

	}

}
