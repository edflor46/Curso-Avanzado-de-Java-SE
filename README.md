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