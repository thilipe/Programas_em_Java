import entities.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        // Caminho do arquivo CSV (altere conforme seu PC)
        String path = "Arquivos/summary.csv";

        Path sourceFolder = Paths.get(path).getParent();
        Path outFolder = Paths.get(sourceFolder.toString(), "out");
        outFolder.toFile().mkdir(); // cria a pasta /out

        Path summaryFile = Paths.get(outFolder.toString(), "summary.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter bw = new BufferedWriter(new FileWriter(summaryFile.toString()))) {

            String line = br.readLine();
            int i = 0;
            bw.newLine();
            while (line != null) {

                i += 1;
                String[] fields = line.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                Product p = new Product(name, price, quantity);

                bw.write(i + "," +p.getName() + "," + String.format("%.2f", p.total()));
                bw.newLine();

                line = br.readLine();
            }

            System.out.println("Arquivo summary.csv gerado com sucesso em: " + summaryFile);

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
        }
    }
}
