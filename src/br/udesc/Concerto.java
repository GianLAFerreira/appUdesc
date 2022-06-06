package br.udesc;

public class Concerto {
    private double soma;

    public void somaConcerto(Veiculo veiculo){
        double valor = veiculo.getConcerto();
        this.soma   += valor;
    }

    public double getSoma() {
        return soma;
    }
}