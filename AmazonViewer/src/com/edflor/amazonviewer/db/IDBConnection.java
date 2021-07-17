package com.edflor.amazonviewer.db;
import java.sql.DriverManager;

import java.sql.Connection;
import static com.edflor.amazonviewer.db.DataBase.*;
public interface IDBConnection {

	default Connection connectToDB() {
		Connection connection = null;
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Se establecio la conexion");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
}
