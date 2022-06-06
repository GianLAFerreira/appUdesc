package br.udesc;

import java.util.ArrayList;
import java.util.List;

public class Servico {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Veiculo>     veiculos     = new ArrayList<>();

    public Servico(Funcionario funcionario, Veiculo veiculo) {
        funcionarios.add(funcionario);
        veiculos.add(veiculo);
    }


    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = (ArrayList<Funcionario>) funcionarios;
    }

    @Override
    public String toString() {
        return "Servico: " + funcionarios + veiculos;
    }
}
