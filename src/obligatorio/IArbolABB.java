package obligatorio;

public interface IArbolABB {
	public void insertar(int x, String n, String e);

	void borrarMinimo();

	void borrarElemento(int x);

	void listarDescendente();

	void listarAscendente();

	boolean pertenece(int x);

	NodoAB obtenerElemento(int n, NodoAB nodo);
}
