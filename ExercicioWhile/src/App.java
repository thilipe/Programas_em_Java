import java.util.Objects;
import java.util.Scanner;

public class App {

    static boolean senhaCorreta;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcao, senha, tipo = "";
        int op, alcool, gasolina, diessel, x, y;

        System.out.println("==========================================================");

        System.out.println("BEM VINDO AO PROGRAMA, EXERCÍCIOS DO WHILE");

        System.out.println("==========================================================");

        while (true) {

            System.out.println("1 - Escreva um programa que repita a leitura de uma senha até que ela seja válida. Para cada leitura de senha\n" +
                    "incorreta informada, escrever a mensagem \"Senha Invalida\". Quando a senha for informada corretamente deve ser\n" +
                    "impressa a mensagem \"Acesso Permitido\" e o algoritmo encerrado. Considere que a senha correta é o valor 2002.");

            System.out.println("2 - Escreva um programa para ler as coordenadas (X,Y) de uma quantidade indeterminada de pontos no sistema\n" +
                    "cartesiano. Para cada ponto escrever o quadrante a que ele pertence. O algoritmo será encerrado quando pelo\n" +
                    "menos uma de duas coordenadas for NULA (nesta situação sem escrever mensagem alguma).");

            System.out.println("3 - Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes. Escreva\n" +
                    "um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma: 1.Álcool 2.Gasolina 3.Diesel\n" +
                    "4.Fim). Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo código (até\n" +
                    "que seja válido). O programa será encerrado quando o código informado for o número 4. Deve ser escrito a\n" +
                    "mensagem:  \"MUITO OBRIGADO\" e a quantidade de clientes que abasteceram cada tipo de combustível.");

            System.out.println("Digite qual exercício quer executar ou zero para sair: ");
            opcao = sc.next();
            if (opcao.matches("\\d+$")) {
                op = Integer.parseInt(opcao);
                sc.nextLine();
                switch (op) {

                    case 1:
                        while (senhaCorreta != true) {
                            System.out.println("Por favor digita a senha");
                            senha = sc.next();
                            VerificarSenha(senha);
                            if (senhaCorreta == true) {
                                System.out.println("Acesso Permitido");
                                break;
                            }else {
                                System.out.println("Senha Invalida");
                            }
                        }
                        break;

                    case 2:
                        while (true) {
                            System.out.print("Digite o valor de X: ");
                            x = sc.nextInt();

                            System.out.print("Digite o valor de Y: ");
                            y = sc.nextInt();

                            if (x == 0 || y == 0) {
                                break; // encerra o loop
                            }

                            if (x > 0 && y > 0) {
                                System.out.println("Quadrante Q1\n");
                            } else if (x < 0 && y > 0) {
                                System.out.println("Quadrante Q2\n");
                            } else if (x < 0 && y < 0) {
                                System.out.println("Quadrante Q3\n");
                            } else {
                                System.out.println("Quadrante Q4\n");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Tipo de combustível abastecido\n1.Álcool \n2.Gasolina \n3.Diesel\n" +
                                "4.Fim");
                        alcool = 0; gasolina = 0; diessel = 0;

                        while (!Objects.equals(tipo, "4")) {
                            System.out.println("Tipo de combustível: ");
                            tipo = sc.next();

                            switch (tipo){

                                case "1":
                                    alcool += 1;
                                    break;

                                case "2":
                                    gasolina += 1;
                                    break;

                                case "3":
                                    diessel += 1;
                                    break;

                                case "4":
                                    break;
                            }

                        }
                        System.out.printf("MUITO OBRIGADO%nAlcool: %d%nGasolina: %d%nDiesel: %d%n",
                                alcool, gasolina, diessel);

                        break;

                    default:
                        System.out.println("Opção inválida!!");
                        sc.nextLine();
                        break;
                }


            } else {
                System.out.println("Opção inválida!!");
                sc.nextLine();
            }


            sc.nextLine();
        }

    }

    public static void VerificarSenha(String senha) {

        if (Objects.equals(senha, "2002")) {
            senhaCorreta = true;
        } else {
            senhaCorreta = false;
        }
    }
}
