package com.infocom.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.infocom.model.Collaborateur;
import com.infocom.model.util.DBUtil;

public class CollaborateurDAO {
	
	private  final String INSERT_COLLAB_SQL = "INSERT INTO collaborateur (nom_coll, societe_coll, poste_coll) VALUES  (?, ?, ?);";
	private  final String SELECT_COLLAB_BY_ID = "SELECT id_coll,nom_coll,societe_coll,poste_coll FROM collaborateur WHERE id_coll =?";	

	
	 public void insertCollab(Collaborateur collaborateur) throws SQLException {
	        System.out.println(INSERT_COLLAB_SQL);
	         Connection connection = DBUtil.getConnection(); 
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL); 
	            preparedStatement.setString(1, collaborateur.getnomCollab());
	            preparedStatement.setString(2, collaborateur.getsocieteCollab());
	            preparedStatement.setString(3, collaborateur.getpostCollab());
	            preparedStatement.executeUpdate();
	            connection.close();	            
	 }          
	
	  public Collaborateur selectCollab(int idColl) {
		  Collaborateur Collaborateur = null;
	        try (Connection connection = DBUtil.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COLLAB_BY_ID)) {
	            preparedStatement.setInt(1, idColl);
	            ResultSet rs = (ResultSet) preparedStatement.executeQuery();

	            while (rs.next()) {
	                String nomColl = rs.getString("nom_coll");
	                String societeColl = rs.getString("societe_coll");
	                String posteColl = rs.getString("poste_coll");
	                
	                Collaborateur = new Collaborateur(idColl, societeColl, societeColl, posteColl);
	                System.out.println(idColl+" "+ nomColl +" "+ societeColl+" "+ posteColl);
	            }
	               
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return Collaborateur;
	    }
}

