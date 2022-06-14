package br.udesc;

public class Gerente  extends Funcionario{


    public Gerente(String nome, String CPF, double salario) {
        super(nome, CPF, salario);
    }


    @Override
    public double getBonificacao() {
        return super.getBonificacao() + super.getSalario();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
