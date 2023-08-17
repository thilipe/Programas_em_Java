import java.util.Arrays;
import java.util.Scanner;
//import javax.annotation.processing.SupportedOptions;

public class App {
    public static void main(String[] args) throws Exception {
        OrganizarN OrgN = new OrganizarN();
        Scanner sc = new Scanner(System.in);
        int n;
        int k, i = 0;

        System.out.println("Por favor digite quantos números você vai armanezar: ");
        k = sc.nextInt();
        int[] Numeros = new int[k];

        while (Numeros.length > i) {
            System.out.println("Digite 0 para sair ou Por favor digite um número: ");
            n = sc.nextInt();
            if (n == 0) {
                break;
            } else {
                Numeros[i] = n;
            }
            i += 1;
        }
        String Colecao = OrgN.Ordenar(Numeros);

        System.out.println(Colecao);
        sc.close();

    }
}
