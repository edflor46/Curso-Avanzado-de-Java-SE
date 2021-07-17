package com.edflor.amazonviewer.db;

public class DataBase {

	//CREDENCIALES
	public static final String URL       		= "jdbc:mysql://localhost:3306/";
	public static final String DB        		= "amazonviewer";
	public static final String USER      		= "amazonviewer";
	public static final String PASSWORD  		= "amazonviewer";
	
	//TABLA MOVIE
	public static final String TMOVIE           = "movie";
	public static final String TMOVIE_ID        = "id";
	public static final String TMOVIE_TITlE     = "title";
	public static final String TMOVIE_GENRE     = "genre";
	public static final String TMOVIE_CREATOR   = "creator";
	public static final String TMOVIE_DURATIOB  = "duration";
	public static final String TMOVIE_YEAR      = "year";
	
	//TABLA MATERIAL
	public static final String TMATERIAL        = "material";
	public static final int[]  ID_TMATERIAL     = {1,2,3,4,5};
	public static final String TMATERIAL_NAME   = "name";
	
	//TABLA USER
	public static final String TUSER       		= "user";
	public static final String TUSER_ID     	= "user_id";
	public static final String TUSER_NAME   	= "user_name";
	
	//TABLA VIEWEd
	public static final String TVIEWEd       	= "viewed";
	public static final String TVIEWED_ID     	= "id";
	public static final String TVIEWED_MATERIAL = "id_material";
	public static final String TVIEWED_ELEMENT  = "id_element";
	public static final String TVIEWED_USER   	= "id_user";	
	
	public static final int  TUSER_IDUSUARIO 	= 1;
}
