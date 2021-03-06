package com.infocom.model;

import java.sql.Date;

import com.infocom.model.DAO.NoteDeFraisDAO;

public class NoteDeFrais extends  NoteDeFraisDAO{
	
	private int idFrais;
	private String raisonFrais;
	private double prixFrais;
	private Date dateFrais;
	
	public NoteDeFrais() {};
	
	public NoteDeFrais(int idFrais, String raisonFrais, int prixFrais, Date dateFrais) {
		super();
		this.idFrais = idFrais;
		this.raisonFrais = raisonFrais;
		this.prixFrais = prixFrais;
		this.dateFrais = dateFrais;
	}
	
	 public int getIdFrais() {
			return idFrais;
		}
	 
	 public int setIdFrais(int idFrais) {
			return this.idFrais = idFrais;
		}
	 
	 public String getRaisonFrais() {
		 return raisonFrais;
	 }
	 public String setRaisonFrais(String raisonFrais) {
		 return this.raisonFrais = raisonFrais;
	 }
	
	 public double getPrixFrais() {
		 return prixFrais;
	 }
	 public double setPrixFrais(double prixFrais) {
		 return this.prixFrais = prixFrais;
	 }
	 
	 public Date getDateFrais() {
		 return dateFrais;
	 }
	 public Date setDateFrais(Date dateFrais) {
		 return this.dateFrais = dateFrais;
	 }

	@Override
	public String toString() {
		return "NoteDeFrais [idFrais=" + idFrais + ", raisonFrais=" + raisonFrais + ", prixFrais=" + prixFrais
				+ ", dateFrais=" + dateFrais + "]";
	}
	 
	 
}
