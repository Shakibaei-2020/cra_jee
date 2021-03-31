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
	
	private  final String INSERT_COLLAB_SQL = "INSERT INTO collaborateur (nom_coll, societe_coll, poste_coll) VALUES  (?, ?, ?);";
	private  final String SELECT_COLLAB_BY_ID = "SELECT id_coll,nom_coll,societe_coll,poste_coll FROM collaborateur WHERE id_coll =?";	
	private  final String SELECT_ALL_COLLAB = "SELECT * FROM collaborateur";
	private  final String SELECT_ALL_NOM_COLLAB = "SELECT nom_coll FROM collaborateur";
	//private  final String DELETE_COLLAB_SQL = "DELETE FROM collaborateur WHERE id_coll = ?;";
	private  final String DELETE_COLLAB_SQL = "DELETE FROM collaborateur WHERE nom_coll = ?;";
	private  final String UPDATE_COLLAB_SQL = "UPDATE collaborateur SET nom_coll = ?,societe_coll= ?, poste_coll =? WHERE id_coll = ?;";
	
	 public void insertCollab(Collaborateur collaborateur) throws SQLException {
	         Connection connection = DBUtil.getConnection(); 
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL); 
	            preparedStatement.setString(1, collaborateur.getnomCollab());
	            preparedStatement.setString(2, collaborateur.getsocieteCollab());
	            preparedStatement.setString(3, collaborateur.getposteCollab());
	            preparedStatement.executeUpdate();
	            connection.close();	            
	 }          
	
	  public List < Collaborateur > selectAllCollab() throws SQLException{
	        List < Collaborateur > Collaborateur = new ArrayList <Collaborateur> ();
	        Connection connection = DBUtil.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COLLAB);
	        ResultSet rs = (ResultSet) preparedStatement.executeQuery();
	        while (rs.next()) {
	        	int idColl = rs.getInt("id_coll");
	            String nomColl = rs.getString("nom_coll");
	            String societeColl = rs.getString("societe_coll");
	            String posteColl = rs.getString("poste_coll");
	            Collaborateur.add(new Collaborateur(idColl, nomColl, societeColl, posteColl));
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
	  
	   public boolean deleteCollab(String nomCollab) throws SQLException {
	        boolean rowDeleted;
	        Connection connection = DBUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(DELETE_COLLAB_SQL);
	        statement.setString(1, nomCollab);
	        rowDeleted = statement.executeUpdate() > 0;
	        return rowDeleted;
	    }
	   
	   public boolean updateCollab(Collaborateur Collaborateur) throws SQLException {
	        boolean rowUpdated;
	    	Connection connection = DBUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_COLLAB_SQL);
	        statement.setString(1, Collaborateur.getnomCollab());
	        statement.setString(2, Collaborateur.getposteCollab());
	        statement.setString(3, Collaborateur.getsocieteCollab());
	        statement.setInt(4, Collaborateur.getIdCollab());
	        rowUpdated = statement.executeUpdate() > 0;
	        return rowUpdated;

	    }

}
