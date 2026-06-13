package tarefa;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ClassesUtilitario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opc;
        ArrayList<String> participante = new ArrayList<>();
        HashMap<Integer, String> cronograma = new HashMap<>();
        cronograma.put(9, "Credenciamento e Cafe");
        cronograma.put(10, "Palestra Magna: O Futuro da Computacao");
        cronograma.put(14, "Workshop Pratico de Java");
        LocalDate dataEvento = LocalDate.of(2026,12,15);
        do {
            System.out.println("-- Sistema de Gestao de Eventos --");
            System.out.println("1- Adicionar participante");
            System.out.println("2- Ver Cronograma e Categorias");
            System.out.println("3- Sortear Brinde");
            System.out.println("4- Calcular Tempo para o evento (15/12/2026)");
            System.out.println("5- Ordenar e Imprimir Participantes");
            System.out.println("0- Sair");

            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    String nome;
                    System.out.println("Digite nome do participante: ");
                    nome = sc.next();
                    participante.add(nome);
                    System.out.println("Participante " + nome + " adicionado");
                    break;
                case 2:
                    System.out.println("Cronograma do Evento: ");
                    for (HashMap.Entry<Integer,String> visual : cronograma.entrySet()){
                        System.out.println(visual.getKey() + "h: " + visual.getValue());
                    }
                    System.out.println("----------------------");
                    break;
                case 3:
                    Random rand = new Random();
                    int indexSortiado = rand.nextInt(0,participante.size());
                    System.out.println("Participante " + participante.get(indexSortiado) + " Foi Escolhido");
                    break;
                case 4:
                    LocalDate hoje = LocalDate.now();
                    Period diferenciaData = Period.between(hoje, dataEvento);
                    System.out.println("Falta " + diferenciaData.getMonths() + " Mes(es) e " + diferenciaData.getDays() + " Dia(s)");
                    break;
                case 5:
                    Collections.sort(participante);
                    System.out.println("Lista de Participante em ordem");
                    for (String part : participante){
                        System.out.println("- " + part);
                    }
                    break;
            }
        } while (opc != 0);

    }

}
