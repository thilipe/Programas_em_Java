import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int x = 4, y = 0, i = 0;

        while (i<x){
            i = i + 1;
            y = y + i;
            System.out.println(i);
            System.out.println(i);

        }

        x = 2;
        y = 10;

        while(x < y){
            System.out.println(x + " - " + y);
            x *= 2;
            y += 1;
        }


        /*
        Scanner sc = new Scanner(System.in);
        int n = 1, t = 0, i = 0;

        System.out.println("======================================================");

        System.out.println("BEM VINDO AO PROGRAMA QUE SOMA NÚMEROS");

        System.out.println("======================================================");

        System.out.println("Por favor digita números inteiros se deseja sair do loop é só dizer zero");

        while (true) {
            System.out.print("digite um número: ");
            try {
                n = sc.nextInt();
                t += n;
                i += 1;
                if (n == 0) break;
                if (i > 9 && n != 0) {
                    i = 0;
                    System.out.println("Se quiser sair do loop é só digitar 0");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Número invalido");
                sc.nextLine();
            }
        }
        System.out.println("Total: " + t);
        sc.close();

         */
    }
}
