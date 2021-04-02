package com.infocom.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infocom.model.Collaborateur;
import com.infocom.model.util.DBUtil;

public class CollaborateurDAO {
	
	//private  final String SELECT_COLLAB_BY_ID = "SELECT id_coll,nom_coll,societe_coll,poste_coll FROM collaborateur WHERE id_coll =?";	
	//private  final String SELECT_ALL_NOM_COLLAB = "SELECT nom_coll FROM collaborateur";
	//private  final String DELETE_COLLAB_SQL = "DELETE FROM collaborateur WHERE id_coll = ?;";
	
	
	 private  final String INSERT_COLLAB_SQL = "INSERT INTO collaborateur (nom,mail,mdp,type) VALUES  (?,?,?,?);";
	
	 public void insertInterne(Collaborateur collaborateur) throws SQLException {
	         Connection connection = DBUtil.getConnection(); 
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL); 
	            preparedStatement.setString(1, collaborateur.getNom());
	            preparedStatement.setString(2, collaborateur.getMail());
	            preparedStatement.setString(3, collaborateur.getMdp());
	            preparedStatement.setBoolean(4,false);
	            preparedStatement.executeUpdate();
	            connection.close();	            
	 }  
	 
	 public void insertAdmin(Collaborateur collaborateur) throws SQLException {
         Connection connection = DBUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL); 
            preparedStatement.setString(1, collaborateur.getNom());
            preparedStatement.setString(2, collaborateur.getMail());
            preparedStatement.setString(3, collaborateur.getMdp());
            preparedStatement.setBoolean(4,true);
            preparedStatement.executeUpdate();
            connection.close();	            
	 }      
	
	 
	 
	 private  final String SELECT_ALL_COLLAB = "SELECT * FROM collaborateur ";

	  public List < Collaborateur > selectAllCollab() throws SQLException{
	        List < Collaborateur > Collaborateur = new ArrayList <Collaborateur> ();
	        Connection connection = DBUtil.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COLLAB);
	        ResultSet rs = (ResultSet) preparedStatement.executeQuery();
	        while (rs.next()) {
	        	int id = rs.getInt("id");
	            String nom = rs.getString("nom");
	            String mail = rs.getString("mail");
	            String mdp = rs.getString("mdp");
	            Boolean type = rs.getBoolean("type");

	            
	            Collaborateur.add(new Collaborateur(id, nom, mail, mdp ,type));
	        }
	        return Collaborateur;
	    }
	  	 
		 
	  /**
	   public void deleteCollab(int idCollab) throws SQLException {
	        boolean rowDeleted;
	        Connection connection = DBUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(DELETE_COLLAB_SQL);
	        statement.setInt(1, idCollab);
	        rowDeleted = statement.executeUpdate() > 0;
	    }
	 * @return 
	    **/
	  
	   private  final String DELETE_COLLAB_SQL = "DELETE FROM collaborateur WHERE nom = ?;";

	  
	   public boolean deleteCollab(String nomCollab) throws SQLException {
	        boolean rowDeleted;
	        Connection connection = DBUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(DELETE_COLLAB_SQL);
	        statement.setString(1, nomCollab);
	        rowDeleted = statement.executeUpdate() > 0;
	        return rowDeleted;
	    }
	   
		private  final String UPDATE_COLLAB_SQL = "UPDATE collaborateur SET nom = ?,mail =? ,mdp =? WHERE id = ?;";

	   public boolean updateCollab(Collaborateur Collaborateur) throws SQLException {
	        boolean rowUpdated;
	    	Connection connection = DBUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_COLLAB_SQL);
	        statement.setString(1, Collaborateur.getNom());
	        statement.setString(2, Collaborateur.getMail());
	        statement.setString(3, Collaborateur.getMdp());
	        statement.setInt(4, Collaborateur.getId());
	        rowUpdated = statement.executeUpdate() > 0;
	        return rowUpdated;

	    }
	   
	   
		private  final String CONNEXION = "SELECT id,nom,mail,mdp,type FROM collaborateur WHERE mail=?";
		
		public Collaborateur ConnectCollab(String mail) {
			  Collaborateur Collaborateur = null;
		        try (
		        	Connection connection = DBUtil.getConnection();
		            PreparedStatement preparedStatement = connection.prepareStatement(CONNEXION)) {
		            preparedStatement.setString(1, mail);
		            ResultSet rs = (ResultSet) preparedStatement.executeQuery();

		            while (rs.next()) {
		            	int id = rs.getInt("id");
		                String nom = rs.getString("nom");
		                String mailRs = rs.getString("mail");
		                String mdp = rs.getString("mdp");
		                Boolean type = rs.getBoolean("type");
		                
		                Collaborateur = new Collaborateur(id, nom, mailRs, mdp,type);
		            }
		               
		        } catch (SQLException e) {
		            System.out.println(e);
		        }
		        return Collaborateur;
		    }

}

