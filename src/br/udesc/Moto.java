package br.udesc;

public class Moto extends Veiculo{

    public Moto(String modelo, String placa, int ano, double valor){
        super(modelo, placa, ano, valor);
    }

    @Override
    public double getConcerto() {
        return getValor();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}