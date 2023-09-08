package fr.eni.gestionListesCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.gestionListesCourses.bo.Ligne;
import fr.eni.gestionListesCourses.bo.Liste;
import fr.eni.gestionListesCourses.messages.CodeErreur;
import fr.eni.gestionListesCourses.messages.LecteurMessage;

public class ListesDaoJdbcImpl implements ListesDAO {

	@Override
	public void insert(Liste liste) throws SQLException {
		String listeSql = "INSERT INTO Liste(title) VALUES (?)";
		String ligneSql = "INSERT INTO Ligne(article, idListe, isBuy) VALUES (?, ?, ?)";
		
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(listeSql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
			 ps.setString(1, liste.getTitle());
			 ps.executeUpdate();
			 
			 ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					liste.setId(generatedKeys.getInt(1));
				}
		} catch (SQLException e) {
			e.printStackTrace();
			new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_INSERT));
		}
		
		for(Ligne ligne : liste.getLignes()) {
			ligne.setIdListe(liste.getId());
			
			try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(ligneSql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
				 ps.setString(1, ligne.getArticle());
				 ps.setInt(2, ligne.getIdListe());
				 ps.setBoolean(3, false);
				 ps.executeUpdate();
				 
				 ResultSet generatedKeys = ps.getGeneratedKeys();
					if (generatedKeys.next()) {
						ligne.setId(generatedKeys.getInt(1));
					}
			} catch (SQLException e) {
				e.printStackTrace();
				new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_INSERT));
			}
		}

	}

	@Override
	public List<Liste> selectListes() throws SQLException {
		String Sql = "SELECT * FROM Liste";
		List<Liste> listes = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(Sql)) {
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Liste liste = new Liste(rs.getInt("id"), rs.getString("title"));
				liste.setLignes(selectLignes(rs.getInt("id")));
				listes.add(liste);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_SELECT));
		}
		
		return listes;
	}

	@Override
	public List<Ligne> selectLignes(int idListe) throws SQLException {
		String Sql = "SELECT * FROM Ligne WHERE idListe = ?";
		List<Ligne> lignes = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(Sql)) {
			ps.setInt(1, idListe);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Ligne ligne = new Ligne(rs.getInt("id"), rs.getString("article"), rs.getInt("idListe"), rs.getBoolean("isBuy"));
				lignes.add(ligne);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_SELECT));
		}
		return lignes;
	}

	@Override
	public void checkLigne(int idLigne) throws SQLException {
		String Sql = "UPDATE Ligne SET isBuy = ? WHERE id = ?";
		
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(Sql)) {
			ps.setBoolean(1, true);
			ps.setInt(2, idLigne);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_UPDATE)); 
		}
			
	}
	
	@Override
	public void resetLignes(int idListe) throws SQLException {
		String Sql = "UPDATE Ligne SET isBuy = ? WHERE idListe = ?";
		
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(Sql)) {
			ps.setBoolean(1, false);
			ps.setInt(2, idListe);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_UPDATE)); 
		}
	}
	
	@Override
	public void delete(int idListe) throws SQLException {
		String listeSql = "DELETE FROM Liste WHERE id = ?";
		String ligneSql = "DELETE FROM Ligne WHERE idListe = ?";
		
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(ligneSql)) {
			ps.setInt(1, idListe);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_DELETE)); 
		}
		
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement ps = cnx.prepareStatement(listeSql)) {
			ps.setInt(1, idListe);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			new Exception(LecteurMessage.getMessageErreur(CodeErreur.ERROR_DELETE)); 
		}
	}

}
