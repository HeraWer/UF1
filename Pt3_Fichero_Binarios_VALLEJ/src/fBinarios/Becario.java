package fBinarios;

public class Becario {
	
	private String nombre;
	private String Sexo;
	private int edad;
	private int suspensos;
	private String rFamiliar;
	private float ingresos;
	
	
	
	@Override
	public String toString() {
		return "Becario [nombre=" + nombre + ", Sexo=" + Sexo + ", edad=" + edad + ", suspensos=" + suspensos
				+ ", rFamiliar=" + rFamiliar + ", ingresos=" + ingresos + "]";
	}

	public Becario() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getSuspensos() {
		return suspensos;
	}

	public void setSuspensos(int suspensos) {
		this.suspensos = suspensos;
	}

	public String getrFamiliar() {
		return rFamiliar;
	}

	public void setrFamiliar(String rFamiliar) {
		this.rFamiliar = rFamiliar;
	}

	public float getIngresos() {
		return ingresos;
	}

	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
