package com.ant.gc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "num_compte")
	private String numCompte;
	@Column(name = "type_compte")
	private String typeCompte;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation")
	private Date dateCreation;
	private double solde;
	
	@ManyToOne
	@JoinColumn(name = "personne_cin", nullable = false)
	private Personne personne;

	public Compte() {
		super();
		personne = new Personne();
		// TODO Auto-generated constructor stub
	}

	public Compte(Integer id, String numCompte, String typeCompte, Date dateCreation, double solde) {
		super();
		this.id = id;
		this.numCompte = numCompte;
		this.typeCompte = typeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}
