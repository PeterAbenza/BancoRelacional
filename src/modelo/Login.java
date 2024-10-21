package modelo;

import java.util.Scanner;

public class Login {
	private Registro registro;
	private Scanner scanner;

	public Login(Registro registro) {
		this.registro = registro;
		this.scanner = new Scanner(System.in);
	}

	public boolean logar(String resposta) {
		String ANSI_GREEN = "\u001B[32m";
		String ANSI_RESET = "\u001B[0m";
		String ANSI_RED = "\u001B[31m";
		String ANSI_YELLOW = "\u001B[33m";
		
		if (resposta.equalsIgnoreCase("Login")) {
			System.out.println(ANSI_YELLOW + "\nLOGIN" + ANSI_RESET);
			System.out.print("Email: ");
			String email = scanner.nextLine();

			try {
				if (registro.getEmail().equalsIgnoreCase(email)) {
					System.out.print("Senha: ");
					String senha = scanner.nextLine();

					if (registro.getSenha().equals(senha)) {
						System.out.println(ANSI_GREEN + "Login bem-sucedido!" + ANSI_RESET);
						return true;
					} else {
						System.out.println(ANSI_RED + "Senha incorreta." + ANSI_RESET);
					}
				}
			} catch (Exception e) {
				System.out.println(ANSI_RED + "\nEmail não encontrado." + ANSI_RESET);
				System.out.println("Se você já tem uma conta, digite 'continuar'. Se ainda não tem, digite 'registro");
				String reposta = scanner.nextLine();
				
				if (reposta.equalsIgnoreCase("Registro")) {
					registro.registrar();
				} else if(reposta.equalsIgnoreCase("continuar")) {
					logar("Login");
				}
			}
		} else if (resposta.equalsIgnoreCase("Registro")) {
			registro.registrar();
		}
		return false;
	}

	public Registro getRegistro() {
		return registro;
	}
}
