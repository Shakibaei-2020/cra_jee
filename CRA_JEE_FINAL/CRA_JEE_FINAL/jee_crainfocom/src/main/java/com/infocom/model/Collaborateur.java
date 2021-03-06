package com.infocom.model;

import com.infocom.model.DAO.CollaborateurDAO;

public class Collaborateur extends CollaborateurDAO {
	
	private int idColl;
	private String nomColl;
	private String societeColl;
	private String posteColl;
	
	public Collaborateur() {}
	
	public Collaborateur( int idColl, String nomColl, String societeColl, String posteColl) {
        	this.idColl = idColl;
			this.nomColl = nomColl;
	        this.societeColl = societeColl;
	        this.posteColl = posteColl;
	 }
	
	 public int getIdCollab() {
			return idColl;
	 }
	 
	 public int setIdCollab(int idColl) {
			return this.idColl = idColl;
	 }
	 
	 public String getnomCollab() {
		 return nomColl;
	 }
	 
	 public String setnomCollab(String nomColl) {
		 return this.nomColl = nomColl;
	 }
	
	 public String getsocieteCollab() {
		 return societeColl;
	 }
	 
	 public String setsocieteCollab(String societeColl) {
		 return this.societeColl = societeColl;
	 }
	 
	 public String getpostCollab() {
		 return posteColl;
	 }
	 
	 public String setpostCollab(String posteColl) {
		 return this.posteColl = posteColl;
	 }

	@Override
	public String toString() {
		return "Collaborateur [idColl=" + idColl + ", nomColl=" + nomColl + ", societeColl=" + societeColl
				+ ", posteColl=" + posteColl + "]";
	}

}
