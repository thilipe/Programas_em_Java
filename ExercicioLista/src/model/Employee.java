package model;

public class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void porcentageSalaryPlus(int porcentage){

        this.salary = this.salary * ((double) porcentage /100);

    }

    public String toString(){
        String resultado = String.format("ID: %d, Nome: %s, Salário: %.2f",this.id, this.name, this.salary);
        return resultado;
    }
}

