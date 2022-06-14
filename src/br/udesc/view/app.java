package br.udesc.view;

import br.udesc.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



public class app {
    private JPanel panelMain;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JComboBox tipoveiculoCombobox;
    private JButton cadastrarButton;
    private JLabel valorLabel;
    private JLabel modeloLabel;
    private JLabel placaLabel;
    private JLabel anoLabel;

    private JTextField valorField;
    private JTextField modeloField;
    private JTextField placaField;
    private JTextField anoField;
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField salarioField;
    private JLabel nomeLabel;
    private JLabel cpfLabel;
    private JLabel tipoLabel;
    private JLabel salarioLabel;
    private JComboBox tipofuncionariocomboBox;
    private JButton cadastrarButton1;
    private JComboBox pessoacomboBox;
    private JComboBox veiculocomboBox;
    private JLabel veiculoLabel;
    private JTabbedPane tabbedPane4;
    private JTextField descricaoField;
    private JLabel Descrição;
    private JButton cadastrarServicoButtom;
    private JTextField relatorioField;
    private JButton buscarServicosButton;
    private JTextField totalField;
    Integer indexVeiculos = 0;
    Integer indexFuncionarios = 0;
    Integer indexServicos = 0;
    Integer indexRelatorio = 0;
    Veiculo[]     totalVeiculos     = new Veiculo[50];
    Funcionario[] totalFuncionarios = new Funcionario[50];
    Servico[]     totalServicos     = new Servico[50];
    Integer indexTotalVeiculos      = 0;
    Integer indexTotalFuncaionarios = 0;
    Integer indexTotalServicos      = 0;
    private List<Servico> servicos  = new ArrayList<Servico>();


    public app() throws ParseException {

        Concerto valor = new Concerto();
        Servico[] servicos = new Servico[50];
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo[] veiculos = new Veiculo[50];

                    if (tipoveiculoCombobox.getSelectedItem().toString() == "Moto"){
                        veiculos[indexVeiculos] = new Moto(
                                modeloField.getText(),
                                placaField.getText(),
                                Integer.parseInt(anoField.getText()),
                                Double.parseDouble(valorField.getText()));
                        totalVeiculos[indexTotalVeiculos] = veiculos[indexVeiculos];
                        indexTotalVeiculos++;
                        valor.somaConcerto(veiculos[indexVeiculos]);
                    }else{
                        System.out.println( valorField.getText());
                        veiculos[indexVeiculos] = new Carro(
                                modeloField.getText(),
                                placaField.getText(),
                                Integer.parseInt(anoField.getText()),
                                Double.parseDouble(valorField.getText()));
                        totalVeiculos[indexTotalVeiculos] = veiculos[indexVeiculos];
                        indexTotalVeiculos++;
                        valor.somaConcerto(veiculos[indexVeiculos]);
                    }
                veiculocomboBox.addItem(modeloField.getText());
                indexVeiculos++;

                modeloField.setText("");
                placaField.setText("");
                valorField.setText("");
                anoField.setText("");
                tabbedPane1.setSelectedIndex(1);
            }
        });

       // pessoacomboBox.addItem(for(Funcionario func : ));
        cadastrarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario[] funcionarios = new Funcionario[50];
                if (tipofuncionariocomboBox.getSelectedItem().toString() == "Gerente"){
                    funcionarios[indexFuncionarios] = new Gerente(
                        nomeField.getText(),
                        cpfField.getText(),
                        Double.parseDouble(salarioField.getText()));
                    totalFuncionarios[indexTotalFuncaionarios] = funcionarios[indexFuncionarios];
                    indexTotalFuncaionarios++;
                    pessoacomboBox.addItem(nomeField.getText());
                }else{
                    funcionarios[indexFuncionarios] = new Mecanico(
                            nomeField.getText(),
                            cpfField.getText(),
                            Double.parseDouble(salarioField.getText()));
                    totalFuncionarios[indexTotalFuncaionarios] = funcionarios[indexFuncionarios];
                    indexTotalFuncaionarios++;
                    pessoacomboBox.addItem(nomeField.getText());
                }
                indexFuncionarios++;
                nomeField.setText("");
                cpfField.setText("");
                salarioField.setText("");
                tabbedPane1.setSelectedIndex(1);

            }
        });
        cadastrarServicoButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(indexServicos);
                servicos[indexServicos] = new Servico(
                        descricaoField.getText(),
                        pessoacomboBox.getSelectedItem().toString(),
                        veiculocomboBox.getSelectedItem().toString()
                );
                System.out.println("descrução:" + descricaoField.getText());
                System.out.println(pessoacomboBox.getSelectedItem().toString());
            }
        });
        buscarServicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                relatorioField.setText("Em desenvolvimento");

                totalField.setText(String.valueOf(valor.getSoma()));

            }
        });

        nomeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if  (   nomeField.getText().length()    > 0 &&
                        cpfField.getText().length()     > 0 &&
                        salarioField.getText().length() > 0) {
                    cadastrarButton1.setEnabled(true);
                }
                else cadastrarButton1.setEnabled(false);

                if (isInteger(nomeField.getText(), 10)) {
                    JOptionPane.showMessageDialog(null, "Apenas string, você não se chama número!");
                    nomeField.setText("");
                };
            }
        });
        cpfField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (!isInteger(cpfField.getText(), 10)) {
                    JOptionPane.showMessageDialog(null, "CPF são apenas números!");
                    cpfField.setText("");
                };
            }
        });
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame("Mecanica UDESC");
        frame.setContentPane(new app().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 470);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
}
}
