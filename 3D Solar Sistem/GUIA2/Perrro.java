public class Perro{
	String nombre,raza,dueño,genero;int edad,vidarest;
	public Perro(){}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	public void setRaza(String raza){
		this.raza=raza;
	}
	public String getRaza(){
		return raza;
	}
	public void setEdad(String edad){
		this.edad=edad;
	}
	public int getEdad(){
		return edad;
	}
	public void setDueño(String dueño){
		this.dueño=dueño;
	}
	public String getDueño(){
		return deuño;
	}
	public void setGenero(String genero){
		this.genero=genero;
	}
	public String getGenero(){
		return genero;
	}
	public int getVidarest(){
		if(nombre.equals("Pastor Aleman")){
			return 15-edad;
		}
		if(nombre.equals("Boxer")){
			return 11-edad;
		}
		if(nombre.equals("Terrier")){
			return 8-edad;
		}
		if(nombre.equals("Doberman")){
			return 13-edad;
		}
		if(nombre.equals("Otra")){
			return 14-edad;
		}}}