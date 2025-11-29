import Entites.ImportedProduct;
import Entites.Product;
import Entites.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppProdutos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdProduto;
        String op, name, dateString;
        double price, customFee;
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> products = new ArrayList<>();
        Product product;

        System.out.println("=========================================================");
        System.out.println("Programa para cadastrar produtos ");
        System.out.println("=========================================================");

        try {
            System.out.print("Quantos produtos vai cadastrar: ");
            qtdProduto = sc.nextInt();

            for (int i = 1 ;i <= qtdProduto; i++){
                sc.nextLine();
                System.out.println("Product #"+i+" data:");
                System.out.print("Common, used or imported (c/u/i)? ");
                op = sc.nextLine();
                System.out.print("Name: ");
                name = sc.nextLine();
                System.out.print("price: ");
                price = sc.nextDouble();

                switch (op){
                    case "c":
                        product = new Product(name, price);
                        products.add(product);
                        break;

                    case "u":
                        sc.nextLine();
                        System.out.print("Manufacture date (DD/MM/YYYY): ");
                        dateString = sc.nextLine();
                        date = sdf.parse(dateString);
                        product = new UsedProduct(name, price,date);
                        products.add(product);
                        break;

                    case "i":
                        sc.nextLine();
                        System.out.print("Cummon fee: ");
                        customFee = sc.nextDouble();
                        product = new ImportedProduct(name, price,customFee);
                        products.add(product);
                        break;
                }

            }


        } catch (RuntimeException | ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product p : products){
            System.out.println(p.priceTag());
        }
    }
}