import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.*;

public class Exercicio {

    String resultado;

    public String Exe1(){

        
        int n1, n2, n3;
        n1 = 10 + 30;
        n2 = -30 + 10;
        n3 = 0;

        resultado = format("SOMA = %d \nSOMA = %d\nSOMA = %d", n1, n2, n3);
        return resultado;
    }

    public String Exe2(double raio){

        final double PI = 3.14159;

        resultado = format("A=%.4f%n", (PI * raio * raio));

        return resultado;

    }

    public String Exe3(int a, int b, int c, int d){

        int conta = (a * b - c * d);

        resultado = format("resultado = %d", conta);

        return resultado;

    }

    public String Exe4(int a, int b, double valor){

        double valortotal = b * valor;

        resultado = String.format("NUMBER = %d\nSALARY = R$ %.2f%n", a, valortotal );

        return resultado;

    }

    public String Exe5(){
        Roupa roupa;
        List<Roupa> roupas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int codigo, quantidade = 0;
        double valorUnitario = 0;

        while (true) {
            System.out.print("Digite o código código da peça (ou 0 para sair): ");
            try {
                codigo = sc.nextInt();
                if (codigo == 0) break;
                System.out.print("Digite a quantidade: ");
                quantidade = sc.nextInt();

                System.out.print("Digite o valor unitário: ");
                valorUnitario = sc.nextDouble();

                roupas.add(new Roupa(codigo, quantidade, valorUnitario));
                System.out.println("Produto adicionado com sucesso!\n");

            } catch (NumberFormatException e) {
                System.out.println("Não é um número válido!");
            }

        }

        // Calcula o total geral
        double totalGeral = 0.0;
        System.out.println("\n--- Lista de Produtos ---");
        for (Roupa p : roupas) {
            System.out.println("Código da peça: "+p.cod);
            totalGeral += p.calcularTotal();
        }

        resultado = String.format("\nValor total da compra: R$ %.2f\n", totalGeral);
        return resultado;

    }

    public String Exe6(double a, double b, double c ){
        double tri, cir, trap, qdr, rtg = 0;
        double pi = 3.14159;

        tri = (a * c) / 2.0;
        cir = pi * Math.pow(c, 2);
        trap = ((a + b) * c) / 2.0;
        qdr = b * b;
        rtg = a * b;

        resultado = String.format("\nTRIANGULO: R$ %.3f\nCIRCULO: R$ %.3f\nTRAPEZIO: R$ %.3f\nQUADRADO: R$ %.3f\nRETANGULO: R$ %.3f\n", tri, cir, trap, qdr, rtg);

        return resultado;
    }
}
