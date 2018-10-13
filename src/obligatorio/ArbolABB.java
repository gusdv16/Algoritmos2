package obligatorio;

public class ArbolABB implements IArbolABB {

	private NodoAB raiz;
	public int recorridoBusqueda = 0;

	public ArbolABB() {
		this.raiz = null;
	}

	public NodoAB getRaiz() {
		return raiz;
	}

	public boolean esArbolVacio() {
		return (raiz == null);
	}

	public void vaciar() {
		this.raiz = null;
	}

	@Override
	public void insertar(int x, String n, String e) {
		if (raiz == null) {
			raiz = new NodoAB(x, n, e);
		} else {
			insertar(x, n, e, raiz);
		}
	}

	public void insertar(int x, String nm, String e, NodoAB n) {
		if (x < n.getCedula()) {
			if (n.getIzq() == null) {
				n.setIzq(new NodoAB(x, nm, e));
			} else {
				insertar(x, nm, e, n.getIzq());
			}
		} else if (x > n.getCedula()) {
			if (n.getDer() == null) {
				n.setDer(new NodoAB(x, nm, e));
			} else {
				insertar(x, nm, e, n.getDer());
			}
		}
	}

	@Override
	public void borrarMinimo() {
		if (raiz != null) {
			raiz = borrarMinimo(raiz);
		}
	}

	public NodoAB borrarMinimo(NodoAB nodo) {
		if (nodo == null) {
			return nodo;
		}

		if (nodo.getIzq() != null) {
			nodo.setIzq(borrarMinimo(nodo.getIzq()));
			return nodo;
		} else {
			return nodo.getDer();
		}
	}

	@Override
	public void borrarElemento(int x) {
		raiz = borrarElemento(x, raiz);
	}

	private NodoAB borrarElemento(int x, NodoAB a) {
		if (a == null) {
			return a;
		}
		if (x < a.getCedula()) {
			a.setIzq(borrarElemento(x, a.getIzq()));
		} else if (x > a.getCedula()) {
			a.setDer(borrarElemento(x, a.getDer()));
		} else {
			if (a.getIzq() != null && a.getDer() != null) {
				a.setDer(borrarMinimo(a.getDer()));
			} else if (a.getIzq() != null) {
				a = a.getIzq();
			} else {
				a = a.getDer();
			}
		}
		return a;
	}

	@Override
	public boolean pertenece(int x) {
		return pertenece(x, raiz);
	}

	private boolean pertenece(int e, NodoAB a) {
		boolean existe;
		if (a == null) {
			existe = false;
		} else {
			if (e == a.getCedula()) {
				existe = true;
			} else if (e < a.getCedula()) {
				existe = pertenece(e, a.getIzq());
			} else {
				existe = pertenece(e, a.getDer());
			}
			recorridoBusqueda++;
		}
		return existe;
	}

	@Override
	public NodoAB obtenerElemento(int n, NodoAB nodo) {
		if (nodo == null) {
			return nodo;
		} else {
			if (n == nodo.getCedula()) {
				return nodo;
			} else if (n < nodo.getCedula()) {
				return obtenerElemento(n, nodo.getIzq());
			} else {
				return obtenerElemento(n, nodo.getDer());
			}
		}
	}

	@Override
	public void listarAscendente() {
		if (esArbolVacio()) {
			System.out.println("Sin datos");
		} else {
			listarAscendente(raiz);
		}
	}

	private void listarAscendente(NodoAB a) {
		if (a != null) {
			listarAscendente(a.getIzq());
			System.out.print(a.getCedula() + ";" + a.getNombre() + ";" + a.getEmail() + "|");
			listarAscendente(a.getDer());
		}
	}

	@Override
	public void listarDescendente() {
		if (esArbolVacio()) {
			System.out.println("Sin datos");
		} else {
			listarDescendente(raiz);
		}
	}

	private void listarDescendente(NodoAB a) {
		if (a != null) {
			listarDescendente(a.getDer());
			System.out.print(a.getCedula() + " - ");
			listarDescendente(a.getIzq());
		}

	}
}
