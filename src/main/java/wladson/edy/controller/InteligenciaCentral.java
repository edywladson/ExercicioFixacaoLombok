package wladson.edy.controller;

import lombok.Cleanup;
import wladson.edy.domain.Rebelde;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class InteligenciaCentral {
    public static ArrayList<Rebelde> rebeldes = new ArrayList<Rebelde>();

    public static boolean solicitarIngressoNaCausa(Rebelde rebelde) throws FileNotFoundException, UnsupportedEncodingException {
        Random random = new Random();
        int ia = random.nextInt(2);

        if (ia == 1) {
            rebeldes.add(rebelde);
            inserirRebeldeNaLista();
            return true;
        }

        return false;
    }

    private static void inserirRebeldeNaLista() throws FileNotFoundException, UnsupportedEncodingException {
        @Cleanup PrintWriter writer = new PrintWriter(("lista-rebeldes.txt"), "UTF-8");
        writer.println("###########################################################################");
        writer.println("############################ LISTA DE REBELDES ############################");
        writer.println("###########################################################################");
        writer.println("---------------------------------------------------------------------------");
        for (Rebelde rebelde : rebeldes) {
            writer.write("NOME: " + rebelde.getNome() + " | IDADE: " + rebelde.getIdade() + " | RAÇA: " + rebelde.getRaca() + "\n");
            writer.println("---------------------------------------------------------------------------");
        }
    }
}
