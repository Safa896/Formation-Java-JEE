package com.ant.gc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Personne;
import com.ant.gc.services.PersonneService;
import com.ant.gc.services.impl.PersonneServiceImpl;

@ManagedBean
@ViewScoped
public class PersonneBean {

	private Personne personne = new Personne();
	@ManagedProperty(value="#{persServ}")
	private PersonneService personneService ;
	private List<Personne> list = new ArrayList<>();
	private boolean btnAdd = true, btnEdit = false;

	public void clickEdit() {
		btnAdd = false;
		btnEdit = true;
	}
	public void clickAnnuler() {
		personne = new Personne();
		btnAdd = true;
		btnEdit = false;
	}
	public void ajouter() {
		try {
			MessageResponse result = personneService.save(personne);

			if (result.isSuccess()) {
				personne = new Personne();
			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(result.getMessage()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opération non effectuée"));

			e.printStackTrace();
		}
	}
	
	public void modifier() {
		try {
			MessageResponse result = personneService.update(personne);

			if (result.isSuccess()) {
				personne = new Personne();
				clickAnnuler();
			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(result.getMessage()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opération non effectuée"));

			e.printStackTrace();
		}
	}

	public void supprimer() {
		try {
			MessageResponse result = personneService.delete(personne);

			if (result.isSuccess()) {
				personne = new Personne();
			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(result.getMessage()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opération non effectuée"));

			e.printStackTrace();
		}
	}

	public List<Personne> getList() {
		try {
			list = personneService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void setList(List<Personne> list) {
		this.list = list;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public boolean isBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(boolean btnAdd) {
		this.btnAdd = btnAdd;
	}

	public boolean isBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(boolean btnEdit) {
		this.btnEdit = btnEdit;
	}
	public PersonneService getPersonneService() {
		return personneService;
	}
	public void setPersonneService(PersonneService personneService) {
		this.personneService = personneService;
	}
	
	

}
