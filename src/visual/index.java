package visual;

import java.util.Scanner;

import modelo.Login;
import modelo.Registro;

public class index {

	public static void main(String[] args) {
		Registro registro = new Registro();
		Scanner scanner = new Scanner(System.in);
		String ANSI_RED = "\u001B[31m";
		String ANSI_RESET = "\u001B[0m";
		
		System.out.println("Bem vindo ao DevPhone!");
		System.out.println(ANSI_RED +"Digite: 'Login/Registro' para começar. \n" + ANSI_RESET);
		String resposta = scanner.nextLine();

		if (resposta.equalsIgnoreCase("Registro")) {
			registro.registrar();
		} else if (resposta.equalsIgnoreCase("Login")) {
			Login login = new Login(registro);
			login.logar(resposta);
		} else {
			System.out.println("Opção inválida.");
		}

		scanner.close();
	}

}
