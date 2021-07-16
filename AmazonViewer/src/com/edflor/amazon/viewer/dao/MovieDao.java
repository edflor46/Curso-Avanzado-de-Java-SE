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
				movies.add(movie);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return movies;
	}
	
	private boolean getMovieViewed() {
		return false;
	}
	
}
