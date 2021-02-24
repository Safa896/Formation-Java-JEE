package com.ant.gc.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ant.gc.dao.CompteDao;
import com.ant.gc.entities.Compte;
import com.ant.gc.entities.Personne;

public class CompteDaoImpl extends GenericDaoImpl<Compte, Integer> implements CompteDao {

	public CompteDaoImpl() {
		super(Compte.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Compte> findByNumCompte(String numCompte) {
		startOperation();
		Criterion criterion = Restrictions.eq("numCompte", numCompte);
		List<Compte> list = session.createCriteria(Compte.class)
				.add(criterion).list();
		session.close();
		return list;
	}

	@Override
	public List<Compte> findByNumCompteAndId(String numCompte, Integer id) {
		startOperation();
		Criterion criterion1 = Restrictions.eq("numCompte", numCompte);
		Criterion criterion2 = Restrictions.idEq(id);
		Criterion criterion3 = Restrictions.and(criterion1, criterion2);
		List<Compte> list = session.createCriteria(Compte.class)
				.add(criterion3).list();
		session.close();
		return list;
	}

}
