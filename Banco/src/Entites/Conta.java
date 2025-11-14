package Entites;

public class Conta {

    private final int numeroConta;
    private String nome;
    private double saldo;

    public Conta(int numeroConta, String nome, double saldo) {
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo += saldo;
    }

    public void sacar(double saldo) {
        saldo += 5;
        if (saldo < this.saldo) {
            this.saldo = this.saldo - saldo;
        }else System.out.printf("Saldo indisponível: R$ %.2f"+this.saldo);
    }

    public String dados(){
        return String.format("Conta: %d, Nome: %s, Saldo: R$ %.2f", this.numeroConta, this.nome, this.saldo);
    }
}
