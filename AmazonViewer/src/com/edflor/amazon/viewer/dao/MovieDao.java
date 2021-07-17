package com.edflor.amazon.viewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.edflor.amazonviewer.db.DataBase.*;

import com.anncode.amazonviewer.model.Movie;
import com.edflor.amazonviewer.db.IDBConnection;


public interface MovieDao extends IDBConnection {

	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	default ArrayList<Movie>read(){
		ArrayList<Movie> movies = new ArrayList();
		try(Connection connection = connectToDB()){
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITlE), 
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR),
						Integer.valueOf(rs.getString(TMOVIE_DURATIOB)), 
						Short.valueOf(rs.getNString(TMOVIE_YEAR)));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(getMovieViewed(preparedStatement, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return movies;
	}
	
	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWEd +
				" WHERE " + TVIEWED_MATERIAL + "= ?" + 
				" AND " + TVIEWED_ELEMENT + "= ?"+
				" AND " + TVIEWED_USER + "= ?";
		
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_TMATERIAL[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDUSUARIO );
			
			rs = preparedStatement.executeQuery();
			
			viewed = rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return viewed;
	}
	
}
