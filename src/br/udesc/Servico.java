package br.udesc;

import java.util.ArrayList;
import java.util.List;

public class Servico {
    private String descricao;
    private String funcionarios;
    private String veiculos;

    public Servico(String descricao, String funcionarios, String veiculos) {
        this.descricao    = descricao;
        this.funcionarios = funcionarios;
        this.veiculos     = veiculos;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='"      + this.descricao + '\'' +
                ", funcionarios='" + this.funcionarios + '\'' +
                ", veiculos='"     + this.veiculos + '\'' +
                '}';
    }
}
