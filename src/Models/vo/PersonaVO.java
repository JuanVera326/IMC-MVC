package Models.vo;

public class PersonaVO {
	
	private String documento;
	private String nombre;
	private String edad;
	private String condicion;
	private double peso;
	private double talla;
	private double imc;
	
	public PersonaVO() {
		
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getTalla() {
		return talla;
	}
	public void setTalla(double talla) {
		this.talla = talla;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}
	
	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	@Override
	public String toString() {
		return "///////////PERSONA REGISTRADA////////\n"+"Documento= " + documento + "\nNombre= " + nombre.toUpperCase() + "\nEdad= " + edad + "\nPeso= " + peso
				+ "\nTalla= " + talla + "\nIMC= " + imc + "\nCondicion: "+ condicion +"\n";
	}
	
}
