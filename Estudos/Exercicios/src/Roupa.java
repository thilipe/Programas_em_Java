public class Roupa {
    int cod, npeca = 0;
    double valorU = 0;

    public Roupa(int cod, int npeca, double valorU) {
        this.cod    = cod;
        this.npeca  = npeca;
        this.valorU = valorU;
    }

    public int getCod() {
        return cod;
    }

    public int getNpeca() {
        return npeca;
    }

    public double getValorU() {
        return valorU;
    }

    public double calcularTotal() {
        return valorU * npeca;
    }
}
