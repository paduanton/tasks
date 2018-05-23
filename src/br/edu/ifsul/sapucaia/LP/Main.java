package br.edu.ifsul.sapucaia.LP;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.management.InvalidAttributeValueException;

/*
 * @author Antonio J�nior
 */
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int opt;
        Notebook noteboot = new Notebook(1, "Acer", "New Pvolution 1.0", 4, 500, "azul", "tassiano", "Linux4ever_S2", 3);
        noteboot.ligar();

        System.out.print("Insira seu Usu�rio: ");
        String user = t.next();
        System.out.print("Insira sua senha: ");
        String psw = t.next();

        String log_result = noteboot.logar(user, psw);
        System.out.println("\n\n");
        System.out.println(log_result);
        System.out.println("\n\n");

        while (noteboot.isLogado()) {
            try {
                t = new Scanner(System.in);
                String space = "", lembrete = null;

                for (int i = 0; i < 38 - noteboot.getUsuario().length(); i++) {
                    space += " ";
                }

                System.out.println("\n________________________MS-Java__________________________");
                System.out.println("*    Logado como: " + noteboot.getUsuario() + space + "*");
                System.out.println("*                                                       *");
                System.out.println("*        1. Adicionar    Lembrete                       *");
                System.out.println("*        2. Visualiar    Lembrete                       *");
                System.out.println("*        3. Atualizar    Lembrete                       *");
                System.out.println("*        4. Deletar      Lembrete                       *");
                System.out.println("*        5. Info do      Lembrete                       *");
                System.out.println("*        6. Localizar em Lembrete                       *");
                System.out.println("*________99. Sair_______________________________________*");
                System.out.print("*    A��o: ");
                opt = Integer.parseInt(t.nextLine());

                switch (opt) {
                    case 1:
                        System.out.println("Inserindo:");
                        System.out.println("    Digite o seu lembrete:");
                        lembrete = t.nextLine();

                        noteboot.createLembrete(lembrete);
                        clearConsole();
                        break;
                    case 2:
                        clearConsole();
                        System.out.println("Lembrete: " + noteboot.getLembrete());
                        break;
                    case 3:
                        System.out.println("Atualizando:");
                        System.out.println("    Digite o seu lembrete:");
                        lembrete = t.next();
                        noteboot.updateLembrete(lembrete);
                        clearConsole();
                        break;

                    case 4:
                        clearConsole();
                        System.out.println("Apagado!");
                        noteboot.deleteLembrete();
                        break;

                    case 5:
                        clearConsole();
                        noteboot.lembreteInfo();
                        break;

                    case 6:
                        System.out.print("    Insira a palavra que quer procurar: ");
                        String palavra = t.next();
                        int num_palavra = noteboot.localizar(palavra);

                        clearConsole();
                        System.out.println("Ocorrencias da palavra " + palavra + ": " + num_palavra);
                        break;

                    case 99:
                        noteboot.logout();
                        break;

                    default:

                        break;
                }

            } catch (InvalidAttributeValueException erro) {
                clearConsole();
                System.out.println(erro.getMessage());
            } catch (InputMismatchException erro) {
                clearConsole();
                System.out.println("Apenas N�meros!");
            } catch (NullPointerException erro) {
                clearConsole();
                System.out.println("Insira o Lembrete primeiro!");
            } catch (NumberFormatException erro) {
                clearConsole();
                System.out.println(erro.getMessage());
            }
        }

        t.close();
    }

    private static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
