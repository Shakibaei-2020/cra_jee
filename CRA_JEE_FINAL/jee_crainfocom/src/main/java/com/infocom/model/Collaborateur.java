package com.infocom.model;



public class Collaborateur{
	
	private int id;
	private String nom;
	private String mail;
	private String mdp;
	private boolean type;
	
	public Collaborateur() {}
	
	public Collaborateur( int id, String nom,String mail,String mdp, boolean type) {
        	this.id = id;
			this.nom = nom;
	        this.mail = mail;
	        this.mdp = mdp;
	        this.type = type;
	 }
	
	 public int getId() {
			return id;
	 }
	 
	 public int setId(int id) {
			return this.id = id;
	 }
	 
	 public String getNom() {
		 return nom;
	 }
	 
	 public String setNom(String nom) {
		 return this.nom = nom;
	 }
	 
	 public String getMail() {
		 return mail;
	 }
	 
	 public String setMail(String mail) {
		 return this.mail = mail;
	 }
	 
	 public String getMdp() {
		 return mdp;
	 }
	 
	 public String setMdp(String mdp) {
		 return this.mdp = mdp;
	 }
	 
	 
	 public boolean setAdmin() {
		 return this.type = true;
	 }
	 
	 public boolean getType() {
		 return type;
	 }
	 
	 public boolean setInterne() {
		 return this.type = false;
	 }

	@Override
	public String toString() {
		return "Collaborateur [id=" + id + ", nom=" + nom + ", mail=" + mail + ", mdp=" + mdp + ", type=" + type + "]";
	}
	
}
