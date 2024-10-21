package modelo;

import java.util.Scanner;

public class Registro {
    private Login login;
    private String email;
    private String senha;
    private String repetirSenha;
    private Scanner scanner;

    public Registro() {
        this.scanner = new Scanner(System.in);
    }

    public boolean registrar() {
    	String ANSI_GREEN = "\u001B[32m";
		String ANSI_RESET = "\u001B[0m";
		String ANSI_RED = "\u001B[31m";
		String ANSI_YELLOW = "\u001B[33m";
    	
    	System.out.println(ANSI_YELLOW + "\nREGISTRO" + ANSI_RESET);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        this.email = email;
        
        System.out.print("Senha:");
        String senha = scanner.nextLine();
        this.senha = senha;
        
        System.out.print("Repetir senha: ");
        String repetirSenha = scanner.nextLine();
        this.repetirSenha = repetirSenha;
        
        while (!senha.equalsIgnoreCase(repetirSenha)) {
            System.out.println(ANSI_RED + "Senhas diferentes!" + ANSI_RESET);
            System.out.print("Repetir senha: ");
            repetirSenha = scanner.nextLine();
        }
        System.out.println(ANSI_GREEN + "Registrado com sucesso!" + ANSI_RESET);
        login = new Login(this);
        login.logar("Login");
        
        return true;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getRepetirSenha() {
        return repetirSenha;
    }
}
