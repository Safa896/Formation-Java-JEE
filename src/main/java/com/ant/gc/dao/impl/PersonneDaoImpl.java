package com.ant.gc.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ant.gc.dao.PersonneDao;
import com.ant.gc.entities.Personne;

public class PersonneDaoImpl extends GenericDaoImpl<Personne, String> implements PersonneDao {

	public PersonneDaoImpl() {
		super(Personne.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Personne> findByEmail(String email) {
		startOperation();
		Criterion criterion = Restrictions.eq("email", email);
		List<Personne> list = session.createCriteria(Personne.class).add(criterion).list();
		session.close();
		return list;
	}

	@Override
	public List<Personne> findByEmailAndCin(String email, String cin) {
		startOperation();
		Criterion criterion1 = Restrictions.eq("email", email);
		Criterion criterion2 = Restrictions.idEq(cin);
		Criterion criterion3 = Restrictions.and(criterion1, criterion2);
		List<Personne> list = session.createCriteria(Personne.class)
				.add(criterion3).list();
		session.close();
		return list;
	}

}
