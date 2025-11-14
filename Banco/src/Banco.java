import Entites.Conta;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcao, nome;
        int op, numeroConta;
        double saldo;

        System.out.println("==========================================================");

        System.out.println("BEM VINDO AO PROGRAMA, SIMULADOR DE UM BANCO");

        System.out.println("==========================================================");

        try {
            System.out.println("VAMOS CADASTRAR SUA CONTA");

            System.out.println("NÚMERO DA CONTA: ");
            numeroConta = sc.nextInt();
            sc.nextLine(); // limpa o buffer do scanner

            System.out.println("NOME: ");
            nome = sc.nextLine();

            System.out.println("VALOR PARA DEPOSITAR (PODE DIGITAR ZERO(0) CASO NÃO FOR DEPOSITAR) ");
            saldo = sc.nextDouble();

            Conta conta = new Conta(numeroConta, nome, saldo);

            sc.nextLine(); // limpa o buffer do scanner

            while (true) {
                System.out.printf("\n1 - Depositar\n2 - Sacar\n3 - alterar nome\n4 - Consultar Saldo");
                System.out.println("Digite qual operação deseja ou zero para encerrar: ");
                opcao = sc.next();
                if (opcao.matches("\\d+$")) {
                    op = Integer.parseInt(opcao);
                    sc.nextLine();

                    if (op == 0) break;

                    switch (op) {

                        case 1:
                            System.out.print("Digite o valor que seja depositar: ");
                            saldo = sc.nextDouble();
                            conta.setSaldo(saldo);
                            break;

                        case 2:
                            System.out.print("Digite o valor que seja sacar: ");
                            saldo = sc.nextDouble();
                            conta.sacar(saldo);
                            break;

                        case 3:
                            System.out.print("Digite o nome: ");
                            nome = sc.nextLine();
                            conta.setNome(nome);
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Opção invalida!");
                            break;

                    }

                    System.out.println(conta.dados());

                } else System.out.println("Opção invalida");
                sc.nextLine(); // limpa o buffer do scanner
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Informação válida!");
        }


        sc.close();
    }

}
