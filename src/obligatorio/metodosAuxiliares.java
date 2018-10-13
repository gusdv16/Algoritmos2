package obligatorio;

public class metodosAuxiliares {
	
	public boolean validarEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public int convertirStringAInt(String dato) {
		return Integer.valueOf(dato);
	}

	public boolean validarFormatoCedula(String cedula) {
		String ePattern = "^[1-9].\\d{3}.\\d{3}-\\d{1}$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(cedula);
		return m.matches();
	}

	public static boolean esCIValida(String ci) {
		if (ci.length() != 7 && ci.length() != 8) {
			return false;
		} else {
			try {
				Integer.parseInt(ci);
			} catch (NumberFormatException e) {
				return false;
			}
		}

		int digVerificador = Integer.parseInt((ci.charAt(ci.length() - 1)) + "");
		int[] factores;
		if (ci.length() == 7) { // CI viejas
			factores = new int[] { 9, 8, 7, 6, 3, 4 };
		} else {
			factores = new int[] { 2, 9, 8, 7, 6, 3, 4 };
		}

		int suma = 0;
		for (int i = 0; i < ci.length() - 1; i++) {
			int digito = Integer.parseInt(ci.charAt(i) + "");
			suma += digito * factores[i];
		}

		int resto = suma % 10;
		int checkdigit = 10 - resto;

		if (checkdigit == 10) {
			return (digVerificador == 0);
		} else {
			return (checkdigit == digVerificador);
		}
	}

	public static String limpiarString(String ci) {
		return ci.replaceAll("[^\\dA-Za-z ]", "");
	}
}