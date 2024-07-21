package br.edu.iftm.gui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrincipalPanel extends TelaPanel {

    private final JButton botaoPrincipal;

    public PrincipalPanel(JPanel telas, JFrame janela){
        super(telas, janela);

        JLabel mensagem = new JLabel("Conteudo do Principal panel");

        botaoPrincipal = new JButton("Voltar");
        botaoPrincipal.addActionListener(this);

        this.add(mensagem);
        this.add(botaoPrincipal);
    }

    @Override
    public void executarBotao(ActionEvent e){
        trocarTela("Tela Login");
    }
}
