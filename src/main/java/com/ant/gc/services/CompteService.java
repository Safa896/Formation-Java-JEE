package com.ant.gc.services;

import java.util.List;

import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Compte;

public interface CompteService {
	
	public MessageResponse save(Compte compte);
	public MessageResponse update(Compte compte);
	public MessageResponse delete(Compte compte);
	public List<Compte> findAll();

}
