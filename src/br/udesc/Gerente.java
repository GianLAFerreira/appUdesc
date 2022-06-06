package br.udesc;

public class Gerente  extends Funcionario{

    @Override
    public double getBonificacao() {
        return super.getBonificacao() + super.getSalario();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
