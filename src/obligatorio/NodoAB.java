package obligatorio;

public class NodoAB {

	// Atributos
	private int cedula;
	private String nombre;
	private String email;
	private NodoAB der;
	private NodoAB izq;

	// Constructores
	public NodoAB(int c, String n, String e) {
		cedula = c;
		nombre = n;
		email = e;
		izq = null;
		der = null;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int n) {
		cedula = n;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NodoAB getDer() {
		return der;
	}

	public void setDer(NodoAB d) {
		der = d;
	}

	public NodoAB getIzq() {
		return izq;
	}

	public void setIzq(NodoAB i) {
		izq = i;
	}

}