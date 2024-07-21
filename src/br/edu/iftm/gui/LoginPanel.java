package br.edu.iftm.gui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginPanel extends TelaPanel{

    private final JButton botaoLogin;

    public LoginPanel(JPanel telas, JFrame janela){
        super(telas, janela);
        
        JLabel mensagem = new JLabel("Conteudo do Login panel");

        botaoLogin = new JButton("Fazer Login");
        botaoLogin.addActionListener(this);

        this.add(mensagem);
        this.add(botaoLogin);
       // this.add(imagem);
    }

    @Override
    public void executarBotao(ActionEvent e){
        trocarTela("Tela Principal");
    }
}
