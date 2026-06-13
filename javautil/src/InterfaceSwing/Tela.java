package InterfaceSwing;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Tela {

    public static void montarTela() throws IOException {
        final JFrame oJFrame = new JFrame("Cadastro de Cliente");
        oJFrame.setBounds(450, 170, 580, 500);
        oJFrame.setLayout(null);

        JLabel oJLabelCPF = new JLabel("CPF: ");
        oJLabelCPF.setBounds(10, 10, 60, 25);
        oJLabelCPF.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(oJLabelCPF);

        JFormattedTextField oJTextFieldCPF = new JFormattedTextField(mascara("###.###.###-##"));
        oJTextFieldCPF.setBounds(75, 10, 120, 25);
        oJTextFieldCPF.setLayout(null);
        oJFrame.add(oJTextFieldCPF);

        JLabel labelNome = new JLabel("Nome: ");
        labelNome.setBounds(10, 40, 60, 25);
        labelNome.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(labelNome);

        JTextField textFieldNome = new JTextField();
        textFieldNome.setBounds(75, 40, 360, 25);
        textFieldNome.setLayout(null);
        oJFrame.add(textFieldNome);

        JLabel labelDataNasc = new JLabel("Dt Nasc: ");
        labelDataNasc.setBounds(10, 75, 60, 25);
        labelDataNasc.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(labelDataNasc);

        JFormattedTextField FTextFieldDataNasc = new JFormattedTextField(mascara("##/##/####"));
        FTextFieldDataNasc.setBounds(75, 75, 120, 25);
        FTextFieldDataNasc.setLayout(null);
        oJFrame.add(FTextFieldDataNasc);

        JLabel oJLabelSexo = new JLabel("Sexo: ");
        oJLabelSexo.setBounds(300, 75, 40, 25);
        oJLabelSexo.setHorizontalAlignment(JLabel.RIGHT);
        oJFrame.add(oJLabelSexo);

        final JComboBox<String> oJComboBox = new JComboBox<>();
        oJComboBox.setBounds(353, 75, 120, 25);
        oJComboBox.addItem("-Selecione-");
        oJComboBox.addItem("Masculino");
        oJComboBox.addItem("Feminino");
        oJFrame.add(oJComboBox);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(30, 175, 100, 35);
        oJFrame.add(botaoSalvar);

        JButton botaoAlterar = new JButton("Alterar");
        botaoAlterar.setBounds(135, 175, 100, 35);
        botaoAlterar.setEnabled(false);
        oJFrame.add(botaoAlterar);

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.setBounds(240, 175, 100, 35);
        botaoExcluir.setEnabled(false);
        oJFrame.add(botaoExcluir);

        JButton botaoGerarArquivo = new JButton("Ger. Arquivo");
        botaoGerarArquivo.setBounds(345, 175, 150, 35);
        oJFrame.add(botaoGerarArquivo);

        String[] colunas = new String[]{"CPF", "Nome", "Dt. Nasc", "Sexo"};

        ArrayList<EPessoa> oListaPessoa = new ArrayList<>();
        PPessoa oPPessoa = new PPessoa();

        try {
            oListaPessoa = oPPessoa.consultarPessaoa();
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }
        String linhas[][] = new String[oListaPessoa.size()][4];
        int i = 0;
        for (EPessoa oEPessoa : oListaPessoa) {

            linhas[i][0] = oEPessoa.getCPF();
            linhas[i][1] = oEPessoa.getNome();
            linhas[i][2] = oEPessoa.getDataNasc();
            linhas[i][3] = oEPessoa.getSexo();
            i++;
        }

        final JTextField textFiltro = new JTextField();
        textFiltro.setBounds(20, 225, 300, 30);
        textFiltro.setLayout(null);
        oJFrame.add(textFiltro);

        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.setBounds(330, 225, 100, 30);
        oJFrame.add(botaoFiltrar);

        JButton botaoCancelarFiltro = new JButton("Cancelar");
        botaoCancelarFiltro.setBounds(440, 225, 100, 30);
        oJFrame.add(botaoCancelarFiltro);

        JTable oJTableTabela = new JTable(linhas, colunas);
        JScrollPane oJScrollPane = new JScrollPane();
        oJScrollPane.setBounds(20, 270, 510, 120);
        oJScrollPane.setViewportView(oJTableTabela);
        oJFrame.add(oJScrollPane);

        botaoSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (oJTextFieldCPF.getText().trim().equalsIgnoreCase("")
                        || textFieldNome.getText().trim().equalsIgnoreCase("")
                        || FTextFieldDataNasc.getText().trim().equalsIgnoreCase("")
                        || oJComboBox.getSelectedIndex() == 0) {

                    JOptionPane.showMessageDialog(null, "Preencha todos os dados");

                    return;

                }

                PPessoa oPPessoa = new PPessoa();
                String inclusao = oPPessoa.incluirPessoa(oJTextFieldCPF.getText(), textFieldNome.getText(),
                        FTextFieldDataNasc.getText(), oJComboBox.getSelectedItem().toString());

                JOptionPane.showMessageDialog(null, inclusao);

                oJFrame.dispose();
                try {
                    Tela.montarTela();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }
        });

        oJTableTabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                oJTextFieldCPF.setText(oJTableTabela.getValueAt(oJTableTabela.getSelectedRow(), 0).toString());
                textFieldNome.setText(oJTableTabela.getValueAt(oJTableTabela.getSelectedRow(), 1).toString());
                FTextFieldDataNasc.setText(oJTableTabela.getValueAt(oJTableTabela.getSelectedRow(), 2).toString());
                if (oJTableTabela.getValueAt(oJTableTabela.getSelectedRow(), 3).toString().trim().equalsIgnoreCase("Masculino")) {
                    oJComboBox.setSelectedIndex(1);
                } else {
                    oJComboBox.setSelectedIndex(2);
                }

                botaoAlterar.setEnabled(true);
                botaoExcluir.setEnabled(true);

                botaoExcluir.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        PPessoa oPPessoa = new PPessoa();

                        try {
                            if (!oJTextFieldCPF.getText().equalsIgnoreCase("") && oJTextFieldCPF.getText() != null) {
                                String exclusao = oPPessoa.excluirPessoa(oJTextFieldCPF.getText());
                                JOptionPane.showMessageDialog(null, exclusao);
                                oJFrame.dispose();
                                Tela.montarTela();
                            } else {
                                JOptionPane.showMessageDialog(null, "Selecione uma pessoa!");
                            }
                        } catch (SQLException | IOException e1) {
                            System.out.println(e1.getMessage());
                        }
                    }

                });

                botaoAlterar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        PPessoa oPPessoa = new PPessoa();

                        try {
                            if (!oJTextFieldCPF.getText().trim().equalsIgnoreCase("") || textFieldNome.getText().trim().equalsIgnoreCase("") || FTextFieldDataNasc.getText().trim().equalsIgnoreCase("") || oJComboBox.getSelectedIndex() == 0) {
                                JOptionPane.showMessageDialog(null, "Preencha todos os dados!");

                                return;
                            }

                            if (!oJTextFieldCPF.getText().equalsIgnoreCase("") && oJTextFieldCPF.getText() != null) {
                                String alteracao = oPPessoa.alterarPessoa(oJTextFieldCPF.getText(), textFieldNome.getText(), FTextFieldDataNasc.getText(), oJComboBox.getSelectedItem().toString());
                                JOptionPane.showMessageDialog(null, alteracao);
                                oJFrame.dispose();
                                Tela.montarTela();
                            } else {
                                JOptionPane.showMessageDialog(null, "Selecione uma pessoa!");
                            }
                        } catch (IOException e1) {
                            System.out.println(e1.getMessage());
                        }
                    }

                });
            }
        });

        botaoFiltrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<EPessoa> oListaPessoa = new ArrayList<>();
                PPessoa oPPessoa = new PPessoa();

                try {
                    oListaPessoa = oPPessoa.consultarPessoaPorNome(textFiltro.getText().trim());
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }

                String linhas[][] = new String[oListaPessoa.size()][4];

                int i = 0;
                for (EPessoa oEPessoa : oListaPessoa) {
                    linhas[i][0] = oEPessoa.getCPF();
                    linhas[i][1] = oEPessoa.getNome();
                    linhas[i][2] = oEPessoa.getDataNasc();
                    linhas[i][3] = oEPessoa.getSexo();
                    i++;
                }

                oJFrame.remove(oJScrollPane);

                JTable tabela = new JTable(linhas, colunas);
                JScrollPane scroll = new JScrollPane();
                scroll.setBounds(20, 270, 510, 120);
                scroll.setViewportView(tabela);
                oJFrame.add(scroll);

            }
        });

        botaoGerarArquivo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<EPessoa> oListaPessoa = new ArrayList<>();
                PPessoa oPPessoa = new PPessoa();

                try {
                    oListaPessoa = oPPessoa.consultarPessoaPorNome(textFiltro.getText().trim());
                    try {
                        Arquivo.gerarArquivoTabela("COLOCAR CAMINHO", oListaPessoa);
                        JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
                    } catch (IOException e1) {
                        System.out.println(e1.getMessage());
                    }
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        
        
        botaoCancelarFiltro.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    oJFrame.dispose();
                    montarTela();
                }catch (IOException e1){
                    //TODO Auto-generated catch block
                    System.out.println(e1.getMessage());
                }
            }
        
        });

        oJFrame.setVisible(true);

        }

    

    public static MaskFormatter mascara(String mascara) {

        MaskFormatter F_Mascara = new MaskFormatter();

        try {
            F_Mascara.setMask(mascara);
            F_Mascara.setPlaceholderCharacter(' ');
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return F_Mascara;
    }

}
