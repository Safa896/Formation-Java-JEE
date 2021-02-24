package com.ant.gc.dao;

import java.util.List;

import com.ant.gc.entities.Compte;

public interface CompteDao extends GenericDao<Compte, Integer> {

	public List<Compte> findByNumCompte(String numCompte);
	public List<Compte> findByNumCompteAndId(String numCompte, Integer id);
}
