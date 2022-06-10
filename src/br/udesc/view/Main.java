package br.udesc.view;

import br.udesc.*;
import br.udesc.acao.Autenticavel;
import br.udesc.acao.Cliente;
import br.udesc.acao.Pessoa;
import br.udesc.acao.TelaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private JButton nameButton;
    private JPanel MainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JTextField nameField;
    private JButton adicionarButton;
    private JTextField lastNameField;
    private JTextField nomeCompletoField;

    public Main() {
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
    }

    public static void main(String[] args) {

            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            pessoas.add(new Cliente("Cliente", "123"));

            for(Pessoa p : pessoas) {
                System.out.println(p.getNome());
            }

            Autenticavel a1 = new Cliente("Cliente2", "123");

            System.out.println(a1.autentica("123"));


            List<Autenticavel> autenticaveis = new ArrayList<>();
            autenticaveis.add(a1);

        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaPrincipal.pack();
        telaPrincipal.setVisible(true);
        telaPrincipal.setSize(800, 450);

//        JFrame f = new JFrame("App");
//       // f.setContentPane(new Main().nameButton);
//
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.pack();
//        f.setVisible(true);
//        f.setSize(800, 450);

    }
}

