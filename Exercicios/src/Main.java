import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        double numero, a, b, c = 0;
        int n1, n2, n3, n4 = 0;
        String resultado, escolha;

        Exercicio ex = new Exercicio();

        System.out.println("===================================================");
        System.out.println("Bem-vindo aos Exercícios de Iniciante");
        System.out.println("===================================================\n");

        while (opcao != 0) {
            System.out.println("\nEscolha qual exercício você quer executar:");
            System.out.println("1 - Exercício 1 - Faça um programa para ler dois valores inteiros, e depois mostrar na tela a soma desses números com uma\n" +
                    "mensagem explicativa, conforme exemplos.");
            System.out.println("2 - Exercício 2 - Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro\n" +
                    "casas decimais");
            System.out.println("3 - Exercício 3 - Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto\n" +
                    "de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D).");
            System.out.println("4 - Exercício 4 - Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por\n" +
                    "hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas\n" +
                    "decimais.");
            System.out.println("5 - Exercício 5 - Fazer um programa para ler o código da peça, o número de peças, o valor unitário de cada peça, Calcule e mostre o valor a ser pago.");
            System.out.println("6 - Exercício 6 - Fazer um programa que leia três valores com ponto flutuante de dupla precisão: A, B e C. Em seguida, calcule e\n" +
                    "mostre:\n" +
                    "a) a área do triângulo retângulo que tem A por base e C por altura.\n" +
                    "b) a área do círculo de raio C. (pi = 3.14159)\n" +
                    "c) a área do trapézio que tem A e B por bases e C por altura.\n" +
                    "d) a área do quadrado que tem lado B.\n" +
                    "e) a área do retângulo que tem lados A e B.");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opção: ");

            // Lê a escolha
            escolha = "";
            escolha = sc.next();
            if (escolha.matches("-?\\d+")) {
                opcao = Integer.parseInt(escolha);
                sc.nextLine(); // limpa o buffer do scanner

                switch (opcao) {
                    case 1:
                        resultado = ex.Exe1();
                        System.out.println("\nResultado do Exercício 1:");
                        System.out.println(resultado);
                        break;

                    case 2:
                        System.out.println("\nDigite um numero:");
                        try {
                            numero = sc.nextDouble();
                            resultado = ex.Exe2(numero);
                            System.out.println("\nResultado do Exercício 2:");
                            System.out.println(resultado);
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Não é um número válido!");
                        }
                        break;

                    case 3:
                        System.out.println("\nDigite o numero A:");
                        try {
                            n1 = sc.nextInt();
                            System.out.println("\nDigite o numero B:");
                            n2 = sc.nextInt();
                            System.out.println("\nDigite o numero C:");
                            n3 = sc.nextInt();
                            System.out.println("\nDigite o numero D:");
                            n4 = sc.nextInt();
                            resultado = ex.Exe3(n1, n2, n3, n4);
                            System.out.println("\nResultado do Exercício 3:");
                            System.out.println(resultado);
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Não é um número válido!");
                        }
                        break;

                    case 4:
                        System.out.println("\nDigite o numero do funcionário:");
                        try {
                            n1 = sc.nextInt();
                            System.out.println("\nDigite suas horas trabalhadas:");
                            n2 = sc.nextInt();
                            System.out.println("\nDigite o valor que recebe por hora:");
                            numero = sc.nextDouble();
                            resultado = ex.Exe4(n1, n2, numero);
                            System.out.println("\nResultado do Exercício 4:");
                            System.out.println(resultado);
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Não é um número válido!");
                        }
                        break;

                    case 5:
                        resultado = ex.Exe5();
                        System.out.println("\nResultado do Exercício 5:");
                        System.out.println(resultado);
                        break;

                    case 6:
                        System.out.println("\nDigite o numero A:");
                        try {
                            a = sc.nextDouble();
                            System.out.println("\nDigite o numero B:");
                            b = sc.nextDouble();
                            System.out.println("\nDigite o numero C:");
                            c = sc.nextDouble();
                            resultado = ex.Exe6(a, b, c);
                            System.out.println("\nResultado do Exercício 5:");
                            System.out.println(resultado);
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Não é um número válido!");
                        }

                    case 0:
                        System.out.println("Encerrando o programa... Até logo!");
                        break;

                    default:
                        System.out.println("⚠️ Opção inválida! Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Por favor digite um número");
            }
            sc.nextLine(); // limpa o buffer do scanner
        }
        sc.close();
    }
}
