package com.ant.gc.servicesimpl;

import java.util.List;

import com.ant.gc.dao.PersonneDao;
import com.ant.gc.daoimpl.PersonneDaoImpl;
import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Personne;
import com.ant.gc.services.PersonneService;

public class PersonneServiceImpl implements PersonneService{
	private PersonneDao personneDao=new PersonneDaoImpl();

	@Override
	public MessageResponse save(Personne personne) {
		Personne pers=personneDao.findById(personne.getCin());
		if(pers!=null) {
			return new MessageResponse(false,"Cin existant");
		}
		List<Personne>list= personneDao.findByEmail(personne.getEmail());
		if(!list.isEmpty()) {
			return new MessageResponse(false,"Email existant");
		}
		personneDao.save(personne);
		 return new MessageResponse(true,"Opération effectuée avec succés");
	}

	@Override
	public MessageResponse update(Personne personne) {
		Personne pers=personneDao.findById(personne.getCin());
		if(pers==null) {
			return new MessageResponse(false,"Cin n'existe pas");
		}
		List<Personne>list= personneDao.findByEmailAndCin(personne.getEmail(),personne.getCin());
		if(list.isEmpty()) {
			list= personneDao.findByEmail(personne.getEmail());
			if(!list.isEmpty()) {
				return new MessageResponse(false,"Email existant");
			}
		}
		
		personneDao.update(personne);
		 return new MessageResponse(true,"Opération effectuée avec succés");
	}

	@Override
	public MessageResponse delete(Personne personne) {
		Personne pers=personneDao.findById(personne.getCin());
		if(pers==null) {
			return new MessageResponse(false,"Cin n'existe pas");
		}
		personneDao.delete(personne);
		 return new MessageResponse(true,"Opération effectuée avec succés");
	}
	

	@Override
	public List<Personne> findAll() {
		return personneDao.findAll();
	}

}
