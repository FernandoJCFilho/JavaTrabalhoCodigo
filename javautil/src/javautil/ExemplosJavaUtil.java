/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javautil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author LAB04-06
 */
public class ExemplosJavaUtil {

    public static void main(String[] args) {
//        demonstrarArrayList();
//        
//        demonstrarHashMap();

//        demonstrarLocalDate();
//        demonstrarLocalDateTime();
//        demonstraPeriod();
//        demonstraRandom();
//        demonstrarArrays();
        demonstraCollections();

    }

    public static void demonstrarArrayList() {

        List<String> alunos = new ArrayList<>();
        alunos.add("Joao");
        alunos.add("Carlos");
        alunos.add("Maria");
        alunos.add("Paulo");

        System.out.println("o Primeiro aluno e: " + alunos.get(0) + "\n");
        alunos.remove("Joao");

        for (String aluno : alunos) {
            System.out.println(aluno);
        }

    }

    public static void demonstrarHashMap() {

        Map<String, Double> notas = new HashMap<>();
        notas.put("Joao", 8.4);
        notas.put("Maria", 7.2);
        notas.put("Carlos", 9.5);
        notas.put("Renata", 10.0);

        System.out.println("A nota do Joao e: " + notas.get("Joao"));

        notas.remove("Joao");

        for (Map.Entry<String, Double> entrada : notas.entrySet()) {
            System.out.println("Chave: " + entrada.getKey() + " | Valor: " + entrada.getValue());
        }
    }

    public static void demonstrarLocalDate() {

        LocalDate hoje = LocalDate.now();

        LocalDate natal = LocalDate.of(2026, 12, 25);

        System.out.println("Data de hoje: " + hoje);
        System.out.println("Data natal: " + natal);

        LocalDate daquiUmaSemana = hoje.plusWeeks(1);
        LocalDate mesPassado = hoje.minusMonths(1);

        System.out.println("Semana que vem: " + daquiUmaSemana);
        System.out.println("Mes passado: " + mesPassado);

    }

    public static void demonstrarLocalDateTime() {

        LocalDateTime agora = LocalDateTime.now();
        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formatadorDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Data Hora Formatada: " + agora.format(formatadorDataHora));
        System.out.println("Data Hora Formatada: " + hoje.format(formatadorData));

    }

    public static void demonstraPeriod() {

        LocalDate fim = LocalDate.now();
        LocalDate inicio = LocalDate.of(2020, 1, 1);

        Period periodo = Period.between(inicio, fim);

        System.out.println("Tempo decorrido em anos: " + periodo.getYears());
        System.out.println("Tempo decorrido em anos: " + periodo.toTotalMonths());
        System.out.println("Tempo decorrido em dias: " + periodo.toString());
    }

    public static void demonstraRandom() {

        Random geradorNumeros = new Random();

        int numeroSorteio = geradorNumeros.nextInt(10) + 1;

        System.out.println("Numero sorteado: " + numeroSorteio);

    }

    public static void demonstrarArrays() {
        double[] notas = {9.7, 7.8, 4.3, 9.9, 10, 6.0};

        System.out.println("Array: " + notas);

        System.out.println("Array: " + Arrays.toString(notas));

        Arrays.sort(notas);

        System.out.println("Array: " + Arrays.toString(notas));

        int posicao = Arrays.binarySearch(notas, 7.8);

        if (posicao >= 0) {
            System.out.println("Elemento encontrado na posicao " + posicao);
        } else {
            System.out.println("Elemento nao encontrado");
        }

        double[] backupArray = Arrays.copyOf(notas, notas.length);
        System.out.println("Array backup: " + Arrays.toString(backupArray));

        Arrays.fill(notas, 0.0);

        System.out.println("Array: " + Arrays.toString(notas));

        boolean saoIguais = Arrays.equals(notas, backupArray);

        System.out.println("Sao iguais? " + (saoIguais ? "Sim" : "Nao"));
    }

    public static void demonstraCollections() {
        ArrayList<Double> notas = new ArrayList<>();
        notas.add(9.2);
        notas.add(6.1);
        notas.add(7.5);
        notas.add(2.8);
        notas.add(3.2);
        notas.add(9.1);
        
        System.out.println("Array: " + notas);
        
        Collections.sort(notas);
        
        System.out.println("Array ordenado: " + notas);
        
        int posicao = Collections.binarySearch(notas, 9.1);
        
        if (posicao >= 0) {
            System.out.println("Elemento encontrado na posicao " + posicao);
        } else {
            System.out.println("Elemento nao encontrado");
        }
        
        ArrayList backupNotas = (ArrayList)notas.clone();
        
        System.out.println("Backup: " + backupNotas);
        
        Collections.fill(notas, 0.0);
        
        System.out.println("Array subistituido: " + notas);
        
        boolean saoIguais = notas.equals(backupNotas);
        
        System.out.println("Sao Iguais?: " + (saoIguais ? "Sim" : "Nao"));
        
        

    }

}
