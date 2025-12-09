import model.Employee;

public class App {
    public static void main(String[] args) {

        Employee[] lista = new Employee[3];

        lista[0] = new Employee(333, "Maria Brow", 4000);
        lista[1] = new Employee(536, "Alex Grey", 3000);
        lista[2] = new Employee(772, "Bob Green", 5000);

        for(int i=0; i < lista.length; i++){
            System.out.println(lista[i]);
        }

    }

}