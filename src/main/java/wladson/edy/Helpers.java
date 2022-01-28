package wladson.edy;

import java.util.Scanner;

public class Helpers {
    static Scanner scanner = new Scanner(System.in);

    public  static int isInteiro(String mensagemUm, String mensagemDois) {
        int valor;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(mensagemUm);
                scanner.next();
            }

            valor = scanner.nextInt();
            if (valor < 0) {
                System.out.println(mensagemDois);
            }
        } while (valor < 0);

        return valor;
    }

    public static String isBlank(String mensagem) {
        String text = scanner.next();

        do {
            if (text.isBlank()) {
                System.out.println(mensagem);
                text = scanner.next();
            }
        } while (text.isBlank());

        return text;
    }
}
