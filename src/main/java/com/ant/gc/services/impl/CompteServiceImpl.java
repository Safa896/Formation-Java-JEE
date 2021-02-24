package com.ant.gc.services.impl;

import java.util.List;

import com.ant.gc.dao.CompteDao;
import com.ant.gc.dao.impl.CompteDaoImpl;
import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Compte;
import com.ant.gc.services.CompteService;

public class CompteServiceImpl implements CompteService {
	private CompteDao compteDao ;

	@Override
	public MessageResponse save(Compte compte) {

		List<Compte> list = compteDao.findByNumCompte(compte.getNumCompte());

		if (!list.isEmpty()) {
			return new MessageResponse(false, "Numéro compte existant");
		}

		compteDao.save(compte);

		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Compte compte) {

		Compte cpt = compteDao.findById(compte.getId());

		if (cpt == null) {
			return new MessageResponse(false, "Compte n'existe pas");
		}

		List<Compte> list = compteDao.findByNumCompteAndId(compte.getNumCompte(), compte.getId());

		if (list.isEmpty()) {
			list = compteDao.findByNumCompte(compte.getNumCompte());
			if (!list.isEmpty()) {
				return new MessageResponse(false, "Numéro compte existant");
			}
		}
		compteDao.update(compte);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(Compte compte) {
		Compte cpt = compteDao.findById(compte.getId());

		if (cpt == null) {
			return new MessageResponse(false, "Compte n'existe pas");
		}
		compteDao.delete(compte);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return compteDao.findAll();
	}

	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}
	

}
