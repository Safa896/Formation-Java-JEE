package com.ant.gc.dao;

import java.util.List;

import com.ant.gc.entities.Personne;

public interface PersonneDao extends GenericDao<Personne, String> {

	List<Personne> findByEmail(String email);
	List<Personne> findByEmailAndCin(String email, String cin);
}
