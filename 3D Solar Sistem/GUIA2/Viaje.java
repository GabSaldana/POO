import java.util.*;

public class Pelicula implements Serializable{
	private String titulo;
	private String director;
	private float año;

	public Pelicula(){}

	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	public String getTilulo(){
		return titulo;
	}
	public void setDirector(String director){
		this.director=director;
	}
	public String getDirector(){
		return director;
	}
	public float setAño(float año){
		this.año=año;
	}
	public void getAño(){
		return año;
	}

}