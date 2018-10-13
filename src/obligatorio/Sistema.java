package obligatorio;

import obligatorio.Retorno.Resultado;

public class Sistema implements ISistema {

	public int MaxPuntos;
	public ArbolABB ListaAfiliados;
	public metodosAuxiliares ma = new metodosAuxiliares();

	@Override
	public Retorno inicializarSistema(int maxPuntos, Double coordX, Double coordY) {
		Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
		if (maxPuntos <= 0) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "La cantidad de puntos debe ser mayor a 0";
		} else {
			MaxPuntos = maxPuntos;
			ListaAfiliados = new ArbolABB();

			ret.resultado = Resultado.OK;
			ret.valorString = "Sistema creado correctamente";
		}
		return ret;
	}

	@Override
	public Retorno destruirSistema() {
		Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
		MaxPuntos = 0;
		ListaAfiliados.vaciar();

		ret.resultado = Resultado.OK;
		ret.valorString = "Sistema eliminado correctamente";

		return ret;
	}

	@Override
	public Retorno registrarAfiliado(String cedula, String nombre, String email) {
		String cedulaLimpia = ma.limpiarString(cedula);
		int cedulaInt = ma.convertirStringAInt(cedulaLimpia);

		Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
		if (!ma.validarFormatoCedula(cedula)) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "La cédula " + cedula + " no tiene un formato valido";
		} else if (!ma.esCIValida(cedulaLimpia)) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "La cédula " + cedula + " no es valida";
		} else if (!ma.validarEmail(email)) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "El correo " + email + " no es valido";
		} else if (ListaAfiliados.pertenece(cedulaInt)) {
			ret.resultado = Resultado.ERROR_3;
			ret.valorString = "La cédula " + cedula + " ya esta ingresada en el sistema";
		} else {
			ListaAfiliados.insertar(cedulaInt, nombre, email);
			ret.resultado = Resultado.OK;
			ret.valorString = "Afiliado " + cedula + " fue agregado correctamente";
		}

		return ret;
	}

	@Override
	public Retorno buscarAfiliado(String CI) {
		Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
		String cedulaLimpia = ma.limpiarString(CI);
		int cedulaInt = ma.convertirStringAInt(cedulaLimpia);

		if (!ma.validarFormatoCedula(CI)) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "La cédula " + CI + " no tiene un formato valido";
		} else if (!ma.esCIValida(cedulaLimpia)) {
			ret.resultado = Resultado.ERROR_1;
			ret.valorString = "La cédula " + CI + " no es valida";
		} else if (!ListaAfiliados.pertenece(cedulaInt)) {
			ret.resultado = Resultado.ERROR_2;
			ret.valorString = "El usuario cédula " + CI + " no esta ingresada en el sistema";
		} else {
			ListaAfiliados.recorridoBusqueda = 0;
			ListaAfiliados.pertenece(cedulaInt);
			NodoAB afiliado = ListaAfiliados.obtenerElemento(cedulaInt, ListaAfiliados.getRaiz());
			ret.resultado = Resultado.OK;
			ret.valorString = "Se encontro al Afiliado " + CI + ";" + afiliado.getNombre() + ";" + afiliado.getEmail();
			ret.valorEntero = ListaAfiliados.recorridoBusqueda;
		}

		return ret;
	}

	@Override
	public Retorno listarAfiliados() {
		Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

		ret.valorString = "Listado de Afiliados";
		ListaAfiliados.listarAscendente();
		ret.resultado = Resultado.OK;

		return ret;
	}

	@Override
	public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
			int nuevoValorPerdidaCalidad) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno calidadCanalera(Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno nodosCriticos() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}
}