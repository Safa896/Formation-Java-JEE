package com.ant.gc.services;

import java.util.List;

import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Personne;

public interface PersonneService {

	public MessageResponse save(Personne personne);
	public MessageResponse update(Personne personne);
	public MessageResponse delete(Personne personne);
	public List<Personne> findAll();
}
