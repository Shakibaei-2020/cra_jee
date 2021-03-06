package com.infocom.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infocom.model.Collaborateur;
import com.infocom.model.NoteDeFrais;
import com.infocom.model.util.DBUtil;

public class CollaborateurDAO {

	
	private final String INSERT_COLLAB_SQL = "INSERT INTO collaborateur (nom,mail,mdp,type) VALUES  (?,?,?,?);";

	public void insertInterne(Collaborateur collaborateur) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection connection = DBUtil.getConnection();
		preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL);
		preparedStatement.setString(1, collaborateur.getNom());
		preparedStatement.setString(2, collaborateur.getMail());
		preparedStatement.setString(3, collaborateur.getMdp());
		preparedStatement.setBoolean(4, false);
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
	}


	public void insertAdmin(Collaborateur collaborateur) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection connection = DBUtil.getConnection();
		preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL);
		preparedStatement.setString(1, collaborateur.getNom());
		preparedStatement.setString(2, collaborateur.getMail());
		preparedStatement.setString(3, collaborateur.getMdp());
		preparedStatement.setBoolean(4, true);
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
	}

	private final String SELECT_ALL_COLLAB = "SELECT * FROM collaborateur ";

	public List<Collaborateur> selectAllCollab() throws SQLException {
		List<Collaborateur> Collaborateur = new ArrayList<Collaborateur>();
		PreparedStatement preparedStatement = null;
		Connection connection = DBUtil.getConnection();
		preparedStatement = connection.prepareStatement(SELECT_ALL_COLLAB);
		ResultSet rs =  preparedStatement.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nom = rs.getString("nom");
			String mail = rs.getString("mail");
			String mdp = rs.getString("mdp");
			Boolean type = rs.getBoolean("type");

			Collaborateur.add(new Collaborateur(id, nom, mail, mdp, type));
		}
		preparedStatement.close();
		rs.close();
		
		return Collaborateur;
	}

	private final String DELETE_COLLAB_SQL = "DELETE FROM collaborateur WHERE nom = ?;";

	public boolean deleteCollab(String nomCollab) throws SQLException {
		boolean rowDeleted;
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(DELETE_COLLAB_SQL);
		preparedStatement.setString(1, nomCollab);
		rowDeleted = preparedStatement.executeUpdate() > 0;
		
		preparedStatement.close();
		
		return rowDeleted;
	}

	private final String UPDATE_COLLAB_SQL = "UPDATE collaborateur SET nom = ?,mail =? ,mdp =?, type = ? WHERE id = ?;";

	public boolean updateCollab(Collaborateur Collaborateur) throws SQLException {
		boolean rowUpdated;
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(UPDATE_COLLAB_SQL);
		preparedStatement.setString(1, Collaborateur.getNom());
		preparedStatement.setString(2, Collaborateur.getMail());
		preparedStatement.setString(3, Collaborateur.getMdp());
		preparedStatement.setBoolean(4, Collaborateur.getType());

		preparedStatement.setInt(5, Collaborateur.getId());
		rowUpdated = preparedStatement.executeUpdate() > 0;
		
		preparedStatement.close();
		
		return rowUpdated;

	}

	private final String CONNEXION = "SELECT id,nom,mail,mdp,type FROM collaborateur WHERE mail=?";

	public Collaborateur ConnectCollab(String mail)throws SQLException {
		PreparedStatement preparedStatement = null;
		Collaborateur Collaborateur = null;
		Connection connection = DBUtil.getConnection();
		 preparedStatement = connection.prepareStatement(CONNEXION);
			preparedStatement.setString(1, mail);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String mailRs = rs.getString("mail");
				String mdp = rs.getString("mdp");
				Boolean type = rs.getBoolean("type");
				Collaborateur = new Collaborateur(id, nom, mailRs, mdp, type);
			}
	
			preparedStatement.close();
			rs.close();
		return Collaborateur;
	}
	
	

}
