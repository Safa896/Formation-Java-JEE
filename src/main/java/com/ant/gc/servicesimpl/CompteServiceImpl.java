package com.ant.gc.servicesimpl;

import java.util.List;

import com.ant.gc.dao.CompteDao;
import com.ant.gc.daoimpl.CompteDaoImpl;
import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Compte;
import com.ant.gc.entities.Personne;
import com.ant.gc.services.CompteService;

public class CompteServiceImpl implements CompteService{
	private CompteDao compteDao=new CompteDaoImpl();
	@Override
	public MessageResponse save(Compte compte) {
		List<Compte>list=compteDao.findByNumCompte(compte.getNumCompte());
		if(!list.isEmpty()) {
			return new MessageResponse(false,"Numéro de compte existant");
		}
		compteDao.save(compte);
		 return new MessageResponse(true,"Opération effectuée avec succés");
	}

	

	@Override
	public MessageResponse update(Compte compte) {
		Compte cpt=compteDao.findById(compte.getId());
		if(cpt==null) {
			return new MessageResponse(false,"Id n'existe pas");
		}
		List<Compte>list= compteDao.findByNumCompteAndId(compte.getNumCompte(),compte.getId());
		if(list.isEmpty()) {
			list= compteDao.findByNumCompte(compte.getNumCompte());
		}
		if(!list.isEmpty()) {
			return new MessageResponse(false,"Numéro de compte existant");
		}
		compteDao.update(compte);
		 return new MessageResponse(true,"Opération effectuée avec succés");
	}

	@Override
	public MessageResponse delete(Compte compte) {
		Compte cpt=compteDao.findById(compte.getId());
		if(cpt==null) {
			return new MessageResponse(false,"Id n'existe pas");
		}
		compteDao.delete(compte);
		 return new MessageResponse(true,"Opération effectuée avec succés");
	}

	@Override
	public List<Compte> findAll() {
		
		return compteDao.findAll();
	}
	

}
