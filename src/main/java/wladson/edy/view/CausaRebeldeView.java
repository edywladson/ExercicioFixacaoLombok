package wladson.edy.view;

import wladson.edy.Helpers;
import wladson.edy.controller.InteligenciaCentral;
import wladson.edy.domain.Rebelde;
import wladson.edy.enums.RacasEnum;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CausaRebeldeView {
    Scanner scanner;

    public CausaRebeldeView() {
        this.scanner = new Scanner(System.in);
    }

    private void chamada() {
        System.out.println("┏━╸┏━┓┏━╸┏━┓   ┏━┓┏━┓┏━┓╺┳╸┏━╸   ╺┳┓┏━┓\n" +
                           "┣╸ ┣━┫┃  ┣━┫   ┣━┛┣━┫┣┳┛ ┃ ┣╸     ┃┃┣━┫\n" +
                           "╹  ╹ ╹┗━╸╹ ╹   ╹  ╹ ╹╹┗╸ ╹ ┗━╸   ╺┻┛╹ ╹");
        System.out.println("┏━╸┏━┓╻ ╻┏━┓┏━┓   ┏━┓┏━╸┏┓ ┏━╸╻  ╺┳┓┏━╸╻\n" +
                           "┃  ┣━┫┃ ┃┗━┓┣━┫   ┣┳┛┣╸ ┣┻┓┣╸ ┃   ┃┃┣╸ ╹\n" +
                           "┗━╸╹ ╹┗━┛┗━┛╹ ╹   ╹┗╸┗━╸┗━┛┗━╸┗━╸╺┻┛┗━╸╹");
    }

    public void askInformacoes() throws FileNotFoundException, UnsupportedEncodingException {
        chamada();

        String verificacao = "S";
        while (!verificacao.equals("N")) {
            do {
                this.scanner = new Scanner(System.in);
                System.out.print("Deseja ingressar em nossa causa? (S/N) ");
                verificacao = scanner.next().toUpperCase();
            } while (!verificacao.equals("S") && !verificacao.equals("N"));

            if(!verificacao.equals("N")) {
                this.scanner = new Scanner(System.in);
                String nome = getNome();
                int idade = getIdade();
                int raca = getRaca();

                Rebelde rebelde = Rebelde.builder()
                        .nome(nome)
                        .idade(idade)
                        .raca(RacasEnum.values()[raca].getDescricao())
                        .build();

                if(InteligenciaCentral.solicitarIngressoNaCausa(rebelde)){
                    System.out.println("\n####################################################");
                    System.out.println("# SEJA BEM VINDO REBELDE! A NOSSA CAUSA TE ESPERA! #");
                    System.out.println("####################################################\n");
                } else {
                    System.out.println("\n################################################");
                    System.out.println("# DÊ O FORA DAQUI! ESSA CAUSA NÃO É PARA VOCÊ! #");
                    System.out.println("################################################\n");
                }
            }
        }
    }

    private String getNome() {
        System.out.println("Digite seu nome:");
        return Helpers.isBlank("Nome não pode estar em branco! Digite seu nome:");
    }

    private int getIdade(){
        System.out.println("Qual sua idade?");
        return Helpers.isInteiro("Idade inválidade! Qual sua Idade?", "A idade deve ser maior que 0. Qual sua Idade?");
    }

    private int getRaca() {
        System.out.println("Qual sua raça?");
        int count = -1;
        for (RacasEnum raca : RacasEnum.values()) {
            System.out.printf("%d - %s %n", raca.ordinal(), raca.name());
            count++;
        }

        int racaSelecionada;
        do {
            racaSelecionada = Helpers.isInteiro("Opção inválida! Escolha um das opções acima.", "Opção inválida! Escolha um das opções acima.");
            if(racaSelecionada > count){
                System.out.println("Opção inválida! Escolha um das opções acima");
            }
        } while (racaSelecionada > count);

        return racaSelecionada;
    }
}
