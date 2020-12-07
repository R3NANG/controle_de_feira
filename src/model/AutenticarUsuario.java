package model;
import java.util.Scanner;

public class AutenticarUsuario {
    private String usuarioAutenticar = "admin";
    private String senhaAutenticar = "admin";
    Scanner entrada = new Scanner(System.in);

    public boolean AutenticarUsuario() {
        String usuario;
        String senha;
        boolean resultado;

        System.out.printf("\nDigite o Usuario: ");
        usuario = entrada.nextLine();
        System.out.printf("Digite a Senha: ");
        senha = entrada.nextLine();

        if(usuarioAutenticar.equals(usuario) && senhaAutenticar.equals(senha)) {
            System.out.println("\nAcesso Permitido.");
            resultado = true;
        }
        else {
            System.out.println("\nAcesso Negado.");
            resultado = false;
        }

        return resultado;
    }
}
