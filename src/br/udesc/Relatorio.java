package br.udesc;

import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    private List<Servico> servicos = new ArrayList<Servico>();



    public void adiciona(Servico servico) {
        this.servicos.add((servico));
    }

    public List<Servico> getServicos() {
        return servicos;
    }
}
