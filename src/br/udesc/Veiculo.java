package br.udesc;

import java.util.Objects;

public abstract class Veiculo {

    private String modelo;
    private String placa;
    private int    ano;
    private double valor;

    public Veiculo(String modelo, String placa, int ano, double valor){
        this.modelo = modelo;
        this.placa  = placa;
        this.ano    = ano;
        this.valor  = valor;
    }

    public abstract double getConcerto();

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return ano == veiculo.ano && Double.compare(veiculo.valor, valor) == 0 && Objects.equals(modelo, veiculo.modelo) && Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, placa, ano, valor);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='"  + modelo + '\'' +
                ", placa='" + placa  + '\'' +
                ", ano="    + ano    +
                ", valor="  + valor  +
                '}';
    }
}
