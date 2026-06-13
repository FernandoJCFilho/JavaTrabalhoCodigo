package tarefa;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class Tarefa {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 1;

        do {
            System.out.println("---------- Menu ---------");
            System.out.println("1- Sortiador de numero");
            System.out.println("2- Ditancias entre datas");
            System.out.println("0- Sair");
            System.out.println("-------------------------");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sortiadorDeNumero();
                    break;
                case 2:
                    diferncaDatas();
                    break;
                case 0:
                    break;
                default:
                    throw new AssertionError();
            }

        } while (opcao != 0);

    }

    public static void sortiadorDeNumero() {
        Random rand = new Random();
        int nMax, nEscolhido;
        System.out.println("Escolha o numero maximo para o sorteador: ");
        nMax = sc.nextInt();
        nEscolhido = rand.nextInt(nMax) + 1;
        System.out.println("Numero sorteado: " + nEscolhido);

    }

    public static void diferncaDatas() {
        int dia, mes, ano;
        System.out.println("-------Primeira Data----------");
        System.out.println("Digite o dia: ");
        dia = sc.nextInt();
        System.out.println("Digite o mes: ");
        mes = sc.nextInt();
        System.out.println("Digite o ano: ");
        ano = sc.nextInt();
        
        LocalDate primeiraData = LocalDate.of(ano, mes, dia);
        
        System.out.println("-------Segunda Data----------");
        System.out.println("Digite o dia: ");
        dia = sc.nextInt();
        System.out.println("Digite o mes: ");
        mes = sc.nextInt();
        System.out.println("Digite o ano: ");
        ano = sc.nextInt();
        
        LocalDate segundaData = LocalDate.of(ano, mes, dia);
        Period diferenca;
        if(primeiraData.isAfter(segundaData)){
            diferenca = Period.between(segundaData, primeiraData);
        }else{
            diferenca = Period.between(primeiraData, segundaData);
        }
        System.out.println("A diferenca entre as duas data e de " + diferenca.getYears() + " ano(s) " + diferenca.getMonths() + " mes(es) e " + diferenca.getDays() + " dia(s)");
                

    }

}
