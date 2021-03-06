package com.infocom.model.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.infocom.model.NoteDeFrais;
import com.infocom.model.util.DBUtil;

public class NoteDeFraisDAO {

	
	
	
	private  final String SELECT_FRAIS_BY_IDD = "SELECT nf.id, nf.raison,nf.prix,nf.date FROM notedefrais nf INNER JOIN collaborateur cl ON nf.idColl = cl.id WHERE cl.id = ?;";
	
	public List < NoteDeFrais > selectFraisCollab(int idColl) throws SQLException{

        List < NoteDeFrais > NoteDeFrais = new ArrayList <NoteDeFrais> ();
        PreparedStatement preparedStatement = null;
      Connection connection = DBUtil.getConnection();
        	     
             preparedStatement = connection.prepareStatement(SELECT_FRAIS_BY_IDD);
        	 preparedStatement.setInt(1, idColl);
	         ResultSet rs = (ResultSet) preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String raison = rs.getString("raison");
                int prix = rs.getInt("prix");
                Date date = rs.getDate("date");
                
                NoteDeFrais.add(new NoteDeFrais(id, raison, prix, date,idColl));

            }
            
        preparedStatement.close();
        return NoteDeFrais;
    }
	
	private  final String INSERT_FRAIS_SQL = "INSERT INTO notedefrais  (raison, prix, date,idColl) VALUES  (?, ?, ?, ?);";

	  public void insertFrais(NoteDeFrais noteDeFrais) throws SQLException { 
		  
		  PreparedStatement preparedStatement = null;
	       Connection connection = DBUtil.getConnection(); 
	       		preparedStatement = connection.prepareStatement(INSERT_FRAIS_SQL);
	            preparedStatement.setString(1, noteDeFrais.getRaison());
	            preparedStatement.setDouble(2, noteDeFrais.getPrix());
	            preparedStatement.setDate(3, (Date) noteDeFrais.getDate());
	            preparedStatement.setInt(4, noteDeFrais.getIdColl());
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	     
	    }
	  
	  
		private final String SELECT_ALL_FRAIS = "SELECT * FROM notedefrais ";

		public List<NoteDeFrais> selectAllFrais() throws SQLException {
			List<NoteDeFrais> noteDeFrais = new ArrayList<NoteDeFrais>();
			
			PreparedStatement preparedStatement = null ;
			Connection connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_FRAIS);
			ResultSet rs =  preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String raison = rs.getString("raison");
				double prix = rs.getDouble("prix");
				Date date = rs.getDate("date");
				noteDeFrais.add(new NoteDeFrais(id, raison, prix, date, id));
			}
			rs.close();
			preparedStatement.close();
			return noteDeFrais;
		}

		private final String DELETE_FRAIS_SQL = "DELETE FROM notedefrais WHERE raison = ?;";

		public boolean deleteFrais(String raison) throws SQLException {
			boolean rowDeleted;
			PreparedStatement preparedStatement = null;
			Connection connection = DBUtil.getConnection();
			 preparedStatement = connection.prepareStatement(DELETE_FRAIS_SQL);
			 preparedStatement.setString(1, raison);
			rowDeleted = preparedStatement.executeUpdate() > 0;
			
			preparedStatement.close();
			return rowDeleted;
		}

		private final String UPDATE_FRAIS_SQL = "UPDATE notedefrais SET raison = ?,prix =? ,date =? WHERE id = ?;";

		public boolean updateFrais(NoteDeFrais noteDeFrais) throws SQLException {
			boolean rowUpdated;
			PreparedStatement preparedStatement = null;
			Connection connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_FRAIS_SQL);
			preparedStatement.setString(1, noteDeFrais.getRaison());
			preparedStatement.setDouble(2, noteDeFrais.getPrix());
			preparedStatement.setDate(3, (java.sql.Date) noteDeFrais.getDate());
			preparedStatement.setInt(4, noteDeFrais.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
			
			preparedStatement.close();
			return rowUpdated;

		}

		
}
