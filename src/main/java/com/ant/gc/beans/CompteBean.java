package com.ant.gc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.ant.gc.dto.MessageResponse;
import com.ant.gc.entities.Compte;
import com.ant.gc.services.CompteService;
import com.ant.gc.services.impl.CompteServiceImpl;

@ManagedBean
@ViewScoped
public class CompteBean {

	private Compte compte = new Compte();
	@ManagedProperty(value="#{cptServ}")
	private CompteService compteService;
	private List<Compte> list = new ArrayList<>();
	private boolean btnAdd = true, btnEdit = false;

	public void clickEdit() {
		btnAdd = false;
		btnEdit = true;
	}
	public void clickAdd() {
		btnAdd = true;
		btnEdit = false;
		compte=new Compte();
	}

	public void clickAnnuler() {
		compte = new Compte();
		btnAdd = true;
		btnEdit = false;
	}

	public void ajouter() {
		boolean valid = false;
		try {
			MessageResponse result = compteService.save(compte);

			if (result.isSuccess()) {
				valid = true;
				compte = new Compte();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", result.getMessage()));
			} else {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention", result.getMessage()));
			}

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opération non effectuée"));

			e.printStackTrace();
		}
		PrimeFaces.current().ajax().addCallbackParam("valid", valid);
	}

	public void modifier() {
		boolean valid = false;
		try {
			MessageResponse result = compteService.update(compte);

			if (result.isSuccess()) {
				valid = true;
				compte = new Compte();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", result.getMessage()));
			} else {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention", result.getMessage()));
			}
			

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opération non effectuée"));

			e.printStackTrace();
		}
		PrimeFaces.current().ajax().addCallbackParam("valid", valid);
	}

	public void supprimer() {
		try {
			MessageResponse result = compteService.delete(compte);

			if (result.isSuccess()) {
				compte = new Compte();
			}

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(result.getMessage()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opération non effectuée"));

			e.printStackTrace();
		}
	}

	public List<Compte> getList() {
		try {
			list = compteService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void setList(List<Compte> list) {
		this.list = list;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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
	public CompteService getCompteService() {
		return compteService;
	}
	public void setCompteService(CompteService compteService) {
		this.compteService = compteService;
	}

	
}
