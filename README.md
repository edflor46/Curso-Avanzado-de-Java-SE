# Curso Avanzado de Java SE

Conversión de clases Abstractas del proyecto previamente realizado.

### Abstract clase Film
<pre>
    <code>public abstract class Film {...}</code>
</pre>

### Método Abstract clase Film
<pre>
    <code>public abstract void view();</code>
</pre>

## Implementando métodos abstractos en Java

**view() clase Movie**
<pre>
    <code>
    @Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
		
	}</code>
</pre>

**view() clase Chapters**
<pre>
    <code>	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		ArrayList<Chapter> chapters =  getSerie().getChapters();
		int chapterViewedCounter = 0;
		
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter ++;
			}
		}
		
		if (chapterViewedCounter == chapters.size()) {
			getSerie().setViewed(true);
		}
	}</code>
</pre>

**view() clase Book**
<pre>
    <code>	public void view() {
		setReaded(true);
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("LeÃ­ste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}</code>
</pre>

### Demo

**Clase Movie**
![movie](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626316221/Academia-Java.-CDMX/Java-Avanzado/metodo_1_rdjl3o.png)

**Clase Book**
![serie](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626316221/Academia-Java.-CDMX/Java-Avanzado/metodo_3_et3zvt.png)

**Clase Serie**
![Serie](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626316221/Academia-Java.-CDMX/Java-Avanzado/metodo_2_gboljh.png)

## Javadoc
### Documentación Javadoc

![documentacion](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626320568/Academia-Java.-CDMX/Java-Avanzado/javadoc_w45l3o.png)

## Implementando clase anidada Page al proyecto

<pre>
	<code>
		//Clase
		public static class Page {
		private int id;
		private int number;
		private String content;
		
		//Constructor
		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
		
		//Metodos get y set
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
			
	}</code>
</pre>

## Creando Interfaz DAO con métodos default y private

<pre>
	<code>
package com.edflor.amazon.viewer.dao;

import java.util.ArrayList;

import com.anncode.amazonviewer.model.Movie;

public interface MovieDao {
	//Set movie
	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	//Read Movie
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList();
		return movies;
	}
	
	//get Movie viewed
	private  boolean getMovieViewed() {
		return false;
	}
	
}</code>
</pre>

## Creando la base de datos MySQL

### Iniciando Servidores
![star_server](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626414493/Academia-Java.-CDMX/Java-Avanzado/jdbc_1_gnc10a.png)

### Panel administrador
![panel_admin](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626414501/Academia-Java.-CDMX/Java-Avanzado/jdbc_2_xp66gq.png)

### Creación de usuario y base de datos
![user_Database](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626414497/Academia-Java.-CDMX/Java-Avanzado/jdbc_3_ygpinz.png)


### Importar base de datos
![import_DB](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626414490/Academia-Java.-CDMX/Java-Avanzado/jdbc_4_ikduon.png)

### Base de datos Amazonviewer
![db](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626414491/Academia-Java.-CDMX/Java-Avanzado/jdbc_5_xu0wvv.png)

## Generando conexión a la base de datos y creando clase de constantes

### Conexión a la base de datos
<pre>
	<code>package com.edflor.amazonviewer.db;
import java.sql.DriverManager;

import java.sql.Connection;
import static com.edflor.amazonviewer.db.DataBase.*;
public interface IDBConnection {

	default Connection connetToDB() {
		Connection connection = null;
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
}</code>
</pre>

### Constantes
<pre>
	<code>
package com.edflor.amazonviewer.db;

public class DataBase {

	//CREDENCIALES
	public static final String URL       		= "jdbc:mysql://localhost:3306/";
	public static final String DB        		= "amazonviewer";
	public static final String USER      		= "amazonviewer";
	public static final String PASSWORD  		= "amazonviewer";
	
	//TABLA MOVIE
	public static final String TMOVIE           = "movie";
	public static final String TMOVIE_ID        = "amazonviewer";
	public static final String TMOVIE_TITlE     = "title";
	public static final String TMOVIE_GENRE     = "amaznviewer";
	public static final String TMOVIE_CREATOR   = "creator";
	public static final String TMOVIE_DURATIOB  = "duration";
	public static final String TMOVIE_YEAR      = "year";
	
	//TABLA MATERIAL
	public static final String TMATERIAL        = "material";
	public static final String TMATERIAL_ID     = "id";
	public static final String TMATERIAL_NAME   = "name";
	
	//TABLA USER
	public static final String TUSER       		= "user";
	public static final String TUSER_ID     	= "user_id";
	public static final String TUSER_NAME   	= "user_name";
	
	//TABLA VIEWEd
	public static final String TVIEWEd       	= "viewed";
	public static final String TVIEWED_ID     	= "id";
	public static final String TVIEWED_NAME   	= "id_material";
	public static final String TVIEWED_ELEMENT  = "id_element";
	public static final String TVIEWED_USER   	= "id_user";	
}
	</code>
</pre>

## Sentencia SELECT Java

<pre>
	<code>	default ArrayList<Movie>read(){
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
	}</code>
</pre>

### Trayendo datos de la tabla movie
![movie](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626496527/Academia-Java.-CDMX/Java-Avanzado/bd_movies_rzkj45.png)

## Select con filtros

<pre>
	<code>private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
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
	}</code>
</pre>

## Sentencia INSERT Java
<pre>
	<code>	default Movie setMovieViewed(Movie movie) {
		try (Connection connection = connectToDB()){
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + TVIEWEd +
					"("+TVIEWED_MATERIAL+", "+TVIEWED_ELEMENT+", "+TVIEWED_USER+")" + 
					"VALUES("+ID_TMATERIAL[0]+", "+movie.getId()+", "+TUSER_IDUSUARIO+")";
			if (statement.executeUpdate(query) > 0) {
				System.out.println("Se marco en visto");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return movie;
	}</code>
</pre>