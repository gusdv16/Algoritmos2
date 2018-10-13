package obligatorio;

public class Main {
	public static void main(String[] args) {
		Sistema s = new Sistema();
		prueba1(s);
	}

	static void prueba1(Sistema s) {
		System.out.println(s.inicializarSistema(1, 0.0, 0.0).valorString);
		System.out.println(s.listarAfiliados());
		System.out.println(s.registrarAfiliado("4.746.670-8", "Persona 1", "email1").valorString);
		System.out.println(s.registrarAfiliado("712.966-5", "Persona 2", "test@algo.com").valorString);
		System.out.println(s.registrarAfiliado("4.427.145-3", "Persona 3", "test@algo.com").valorString);
		System.out.println(s.registrarAfiliado("4.427.145-3", "Persona 3", "test@algo.com").valorString);
		System.out.println(s.registrarAfiliado("3.230.172-7", "Persona 4", "test2@algo.com").valorString);
		System.out.println(s.registrarAfiliado("5.388.814-6", "Persona 5", "test2@algo.com").valorString);
		System.out.println(s.buscarAfiliado("47466708").valorString + "\nEl proceso tomo " + s.buscarAfiliado("4.746.670-8").valorEntero + " elementos recorridos");
		System.out.println(s.buscarAfiliado("4.746.670-8").valorString + "\nEl proceso tomo " + s.buscarAfiliado("4.746.670-8").valorEntero + " elementos recorridos");
		System.out.println(s.buscarAfiliado("4.427.145-3").valorString + "\nEl proceso tomo " + s.buscarAfiliado("4.427.145-3").valorEntero + " elementos recorridos");
		System.out.println(s.buscarAfiliado("3.230.172-7").valorString + "\nEl proceso tomo " + s.buscarAfiliado("3.230.172-7").valorEntero + " elementos recorridos");
		System.out.println(s.buscarAfiliado("5.388.814-6").valorString + "\nEl proceso tomo " + s.buscarAfiliado("5.388.814-6").valorEntero + " elementos recorridos");
		System.out.println(s.listarAfiliados());
	}
}